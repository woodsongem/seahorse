/**
 * 
 */
package seahorse.internal.business.katavuccolservice.validators;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsRequestMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceValidator {

	Result validateCreateCredentials(CredentialsRequestMessageEntity credentialsRequestMessageEntity);
	
	Result isCredentialsRequestMessageEntityValid(CredentialsRequestMessageEntity credentialsRequestMessageEntity);
	
	Result isUserIdValid(CredentialsRequestMessageEntity credentialsRequestMessageEntity);
	
    Result isTypeIdValid(CredentialsRequestMessageEntity credentialsRequestMessageEntity); 

	Result isCategoryIdValid(CredentialsRequestMessageEntity credentialsRequestMessageEntity);
	
	Result isValueValid(CredentialsRequestMessageEntity credentialsRequestMessageEntity);
}
