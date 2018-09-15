/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;

import seahorse.internal.business.credentialtypeservice.api.datacontracts.CredentialTypeModel;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;

/**
 * @author admin
 *
 */
public interface ICredentialTypeServiceRepositoryMapper {

	BoundStatement mapCredentialTypeByUserIdBoundStatement(PreparedStatement preparedStatement, UUID userId);

	CredentialTypeModel mapCredentialTypeModel(Row typeDAOResult);

	CredentialTypeDAO mapCredentialTypeDAO(Row typeDAOResult);

	BoundStatement mapBoundStatementRequest(PreparedStatement preparedStatement, CredentialTypeDAO credentialTypeDAO);

	BoundStatement mapGetDefaultCredentialTypeDAOBoundStatement(PreparedStatement preparedStatement);

	BoundStatement mapgetCredentialTypeByUserIdAndIdBoundStatement(PreparedStatement preparedStatement, UUID userId,UUID id);

	BoundStatement mapDeleteCredentialTypeBoundStatement(PreparedStatement preparedStatement,CredentialTypeDAO credentialTypeDAO);

}
