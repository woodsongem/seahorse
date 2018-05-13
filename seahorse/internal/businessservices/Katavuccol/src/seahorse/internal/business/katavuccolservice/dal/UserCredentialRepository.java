/**
 * 
 */
package seahorse.internal.business.katavuccolservice.dal;

import org.apache.logging.log4j.Logger;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.google.inject.Inject;
import seahorse.internal.business.katavuccolservice.common.ICassandraConnector;
import seahorse.internal.business.katavuccolservice.common.IReadPropertiesFile;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.UserCredentialMessageEntity;
import seahorse.internal.business.shared.aop.InjectLogger;

/**
 * @author sajanmje
 *
 */

public class UserCredentialRepository implements IUserCredentialRepository {
	
	private final IUserCredentialRepositoryMapper userCredentialRepositoryMapper;
	private final ICassandraConnector cassandraConnector;
	private final IReadPropertiesFile readPropertiesFile;

	@InjectLogger
	Logger logger;

	@Inject
	public UserCredentialRepository(
			IUserCredentialRepositoryMapper userCredentialRepositoryMapper,
			ICassandraConnector cassandraConnector, 
			IReadPropertiesFile readPropertiesFile) {
		this.userCredentialRepositoryMapper = userCredentialRepositoryMapper;
		this.cassandraConnector = cassandraConnector;
		this.readPropertiesFile = readPropertiesFile;
	}
	
	public UserCredentialDAO getUserCredential(UserCredentialMessageEntity userCredentialMessageEntity) {

		UserCredentialDAO userCredentialDAO = new UserCredentialDAO();

		try {
			cassandraConnector.connect(null, 0,null);
			PreparedStatement prepared=cassandraConnector.getSession().prepare(QueryConstants.GET_USER_CREDENTIAL_BY_USERIDQUERY);
			BoundStatement bound=userCredentialRepositoryMapper.mapBoundStatement(prepared,userCredentialMessageEntity);
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row userCredentialDAOResult = resultSet.one();
				userCredentialDAO = userCredentialRepositoryMapper.mapUserCredentialDAO(userCredentialDAOResult);				
			}
		} catch (Exception exception) {
			logger.error("Exception in getUserCredential error=" + exception);
		}
		return userCredentialDAO;
	}

}
