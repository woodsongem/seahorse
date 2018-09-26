/**
 * 
 */
package seahorse.internal.business.profileservice.datacontracts;

import java.util.UUID;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.BaseMessageEntity;

/**
 * @author SMJE
 *
 */
public class DeleteUserProfileMsgEntity extends BaseMessageEntity {
	
	private String userId;
	private UUID parsedUserId;
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the parsedUserId
	 */
	public UUID getParsedUserId() {
		return parsedUserId;
	}
	/**
	 * @param parsedUserId the parsedUserId to set
	 */
	public void setParsedUserId(UUID parsedUserId) {
		this.parsedUserId = parsedUserId;
	}
}
