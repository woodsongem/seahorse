/**
 * 
 */
package seahorse.internal.business.credentialservice.api.datacontracts;

import seahorse.internal.business.katavuccolservice.api.datacontracts.ResponseBase;

/**
 * @author sajanmje
 *
 */
public class CredentialResponseModel extends ResponseBase {
	private String id;

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
}
