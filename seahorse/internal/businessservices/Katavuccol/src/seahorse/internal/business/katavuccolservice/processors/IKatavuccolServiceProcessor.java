/**
 * 
 */
package seahorse.internal.business.katavuccolservice.processors;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceProcessor {

	Result ProcessorCreateCredentials(CredentialRequestMessageEntity credentialRequestMessageEntity);

}
