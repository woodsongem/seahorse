/**
 * 
 */
package seahorse.internal.business.coldfishservice;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceMapper {

	IncomeTypeResponseMessageEntity mapIncomeTypeResponseMessageEntity(ResultMessageEntity resultMessageEntity,
			IncomeTypeMessageEntity incomeTypeMessageEntity);

	IncomeTypeResponseMessageEntity mapIncomeTypeResponseMessageEntity(ResultMessageEntity resultMessageEntity,	Status badRequest);

}
