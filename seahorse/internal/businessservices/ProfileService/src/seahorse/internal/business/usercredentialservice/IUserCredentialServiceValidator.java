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
public interface IUserCredentialServiceValidator {

	Result validCreateUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

	Result isCreateUserCredentialMsgEntityValid(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

	Result isUserNameValid(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

	Result isPasswordValid(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

	Result isProductItemIdValid(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

	Result validDeleteUserProfile(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity);

	Result isDeleteUserProfileMsgEntityValid(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity);

	Result isUserIdValid(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity);

}
