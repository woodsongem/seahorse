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
public interface IBaseProfileService {

	UserProfileMsgEntity getUserDetail(UUID parsedUserId);

}
