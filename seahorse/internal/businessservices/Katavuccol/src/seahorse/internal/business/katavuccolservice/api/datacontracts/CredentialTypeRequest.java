/**
 * 
 */
package seahorse.internal.business.katavuccolservice.api.datacontracts;

/**
 * @author sajanmje
 *
 */
public class CredentialTypeRequest extends RequestBase {
	private String name;
	private String description;
	private Boolean isDuplicationAllowed;
	private Boolean isSubitemAllowed;
	
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
