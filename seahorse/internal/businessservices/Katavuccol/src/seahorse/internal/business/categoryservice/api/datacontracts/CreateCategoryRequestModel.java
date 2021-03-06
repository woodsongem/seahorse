/**
 * 
 */
package seahorse.internal.business.categoryservice.api.datacontracts;

import seahorse.internal.business.katavuccolservice.api.datacontracts.RequestBase;

/**
 * @author SMJE
 *
 */
public class CreateCategoryRequestModel extends RequestBase {

	private String name;	
	private String description;
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
}
