/**
 * 
 */
package seahorse.internal.business.customerservice.dal;

import seahorse.internal.business.customerservice.dal.datacontracts.UserCredentialServiceDAO;
import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.LoginResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IUserCredentialServiceRepository {	

	UserCredentialServiceDAO GetUserCredential(LoginDetailMessageEntity loginDetailMessageEntity);
}
