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
public interface IUserCredentialServiceProcessor {

	Result processCreateUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

	Result createUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

	Result processDeleteUserProfile(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity);

	Result deleteUserCredential(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity);

}
