/**
 * 
 */
package seahorse.internal.business.applicationservice.validators;

import seahorse.internal.business.applicationservice.datacontracts.ResultMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IApplicationServiceValidator {

	ResultMessageEntity ValidateApplicationByApplicationId(String applicationId);
	
	ResultMessageEntity IsApplicationIdValid(String applicationId);

}
