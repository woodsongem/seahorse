/**
 * 
 */
package seahorse.internal.business.usercredentialservice.datacontracts;

import java.util.UUID;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.BaseMessageEntity;

/**
 * @author SMJE
 *
 */
public class DeleteUserProfileMsgEntity extends BaseMessageEntity {

	private String userId;
	private UUID parsedUserId;
	private String status;
	
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
