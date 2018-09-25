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
public interface IProfileServiceValidator {

	Result isUserIdValid(String userId);

	Result validCreateUserProfile(CreateUserProfileMsgEntity createUserProfileMsgEntity);

	Result validDeleteUserProfile(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity);

	Result validDeleteUserProfile(UpdateUserProfileMsgEntity updateUserProfileMsgEntity);
}
