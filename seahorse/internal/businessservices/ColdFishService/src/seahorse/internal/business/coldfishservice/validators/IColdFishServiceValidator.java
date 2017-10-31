/**
 * 
 */
package seahorse.internal.business.coldfishservice.validators;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceValidator {

	ResultMessageEntity validateCreateIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity);

	ResultMessageEntity isIncomeTypeMessageEntityValid(IncomeTypeMessageEntity incomeTypeMessageEntity);
	
	ResultMessageEntity isNameValid(IncomeTypeMessageEntity incomeTypeMessageEntity);
	
	ResultMessageEntity isUserIdValid(IncomeTypeMessageEntity incomeTypeMessageEntity);
	
	ResultMessageEntity isDescriptionValid(IncomeTypeMessageEntity incomeTypeMessageEntity);

	ResultMessageEntity isCategoryValid(IncomeTypeMessageEntity incomeTypeMessageEntity);

	ResultMessageEntity validategetIncomeTypeByUserId(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity);
	
	ResultMessageEntity isGetIncomeTypeMessageEntityValid(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity);

	ResultMessageEntity validateCreateIncomeDetail(IncomeDetailMessageEntity incomeDetailMessageEntity);
	
	ResultMessageEntity isUserIdValid(String userId);
	
	ResultMessageEntity isUserIdValid(IncomeDetailMessageEntity incomeDetailMessageEntity);
	
	ResultMessageEntity isIncomeTypeIdValid(IncomeDetailMessageEntity incomeDetailMessageEntity);
	
	 ResultMessageEntity isIncomeTypeIdValid(String incomeTypeId);
	 
	 ResultMessageEntity isAmountValid(IncomeDetailMessageEntity incomeDetailMessageEntity);
	 
	 Boolean isAmountValid(double amount);
}
