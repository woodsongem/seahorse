/**
 * 
 */
package seahorse.internal.business.katavuccolservice.postprocessors;

import seahorse.internal.business.katavuccolservice.api.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;


/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServicePostProcessor {

	Result PostProcessorCreateCredentials(CredentialRequestMessageEntity credentialRequestMessageEntity);

	Result PostProcessorDeleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);

	Result PostProcessorUpdateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity);

}
