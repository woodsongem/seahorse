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
public interface IProfileServiceVerifier {

	Result verifyCreateUserProfile(CreateUserProfileMsgEntity createUserProfileMsgEntity);

	Result verifyDeleteUserProfile(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity);

	Result verifyDeleteUserProfile(UpdateUserProfileMsgEntity updateUserProfileMsgEntity);

}
