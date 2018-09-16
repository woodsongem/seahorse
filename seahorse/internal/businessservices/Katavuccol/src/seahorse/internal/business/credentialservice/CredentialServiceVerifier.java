/**
 * 
 */
package seahorse.internal.business.credentialservice;

import java.util.List;
import java.util.Map;

import com.google.common.collect.FluentIterable;
import com.google.gson.Gson;
import com.google.inject.Inject;

import seahorse.internal.business.categoryservice.ICategoryService;
import seahorse.internal.business.categoryservice.datacontracts.CategoryMessageEntity;
import seahorse.internal.business.credentialservice.dal.datacontracts.CredentialDAO;
import seahorse.internal.business.credentialservice.datacontracts.CreateCredentialRequestMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.GetCredentialByUserIdMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.credentialtypeservice.ICredentialTypeService;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByIdMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeMsgEntity;
import seahorse.internal.business.katavuccolservice.IUserCredentialService;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.Ikatavuccolredis;
import seahorse.internal.business.katavuccolservice.common.KatavuccolConstant;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.UserCredentialMessageEntity;

/**
 * @author admin
 *
 */
public class CredentialServiceVerifier implements ICredentialServiceVerifier {
	private final ICredentialServiceVerifierMapper credentialServiceVerifierMapper;
	private final IKatavuccolServiceErrorCode katavuccolServiceErrorCode;
	private final ICredentialServiceRepository credentialServiceRepository;
	private final Ikatavuccolredis katavuccolredis;
	private final IUserCredentialService userCredentialService;
	private final ICategoryService categoryService;
	private final ICredentialTypeService credentialTypeService;
	
	@Inject
	public CredentialServiceVerifier(
			ICredentialServiceVerifierMapper credentialServiceVerifierMapper,
			IKatavuccolServiceErrorCode katavuccolServiceErrorCode, 
			ICredentialServiceRepository credentialServiceRepository,
			Ikatavuccolredis katavuccolredis,
			IUserCredentialService userCredentialService,
			ICategoryService categoryService,
			ICredentialTypeService credentialTypeService)
	{
		this.credentialServiceVerifierMapper = credentialServiceVerifierMapper;
		this.katavuccolServiceErrorCode = katavuccolServiceErrorCode;
		this.credentialServiceRepository = credentialServiceRepository;
		this.katavuccolredis=katavuccolredis;
		this.userCredentialService=userCredentialService;
		this.categoryService=categoryService;
		this.credentialTypeService=credentialTypeService;
	}
	
	@Override
	public Result verifyGetCredentialsByUserId(GetCredentialByUserIdMessageEntity getCredentialByUserIdMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result verifyCreateCredentials(CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {
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
		
		result = isEncryptValid(credentialRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
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
		return new Result(ResultStatus.SUCCESS);	
	}
	
	@Override
	public Result verifyGetCredentials(GetCredentialMessageEntity getCredentialMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Result isCredentialTypeIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		
		if(updateCredentialMessageEntity.getParsedCredentialTypeId() ==null)
		{
			return new Result(ResultStatus.SUCCESS);
		}
		String credentialType=katavuccolredis.getvalue(KatavuccolConstant.REDIS_CREDENTIALTYPE);
		CredentialTypeMsgEntity credentialTypeMsgEntity = null;
		if(credentialType == null)
		{
			credentialTypeMsgEntity = credentialTypeService.getCredentialTypeById(updateCredentialMessageEntity.getParsedCredentialTypeId(),updateCredentialMessageEntity.getParsedUserId());
			katavuccolredis.setvalue(KatavuccolConstant.REDIS_CREDENTIALTYPE, credentialTypeMsgEntity);
		}		
		else
		{
			Gson gson=new Gson();
			credentialTypeMsgEntity =gson.fromJson(credentialType, CredentialTypeMsgEntity.class);
		}
		if(credentialTypeMsgEntity ==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Not able to find category type id", "CategoryTypeId", katavuccolServiceErrorCode.updateCategoryTypeIdNotFoundErrorCode());
		}	
		
		updateCredentialMessageEntity.setCredentialType(credentialTypeMsgEntity);
		
		if(!updateCredentialMessageEntity.getCredential().stream().anyMatch(x->KatavuccolServiceUtility.isEqual(x.getCredentialTypeId(), updateCredentialMessageEntity.getParsedCredentialId())))
		{
			return new Result(ResultStatus.SUCCESS);
		}
		return new Result(ResultStatus.SUCCESS);
	}
	
	@Override
	public Result isCategoryIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		CategoryMessageEntity categoryMessageEntity = categoryService.getCategoryDetailById(updateCredentialMessageEntity.getParsedCategoryId(),updateCredentialMessageEntity.getParsedUserId());
		if(categoryMessageEntity ==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Not able to find categoryid", "CategoryId", katavuccolServiceErrorCode.categoryIdNotFoundErrorCode());
		}		
		updateCredentialMessageEntity.setCategory(categoryMessageEntity);		
				
		return new Result(ResultStatus.SUCCESS);
	}
	
	@Override
	public Result isUserIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		UserCredentialMessageEntity userCredentialMessageEntity=userCredentialService.getUserCredential(updateCredentialMessageEntity.getParsedUserId());
		if(userCredentialMessageEntity == null || userCredentialMessageEntity.getUserId()==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "InValid user Id", "UserId", katavuccolServiceErrorCode.createCredentialUserIdNotFoundErrorCode());
		}
		
		return new Result(ResultStatus.SUCCESS);
	}
	
	@Override
	public Result isCredentialIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		List<CredentialDAO>  credentialDAOs=credentialServiceRepository.getCredentialByUserId(updateCredentialMessageEntity.getParsedUserId());
		
		List<CredentialDAO>  curCredentialDAOs =FluentIterable
								.from(credentialDAOs)
								.filter(x-> KatavuccolServiceUtility.isEqual(x.getId(),updateCredentialMessageEntity.getParsedCredentialId()))
								.toList();
		
		if(credentialDAOs == null || credentialDAOs.isEmpty() || curCredentialDAOs.isEmpty())
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Not able to find category id", "CategoryId", katavuccolServiceErrorCode.updateCredentialIdNotFoundErrorCode());
		}
		updateCredentialMessageEntity.setParsedCategoryId(curCredentialDAOs.get(0).getCategoryId());
		List<CredentialDAO>  categoryCredentialDAOs=
				FluentIterable
				.from(credentialDAOs)
				.filter(x-> KatavuccolServiceUtility.isEqual(x.getCategoryId(),updateCredentialMessageEntity.getParsedCategoryId()))
				.toList();				
		
		if(categoryCredentialDAOs == null || categoryCredentialDAOs.isEmpty())
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Not able to find category id", "CategoryId", katavuccolServiceErrorCode.updateCredentialIdNotFoundErrorCode());
		}
		
		updateCredentialMessageEntity.setCredential(credentialDAOs);
		return new Result(ResultStatus.SUCCESS);
	}
	
	
	@Override
	public Result isUserIdValid(CreateCredentialRequestMessageEntity credentialsRequestMessageEntity) {
		UserCredentialMessageEntity userCredentialMessageEntity=userCredentialService.getUserCredential(credentialsRequestMessageEntity.getParsedUserId());
		if(userCredentialMessageEntity == null || userCredentialMessageEntity.getUserId()==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "InValid user Id", "UserId", katavuccolServiceErrorCode.createCredentialUserIdNotFoundErrorCode());
		}
		
		return new Result(ResultStatus.SUCCESS);
	}
	@Override
	public Result isCategoryIdValid(CreateCredentialRequestMessageEntity credentialsRequestMessageEntity) {		
		CategoryMessageEntity categoryMessageEntity = categoryService.getCategoryDetailById(credentialsRequestMessageEntity.getParsedCategoryId(),credentialsRequestMessageEntity.getParsedUserId());
		if(categoryMessageEntity ==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Not able to find categoryid", "CategoryId", katavuccolServiceErrorCode.categoryIdNotFoundErrorCode());
		}		
		credentialsRequestMessageEntity.setCategory(categoryMessageEntity);
		return new Result(ResultStatus.SUCCESS);
	}
	
	@Override
	public Result isCredentialTypeIdValid(CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {	
		String credentialType=katavuccolredis.getvalue(KatavuccolConstant.REDIS_CREDENTIALTYPE);
		CredentialTypeMsgEntity credentialTypeMsgEntity = null;
		if(credentialType == null)
		{
			CredentialTypeByIdMsgEntity credentialTypeByIdMsgEntity=credentialServiceVerifierMapper.mapCredentialTypeByIdMsgEntity(credentialRequestMessageEntity);
			credentialTypeMsgEntity = credentialTypeService.getCredentialTypeById(credentialTypeByIdMsgEntity);
			katavuccolredis.setvalue(KatavuccolConstant.REDIS_CREDENTIALTYPE, credentialTypeMsgEntity);
		}		
		else
		{
			Gson gson=new Gson();
			credentialTypeMsgEntity =gson.fromJson(credentialType, CredentialTypeMsgEntity.class);
		}
		if(credentialTypeMsgEntity ==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Not able to find category type id", "CategoryTypeId", katavuccolServiceErrorCode.categoryTypeIdNotFoundErrorCode());
		}
		
		if(credentialRequestMessageEntity.getParsedParentCredentialId() !=null && !credentialRequestMessageEntity.getCredentialType().getIsSubitemAllowed())
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Sub entry is not allowed for this Credential type", "CategoryTypeId", katavuccolServiceErrorCode.categoryTypeSubEntryNotAllowedErrorCode());
		}
		credentialRequestMessageEntity.setCredentialType(credentialTypeMsgEntity);		
		return new Result(ResultStatus.SUCCESS);
	}
	
	@Override
	public Result isCredentialTypeDuplicateAllowedValid(CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {		
		
		if(credentialRequestMessageEntity.getIsCredentialNull() || credentialRequestMessageEntity.getParsedParentCredentialId() != null )
		{
			return new Result(ResultStatus.SUCCESS);
		}
		List<CredentialDAO>  credentialDAOs=credentialServiceRepository.getCredentialByUserId(credentialRequestMessageEntity.getParsedUserId());
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
		credentialRequestMessageEntity.setCredential(credentialDAOs);
		return new Result(ResultStatus.SUCCESS);
	}
	
	@Override
	public Result isCredentialTypeSubItemAllowedValid(CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {
		if(credentialRequestMessageEntity.getIsCredentialNull() || credentialRequestMessageEntity.getParsedParentCredentialId() == null)
		{
			return new Result(ResultStatus.SUCCESS);
		}
		List<CredentialDAO>  credentialDAOs=credentialServiceRepository.getCredentialByUserId(credentialRequestMessageEntity.getParsedUserId());
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
		credentialRequestMessageEntity.setCredential(credentialDAOs);
		return new Result(ResultStatus.SUCCESS);
	}
	
	@Override
	public Result isEncryptValid(CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {
		
		Map<String,String> encryptedvalue=seahorse.internal.business.katavuccolservice.utilities.KatavuccolServiceUtility.
				encrypt(credentialRequestMessageEntity.getUserEncryptKey(), credentialRequestMessageEntity.getValue());
		
		if(encryptedvalue ==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Error in Encrypt", "", katavuccolServiceErrorCode.createCredentialEncryptErrorCode());
		}
		
		credentialRequestMessageEntity.setEncryptValue(encryptedvalue.get(KatavuccolConstant.CREDENTIAL_ENCRYPT_VALUE));
		credentialRequestMessageEntity.setEncryptKey(encryptedvalue.get(KatavuccolConstant.CREDENTIAL_ENCRYPT_KEY));
		
		return new Result(ResultStatus.SUCCESS);		
	}

	
	
	@Override
	public Result isUserIdValid(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
		UserCredentialMessageEntity userCredentialMessageEntity=userCredentialService.getUserCredential(deleteCredentialMessageEntity.getParsedUserId());
		if(userCredentialMessageEntity == null || userCredentialMessageEntity.getUserId()==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "InValid user Id", "UserId", katavuccolServiceErrorCode.createCredentialUserIdNotFoundErrorCode());
		}
		
		return new Result(ResultStatus.SUCCESS);
	}
	
	@Override
	public Result isCredentialIdValid(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
		CredentialDAO  credentialDAO=credentialServiceRepository.getCredentialById(deleteCredentialMessageEntity);
		if(credentialDAO == null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Not able to find credential id", "CredentialId", katavuccolServiceErrorCode.credentialIdNotFoundErrorCode());
		}
	//	CredentialMessageEntity credentialMessageEntity=credentialServiceVerifierMapper.MapCredentialMessageEntity(credentialDAO);		
		deleteCredentialMessageEntity.setCredential(credentialDAO);
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}



}
