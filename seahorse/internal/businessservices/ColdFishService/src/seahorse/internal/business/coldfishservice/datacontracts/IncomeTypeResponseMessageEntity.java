/**
 * 
 */
package seahorse.internal.business.coldfishservice.datacontracts;

import java.util.UUID;

import seahorse.internal.business.coldfishservice.common.datacontracts.BaseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class IncomeTypeResponseMessageEntity  extends BaseMessageEntity{
	
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
