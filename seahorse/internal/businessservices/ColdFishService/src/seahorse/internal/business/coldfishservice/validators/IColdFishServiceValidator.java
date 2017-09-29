/**
 * 
 */
package seahorse.internal.business.coldfishservice.validators;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
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

}
