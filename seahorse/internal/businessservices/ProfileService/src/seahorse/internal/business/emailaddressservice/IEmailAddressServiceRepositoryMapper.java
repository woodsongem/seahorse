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
public interface IEmailAddressServiceRepositoryMapper {

	BoundStatement mapBoundStatement(PreparedStatement preparedStatement);

	EmailAddressDAO mapEmailAddressDAO(Row emailDAOResult);

	BoundStatement mapBoundStatementRequest(PreparedStatement preparedStatement, EmailAddressDAO emailAddressDAO);

	BoundStatement mapBoundStatement(PreparedStatement preparedStatement, EmailAddressDAO emailAddressDAO);

	BoundStatement mapBoundStatement(PreparedStatement preparedStatement, UUID emailAddressId);

	BoundStatement mapEmailAddressBoundStatement(PreparedStatement preparedStatement, UUID userId);

	BoundStatement mapEmailAddressByIdBoundStatement(PreparedStatement preparedStatement, UUID emailAddressId);

	BoundStatement mapDeleteEmailAddressBoundStatement(PreparedStatement preparedStatement,EmailAddressDAO emailAddressDAO);

	BoundStatement mapEmailAddressDetailByEmailAddressBoundStatement(PreparedStatement preparedStatement,String emailAddress);

	BoundStatement mapEmailAddressDetailByIdBoundStatement(PreparedStatement preparedStatement, UUID id);

}
