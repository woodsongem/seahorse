/**
 * 
 */
package seahorse.internal.business.profileservice;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;

import seahorse.internal.business.profileservice.datacontracts.CreateUserProfileMsgEntity;
import seahorse.internal.business.profileservice.datacontracts.DeleteUserProfileMsgEntity;
import seahorse.internal.business.profileservice.datacontracts.UpdateUserProfileMsgEntity;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.*;

/**
 * @author admin
 *
 */
public class ProfileServiceValidator implements IProfileServiceValidator {

	private final IKatavuccolServiceErrorCode katavuccolServiceErrorCode;

	@Inject
	public ProfileServiceValidator(IKatavuccolServiceErrorCode katavuccolServiceErrorCode) {
		this.katavuccolServiceErrorCode = katavuccolServiceErrorCode;
	}

	public Result isUserIdValid(String userId) {
		Result result = new Result();
		result.setResultStatus(ResultStatus.SUCCESS);
		if (StringUtils.isBlank(userId)) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UserId is null", "UserId",
					katavuccolServiceErrorCode.userIdEmptyErrorCode());
		}

		if (KatavuccolServiceUtility.isValidUUID(userId)) {
			return result;
		}

		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Invalid user id", "UserId",
				katavuccolServiceErrorCode.userIdInValidFormat());
	}

	@Override
	public Result validCreateUserProfile(CreateUserProfileMsgEntity createUserProfileMsgEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result validDeleteUserProfile(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result validDeleteUserProfile(UpdateUserProfileMsgEntity updateUserProfileMsgEntity) {
		// TODO Auto-generated method stub
		return null;
	}
}
