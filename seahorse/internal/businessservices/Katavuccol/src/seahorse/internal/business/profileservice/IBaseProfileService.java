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
public interface IBaseProfileService {

	UserMessageEntity getUserDetail(UUID parsedUserId);

}
