/**
 * 
 */
package seahorse.internal.business.credentialtypeservice.datacontracts;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeModel;
import seahorse.internal.business.katavuccolservice.datacontracts.RequestMessageEntity;

/**
 * @author admin
 *
 */
public class CredentialTypeByUserIdMsgEntity extends RequestMessageEntity {

	private String userId;
	private UUID parsedUserId;
	private String id;
	private UUID parsedId;
	private List<CredentialTypeModel> credentialType;

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

	/**
	 * @return the credentialType
	 */
	public List<CredentialTypeModel> getCredentialType() {
		return credentialType;
	}

	/**
	 * @param credentialType the credentialType to set
	 */
	public void setCredentialType(List<CredentialTypeModel> credentialType) {
		this.credentialType = credentialType;
	}

	/**
	 * @return the parsedId
	 */
	public UUID getParsedId() {
		return parsedId;
	}

	/**
	 * @param parsedId the parsedId to set
	 */
	public void setParsedId(UUID parsedId) {
		this.parsedId = parsedId;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}
