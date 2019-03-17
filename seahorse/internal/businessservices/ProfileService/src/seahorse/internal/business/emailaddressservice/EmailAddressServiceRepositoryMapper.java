/**
 * 
 */
package seahorse.internal.business.emailaddressservice;

import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;

import seahorse.internal.business.emailaddressservice.dal.datacontracts.EmailAddressDAO;

/**
 * @author SMJE
 *
 */
public class EmailAddressServiceRepositoryMapper implements IEmailAddressServiceRepositoryMapper {

	@Override
	public BoundStatement mapBoundStatement(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmailAddressDAO mapEmailAddressDAO(Row emailDAOResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoundStatement mapBoundStatementRequest(PreparedStatement preparedStatement,
			EmailAddressDAO emailAddressDAO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoundStatement mapBoundStatement(PreparedStatement preparedStatement, EmailAddressDAO emailAddressDAO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoundStatement mapBoundStatement(PreparedStatement preparedStatement, UUID emailAddressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoundStatement mapEmailAddressBoundStatement(PreparedStatement preparedStatement, UUID userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoundStatement mapEmailAddressByIdBoundStatement(PreparedStatement preparedStatement, UUID emailAddressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoundStatement mapDeleteEmailAddressBoundStatement(PreparedStatement preparedStatement,EmailAddressDAO emailAddressDAO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoundStatement mapEmailAddressDetailByEmailAddressBoundStatement(PreparedStatement preparedStatement,String emailAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoundStatement mapEmailAddressDetailByIdBoundStatement(PreparedStatement preparedStatement, UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
