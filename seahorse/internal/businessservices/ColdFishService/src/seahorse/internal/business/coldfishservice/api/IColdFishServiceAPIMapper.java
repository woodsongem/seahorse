/**
 * 
 */
package seahorse.internal.business.coldfishservice.api;

import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeRequest;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeResponse;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceAPIMapper {

	IncomeTypeMessageEntity mapIncomeTypeMessageEntity(IncomeTypeRequest incomeTypeRequest);

	IncomeTypeResponse mapIncomeTypeResponse(IncomeTypeResponseMessageEntity incomeTypeResponseMessageEntity);

}
