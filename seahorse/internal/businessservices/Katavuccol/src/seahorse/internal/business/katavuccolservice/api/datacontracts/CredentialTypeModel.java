/**
 * 
 */
package seahorse.internal.business.katavuccolservice.api.datacontracts;

/**
 * @author admin
 *
 */
public class CredentialTypeModel extends BaseModel {
	private String id;
	private String name;
	private String userId;
	private String categoryId;
	private String description;	
	private String status;
	private Boolean isDuplicationAllowed;
	private Boolean isSubitemAllowed;
	private String type;
	
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
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
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
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}
