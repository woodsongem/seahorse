/**
 * 
 */
package seahorse.internal.business.katavuccolservice.api.datacontracts;

/**
 * @author sajanmje
 *
 */
public class UpdateCredentialRequest extends RequestBase {	
	private String value;	
	private String description;	
	private String credentialTypeId;
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
	 * @return the credentialTypeId
	 */
	public String getCredentialTypeId() {
		return credentialTypeId;
	}
	/**
	 * @param credentialTypeId the credentialTypeId to set
	 */
	public void setCredentialTypeId(String credentialTypeId) {
		this.credentialTypeId = credentialTypeId;
	}	
}
