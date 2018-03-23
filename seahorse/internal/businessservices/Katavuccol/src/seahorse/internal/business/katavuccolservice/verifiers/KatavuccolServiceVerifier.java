/**
 * 
 */
package seahorse.internal.business.katavuccolservice.verifiers;

import java.util.List;

import com.google.gson.Gson;
import com.google.inject.Inject;
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

}
