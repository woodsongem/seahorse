/**
 * 
 */
package seahorse.internal.business.coldfishservice.processors;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceProcessor {

	ResultMessageEntity createIncomeTypeProcessor(IncomeTypeMessageEntity incomeTypeMessageEntity);	

	ResultMessageEntity getIncomeTypeByUserId(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity);
	
	ResultMessageEntity getDefaultIncomeType(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity);

	ResultMessageEntity getIncomeTypeByUserIdProcessor(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity);

	ResultMessageEntity createIncomeDetailProcessor(IncomeDetailMessageEntity incomeDetailMessageEntity);
	
	ResultMessageEntity createIncomeDetail(IncomeDetailMessageEntity incomeDetailMessageEntity);

	ResultMessageEntity getIncomeDetailByUserIdProcessor(GetIncomeDetailMessageEntity getincomeDetailMessageEntity);
	
	ResultMessageEntity getIncomeDetailByUserId(GetIncomeDetailMessageEntity getincomeDetailMessageEntity);
	
	ResultMessageEntity getIncomeTypeByIds(GetIncomeDetailMessageEntity getIncomeDetailMessageEntity);

	ResultMessageEntity createIncomeCategoryProcessor(IncomeCategoryMessageEntity incomeDetailMessageEntity);
	
	ResultMessageEntity createIncomeCategory(IncomeCategoryMessageEntity incomeDetailMessageEntity);

	ResultMessageEntity UpdateIncomeCategoryProcessor(IncomeCategoryMessageEntity incomeCategoryMessageEntity);

}
