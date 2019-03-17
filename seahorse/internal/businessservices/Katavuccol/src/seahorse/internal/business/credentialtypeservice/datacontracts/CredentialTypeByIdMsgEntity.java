/**
 * 
 */
package seahorse.internal.business.credentialtypeservice.datacontracts;

import seahorse.internal.business.katavuccolservice.datacontracts.RequestMessageEntity;

/**
 * @author admin
 *
 */
public class CredentialTypeByIdMsgEntity extends RequestMessageEntity {

	private String userId;
	private String credentialTypeId;
	private String parsedUserId;
	private String parsedCredentialTypeId;
	
	
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
	 * @return the credentialTypeId
	 */
	public String getCredentialTypeId() {
		return credentialTypeId;
	}
	/**
	 * @param credentialTypeId the credentialTypeId to set
	 */
	public void setCredentialTypeId(String credentialTypeId) {
		this.credentialTypeId = credentialTypeId;
	}
	/**
	 * @return the parsedUserId
	 */
	public String getParsedUserId() {
		return parsedUserId;
	}
	/**
	 * @param parsedUserId the parsedUserId to set
	 */
	public void setParsedUserId(String parsedUserId) {
		this.parsedUserId = parsedUserId;
	}
	/**
	 * @return the parsedCredentialTypeId
	 */
	public String getParsedCredentialTypeId() {
		return parsedCredentialTypeId;
	}
	/**
	 * @param parsedCredentialTypeId the parsedCredentialTypeId to set
	 */
	public void setParsedCredentialTypeId(String parsedCredentialTypeId) {
		this.parsedCredentialTypeId = parsedCredentialTypeId;
	}
	
}
