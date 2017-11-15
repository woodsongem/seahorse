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
public class IncomeCategoryResponseMessageEntity extends BaseMessageEntity {
	
	private UUID id;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
