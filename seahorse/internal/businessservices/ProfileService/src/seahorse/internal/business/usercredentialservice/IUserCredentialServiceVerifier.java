/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.DeleteUserProfileMsgEntity;

/**
 * @author SMJE
 *
 */
public interface IUserCredentialServiceVerifier {

	Result verifyCreateUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

	Result IsUserNameValid(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

	Result IsProductItemValid(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

	Result verifyDeleteUserProfile(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity);

	Result IsUserIdValid(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity);

}
