/**
 * 
 */
package seahorse.internal.business.katavuccolservice.api.datacontracts;

/**
 * @author sajanmje
 *
 */
public class CredentialRequest extends RequestBase {

	private String categoryId;
	private String typeId;
	private String value;	
	private String description;
	private String parentId;
	private String encryptKey;
	
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
	 * @return the typeid
	 */
	public String getTypeId() {
		return typeId;
	}
	/**
	 * @param typeid the typeid to set
	 */
	public void setTypeId(String typeid) {
		this.typeId = typeid;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
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
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * @return the encryptKey
	 */
	public String getEncryptKey() {
		return encryptKey;
	}
	/**
	 * @param encryptKey the encryptKey to set
	 */
	public void setEncryptKey(String encryptKey) {
		this.encryptKey = encryptKey;
	}
}
