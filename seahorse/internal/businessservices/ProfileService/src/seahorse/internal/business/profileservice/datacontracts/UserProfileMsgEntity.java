/**
 * 
 */
package seahorse.internal.business.profileservice.datacontracts;

import java.util.UUID;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.BaseMessageEntity;

/**
 * @author admin
 *
 */
public class UserProfileMsgEntity extends BaseMessageEntity {

	private UUID userId;

	/**
	 * @return the userId
	 */
	public UUID getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
}
