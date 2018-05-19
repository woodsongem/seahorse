/**
 * 
 */
package seahorse.internal.business.katavuccolservice.dal;

import seahorse.internal.business.katavuccolservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IUserCredentialRepository {

	UserCredentialDAO getUserCredentialById(UserCredentialMessageEntity userCredentialMessageEntity);	
}
