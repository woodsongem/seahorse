/**
 * 
 */
package seahorse.internal.business.credentialtypeservice.datacontracts;

import java.util.UUID;

import seahorse.internal.business.katavuccolservice.common.datacontracts.BaseMessageEntity;

/**
 * @author admin
 *
 */
public class CredentialTypeMsgEntity extends BaseMessageEntity {
	private UUID id;
	private String name;
	private UUID userId;	
	private String description;	
	private String status;
	private Boolean isDuplicationAllowed;
	private Boolean isSubitemAllowed;
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
	public UUID getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(UUID userId) {
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

}
