/**
 * 
 */
package seahorse.internal.business.profileservice;

import seahorse.internal.business.profileservice.datacontracts.CreateUserProfileMsgEntity;
import seahorse.internal.business.profileservice.datacontracts.DeleteUserProfileMsgEntity;
import seahorse.internal.business.profileservice.datacontracts.UpdateUserProfileMsgEntity;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;

/**
 * @author admin
 *
 */
public interface IProfileServicePostProcessor {

	Result postProcessorCreateUserProfile(CreateUserProfileMsgEntity createUserProfileMsgEntity);

	Result postProcessorDeleteUserProfile(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity);

	Result postProcessorDeleteUserProfile(UpdateUserProfileMsgEntity updateUserProfileMsgEntity);

}
