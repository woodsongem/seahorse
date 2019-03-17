/**
 * 
 */
package seahorse.internal.business.credentialservice.datacontracts;

import java.util.UUID;
import seahorse.internal.business.katavuccolservice.common.datacontracts.BaseMessageEntity;


/**
 * @author sajanmje
 *
 */
public class CreateCredentialResponseMessageEntity extends BaseMessageEntity {

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
