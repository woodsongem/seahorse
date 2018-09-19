/**
 * 
 */
package seahorse.internal.business.credentialservice.api.datacontracts;

import seahorse.internal.business.katavuccolservice.api.datacontracts.RequestBase;

/**
 * @author sajanmje
 *
 */
public class GetCredentialValueRequest extends RequestBase {

	private String key;

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
}
