/**
 * 
 */
package seahorse.internal.business.katavuccolservice.postprocessors;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;


/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServicePostProcessor {

	Result PostProcessorCreateCredentials(CredentialRequestMessageEntity credentialRequestMessageEntity);

}
