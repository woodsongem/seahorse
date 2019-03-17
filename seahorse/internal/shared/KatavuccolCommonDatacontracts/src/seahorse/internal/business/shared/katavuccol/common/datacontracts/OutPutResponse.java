/**
 * 
 */
package seahorse.internal.business.shared.katavuccol.common.datacontracts;

import java.util.UUID;

/**
 * @author sajanmje
 *
 */
public class OutPutResponse extends Result {

	private UUID Id;

	/**
	 * @return the id
	 */
	public UUID getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		Id = id;
	}
}
