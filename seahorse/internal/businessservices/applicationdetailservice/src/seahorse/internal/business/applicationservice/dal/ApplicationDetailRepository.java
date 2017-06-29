/**
 * 
 */
package seahorse.internal.business.applicationservice.dal;

import java.text.MessageFormat;

import org.apache.logging.log4j.Logger;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.google.inject.Inject;

import seahorse.internal.business.applicationservice.common.ICassandraConnector;
import seahorse.internal.business.applicationservice.common.IReadPropertiesFile;
import seahorse.internal.business.applicationservice.constants.QueryConstants;
import seahorse.internal.business.applicationservice.dal.datacontracts.ApplicationDetailDAO;
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

	@Override
	public ApplicationDetailResponseMessageEntity CreateApplication(ApplicationDetailDAO _applicationDetailDAO) {
		return null;
	}

	@Override
	public ApplicationDetailResponseMessageEntity UpdateApplication(ApplicationDetailDAO _applicationDetailDAO) {
		return null;
	}
}
