/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolService {

	CredentialsResponseMessageEntity createCredentials(CredentialsRequestMessageEntity credentialsRequestMessageEntity);
}
