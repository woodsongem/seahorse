/**
 * 
 */
package seahorse.internal.business.katavuccolservice.validators;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;


/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceValidator {

	Result validateCreateCredentials(CredentialRequestMessageEntity credentialRequestMessageEntity);
	
	Result isCredentialsRequestMessageEntityValid(CredentialRequestMessageEntity credentialRequestMessageEntity);
	
	Result isUserIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity);
	
    Result isTypeIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity); 

	Result isCategoryIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity);
	
	Result isValueValid(CredentialRequestMessageEntity credentialRequestMessageEntity);
}
