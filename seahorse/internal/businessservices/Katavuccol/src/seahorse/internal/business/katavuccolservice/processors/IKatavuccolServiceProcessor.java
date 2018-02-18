/**
 * 
 */
package seahorse.internal.business.katavuccolservice.processors;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsRequestMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceProcessor {

	Result ProcessorCreateCredentials(CredentialsRequestMessageEntity credentialsRequestMessageEntity);

}
