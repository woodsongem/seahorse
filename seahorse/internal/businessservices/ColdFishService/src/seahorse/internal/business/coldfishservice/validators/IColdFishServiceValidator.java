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

	ResultMessageEntity ValidateCreateIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity);

	

}
