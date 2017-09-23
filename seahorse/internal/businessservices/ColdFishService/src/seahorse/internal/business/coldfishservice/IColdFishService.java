/**
 * 
 */
package seahorse.internal.business.coldfishservice;

import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishService {

	IncomeTypeResponseMessageEntity CreateIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity);

}
