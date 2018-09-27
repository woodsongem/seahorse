/**
 * 
 */
package seahorse.internal.business.profileservice.api;

import seahorse.internal.business.profileservice.api.datacontracts.CreateProfileRequestModel;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.GetUserCredentialByUserIdMsgEntity;

/**
 * @author SMJE
 *
 */
public interface IProfileServiceApiMapper {

	CreateUserCredentialMsgEntity MapCreateUserCredentialMsgEntity(CreateProfileRequestModel createProfileRequestModel);

	GetUserCredentialByUserIdMsgEntity MapGetUserCredentialByUserIdMsgEntity(String userid);

}
