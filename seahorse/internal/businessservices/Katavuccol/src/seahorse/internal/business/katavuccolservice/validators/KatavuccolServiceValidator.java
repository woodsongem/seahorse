/**
 * 
 */
package seahorse.internal.business.katavuccolservice.validators;

import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import com.google.inject.Inject;

import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;


/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceValidator implements IKatavuccolServiceValidator {
	
	private final IBaseValidator baseValidator;
	private final IKatavuccolServiceErrorCode katavuccolServiceErrorCode;
	
	@Inject
	public KatavuccolServiceValidator(IBaseValidator baseValidator,IKatavuccolServiceErrorCode katavuccolServiceErrorCode)
	{
		this.baseValidator=baseValidator;
		this.katavuccolServiceErrorCode=katavuccolServiceErrorCode;
	}

	@Override
	public Result validateCreateCredentials(CredentialRequestMessageEntity credentialRequestMessageEntity) {
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
		
		return new Result(ResultStatus.SUCCESS);
	}
	
	public Result isParentIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity) {
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

	public Result isValueValid(CredentialRequestMessageEntity credentialRequestMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);
		
		if(credentialRequestMessageEntity.getValue()==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"Value is null","Value",katavuccolServiceErrorCode.inValueEmptyErrorCode());
		}
		return result;
	}

	public Result isTypeIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity) {
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

	public Result isCategoryIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity) {		
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

	public Result isUserIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity) {
		Result result;		
		
		result = isUserIdValid(credentialRequestMessageEntity.getUserId(),
				katavuccolServiceErrorCode.createCredentialInValidUserIdErrorCode(),
				katavuccolServiceErrorCode.createCredentialEmptyUserIdErrorCode());
		if(result.getResultStatus()!=ResultStatus.SUCCESS)
		{
			return result;			
		}
		credentialRequestMessageEntity.setParsedUserId(UUID.fromString(credentialRequestMessageEntity.getUserId()));
		return result;
	}
	
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
	
	public Result isCredentialsRequestMessageEntityValid(CredentialRequestMessageEntity credentialRequestMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);		
		
		if(credentialRequestMessageEntity==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"credentialsRequestMessageEntity is null","CredentialsRequestMessageEntity","8989");
		}
		
		return result;
	}

	@Override
	public Result validateGetCredentials(GetCredentialMessageEntity getCredentialMessageEntity) {
		Result result;

		result = isGetCredentialMessageEntityValid(getCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isUserIdValid(getCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return result;
	}

	public Result isUserIdValid(GetCredentialMessageEntity getCredentialMessageEntity) {
		Result result;	
		
		result = isUserIdValid(getCredentialMessageEntity.getUserId(),
				katavuccolServiceErrorCode.getCredentialInValidUserIdErrorCode(),
				katavuccolServiceErrorCode.getCredentialEmptyUserIdErrorCode());
		if(result.getResultStatus()!=ResultStatus.SUCCESS)
		{
			return result;			
		}
		getCredentialMessageEntity.setParsedUserId(UUID.fromString(getCredentialMessageEntity.getUserId()));
		return result;
	}

	public Result isGetCredentialMessageEntityValid(GetCredentialMessageEntity getCredentialMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);	
		
		if(getCredentialMessageEntity==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"getCredentialMessageEntity is null","GetCredentialMessageEntity",katavuccolServiceErrorCode.getCredentialMessageEntityEmptyErrorCode());
		}
		
		return result;
	}

	@Override
	public Result validateDeleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
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

	public Result isCredentialIdValid(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
		
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

	public Result isUserIdValid(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
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

	public Result isDeleteCredentialRequestMessageEntityValid(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);		
		
		if(deleteCredentialMessageEntity==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"DeleteCredentialRequestMessageEntity is null","DeleteCredentialRequestMessageEntity",katavuccolServiceErrorCode.deleteCredentialRequestMessageEntityIsEmptyErrorCode());
		}
		
		return result;
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


	public Result isCategoryIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		if(updateCredentialMessageEntity.getCategoryId()==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"CategoryId is null","CategoryId",katavuccolServiceErrorCode.updateCategoryIdEmptyErrorCode());
		}		
		if(KatavuccolServiceUtility.isValidUUID(updateCredentialMessageEntity.getCategoryId()))
		{
			updateCredentialMessageEntity.setParsedCategoryId(UUID.fromString(updateCredentialMessageEntity.getCategoryId()));
			return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"CategoryId is inValid","CategoryId",katavuccolServiceErrorCode.updateCategoryIdInValidErrorCode());
	}

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

	public Result isUpdateCredentialMessageEntityValid(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);		
		
		if(updateCredentialMessageEntity==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"UpdateCredentialMessageEntity is null","UpdateCredentialMessageEntity",katavuccolServiceErrorCode.updateCredentialMessageEntityIsEmptyErrorCode());
		}
		
		return result;		
	}

	@Override
	public Result validateCreateCredentialType(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity) {
		Result result;

		result = isCredentialTypeRequestMessageEntityValid(credentialTypeRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isUserIdValid(credentialTypeRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isNameValid(credentialTypeRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
				
		return new Result(ResultStatus.SUCCESS);
	}

	public Result isNameValid(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);		
		
		if(credentialTypeRequestMessageEntity.getName() == null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"name is null","Name",katavuccolServiceErrorCode.credentialTypeNameIsEmptyErrorCode());
		}
		
		return result;
	}

	public Result isUserIdValid(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity) {
		Result result;		
		
		result = isUserIdValid(credentialTypeRequestMessageEntity.getUserId(),
				katavuccolServiceErrorCode.createCredentialInValidUserIdErrorCode(),
				katavuccolServiceErrorCode.createCredentialEmptyUserIdErrorCode());
		if(result.getResultStatus()!=ResultStatus.SUCCESS)
		{
			return result;			
		}
		credentialTypeRequestMessageEntity.setParsedUserId(UUID.fromString(credentialTypeRequestMessageEntity.getUserId()));
		return result;
	}

	public Result isCredentialTypeRequestMessageEntityValid(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);		
		
		if(credentialTypeRequestMessageEntity==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"credentialTypeRequestMessageEntity is null","credentialTypeRequestMessageEntity",katavuccolServiceErrorCode.credentialTypeMessageEntityIsEmptyErrorCode());
		}
		
		return result;
	}

	@Override
	public Result validateCreateCategory(CategoryRequestMessageEntity categoryRequestMessageEntity) {
		Result result;

		result = isCategoryRequestMessageEntityValid(categoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = isUserIdValid(categoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = isNameValid(categoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return new Result(ResultStatus.SUCCESS);
	}

	public Result isNameValid(CategoryRequestMessageEntity categoryRequestMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);		
		
		if(StringUtils.isEmpty(categoryRequestMessageEntity.getName()))
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"categoryRequestMessageEntity is null","CategoryRequestMessageEntity",katavuccolServiceErrorCode.createCategoryNameIsEmptyErrorCode());
		}
		
		return result;
	}

	public Result isUserIdValid(CategoryRequestMessageEntity categoryRequestMessageEntity) {
		Result result;		
		
		result = isUserIdValid(categoryRequestMessageEntity.getUserId(),
				katavuccolServiceErrorCode.createCategoryInValidUserIdErrorCode(),
				katavuccolServiceErrorCode.createCategoryEmptyUserIdErrorCode());
		if(result.getResultStatus()!=ResultStatus.SUCCESS)
		{
			return result;			
		}
		categoryRequestMessageEntity.setParsedUserId(UUID.fromString(categoryRequestMessageEntity.getUserId()));
		categoryRequestMessageEntity.setCreatedBy(categoryRequestMessageEntity.getParsedUserId());
		return result;
	}

	public Result isCategoryRequestMessageEntityValid(CategoryRequestMessageEntity categoryRequestMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);		
		
		if(categoryRequestMessageEntity==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"CategoryRequestMessageEntity is null","CategoryRequestMessageEntity",katavuccolServiceErrorCode.categoryRequestMessageEntityIsEmptyErrorCode());
		}
		
		return result;
	}

	@Override
	public Result validateDeleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		Result result;

		result = isDeleteCategoryRequestMessageEntityValid(deleteCategoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isUserIdValid(deleteCategoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isCategoryIdValid(deleteCategoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return new Result(ResultStatus.SUCCESS);
	}

	public Result isCategoryIdValid(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		if(deleteCategoryRequestMessageEntity.getCategoryId()==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"CategoryId is null","CategoryId",katavuccolServiceErrorCode.deleteCategoryIdEmptyErrorCode());
		}		
		if(KatavuccolServiceUtility.isValidUUID(deleteCategoryRequestMessageEntity.getCategoryId()))
		{
			deleteCategoryRequestMessageEntity.setParsedCategoryId(UUID.fromString(deleteCategoryRequestMessageEntity.getCategoryId()));
			return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"CategoryId is inValid","CategoryId",katavuccolServiceErrorCode.deleteCategoryIdInValidErrorCode());
	}

	public Result isUserIdValid(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		Result result;		
		
		result = isUserIdValid(deleteCategoryRequestMessageEntity.getUserId(),
				katavuccolServiceErrorCode.deleteCategoryInValidUserIdErrorCode(),
				katavuccolServiceErrorCode.deleteCategoryEmptyUserIdErrorCode());
		if(result.getResultStatus()!=ResultStatus.SUCCESS)
		{
			return result;			
		}
		deleteCategoryRequestMessageEntity.setParsedUserId(UUID.fromString(deleteCategoryRequestMessageEntity.getUserId()));
		deleteCategoryRequestMessageEntity.setModifiedBy(deleteCategoryRequestMessageEntity.getParsedUserId());
		return result;
	}

	public Result isDeleteCategoryRequestMessageEntityValid(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);		
		
		if(deleteCategoryRequestMessageEntity==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"DeleteCategoryRequestMessageEntity is null","DeleteCategoryRequestMessageEntity",katavuccolServiceErrorCode.deleteCategoryRequestMessageEntityIsEmptyErrorCode());
		}
		
		return result;
	}

	@Override
	public Result validateGetCategory(GetCategoryMessageEntity getCategoryMessageEntity) {
		Result result;

		result = isGetCategoryMessageEntityValid(getCategoryMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isUserIdValid(getCategoryMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return new Result(ResultStatus.SUCCESS);
	}

	public Result isGetCategoryMessageEntityValid(GetCategoryMessageEntity getCategoryMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);		
		
		if(getCategoryMessageEntity==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"GetCategoryMessageEntity is null","GetCategoryMessageEntity",katavuccolServiceErrorCode.getCategoryMessageEntityIsEmptyErrorCode());
		}
		
		return result;
	}

	public Result isUserIdValid(GetCategoryMessageEntity getCategoryMessageEntity) {
		Result result;		
		
		result = isUserIdValid(getCategoryMessageEntity.getUserId(),
				katavuccolServiceErrorCode.getCategoryInValidUserIdErrorCode(),
				katavuccolServiceErrorCode.getCategoryEmptyUserIdErrorCode());
		if(result.getResultStatus()!=ResultStatus.SUCCESS)
		{
			return result;			
		}
		getCategoryMessageEntity.setParsedUserId(UUID.fromString(getCategoryMessageEntity.getUserId()));
		getCategoryMessageEntity.setModifiedBy(getCategoryMessageEntity.getParsedUserId());
		return result;
	}
}
