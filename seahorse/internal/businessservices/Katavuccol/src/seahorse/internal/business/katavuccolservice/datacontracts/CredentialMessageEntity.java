/**
 * 
 */
package seahorse.internal.business.katavuccolservice.datacontracts;

import java.util.UUID;

import seahorse.internal.business.katavuccolservice.common.datacontracts.BaseMessageEntity;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialDAO;

/**
 * @author sajanmje
 *
 */
public class CredentialMessageEntity extends BaseMessageEntity {

	private UUID userId;
	private UUID id;
	private UUID categoryId;
	private UUID credentialTypeId;
	private String description;
	private String status;
	private UUID parentId;	
	
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
	 * @return the categoryId
	 */
	public UUID getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(UUID categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the credentialTypeId
	 */
	public UUID getCredentialTypeId() {
		return credentialTypeId;
	}
	/**
	 * @param credentialTypeId the credentialTypeId to set
	 */
	public void setCredentialTypeId(UUID credentialTypeId) {
		this.credentialTypeId = credentialTypeId;
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
	 * @return the parentId
	 */
	public UUID getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(UUID parentId) {
		this.parentId = parentId;
	}	
}
