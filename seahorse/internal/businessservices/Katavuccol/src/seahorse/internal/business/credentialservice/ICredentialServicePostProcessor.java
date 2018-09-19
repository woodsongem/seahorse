/**
 * 
 */
package seahorse.internal.business.credentialservice;

import seahorse.internal.business.credentialservice.datacontracts.CreateCredentialRequestMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.DeleteCredentialMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.GetCredentialByUserIdMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;

/**
 * @author admin
 *
 */
public interface ICredentialServicePostProcessor {

	Result postProcessorGetCredentialsByUserId(GetCredentialByUserIdMessageEntity getCredentialByUserIdMessageEntity);

	Result postProcessorCreateCredentials(CreateCredentialRequestMessageEntity credentialRequestMessageEntity);

	Result postProcessorUpdateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity);

	Result postProcessorDeleteCredential(DeleteCredentialMessageEntity deleteCredentialMessageEntity);

}
