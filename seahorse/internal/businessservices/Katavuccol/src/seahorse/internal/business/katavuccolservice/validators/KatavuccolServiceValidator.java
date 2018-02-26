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
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsRequestMessageEntity;

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
	public Result validateCreateCredentials(CredentialsRequestMessageEntity credentialsRequestMessageEntity) {
		Result result;

		result = isCredentialsRequestMessageEntityValid(credentialsRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = isUserIdValid(credentialsRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isCategoryIdValid(credentialsRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isTypeIdValid(credentialsRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isValueValid(credentialsRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return new Result(ResultStatus.SUCCESS);
	}

	public Result isValueValid(CredentialsRequestMessageEntity credentialsRequestMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);
		
		if(credentialsRequestMessageEntity.getValue()==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"Value is null","Value",katavuccolServiceErrorCode.inValueEmptyErrorCode());
		}
		return result;
	}

	public Result isTypeIdValid(CredentialsRequestMessageEntity credentialsRequestMessageEntity) {
		if(credentialsRequestMessageEntity.getTypeId() ==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"TypeId is null","TypeId","8989");
		}
		if(KatavuccolServiceUtility.isValidUUID(credentialsRequestMessageEntity.getCategoryId()))
		{
			credentialsRequestMessageEntity.setParsedTypeId(UUID.fromString(credentialsRequestMessageEntity.getTypeId()));
			return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"TypeId is inValid","TypeId",katavuccolServiceErrorCode.inTypeIdInValidErrorCode());		
	}

	public Result isCategoryIdValid(CredentialsRequestMessageEntity credentialsRequestMessageEntity) {		
		if(credentialsRequestMessageEntity.getCategoryId()==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"CategoryId is null","CategoryId","8989");
		}		
		if(KatavuccolServiceUtility.isValidUUID(credentialsRequestMessageEntity.getCategoryId()))
		{
			credentialsRequestMessageEntity.setParsedCategoryId(UUID.fromString(credentialsRequestMessageEntity.getCategoryId()));
			return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"CategoryId is inValid","CategoryId",katavuccolServiceErrorCode.inCategoryIdInValidErrorCode());		
	}

	public Result isUserIdValid(CredentialsRequestMessageEntity credentialsRequestMessageEntity) {
		Result result;		
		
		result = isUserIdValid(credentialsRequestMessageEntity.getUserId());
		if(result.getResultStatus()!=ResultStatus.SUCCESS)
		{
			return result;			
		}
		credentialsRequestMessageEntity.setParsedUserId(UUID.fromString(credentialsRequestMessageEntity.getUserId()));
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
	
	public Result isCredentialsRequestMessageEntityValid(CredentialsRequestMessageEntity credentialsRequestMessageEntity) {
		Result result=new Result(ResultStatus.SUCCESS);		
		
		if(credentialsRequestMessageEntity==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"credentialsRequestMessageEntity is null","CredentialsRequestMessageEntity","8989");
		}
		
		return result;
	}
}
