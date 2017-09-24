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
public class IncomeTypeMessageEntity extends BaseMessageEntity {
	
	public String name;
	
	public String UserId;
	
	public String Description;
	
	public UUID ParsedUserId;
}
