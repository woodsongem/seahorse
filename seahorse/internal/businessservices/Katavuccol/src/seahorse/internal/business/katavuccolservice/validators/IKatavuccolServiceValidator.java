/**
 * 
 */
package seahorse.internal.business.katavuccolservice.validators;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsRequestMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceValidator {

	Result validateCreateCredentials(CredentialsRequestMessageEntity credentialsRequestMessageEntity);

}
