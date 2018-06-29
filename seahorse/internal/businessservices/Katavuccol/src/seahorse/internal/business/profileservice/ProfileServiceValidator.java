/**
 * 
 */
package seahorse.internal.business.profileservice;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;

import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;

/**
 * @author admin
 *
 */
public class ProfileServiceValidator implements IProfileServiceValidator {

	private final IKatavuccolServiceErrorCode katavuccolServiceErrorCode;
	
	@Inject
	public 	ProfileServiceValidator(
			IKatavuccolServiceErrorCode katavuccolServiceErrorCode
			)
	{
		this.katavuccolServiceErrorCode=katavuccolServiceErrorCode;
	}
	
	public Result isUserIdValid(String userId)
	{
		Result result=new Result();
		result.setResultStatus(ResultStatus.SUCCESS);
		if (StringUtils.isBlank(userId)) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"UserId is null","UserId",katavuccolServiceErrorCode.userIdEmptyErrorCode());
		}
		
		if(KatavuccolServiceUtility.isValidUUID(userId))
		{
			return result;
		}
		
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"Invalid user id","UserId",katavuccolServiceErrorCode.userIdInValidFormat());
	}
}
