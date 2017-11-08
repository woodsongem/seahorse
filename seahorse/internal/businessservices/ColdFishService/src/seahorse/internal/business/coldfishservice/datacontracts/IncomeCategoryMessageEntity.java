/**
 * 
 */
package seahorse.internal.business.coldfishservice.datacontracts;

import java.util.UUID;

import seahorse.internal.business.coldfishservice.processors.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public class IncomeCategoryMessageEntity {

	private UUID id;
	private String name;
	private String userId;
	private String description;
	private UUID parsedUserId;
	private UserCredentialMessageEntity userCredential;
	
	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the userCredential
	 */
	public UserCredentialMessageEntity getUserCredential() {
		return userCredential;
	}
	/**
	 * @param userCredential the userCredential to set
	 */
	public void setUserCredential(UserCredentialMessageEntity userCredential) {
		this.userCredential = userCredential;
	}
}
