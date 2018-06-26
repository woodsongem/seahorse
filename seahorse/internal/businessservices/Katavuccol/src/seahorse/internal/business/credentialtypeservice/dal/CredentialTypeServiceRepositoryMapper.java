/**
 * 
 */
package seahorse.internal.business.credentialtypeservice.dal;

import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;

import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeModel;

/**
 * @author admin
 *
 */
public class CredentialTypeServiceRepositoryMapper implements ICredentialTypeServiceRepositoryMapper {

	@Override
	public BoundStatement mapCredentialTypeByUserIdBoundStatement(PreparedStatement preparedStatement, UUID userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CredentialTypeModel mapCredentialTypeModel(Row typeDAOResult) {
		// TODO Auto-generated method stub
		return null;
	}

}
