/**
 * 
 */
package seahorse.internal.business.applicationservice.dal;

import java.util.UUID;

import org.apache.logging.log4j.Logger;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.google.inject.Inject;

import seahorse.internal.business.applicationservice.common.ICassandraConnector;
import seahorse.internal.business.applicationservice.common.IReadPropertiesFile;
import seahorse.internal.business.applicationservice.dal.datacontracts.ApplicationDetailDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.EmailAddressDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.PhoneDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.UserSecurityQuestionDAO;
import seahorse.internal.business.applicationservice.datacontracts.ApplicationDetailResponseMessageEntity;
import seahorse.internal.business.shared.aop.InjectLogger;
import seahorse.internal.business.shared.aop.Report;

/**
 * @author admin
 *
 */
public class ApplicationDetailRepository implements IApplicationDetailRepository {

	private final IApplicationDetailRepositoryMapper _applicationDetailRepositoryMapper;
	private final ICassandraConnector _cassandraConnector;
	private final IReadPropertiesFile _readPropertiesFile;
	
	@InjectLogger
	Logger logger;

	@Inject
	ApplicationDetailRepository(IApplicationDetailRepositoryMapper applicationDetailRepositoryMapper,
			ICassandraConnector cassandraConnector,IReadPropertiesFile readPropertiesFile
	// , Logger logger
	) {
		this._applicationDetailRepositoryMapper = applicationDetailRepositoryMapper;
		this._cassandraConnector = cassandraConnector;
		this._readPropertiesFile=readPropertiesFile;
		// this.logger = logger;
	}

	@Report
	public ApplicationDetailDAO GetApplicationByApplicationId(String applicationId) {
		ApplicationDetailDAO applicationDetailDAO = null;
		_cassandraConnector.connect(null, 0);
		String applicationQuery=_applicationDetailRepositoryMapper.getApplicationByApplicationIdQuery(applicationId);
		final ResultSet resultSet = _cassandraConnector.getSession().execute(applicationQuery);		
		_cassandraConnector.close();	
		while (!resultSet.isExhausted()) {
			final Row applicationResult = resultSet.one();
			applicationDetailDAO=_applicationDetailRepositoryMapper.mapGetApplicationByApplicationId(applicationResult);
		}
		return applicationDetailDAO;
	}
	
	@Report
	public EmailAddressDAO GetEmailAddressById(UUID emailid) {
		EmailAddressDAO emailAddressDAO=new EmailAddressDAO();		
		_cassandraConnector.connect(null, 0);
		String emailAddressQuery=_applicationDetailRepositoryMapper.getEmailAddressByIdQuery(emailid);
		final ResultSet resultSet = _cassandraConnector.getSession().execute(emailAddressQuery);		
		_cassandraConnector.close();	
		while (!resultSet.isExhausted()) {
			final Row emailAddressResult = resultSet.one();
			emailAddressDAO=_applicationDetailRepositoryMapper.mapEmailAddressDAO(emailAddressResult);
		}		
		return emailAddressDAO;
	}
	
	@Report
	public PhoneDAO GetPhoneById(UUID phoneid) {
		PhoneDAO phoneDAO=new PhoneDAO();		
		_cassandraConnector.connect(null, 0);
		String phoneQuery=_applicationDetailRepositoryMapper.getPhoneByIdQuery(phoneid);
		final ResultSet resultSet = _cassandraConnector.getSession().execute(phoneQuery);		
		_cassandraConnector.close();	
		while (!resultSet.isExhausted()) {
			final Row phoneResult = resultSet.one();
			phoneDAO=_applicationDetailRepositoryMapper.mapPhoneDAO(phoneResult);
		}		
		return phoneDAO;
	}
	
	@Report
	public UserSecurityQuestionDAO GetUserSecurityQuestion(UUID userSecurityQuestionId) {
		UserSecurityQuestionDAO userSecurityQuestionDAO=new UserSecurityQuestionDAO();		
		_cassandraConnector.connect(null, 0);
		String phoneQuery=_applicationDetailRepositoryMapper.getUserSecurityQuestionQuery(userSecurityQuestionId);
		final ResultSet resultSet = _cassandraConnector.getSession().execute(phoneQuery);		
		_cassandraConnector.close();	
		while (!resultSet.isExhausted()) {
			final Row phoneResult = resultSet.one();
			userSecurityQuestionDAO=_applicationDetailRepositoryMapper.mapUserSecurityQuestionDAO(phoneResult);
		}		
		return userSecurityQuestionDAO;
	}

	@Override
	public ApplicationDetailResponseMessageEntity CreateApplication(ApplicationDetailDAO _applicationDetailDAO) {
		return null;
	}

	@Override
	public ApplicationDetailResponseMessageEntity UpdateApplication(ApplicationDetailDAO _applicationDetailDAO) {
		return null;
	}
}
