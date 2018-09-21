/**
 * 
 */
package seahorse.internal.business.profileservice;

import java.util.List;

import seahorse.internal.business.profileservice.api.datacontracts.UserProfileModel;

/**
 * @author admin
 *
 */
public interface IProfileService {

	List<UserProfileModel> getUserProfile(String userid);

}
