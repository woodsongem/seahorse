/**
 * 
 */
package seahorse.internal.business.katavuccolservice.validators;

import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.datacontracts.GetUserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public class UserCredentialServiceValidator implements IUserCredentialServiceValidator {

	@Override
	public Result validateGetUserCredential(GetUserCredentialMessageEntity getUserCredentialMessageEntity) {
	
		Result result;
		
		result = isUserIdValid(getUserCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return result;
	}

	public Result isUserIdValid(GetUserCredentialMessageEntity getUserCredentialMessageEntity) {
		Result result=new Result();
		result.setResultStatus(ResultStatus.SUCCESS);
		if (getUserCredentialMessageEntity.getUserId()==null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"UserId is null","UserId","");
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"Invalid user id","UserId","");
	}

	public Result isGetUserCredentialMessageEntityValid(GetUserCredentialMessageEntity getUserCredentialMessageEntity) {
		Result result=new Result();
		result.setResultStatus(ResultStatus.SUCCESS);
		if (getUserCredentialMessageEntity==null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"GetUserCredentialMessageEntity is null","UserId","");
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"GetUserCredentialMessageEntity user id","UserId","");
	}	
}
