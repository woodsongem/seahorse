/**
 * 
 */
package seahorse.internal.business.credentialservice;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;

import seahorse.internal.business.credentialservice.datacontracts.CreateCredentialRequestMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.DeleteCredentialMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.GetCredentialByUserIdMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;

/**
 * @author admin
 *
 */
public class CredentialServiceValidator implements ICredentialServiceValidator {

	private final IKatavuccolServiceErrorCode katavuccolServiceErrorCode;
	
	@Inject
	public CredentialServiceValidator(KatavuccolServiceErrorCode katavuccolServiceErrorCode)
	{
		this.katavuccolServiceErrorCode=katavuccolServiceErrorCode;
	}
	
	@Override
	public Result validateGetCredentialsByUserId(GetCredentialByUserIdMessageEntity getCredentialByUserIdMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result validateCreateCredential(CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {
		Result result;

		result = isCredentialsRequestMessageEntityValid(credentialRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = isUserIdValid(credentialRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isParentIdValid(credentialRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isCategoryIdValid(credentialRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isTypeIdValid(credentialRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isValueValid(credentialRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isUserEncryptKeyValid(credentialRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return new Result(ResultStatus.SUCCESS);
	}
	
	@Override
	public Result validateUpdateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		Result result;

		result = isUpdateCredentialMessageEntityValid(updateCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = isUserIdValid(updateCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = isCredentialIdValid(updateCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isCategoryTypeIdValid(updateCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return new Result(ResultStatus.SUCCESS);
	}
	
	@Override
	public Result validateDeleteCredential(DeleteCredentialMessageEntity deleteCredentialMessageEntity) {
		Result result;
		result = isDeleteCredentialRequestMessageEntityValid(deleteCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
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
	public Result validateGetCredentials(GetCredentialMessageEntity getCredentialMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Result isDeleteCredentialRequestMessageEntityValid(DeleteCredentialMessageEntity deleteCredentialMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);		
		
		if(deleteCredentialMessageEntity==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"DeleteCredentialRequestMessageEntity is null","DeleteCredentialRequestMessageEntity",katavuccolServiceErrorCode.deleteCredentialRequestMessageEntityIsEmptyErrorCode());
		}
		
		return result;
	}
	
	@Override
	public Result isUserIdValid(DeleteCredentialMessageEntity deleteCredentialMessageEntity) {
		Result result;		
		
		result = isUserIdValid(deleteCredentialMessageEntity.getUserId(),
				katavuccolServiceErrorCode.deleteCredentialInValidUserIdErrorCode(),
				katavuccolServiceErrorCode.deleteCredentialEmptyUserIdErrorCode());
		if(result.getResultStatus()!=ResultStatus.SUCCESS)
		{
			return result;			
		}
		deleteCredentialMessageEntity.setParsedUserId(UUID.fromString(deleteCredentialMessageEntity.getUserId()));
		deleteCredentialMessageEntity.setModifiedBy(UUID.fromString(deleteCredentialMessageEntity.getUserId()));
		return result;
	}
	
	@Override
	public Result isCredentialIdValid(DeleteCredentialMessageEntity deleteCredentialMessageEntity) {
		
		if(StringUtils.isEmpty(deleteCredentialMessageEntity.getCredentialId()))
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"Credential id is empty","CredentialId",katavuccolServiceErrorCode.credentialIdEmptyErrorCode());
		}
		if(KatavuccolServiceUtility.isValidUUID(deleteCredentialMessageEntity.getCredentialId()))
		{
			deleteCredentialMessageEntity.setParsedCredentialId(UUID.fromString(deleteCredentialMessageEntity.getCredentialId()));
			return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
		}
		else
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"Credential id is invalid","CredentialId",katavuccolServiceErrorCode.credentialIdInValidErrorCode());
		}		
	}
	
	
	@Override
	public Result isUpdateCredentialMessageEntityValid(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);		
		
		if(updateCredentialMessageEntity==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"UpdateCredentialMessageEntity is null","UpdateCredentialMessageEntity",katavuccolServiceErrorCode.updateCredentialMessageEntityIsEmptyErrorCode());
		}
		
		return result;		
	}
	
	@Override
	public Result isUserIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		Result result;
		result = isUserIdValid(updateCredentialMessageEntity.getUserId(),
				katavuccolServiceErrorCode.updateCredentialInValidUserIdErrorCode(),
				katavuccolServiceErrorCode.updateCredentialEmptyUserIdErrorCode());
		if(result.getResultStatus()!=ResultStatus.SUCCESS)
		{
			return result;			
		}
		updateCredentialMessageEntity.setParsedUserId(UUID.fromString(updateCredentialMessageEntity.getUserId()));
		updateCredentialMessageEntity.setModifiedBy(updateCredentialMessageEntity.getParsedUserId());
		return result;
	}
	
	@Override
	public Result isCredentialIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		if(updateCredentialMessageEntity.getCredentialId() ==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"Credential Id is null","TypeId",katavuccolServiceErrorCode.updateCredentialIdEmptyErrorCode());
		}
		if(KatavuccolServiceUtility.isValidUUID(updateCredentialMessageEntity.getCredentialId()))
		{
			updateCredentialMessageEntity.setParsedCredentialId(UUID.fromString(updateCredentialMessageEntity.getCredentialId()));
			return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"Credential is inValid","CredentialId",katavuccolServiceErrorCode.updateCredentialIdInValidErrorCode());
	}
	
	@Override
	public Result isCategoryTypeIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		if(updateCredentialMessageEntity.getCredentialTypeId() ==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"TypeId is null","TypeId",katavuccolServiceErrorCode.updateCategoryTypeIdEmptyErrorCode());
		}
		if(KatavuccolServiceUtility.isValidUUID(updateCredentialMessageEntity.getCredentialTypeId()))
		{
			updateCredentialMessageEntity.setParsedCredentialTypeId(UUID.fromString(updateCredentialMessageEntity.getCredentialTypeId()));
			return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"TypeId is inValid","TypeId",katavuccolServiceErrorCode.updateCategoryTypeIdInValidErrorCode());
	}
	
	@Override
	public Result isCredentialsRequestMessageEntityValid(CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);		
		
		if(credentialRequestMessageEntity==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"credentialsRequestMessageEntity is null","CreateCredentialRequestMessageEntity","8989");
		}
		
		return result;
	}
	@Override
	public Result isUserIdValid(CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {
		Result result;		
		
		result = isUserIdValid(credentialRequestMessageEntity.getUserId(),
				katavuccolServiceErrorCode.createCredentialInValidUserIdErrorCode(),
				katavuccolServiceErrorCode.createCredentialEmptyUserIdErrorCode());
		if(result.getResultStatus()!=ResultStatus.SUCCESS)
		{
			return result;			
		}
		credentialRequestMessageEntity.setParsedUserId(UUID.fromString(credentialRequestMessageEntity.getUserId()));
		credentialRequestMessageEntity.setCreatedBy(credentialRequestMessageEntity.getParsedUserId());
		return result;
	}
	@Override
	public Result isUserIdValid(String userId,String errorCode,String nullErrorCode)
	{
		Result result=new Result();
		result.setResultStatus(ResultStatus.SUCCESS);
		if (StringUtils.isBlank(userId)) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"UserId is null","UserId",nullErrorCode);
		}
		
		if(KatavuccolServiceUtility.isValidUUID(userId))
		{
			return result;
		}
		
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"Invalid user id","UserId",errorCode);
	}
	@Override
	public Result isParentIdValid(CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {
		Result result=new Result();
		result.setResultStatus(ResultStatus.SUCCESS);
		if(credentialRequestMessageEntity.getParentCredentialId() == null)
		{
			return result;
		}
		if(KatavuccolServiceUtility.isValidUUID(credentialRequestMessageEntity.getParentCredentialId()))
		{
			credentialRequestMessageEntity.setParsedParentCredentialId(UUID.fromString(credentialRequestMessageEntity.getParentCredentialId()));
			return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"ParentId is inValid","ParentId",katavuccolServiceErrorCode.parentIdInValidErrorCode());
	}
	@Override
	public Result isCategoryIdValid(CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {		
		if(credentialRequestMessageEntity.getCategoryId()==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"CategoryId is null","CategoryId",katavuccolServiceErrorCode.categoryIdEmptyErrorCode());
		}		
		if(KatavuccolServiceUtility.isValidUUID(credentialRequestMessageEntity.getCategoryId()))
		{
			credentialRequestMessageEntity.setParsedCategoryId(UUID.fromString(credentialRequestMessageEntity.getCategoryId()));
			return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"CategoryId is inValid","CategoryId",katavuccolServiceErrorCode.inCategoryIdInValidErrorCode());		
	}
	
	@Override
	public Result isTypeIdValid(CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {
		if(credentialRequestMessageEntity.getTypeId() ==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"TypeId is null","TypeId","8989");
		}
		if(KatavuccolServiceUtility.isValidUUID(credentialRequestMessageEntity.getCategoryId()))
		{
			credentialRequestMessageEntity.setParsedCredentialTypeId(UUID.fromString(credentialRequestMessageEntity.getTypeId()));
			return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"TypeId is inValid","TypeId",katavuccolServiceErrorCode.inTypeIdInValidErrorCode());		
	}
	@Override
	public Result isValueValid(CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);
		
		if(credentialRequestMessageEntity.getValue()==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"Value is null","Value",katavuccolServiceErrorCode.inValueEmptyErrorCode());
		}
		return result;
	}
	
	@Override
	public Result isUserEncryptKeyValid(CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);		
		
		if(StringUtils.isEmpty(credentialRequestMessageEntity.getUserEncryptKey()))
		{			 
		    UUID idOne = UUID.randomUUID();
		    credentialRequestMessageEntity.setUserEncryptKey(idOne.toString().substring(0, 14));
			return result;			
		}
		
		if(credentialRequestMessageEntity.getUserEncryptKey().length() < 8)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"UserEncryptKey is too small","UserEncryptKey",katavuccolServiceErrorCode.createCredentialUserEncryptKeySmall());
		}
		
		if(credentialRequestMessageEntity.getUserEncryptKey().length() > 15)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"UserEncryptKey is too long","UserEncryptKey",katavuccolServiceErrorCode.createCredentialUserEncryptKeyLong());
		}
		
		return result;
	}

	
	

	

}
