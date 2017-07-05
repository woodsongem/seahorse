/**
 * 
 */
package seahorse.internal.business.customerservice.dal.datacontracts;

import com.datastax.driver.core.Row;

import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IUserCredentialServiceRepositoryMapper {

	String getUserCredentialbyUserNameQuery(LoginDetailMessageEntity loginDetailMessageEntity);

	UserCredentialServiceDAO mapUserCredentialServiceDAO(Row userCredentialResult);

}
