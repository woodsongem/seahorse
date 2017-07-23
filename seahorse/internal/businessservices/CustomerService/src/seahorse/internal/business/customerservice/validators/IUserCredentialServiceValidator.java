/**
 * 
 */
package seahorse.internal.business.customerservice.validators;

import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IUserCredentialServiceValidator {

	ResultMessageEntity ValidateLogin(LoginDetailMessageEntity loginDetailMessageEntity);
	
	ResultMessageEntity IsUserNameValid(LoginDetailMessageEntity loginDetailMessageEntity);	
	
	ResultMessageEntity IsPasswordValid(LoginDetailMessageEntity loginDetailMessageEntity);
	
	ResultMessageEntity IsPasswordEncryptionValid(LoginDetailMessageEntity loginDetailMessageEntity);
	
	ResultMessageEntity IsProductItemValid(LoginDetailMessageEntity loginDetailMessageEntity);
	
	ResultMessageEntity IsLoginDetailMessageEntityValid(LoginDetailMessageEntity loginDetailMessageEntity) ;

}
