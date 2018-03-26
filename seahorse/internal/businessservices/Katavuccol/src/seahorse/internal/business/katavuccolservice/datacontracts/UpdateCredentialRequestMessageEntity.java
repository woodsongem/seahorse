/**
 * 
 */
package seahorse.internal.business.katavuccolservice.datacontracts;

import java.util.UUID;

import seahorse.internal.business.katavuccolservice.common.datacontracts.BaseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class UpdateCredentialRequestMessageEntity extends BaseMessageEntity {
	private String userId;		
	private String credentialId;
	private UUID parsedUserId;
	private UUID parsedCredentialId;
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
	 * @return the credentialId
	 */
	public String getCredentialId() {
		return credentialId;
	}
	/**
	 * @param credentialId the credentialId to set
	 */
	public void setCredentialId(String credentialId) {
		this.credentialId = credentialId;
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
	/**
	 * @return the parsedCredentialId
	 */
	public UUID getParsedCredentialId() {
		return parsedCredentialId;
	}
	/**
	 * @param parsedCredentialId the parsedCredentialId to set
	 */
	public void setParsedCredentialId(UUID parsedCredentialId) {
		this.parsedCredentialId = parsedCredentialId;
	}
}
