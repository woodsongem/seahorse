/**
 * 
 */
package seahorse.internal.business.credentialtypeservice.api.datacontracts;

import seahorse.internal.business.katavuccolservice.api.datacontracts.RequestBase;

/**
 * @author sajanmje
 *
 */
public class CreateCredentialTypeRequestModel extends RequestBase {
	private String name;
	private String description;
	private Boolean isduplicationallowed;
	private Boolean issubitemallowed;
	
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
		return isduplicationallowed;
	}
	/**
	 * @param isDuplicationAllowed the isDuplicationAllowed to set
	 */
	public void setIsDuplicationAllowed(Boolean isDuplicationAllowed) {
		this.isduplicationallowed = isDuplicationAllowed;
	}
	/**
	 * @return the isSubitemAllowed
	 */
	public Boolean getIsSubitemAllowed() {
		return issubitemallowed;
	}
	/**
	 * @param isSubitemAllowed the isSubitemAllowed to set
	 */
	public void setIsSubitemAllowed(Boolean isSubitemAllowed) {
		this.issubitemallowed = isSubitemAllowed;
	}
}
