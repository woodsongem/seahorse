/**
 * 
 */
package seahorse.internal.business.coldfishservice.verifiers;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceVerifier {

	ResultMessageEntity verifyCreateIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity);
	
	ResultMessageEntity isUserIdValid(IncomeTypeMessageEntity incomeTypeMessageEntity);
	
	ResultMessageEntity isNameValid(IncomeTypeMessageEntity incomeTypeMessageEntity);

	ResultMessageEntity verifygetIncomeTypeByUserId(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity);

	ResultMessageEntity verifyCreateIncomeDetail(IncomeDetailMessageEntity incomeDetailMessageEntity);

}
