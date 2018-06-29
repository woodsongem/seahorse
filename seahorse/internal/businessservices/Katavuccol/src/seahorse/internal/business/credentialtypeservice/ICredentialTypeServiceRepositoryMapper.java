/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;

import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeModel;

/**
 * @author admin
 *
 */
public interface ICredentialTypeServiceRepositoryMapper {

	BoundStatement mapCredentialTypeByUserIdBoundStatement(PreparedStatement preparedStatement, UUID userId);

	CredentialTypeModel mapCredentialTypeModel(Row typeDAOResult);

}
