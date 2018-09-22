/**
 * 
 */
package seahorse.internal.business.profileservice;

import java.util.UUID;

import seahorse.internal.business.profileservice.api.datacontracts.UserProfileModel;
import seahorse.internal.business.profileservice.datacontracts.UserProfileMsgEntity;

/**
 * @author admin
 *
 */
public interface IProfileService {

	UserProfileModel getUserProfileByUserId(String userid);
	
	UserProfileMsgEntity getUserProfileMsgEntityByUserId(UUID userid);

}
