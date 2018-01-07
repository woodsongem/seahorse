/**
 * 
 */
package seahorse.internal.business.customerservice.dal;

import seahorse.internal.business.customerservice.dal.datacontracts.LoginAttemptDAO;
import seahorse.internal.business.customerservice.dal.datacontracts.LoginHistoryDAO;
import seahorse.internal.business.customerservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.LoginResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IUserCredentialServiceRepository {	

	UserCredentialDAO GetUserCredential(LoginDetailMessageEntity loginDetailMessageEntity);

	LoginHistoryDAO InsertLoginAttemptHistory(LoginHistoryDAO loginHistoryDAO);

	LoginAttemptDAO InsertLoginAttempt(LoginAttemptDAO loginAttemptDAO);
}
