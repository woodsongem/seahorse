/**
 * 
 */
package seahorse.internal.business.katavuccolservice.verifiers;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsRequestMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceVerifier {

	Result verifyCreateCredentials(CredentialsRequestMessageEntity credentialsRequestMessageEntity);
}
