/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;

import seahorse.internal.business.usercredentialservice.dal.datacontracts.UserCredentialDAO;

/**
 * @author SMJE
 *
 */
public interface IUserCredentialServiceRepositoryMapper {

	BoundStatement mapUserCredentialBoundStatement(PreparedStatement preparedStatement,UserCredentialDAO userCredentialDAO);

}
