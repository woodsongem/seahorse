/**
 * 
 */
package seahorse.internal.business.customerservice.verifiers;

import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IUserCredentialServiceVerifier {

	ResultMessageEntity VerifyLogin(LoginDetailMessageEntity loginDetailMessageEntity);
	
	ResultMessageEntity IsCredentialServiceValid(LoginDetailMessageEntity loginDetailMessageEntity);

}
