/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import seahorse.internal.business.katavuccolservice.datacontracts.CreateUserCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CreateUserCredentialResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IUserCredentialService {

	CreateUserCredentialResponseMessageEntity createUserCredential(CreateUserCredentialRequestMessageEntity createUserCredentialRequestMessageEntity);
}
