/**
 * 
 */
package seahorse.internal.business.katavuccolservice.postprocessors;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsRequestMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServicePostProcessor {

	Result PostProcessorCreateCredentials(CredentialsRequestMessageEntity credentialsRequestMessageEntity);

}
