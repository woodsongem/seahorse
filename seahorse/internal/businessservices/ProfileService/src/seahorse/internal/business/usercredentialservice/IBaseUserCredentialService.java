/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import java.util.UUID;

import seahorse.internal.business.profileservice.api.datacontracts.UserCredentialModel;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.DeleteUserProfileMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.UserCredentialMsgEntity;

/**
 * @author SMJE
 *
 */
public interface IBaseUserCredentialService {

	UserCredentialMsgEntity getUserCredentialByUserName(String username);

	Result createUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

	UserCredentialModel getUserCredentialModelByUserId(UUID parsedUserId);

	UserCredentialMsgEntity getUserCredentialByUserId(UUID parsedUserId);

	Result deleteUserCredential(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity);

}
