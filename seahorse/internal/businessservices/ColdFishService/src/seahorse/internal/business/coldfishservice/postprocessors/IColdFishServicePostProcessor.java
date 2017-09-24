/**
 * 
 */
package seahorse.internal.business.coldfishservice.postprocessors;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServicePostProcessor {

	ResultMessageEntity CreateIncomeTypePostProcessor(IncomeTypeMessageEntity incomeTypeMessageEntity);

}
