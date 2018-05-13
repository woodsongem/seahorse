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
public class UserCredentialRepositoryMapper implements IUserCredentialRepositoryMapper {

	@Override
	public BoundStatement mapBoundStatement(PreparedStatement prepared,UserCredentialMessageEntity userCredentialMessageEntity) {
		return prepared.bind(userCredentialMessageEntity.getUserId());	
	}

	@Override
	public UserCredentialDAO mapUserCredentialDAO(Row userCredentialDAOResult) {
		UserCredentialDAO userCredentialDAO = new UserCredentialDAO();
		userCredentialDAO.setId(userCredentialDAOResult.getUUID(DataBaseColumn.ID));
		userCredentialDAO.setUsername(userCredentialDAOResult.getString(DataBaseColumn.USERCREDENTIAL_USERNAME));
		userCredentialDAO.setStatus(userCredentialDAOResult.getString(DataBaseColumn.STATUS));
		return userCredentialDAO;
	}

}
