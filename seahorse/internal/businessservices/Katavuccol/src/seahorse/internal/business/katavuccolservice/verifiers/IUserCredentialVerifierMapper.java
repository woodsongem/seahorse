/**
 * 
 */
package seahorse.internal.business.katavuccolservice.verifiers;

import seahorse.internal.business.katavuccolservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.GetUserCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IUserCredentialVerifierMapper {

	UserCredentialMessageEntity mapUserCredentialMessageEntity(GetUserCredentialMessageEntity getUserCredentialMessageEntity);

	UserCredentialMessageEntity mapUserCredentialMessageEntity(UserCredentialDAO userCredentialDAO);

}
