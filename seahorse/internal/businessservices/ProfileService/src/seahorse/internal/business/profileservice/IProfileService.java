/**
 * 
 */
package seahorse.internal.business.profileservice;

import java.util.UUID;

import seahorse.internal.business.profileservice.api.datacontracts.UserProfileModel;
import seahorse.internal.business.profileservice.datacontracts.*;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;

/**
 * @author admin
 *
 */
public interface IProfileService {

	UserProfileModel getUserProfileByUserId(String userid);
	
	UserProfileMsgEntity getUserProfileMsgEntityByUserId(UUID userid);

	Result createUserProfile(CreateUserProfileMsgEntity createUserProfileMsgEntity);
	
	Result deleteUserProfile(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity);

	Result updateUserProfile(UpdateUserProfileMsgEntity updateUserProfileMsgEntity);

}
