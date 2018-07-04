/**
 * 
 */
package seahorse.internal.business.credentialtypeservice.datacontracts;
import java.util.UUID;

import seahorse.internal.business.katavuccolservice.common.datacontracts.ResponseBaseMsgEntity;

/**
 * @author admin
 *
 */
public class CreateCredentialTypeResMsgEntity extends ResponseBaseMsgEntity  {

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
