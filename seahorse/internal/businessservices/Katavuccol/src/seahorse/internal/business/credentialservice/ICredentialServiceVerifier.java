/**
 * 
 */
package seahorse.internal.business.credentialservice;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialByUserIdMessageEntity;

/**
 * @author admin
 *
 */
public interface ICredentialServiceVerifier {

	Result verifyGetCredentialsByUserId(GetCredentialByUserIdMessageEntity getCredentialByUserIdMessageEntity);

}
