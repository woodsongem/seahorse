/**
 * 
 */
package seahorse.internal.business.credentialservice;

import seahorse.internal.business.credentialservice.datacontracts.CreateCredentialRequestMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.GetCredentialByUserIdMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;

/**
 * @author admin
 *
 */
public interface ICredentialServiceProcessor {

	Result processorGetCredentialsByUserId(GetCredentialByUserIdMessageEntity getCredentialByUserIdMessageEntity);

	Result processorCreateCredentials(CreateCredentialRequestMessageEntity credentialRequestMessageEntity);

	Result createCredential(CreateCredentialRequestMessageEntity credentialRequestMessageEntity);

	Result processorUpdateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity);

	Result updateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity);

	Result processorDeleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);

	Result deleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);

}
