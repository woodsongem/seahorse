/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import java.util.UUID;

import seahorse.internal.business.katavuccolservice.datacontracts.CreateUserCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CreateUserCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IUserCredentialService {

	CreateUserCredentialResponseMessageEntity createUserCredential(CreateUserCredentialRequestMessageEntity createUserCredentialRequestMessageEntity);
	
	UserCredentialMessageEntity getUserCredential(UUID userId);
}
