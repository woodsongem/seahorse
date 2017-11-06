/**
 * 
 */
package seahorse.internal.business.coldfishservice.postprocessors;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServicePostProcessor {

	ResultMessageEntity createIncomeTypePostProcessor(IncomeTypeMessageEntity incomeTypeMessageEntity);

	ResultMessageEntity getIncomeTypeByUserIdPostProcessor(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity);

	ResultMessageEntity createIncomeDetailProcessor(IncomeDetailMessageEntity incomeDetailMessageEntity);

	ResultMessageEntity getIncomeDetailByUserIdProcessor(GetIncomeDetailMessageEntity getincomeDetailMessageEntity);

}
