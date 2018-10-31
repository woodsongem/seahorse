/**
 * 
 */
package seahorse.internal.business.emailservice;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.Logger;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.google.inject.Inject;

import seahorse.internal.business.emailservice.dal.datacontracts.EmailAddressDAO;
import seahorse.internal.business.shared.aop.InjectLogger;
import seahorse.internal.business.shared.katavuccol.common.ICassandraConnector;
import seahorse.internal.business.shared.katavuccol.common.IReadPropertiesFile;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolConstant;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolServiceUtility;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;

/**
 * @author SMJE
 *
 */
public class EmailServiceRepository implements IEmailServiceRepository {
	private final IEmailServiceRepositoryMapper emailServiceRepositoryMapper;
	private final ICassandraConnector cassandraConnector;
	private final IReadPropertiesFile readPropertiesFile;

	@InjectLogger
	Logger logger;

	@Inject
	public EmailServiceRepository(IEmailServiceRepositoryMapper emailServiceRepositoryMapper,
			ICassandraConnector cassandraConnector, IReadPropertiesFile readPropertiesFile) {
		this.emailServiceRepositoryMapper = emailServiceRepositoryMapper;
		this.cassandraConnector = cassandraConnector;
		this.readPropertiesFile = readPropertiesFile;
	}

	@Override
	public List<EmailAddressDAO> getEmailAddressByUserId(UUID userId) {
		List<EmailAddressDAO> emailServiceDAO = new ArrayList<>();

		try {
			cassandraConnector.connect(null, 0, null);
			PreparedStatement preparedStatement = cassandraConnector.getSession().prepare(EmailServiceQueryConstants.GET_EMAILADDRESS_BY_USERID_QUERY);
			BoundStatement bound = emailServiceRepositoryMapper.mapEmailAddressBoundStatement(preparedStatement,userId);
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row emailDAOResult = resultSet.one();
				EmailAddressDAO emailAddressDAO = emailServiceRepositoryMapper.mapEmailAddressDAO(emailDAOResult);
				if (KatavuccolServiceUtility.isEqual(emailAddressDAO.getStatus(), KatavuccolConstant.ACTIVESTATUS)) {
					emailServiceDAO.add(emailAddressDAO);
				}
			}
		} catch (Exception exception) {
			logger.error("Exception in getEmailAddressByUserId error=" + exception);
		}
		return emailServiceDAO;
	}

	@Override
	public EmailAddressDAO getEmailAddressById(UUID emailAddressId) {
		EmailAddressDAO emailServiceDAO = new EmailAddressDAO();

		try {
			cassandraConnector.connect(null, 0, null);
			PreparedStatement preparedStatement = cassandraConnector.getSession().prepare(EmailServiceQueryConstants.GET_EMAILADDRESS_BY_ID_QUERY);
			BoundStatement bound = emailServiceRepositoryMapper.mapEmailAddressByIdBoundStatement(preparedStatement,emailAddressId);
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row emailDAOResult = resultSet.one();
				EmailAddressDAO emailAddressDAO = emailServiceRepositoryMapper.mapEmailAddressDAO(emailDAOResult);
				if (KatavuccolServiceUtility.isEqual(emailAddressDAO.getStatus(), KatavuccolConstant.ACTIVESTATUS)) {
					emailAddressDAO = null;
				}
			}
		} catch (Exception exception) {
			logger.error("Exception in getEmailAddressByUserId error=" + exception);
		}
		return emailServiceDAO;
	}

	@Override
	public OutPutResponse CreateEmailAddress(EmailAddressDAO emailAddressDAO) {
		OutPutResponse outPutResponse = new OutPutResponse();
		outPutResponse.setResultStatus(ResultStatus.SUCCESS);
		cassandraConnector.connect(null, 0, null);
		PreparedStatement preparedStatement = cassandraConnector.getSession()
				.prepare(EmailServiceQueryConstants.GET_CREATE_EMAIL_ADDRESS_QUERY);
		BoundStatement bound = emailServiceRepositoryMapper.mapBoundStatementRequest(preparedStatement,
				emailAddressDAO);
		cassandraConnector.getSession().execute(bound);
		cassandraConnector.close();
		return outPutResponse;
	}

	@Override
	public Result updateEmailId(EmailAddressDAO emailAddressDAO) {
		Result result = new Result();
		result.setResultStatus(ResultStatus.SUCCESS);
		cassandraConnector.connect(null, 0, null);
		PreparedStatement preparedStatement = cassandraConnector.getSession()
				.prepare(EmailServiceQueryConstants.GET_UPDATE_EMAILADDRESS_QUERY);
		BoundStatement bound = emailServiceRepositoryMapper.mapBoundStatement(preparedStatement, emailAddressDAO);
		cassandraConnector.getSession().execute(bound);
		cassandraConnector.close();
		return result;
	}

	@Override
	public Result DeleteEmailId(UUID emailAddressId) {
		Result result = new Result();
		result.setResultStatus(ResultStatus.SUCCESS);
		cassandraConnector.connect(null, 0, null);
		PreparedStatement preparedStatement = cassandraConnector.getSession()
				.prepare(EmailServiceQueryConstants.GET_DELETE_EMAILADDRESS_EMAILADDRESS_ID_QUERY);
		BoundStatement bound = emailServiceRepositoryMapper.mapBoundStatement(preparedStatement, emailAddressId);
		cassandraConnector.getSession().execute(bound);
		cassandraConnector.close();
		return result;
	}

}
