/**
 * 
 */
package seahorse.internal.business.profileservice;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.profileservice.datacontracts.CreateUserProfileMsgEntity;
import seahorse.internal.business.profileservice.datacontracts.DeleteUserProfileMsgEntity;
import seahorse.internal.business.profileservice.datacontracts.UpdateUserProfileMsgEntity;

/**
 * @author admin
 *
 */
public interface IProfileServiceProcessor {

	Result processorCreateUserProfile(CreateUserProfileMsgEntity createUserProfileMsgEntity);

	Result processorDeleteUserProfile(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity);

	Result processorDeleteUserProfile(UpdateUserProfileMsgEntity updateUserProfileMsgEntity);

}
