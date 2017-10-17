/**
 * 
 */
package seahorse.internal.business.coldfishservice.processors;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceProcessor {

	ResultMessageEntity createIncomeTypeProcessor(IncomeTypeMessageEntity incomeTypeMessageEntity);	

	ResultMessageEntity getIncomeTypeByUserIdProcessor(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity);

}
