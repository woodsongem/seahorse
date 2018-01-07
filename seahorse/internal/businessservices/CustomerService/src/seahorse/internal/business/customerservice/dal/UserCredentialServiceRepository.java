/**
 * 
 */
package seahorse.internal.business.customerservice.dal;


import org.apache.logging.log4j.Logger;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.google.inject.Inject;

import seahorse.internal.business.customerservice.common.ICassandraConnector;
import seahorse.internal.business.customerservice.common.IReadPropertiesFile;
import seahorse.internal.business.customerservice.dal.datacontracts.IUserCredentialServiceRepositoryMapper;
import seahorse.internal.business.customerservice.dal.datacontracts.LoginAttemptDAO;
import seahorse.internal.business.customerservice.dal.datacontracts.LoginHistoryDAO;
import seahorse.internal.business.customerservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultStatus;
import seahorse.internal.business.shared.aop.InjectLogger;
import seahorse.internal.business.shared.aop.Report;

/**
 * @author sajanmje
 *
 */
public class UserCredentialServiceRepository  implements IUserCredentialServiceRepository{

	private final IUserCredentialServiceRepositoryMapper userCredentialServiceRepositoryMapper;
	private final ICassandraConnector cassandraConnector;
	private final IReadPropertiesFile readPropertiesFile;	
	@InjectLogger  Logger logger;

	@Inject
	public UserCredentialServiceRepository(IUserCredentialServiceRepositoryMapper userCredentialServiceRepositoryMapper,
			ICassandraConnector cassandraConnector,IReadPropertiesFile readPropertiesFile)
	{
		this.userCredentialServiceRepositoryMapper=userCredentialServiceRepositoryMapper;
		this.cassandraConnector=cassandraConnector;
		this.readPropertiesFile=readPropertiesFile;
	}
	
	@Report
	public UserCredentialDAO GetUserCredential(LoginDetailMessageEntity loginDetailMessageEntity) {
		UserCredentialDAO userCredentialDAO=new UserCredentialDAO();
		cassandraConnector.connect(null, 0);
		String applicationQuery=userCredentialServiceRepositoryMapper.getUserCredentialbyUserNameQuery(loginDetailMessageEntity);
		final ResultSet resultSet = cassandraConnector.getSession().execute(applicationQuery);		
		cassandraConnector.close();	
		while (!resultSet.isExhausted()) {
			final Row userCredentialResult = resultSet.one();
			userCredentialDAO=userCredentialServiceRepositoryMapper.mapUserCredentialServiceDAO(userCredentialResult);
		}
		return userCredentialDAO;
	}

	@Report
	public LoginHistoryDAO InsertLoginAttemptHistory(LoginHistoryDAO loginHistoryDAO) {
		LoginHistoryDAO loginHistoryDAORes=new LoginHistoryDAO();
		cassandraConnector.connect(null, 0);
		String applicationQuery=userCredentialServiceRepositoryMapper.getInsertLoginAttemptHistoryQuery(loginHistoryDAO);
		final ResultSet resultSet = cassandraConnector.getSession().execute(applicationQuery);	
		cassandraConnector.close();	
		if(resultSet.wasApplied())
		{
			loginHistoryDAORes.SetResultStatus(ResultStatus.Success);
		}
		else
		{
			loginHistoryDAORes.SetResultStatus(ResultStatus.Error);
		}
		
		return loginHistoryDAORes;
	}

	@Report
	public LoginAttemptDAO InsertLoginAttempt(LoginAttemptDAO loginAttemptDAO) {
		LoginAttemptDAO loginAttemptDAORes=new LoginAttemptDAO();
		cassandraConnector.connect(null, 0);
		String applicationQuery=userCredentialServiceRepositoryMapper.getInsertLoginAttemptQuery(loginAttemptDAO);
		final ResultSet resultSet = cassandraConnector.getSession().execute(applicationQuery);	
		cassandraConnector.close();	
		if(resultSet.wasApplied())
		{
			loginAttemptDAORes.SetResultStatus(ResultStatus.Success);
		}
		else
		{
			loginAttemptDAORes.SetResultStatus(ResultStatus.Error);
		}
		
		return loginAttemptDAORes;
	}

}
