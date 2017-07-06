/**
 * 
 */
package seahorse.internal.business.customerservice.dal;


import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import seahorse.internal.business.customerservice.common.ICassandraConnector;
import seahorse.internal.business.customerservice.common.IReadPropertiesFile;
import seahorse.internal.business.customerservice.dal.datacontracts.IUserCredentialServiceRepositoryMapper;
import seahorse.internal.business.customerservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;

/**
 * @author sajanmje
 *
 */
public class UserCredentialServiceRepository  implements IUserCredentialServiceRepository{

	private final IUserCredentialServiceRepositoryMapper userCredentialServiceRepositoryMapper;
	private final ICassandraConnector cassandraConnector;
	private final IReadPropertiesFile readPropertiesFile;
	
	public UserCredentialServiceRepository(IUserCredentialServiceRepositoryMapper userCredentialServiceRepositoryMapper,
			ICassandraConnector cassandraConnector,IReadPropertiesFile readPropertiesFile)
	{
		this.userCredentialServiceRepositoryMapper=userCredentialServiceRepositoryMapper;
		this.cassandraConnector=cassandraConnector;
		this.readPropertiesFile=readPropertiesFile;
	}
	
	@Override
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

}
