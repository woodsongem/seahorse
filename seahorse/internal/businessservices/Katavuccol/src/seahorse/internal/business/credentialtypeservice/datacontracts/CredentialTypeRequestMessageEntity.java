/**
 * 
 */
package seahorse.internal.business.credentialtypeservice.datacontracts;

import java.util.UUID;

import seahorse.internal.business.katavuccolservice.common.datacontracts.BaseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class CredentialTypeRequestMessageEntity extends BaseMessageEntity {
	private UUID id;
	private String name;
	private String description;
	private String userId;
	private UUID parsedUserId;	
	private Boolean isDuplicationAllowed;
	private Boolean isSubitemAllowed;
	private String status;
	
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
	 * @return the isDuplicationAllowed
	 */
	public Boolean getIsDuplicationAllowed() {
		return isDuplicationAllowed;
	}
	/**
	 * @param isDuplicationAllowed the isDuplicationAllowed to set
	 */
	public void setIsDuplicationAllowed(Boolean isDuplicationAllowed) {
		this.isDuplicationAllowed = isDuplicationAllowed;
	}
	/**
	 * @return the isSubitemAllowed
	 */
	public Boolean getIsSubitemAllowed() {
		return isSubitemAllowed;
	}
	/**
	 * @param isSubitemAllowed the isSubitemAllowed to set
	 */
	public void setIsSubitemAllowed(Boolean isSubitemAllowed) {
		this.isSubitemAllowed = isSubitemAllowed;
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
}
