/**
 * 
 */
package seahorse.internal.business.credentialservice;

import seahorse.internal.business.katavuccolservice.datacontracts.CredentialValueDetail;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialByUserIdMessageEntity;

/**
 * @author admin
 *
 */
public interface ICredentialService {

	CredentialValueDetail getCredentialsByUserId(GetCredentialByUserIdMessageEntity getCredentialByUserIdMessageEntity);

}
