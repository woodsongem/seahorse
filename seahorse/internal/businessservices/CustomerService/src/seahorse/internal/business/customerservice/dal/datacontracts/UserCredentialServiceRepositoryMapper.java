/**
 * 
 */
package seahorse.internal.business.customerservice.dal.datacontracts;

import java.text.MessageFormat;
import com.datastax.driver.core.Row;

import seahorse.internal.business.applicationservice.utilities.CustomerServiceUtility;
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

	@Override
	public String getInsertLoginAttemptHistoryQuery(LoginHistoryDAO loginHistoryDAO) {
		
		Object[] args = { loginHistoryDAO.getCreatedBy(),CustomerServiceUtility.GetCurrentDateTimeUTC(),
				loginHistoryDAO.getIpAddress(),CustomerServiceUtility.GetCurrentDateTimeUTC(),
				loginHistoryDAO.getLogType(),loginHistoryDAO.getId() };
		return new MessageFormat(QueryConstants.getInsertLoginAttemptHistoryQuery).format(args);
	}

	@Override
	public LoginHistoryDAO mapLoginHistoryDAO(Row loginHistoryResult) {
		
		return null;
	}

	@Override
	public String getInsertLoginAttemptQuery(LoginAttemptDAO loginAttemptDAO) {
		Object[] args = { loginAttemptDAO.getUserName(),CustomerServiceUtility.GetCurrentDateTimeUTC(),loginAttemptDAO.getLoginAttempts(),loginAttemptDAO.getId() };
		return new MessageFormat(QueryConstants.getInsertLoginAttemptQuery).format(args);
	}

}
