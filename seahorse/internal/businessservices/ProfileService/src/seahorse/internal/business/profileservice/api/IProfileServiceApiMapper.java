/**
 * 
 */
package seahorse.internal.business.profileservice.api;

import seahorse.internal.business.profileservice.api.datacontracts.CreateProfileRequestModel;
import seahorse.internal.business.profileservice.datacontracts.CreateUserProfileMsgEntity;

/**
 * @author SMJE
 *
 */
public interface IProfileServiceApiMapper {

	CreateUserProfileMsgEntity MapCreateUserProfileMsgEntity(CreateProfileRequestModel createProfileRequestModel);

}
