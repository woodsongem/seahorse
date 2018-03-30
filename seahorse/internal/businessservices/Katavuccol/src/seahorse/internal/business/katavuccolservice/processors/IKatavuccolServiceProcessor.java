/**
 * 
 */
package seahorse.internal.business.katavuccolservice.processors;

import seahorse.internal.business.katavuccolservice.api.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceProcessor {

	Result ProcessorCreateCredentials(CredentialRequestMessageEntity credentialRequestMessageEntity);

	Result ProcessorDeleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);

	Result ProcessorUpdateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity);

}
