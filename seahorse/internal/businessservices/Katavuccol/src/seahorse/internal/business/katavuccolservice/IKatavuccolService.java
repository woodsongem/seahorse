/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialsMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolService {

	CredentialsResponseMessageEntity createCredentials(CredentialsRequestMessageEntity credentialsRequestMessageEntity);

	GetCredentialsMessageEntity getCredentials(GetCredentialMessageEntity getCredentialMessageEntity);
}
