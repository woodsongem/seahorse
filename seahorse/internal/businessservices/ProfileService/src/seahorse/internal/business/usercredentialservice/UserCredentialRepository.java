/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import java.util.UUID;

import org.apache.logging.log4j.Logger;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.google.inject.Inject;

import seahorse.internal.business.shared.aop.InjectLogger;
import seahorse.internal.business.shared.katavuccol.common.ICassandraConnector;
import seahorse.internal.business.shared.katavuccol.common.IReadPropertiesFile;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolConstant;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolServiceUtility;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;
import seahorse.internal.business.usercredentialservice.dal.datacontracts.UserCredentialDAO;

/**
 * @author SMJE
 *
 */
public class UserCredentialRepository implements IUserCredentialRepository {

	private final IUserCredentialServiceRepositoryMapper userCredentialServiceRepositoryMapper;
	private final ICassandraConnector cassandraConnector;
	private final IReadPropertiesFile readPropertiesFile;
	
	@InjectLogger
	Logger logger;

	@Inject
	public UserCredentialRepository(IUserCredentialServiceRepositoryMapper userCredentialServiceRepositoryMapper,
			ICassandraConnector cassandraConnector, IReadPropertiesFile readPropertiesFile) {
		this.userCredentialServiceRepositoryMapper = userCredentialServiceRepositoryMapper;
		this.cassandraConnector = cassandraConnector;
		this.readPropertiesFile = readPropertiesFile;
	}

	@Override
	public UserCredentialDAO getUserCredentialByUserId(UUID userId) {
		return null;

	}

	@Override
	public Result createUserCredential(UserCredentialDAO userCredentialDAO) {
		OutPutResponse outPutResponse = new OutPutResponse();
		outPutResponse.setResultStatus(ResultStatus.SUCCESS);
		cassandraConnector.connect(null, 0, null);
		PreparedStatement preparedStatement = cassandraConnector.getSession().prepare(UserCredentialServiceQueryConstants.GET_CREATE_USER_CREDENTIAL_QUERY);
		BoundStatement bound = userCredentialServiceRepositoryMapper.mapUserCredentialBoundStatement(preparedStatement,userCredentialDAO);
		cassandraConnector.getSession().execute(bound);
		cassandraConnector.close();
		return outPutResponse;

	}

	@Override
	public Result deleteUserCredential(UUID userId) {
		return null;

	}

	@Override
	public Result updateUserCredential(UserCredentialDAO userCredentialDAO) {
		return null;

	}

	@Override
	public UserCredentialDAO getUserCredentialByUserName(UserCredentialDAO userCredentialDAO) {
		UserCredentialDAO resUserCredentialDAO=null;
		try {
			cassandraConnector.connect(null, 0,null);
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(UserCredentialServiceQueryConstants.GET_USERCREDENTIAL_BY_USERNAME_QUERY);
			BoundStatement bound=userCredentialServiceRepositoryMapper.mapGetUserCredentialByUserNameBoundStatement(preparedStatement,userCredentialDAO);
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row userCredentialDAOResult = resultSet.one();
				resUserCredentialDAO = userCredentialServiceRepositoryMapper.mapUserCredentialDAO(userCredentialDAOResult);
				if(!KatavuccolServiceUtility.isEqual(resUserCredentialDAO.getStatus(), KatavuccolConstant.ACTIVESTATUS))
				{
					resUserCredentialDAO=null;
				}
			}
		} catch (Exception exception) {
			logger.error("Exception in getUserCredentialByUserName error=" + exception);
		}
		return resUserCredentialDAO;
	}

}
