/**
 * 
 */
package seahorse.internal.business.profileservice;

import java.util.UUID;

import seahorse.internal.business.profileservice.datacontracts.UserProfileMsgEntity;

/**
 * @author admin
 *
 */
public class BaseProfileService implements IBaseProfileService {

	@Override
	public UserProfileMsgEntity getUserDetail(UUID parsedUserId) {
		UserProfileMsgEntity userMessageEntity=new UserProfileMsgEntity();
		
		return userMessageEntity;
	}

}
