/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;

import seahorse.internal.business.profileservice.api.datacontracts.UserCredentialModel;
import seahorse.internal.business.usercredentialservice.dal.datacontracts.UserCredentialDAO;

/**
 * @author SMJE
 *
 */
public interface IUserCredentialServiceRepositoryMapper {

	BoundStatement mapUserCredentialBoundStatement(PreparedStatement preparedStatement,UserCredentialDAO userCredentialDAO);

	BoundStatement mapGetUserCredentialByUserNameBoundStatement(PreparedStatement preparedStatement,UserCredentialDAO userCredentialDAO);

	UserCredentialDAO mapUserCredentialDAO(Row userCredentialDAOResult);

	BoundStatement mapgetUserCredentialModelByUserIdBoundStatement(PreparedStatement preparedStatement, UUID userId);

	UserCredentialModel mapUserCredentialModel(Row userCredentialDAOResult);

	BoundStatement mapGetUserCredentialByUserIdBoundStatement(PreparedStatement preparedStatement, UUID userId);

	BoundStatement mapDeleteUserCredentialBoundStatement(PreparedStatement preparedStatement, UserCredentialDAO userCredentialDAO);

}
