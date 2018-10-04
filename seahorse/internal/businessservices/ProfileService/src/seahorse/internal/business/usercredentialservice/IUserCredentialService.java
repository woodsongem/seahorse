/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import seahorse.internal.business.profileservice.api.datacontracts.UserCredentialModel;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.DeleteUserCredentialMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.DeleteUserProfileMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.GetUserCredentialByUserIdMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.UpdateUserCredentialMsgEntity;

/**
 * @author SMJE
 *
 */
public interface IUserCredentialService {

	Result createUserCredential(CreateUserCredentialMsgEntity CreateUserCredentialMsgEntity);

	Result deleteUserCredential(DeleteUserCredentialMsgEntity deleteUserCredentialMsgEntity);

	Result updateUserCredential(UpdateUserCredentialMsgEntity updateUserCredentialMsgEntity);

	UserCredentialModel getUserCredentialByUserId(GetUserCredentialByUserIdMsgEntity getUserCredentialByUserIdMsgEntity);

	Result deleteUserProfile(DeleteUserProfileMsgEntity getUserCredentialByUserIdMsgEntity);

}
