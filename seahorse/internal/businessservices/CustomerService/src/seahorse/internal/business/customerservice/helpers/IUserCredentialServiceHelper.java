/**
 * 
 */
package seahorse.internal.business.customerservice.helpers;

import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IUserCredentialServiceHelper {
	
	ResultMessageEntity LoginPostProcessor(LoginDetailMessageEntity loginDetailMessageEntity);
	
	ResultMessageEntity InsertLoginAttemptsHistory(LoginDetailMessageEntity loginDetailMessageEntity);
	
	ResultMessageEntity LoginProcessor(LoginDetailMessageEntity loginDetailMessageEntity);
	
	ResultMessageEntity insertLoginAttempt(LoginDetailMessageEntity loginDetailMessageEntity);
}
