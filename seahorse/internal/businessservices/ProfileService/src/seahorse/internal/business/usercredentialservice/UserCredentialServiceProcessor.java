/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import com.google.inject.Inject;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.DeleteUserProfileMsgEntity;

/**
 * @author SMJE
 *
 */
public class UserCredentialServiceProcessor implements IUserCredentialServiceProcessor {

	private final IBaseUserCredentialService baseUserCredentialService;

	@Inject
	public UserCredentialServiceProcessor(IBaseUserCredentialService baseUserCredentialService) {
		this.baseUserCredentialService = baseUserCredentialService;
	}

	@Override
	public Result processCreateUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		Result result = createUserCredential(createUserCredentialMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		return result;
	}
	
	@Override
	public Result processDeleteUserProfile(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity) {
		Result result = deleteUserCredential(deleteUserProfileMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		return result;
	}

	@Override
	public Result deleteUserCredential(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity) {
		return baseUserCredentialService.deleteUserCredential(deleteUserProfileMsgEntity);
	}

	@Override
	public Result createUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		return baseUserCredentialService.createUserCredential(createUserCredentialMsgEntity);

	}

	

}
