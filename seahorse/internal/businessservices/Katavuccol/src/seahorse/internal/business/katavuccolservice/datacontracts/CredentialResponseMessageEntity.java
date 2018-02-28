/**
 * 
 */
package seahorse.internal.business.katavuccolservice.datacontracts;

import java.util.UUID;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;

/**
 * @author sajanmje
 *
 */
public class CredentialResponseMessageEntity extends Result {

	private UUID id;

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
}
