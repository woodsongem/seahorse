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
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;


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
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"CategoryId is null","CategoryId","8989");
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
		
		result = isUserIdValid(credentialRequestMessageEntity.getUserId());
		if(result.getResultStatus()!=ResultStatus.SUCCESS)
		{
			return result;			
		}
		credentialRequestMessageEntity.setParsedUserId(UUID.fromString(credentialRequestMessageEntity.getUserId()));
		return result;
	}
	
	public Result isUserIdValid(String userId)
	{
		Result result=new Result();
		result.setResultStatus(ResultStatus.SUCCESS);
		if (StringUtils.isBlank(userId)) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"UserId is null","UserId","8989");
		}
		
		if(KatavuccolServiceUtility.isValidUUID(userId))
		{
			return result;
		}
		
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"Invalid user id","UserId","8989");
	}
	
	public Result isCredentialsRequestMessageEntityValid(CredentialRequestMessageEntity credentialRequestMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);		
		
		if(credentialRequestMessageEntity==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"credentialsRequestMessageEntity is null","CredentialsRequestMessageEntity","8989");
		}
		
		return result;
	}
}
