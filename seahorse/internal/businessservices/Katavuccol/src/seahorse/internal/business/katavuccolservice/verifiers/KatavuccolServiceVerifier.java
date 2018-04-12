/**
 * 
 */
package seahorse.internal.business.katavuccolservice.verifiers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.google.common.collect.FluentIterable;
import com.google.gson.Gson;
import com.google.inject.Inject;

import jersey.repackaged.com.google.common.collect.Collections2;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.Ikatavuccolredis;
import seahorse.internal.business.katavuccolservice.common.KatavuccolConstant;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.IKatavuccolServiceRepository;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;


/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceVerifier implements IKatavuccolServiceVerifier {
	
	private final IBaseVerifier baseVerifier;	
	private final IKatavuccolServiceVerifierMapper katavuccolServiceVerifierMapper;
	private final IKatavuccolServiceErrorCode katavuccolServiceErrorCode;
	private final IKatavuccolServiceRepository katavuccolServiceRepository;
	private final Ikatavuccolredis katavuccolredis;
	
	@Inject
	public KatavuccolServiceVerifier(IBaseVerifier baseVerifier,
			IKatavuccolServiceVerifierMapper katavuccolServiceVerifierMapper,
			IKatavuccolServiceErrorCode katavuccolServiceErrorCode, 
			IKatavuccolServiceRepository katavuccolServiceRepository,
			Ikatavuccolredis katavuccolredis)
	{
		this.baseVerifier=baseVerifier;
		this.katavuccolServiceVerifierMapper = katavuccolServiceVerifierMapper;
		this.katavuccolServiceErrorCode = katavuccolServiceErrorCode;
		this.katavuccolServiceRepository = katavuccolServiceRepository;
		this.katavuccolredis=katavuccolredis;
	}
	

	@Override
	public Result verifyCreateCredentials(CredentialRequestMessageEntity credentialRequestMessageEntity) {	
		Result result;

		result = isUserIdValid(credentialRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		result = isCategoryIdValid(credentialRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isCredentialTypeIdValid(credentialRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}		
				
		result = isCredentialTypeDuplicateAllowedValid(credentialRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		result = isCredentialTypeSubItemAllowedValid(credentialRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}

	public Result isCredentialTypeSubItemAllowedValid(CredentialRequestMessageEntity credentialRequestMessageEntity) {
		if(credentialRequestMessageEntity.getIsCredentialNull() || credentialRequestMessageEntity.getParsedParentCredentialId() == null)
		{
			return new Result(ResultStatus.SUCCESS);
		}
		List<CredentialDAO>  credentialDAOs=katavuccolServiceRepository.getCredentialByUserId(credentialRequestMessageEntity.getParsedUserId());
		if(credentialDAOs.isEmpty())
		{
			credentialRequestMessageEntity.setIsCredentialNull(true);
			return new Result(ResultStatus.SUCCESS);
		}
		
		if(!credentialDAOs.stream().anyMatch(x -> KatavuccolServiceUtility.isEqual(x.getId(),credentialRequestMessageEntity.getParsedParentCredentialId())				
				&& x.getStatus()==KatavuccolConstant.ACTIVESTATUS))
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "InValid Parent Id", "ParentCredentialId", katavuccolServiceErrorCode.parentIdNotFoundErrorCode());
		}
		
		if(credentialDAOs.stream().anyMatch(x -> KatavuccolServiceUtility.isEqual(x.getCredentialTypeId(),credentialRequestMessageEntity.getParsedCredentialTypeId())
				&& KatavuccolServiceUtility.isEqual(x.getCategoryId(),credentialRequestMessageEntity.getParsedParentCredentialId())
				&& KatavuccolServiceUtility.isEqual(x.getStatus(), KatavuccolConstant.ACTIVESTATUS))
				&& !credentialRequestMessageEntity.getCredentialType().getIsSubitemAllowed())
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Sub entry is not allowed", "", katavuccolServiceErrorCode.categoryTypeSubEntryNotAllowedErrorCode());
		}
		
		if(credentialDAOs.stream().anyMatch(x ->KatavuccolServiceUtility.isEqual(x.getCredentialTypeId(),credentialRequestMessageEntity.getParsedCredentialTypeId())
				&& KatavuccolServiceUtility.isEqual(x.getCategoryId(),credentialRequestMessageEntity.getParsedParentCredentialId())
				&& x.getParentId() != null
				&& KatavuccolServiceUtility.isEqual(x.getStatus(),KatavuccolConstant.ACTIVESTATUS)))
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Sub entry exceed limitation", "", katavuccolServiceErrorCode.credentialSubEntryExceedLimitationErrorCode());
		}		
		
		List<CredentialMessageEntity> credentialMessageEntities=katavuccolServiceVerifierMapper.MapCredentialMessageEntity(credentialDAOs);
		credentialRequestMessageEntity.setCredential(credentialMessageEntities);
		return new Result(ResultStatus.SUCCESS);
	}


	public Result isCredentialTypeDuplicateAllowedValid(CredentialRequestMessageEntity credentialRequestMessageEntity) {		
		
		if(credentialRequestMessageEntity.getIsCredentialNull() || credentialRequestMessageEntity.getParsedParentCredentialId() != null )
		{
			return new Result(ResultStatus.SUCCESS);
		}
		List<CredentialDAO>  credentialDAOs=katavuccolServiceRepository.getCredentialByUserId(credentialRequestMessageEntity.getParsedUserId());
		if(credentialDAOs.isEmpty())
		{
			credentialRequestMessageEntity.setIsCredentialNull(true);
			return new Result(ResultStatus.SUCCESS);
		}
		
		if(credentialDAOs.stream().anyMatch(x -> KatavuccolServiceUtility.isEqual(x.getCategoryId(),credentialRequestMessageEntity.getParsedCategoryId())
				&& KatavuccolServiceUtility.isEqual(x.getCredentialTypeId() , credentialRequestMessageEntity.getParsedCredentialTypeId())
				&& KatavuccolServiceUtility.isEqual(x.getStatus(),KatavuccolConstant.ACTIVESTATUS)) 
				&& !credentialRequestMessageEntity.getCredentialType().getIsDuplicationAllowed())
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Duplicate entry is not allowed", "CategoryTypeId", katavuccolServiceErrorCode.categoryTypeDuplicateNotAllowedErrorCode());
		}
		
		List<CredentialMessageEntity> credentialMessageEntities=katavuccolServiceVerifierMapper.MapCredentialMessageEntity(credentialDAOs);		
		credentialRequestMessageEntity.setCredential(credentialMessageEntities);
		return new Result(ResultStatus.SUCCESS);
	}

	public Result isCredentialTypeIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity) {	
		String credentialType=katavuccolredis.getvalue(KatavuccolConstant.REDIS_CREDENTIALTYPE);
		CredentialTypeDAO typeDAO = null;
		if(credentialType == null)
		{
			typeDAO = katavuccolServiceRepository.getCredentialTypeDetailById(credentialRequestMessageEntity.getParsedCredentialTypeId(),credentialRequestMessageEntity.getParsedUserId());
			katavuccolredis.setvalue(KatavuccolConstant.REDIS_CREDENTIALTYPE, typeDAO);
		}		
		else
		{
			Gson gson=new Gson();
			typeDAO =gson.fromJson(credentialType, CredentialTypeDAO.class);
		}
		if(typeDAO ==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Not able to find category type id", "CategoryTypeId", katavuccolServiceErrorCode.categoryTypeIdNotFoundErrorCode());
		}
		
		if(credentialRequestMessageEntity.getParsedParentCredentialId() !=null && !credentialRequestMessageEntity.getCredentialType().getIsSubitemAllowed())
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Sub entry is not allowed for this Credential type", "CategoryTypeId", katavuccolServiceErrorCode.categoryTypeSubEntryNotAllowedErrorCode());
		}
		credentialRequestMessageEntity.setCredentialType(katavuccolServiceVerifierMapper.mapCredentialTypeDAOMessageEntity(typeDAO));		
		return new Result(ResultStatus.SUCCESS);
	}


	public Result isCategoryIdValid(CredentialRequestMessageEntity credentialsRequestMessageEntity) {		
		CategoryDAO categoryDAO = katavuccolServiceRepository.getCategoryDetailById(credentialsRequestMessageEntity.getParsedCategoryId(),credentialsRequestMessageEntity.getParsedUserId());
		if(categoryDAO ==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Not able to find categoryid", "CategoryId", katavuccolServiceErrorCode.categoryIdNotFoundErrorCode());
		}		
		credentialsRequestMessageEntity.setCategory(katavuccolServiceVerifierMapper.mapCategoryMessageEntity(categoryDAO));
		return new Result(ResultStatus.SUCCESS);
	}

	public Result isUserIdValid(CredentialRequestMessageEntity credentialsRequestMessageEntity) {		
		return new Result(ResultStatus.SUCCESS);
	}


	@Override
	public Result verifyGetCredentials(GetCredentialMessageEntity getCredentialMessageEntity) {
		Result result;

		result = isUserIdValid(getCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = isCredentialValid(getCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}


	public Result isCredentialValid(GetCredentialMessageEntity getCredentialMessageEntity) {
		List<CredentialDAO>  credentialDAOs=katavuccolServiceRepository.getCredentialByUserId(getCredentialMessageEntity.getParsedUserId());
		getCredentialMessageEntity.setCredentialDAO(credentialDAOs);
		return new Result(ResultStatus.SUCCESS);
	}


	public Result isUserIdValid(GetCredentialMessageEntity getCredentialMessageEntity) {
		return new Result(ResultStatus.SUCCESS);
	}


	@Override
	public Result verifyDeleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
		Result result;

		result = isUserIdValid(deleteCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = isCredentialIdValid(deleteCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}


	public Result isCredentialIdValid(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
		CredentialDAO  credentialDAO=katavuccolServiceRepository.getCredentialById(deleteCredentialMessageEntity);
		if(credentialDAO == null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Not able to find credential id", "CredentialId", katavuccolServiceErrorCode.credentialIdNotFoundErrorCode());
		}
		CredentialMessageEntity credentialMessageEntity=katavuccolServiceVerifierMapper.MapCredentialMessageEntity(credentialDAO);		
		deleteCredentialMessageEntity.setCredential(credentialMessageEntity);
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}


	public Result isUserIdValid(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
		return new Result(ResultStatus.SUCCESS);
	}


	@Override
	public Result verifyUpdateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		Result result;

		result = isUserIdValid(updateCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isCredentialIdValid(updateCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isCategoryIdValid(updateCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isCredentialTypeIdValid(updateCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}


	public Result isCredentialIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		List<CredentialDAO>  credentialDAOs=katavuccolServiceRepository.getCredentialByUserId(
				updateCredentialMessageEntity.getParsedUserId());
		
		List<CredentialDAO>  curCredentialDAOs =FluentIterable
								.from(credentialDAOs)
								.filter(x-> KatavuccolServiceUtility.isEqual(x.getId(),updateCredentialMessageEntity.getParsedCredentialId()))
								.toList();
		
		if(credentialDAOs == null || credentialDAOs.isEmpty() || curCredentialDAOs.isEmpty())
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Not able to find category id", "CategoryId", katavuccolServiceErrorCode.updateCategoryIdNotFoundErrorCode());
		}
		updateCredentialMessageEntity.setParsedCategoryId(curCredentialDAOs.get(0).getCategoryId());
		List<CredentialDAO>  categoryCredentialDAOs=
				FluentIterable
				.from(credentialDAOs)
				.filter(x-> KatavuccolServiceUtility.isEqual(x.getCategoryId(),updateCredentialMessageEntity.getParsedCategoryId()))
				.toList();				
		
		if(categoryCredentialDAOs == null || categoryCredentialDAOs.isEmpty())
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Not able to find category id", "CategoryId", katavuccolServiceErrorCode.updateCategoryIdNotFoundErrorCode());
		}
		
		updateCredentialMessageEntity.setCredential(katavuccolServiceVerifierMapper.MapCredentialMessageEntity(categoryCredentialDAOs));
		return new Result(ResultStatus.SUCCESS);
	}


	public Result isCredentialTypeIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		
		if(updateCredentialMessageEntity.getParsedCredentialTypeId() ==null)
		{
			return new Result(ResultStatus.SUCCESS);
		}
		String credentialType=katavuccolredis.getvalue(KatavuccolConstant.REDIS_CREDENTIALTYPE);
		CredentialTypeDAO typeDAO = null;
		if(credentialType == null)
		{
			typeDAO = katavuccolServiceRepository.getCredentialTypeDetailById(updateCredentialMessageEntity.getParsedCredentialTypeId(),updateCredentialMessageEntity.getParsedUserId());
			katavuccolredis.setvalue(KatavuccolConstant.REDIS_CREDENTIALTYPE, typeDAO);
		}		
		else
		{
			Gson gson=new Gson();
			typeDAO =gson.fromJson(credentialType, CredentialTypeDAO.class);
		}
		if(typeDAO ==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Not able to find category type id", "CategoryTypeId", katavuccolServiceErrorCode.updateCategoryTypeIdNotFoundErrorCode());
		}	
		
		updateCredentialMessageEntity.setCredentialType(katavuccolServiceVerifierMapper.mapCredentialTypeDAOMessageEntity(typeDAO));
		
		if(!updateCredentialMessageEntity.getCredential().stream().anyMatch(x->KatavuccolServiceUtility.isEqual(x.getCredentialTypeId(), updateCredentialMessageEntity.getParsedCredentialId())))
		{
			return new Result(ResultStatus.SUCCESS);
		}
		return new Result(ResultStatus.SUCCESS);
	}


	public Result isCategoryIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		CategoryDAO categoryDAO = katavuccolServiceRepository.getCategoryDetailById(updateCredentialMessageEntity.getParsedCategoryId(),updateCredentialMessageEntity.getParsedUserId());
		if(categoryDAO ==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Not able to find categoryid", "CategoryId", katavuccolServiceErrorCode.categoryIdNotFoundErrorCode());
		}		
		updateCredentialMessageEntity.setCategory(katavuccolServiceVerifierMapper.mapCategoryMessageEntity(categoryDAO));		
				
		return new Result(ResultStatus.SUCCESS);
	}


	public Result isUserIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		return new Result(ResultStatus.SUCCESS);
	}


	@Override
	public Result verifyCreateCredentialType(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity) {
		Result result;

		result = isUserIdValid(credentialTypeRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}	
			
		result = isNameValid(credentialTypeRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
				
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}


	public Result isNameValid(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity) {
		List<CategoryDAO> categoryDAOs=katavuccolServiceRepository.getCategoryDetailByUserId(credentialTypeRequestMessageEntity.getParsedUserId());
		List<CategoryDAO> filterCategoryDAOs=
										FluentIterable
										.from(categoryDAOs)
										.filter(x-> KatavuccolServiceUtility.isEqual(x.getName(),credentialTypeRequestMessageEntity.getName()))
										.toList();
		if(filterCategoryDAOs == null || filterCategoryDAOs.isEmpty())
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Duplicate credential type is is not allowed", "Name", katavuccolServiceErrorCode.credentialTypeDuplicateErrorCode());
		}
		return new Result(ResultStatus.SUCCESS);
	}


	public Result isUserIdValid(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity) {
		return new Result(ResultStatus.SUCCESS);
	}

}
