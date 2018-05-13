/**
 * 
 */
package seahorse.internal.business.katavuccolservice.dal;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;

import seahorse.internal.business.katavuccolservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IUserCredentialRepositoryMapper {

	BoundStatement mapBoundStatement(PreparedStatement prepared,UserCredentialMessageEntity userCredentialMessageEntity);

	UserCredentialDAO mapUserCredentialDAO(Row userCredentialDAOResult);

}
