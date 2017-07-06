/**
 * 
 */
package seahorse.internal.business.customerservice.dal.datacontracts;

import java.text.MessageFormat;

import com.datastax.driver.core.Row;

import seahorse.internal.business.customerservice.constants.Constant;
import seahorse.internal.business.customerservice.constants.DataBaseColumn;
import seahorse.internal.business.customerservice.constants.QueryConstants;
import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;

/**
 * @author sajanmje
 *
 */
public class UserCredentialServiceRepositoryMapper implements IUserCredentialServiceRepositoryMapper {

	@Override
	public String getUserCredentialbyUserNameQuery(LoginDetailMessageEntity loginDetailMessageEntity) {
		Object[] args = { loginDetailMessageEntity.getUsername(), loginDetailMessageEntity.getEncryptedpassword() };
		return new MessageFormat(QueryConstants.getUserCredentialbyUserNameQuery).format(args);
	}

	@Override
	public UserCredentialDAO mapUserCredentialServiceDAO(Row userCredentialResult) {
		UserCredentialDAO userCredentialDAO = new UserCredentialDAO();		
		userCredentialDAO.setId(userCredentialResult.getUUID(DataBaseColumn.Id));
		userCredentialDAO.setUsername(userCredentialResult.getString(DataBaseColumn.UserName));
		userCredentialDAO.setStatus(userCredentialResult.getString(DataBaseColumn.Status));
		return userCredentialDAO;
	}

}
