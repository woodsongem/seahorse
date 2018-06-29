/**
 * 
 */
package seahorse.internal.business.profileservice;

import java.util.UUID;

import seahorse.internal.business.profileservice.datacontracts.UserMessageEntity;

/**
 * @author admin
 *
 */
public class BaseProfileService implements IBaseProfileService {

	@Override
	public UserMessageEntity getUserDetail(UUID parsedUserId) {
		UserMessageEntity userMessageEntity=new UserMessageEntity();
		
		return userMessageEntity;
	}

}
