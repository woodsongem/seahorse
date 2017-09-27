/**
 * 
 */
package seahorse.internal.business.coldfishservice.dal;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.google.inject.Inject;

import seahorse.internal.business.coldfishservice.common.ICassandraConnector;
import seahorse.internal.business.coldfishservice.common.IReadPropertiesFile;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
import seahorse.internal.business.shared.aop.InjectLogger;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceRepository implements IColdFishServiceRepository {

	private final IColdFishServiceRepositoryMapper coldFishServiceRepositoryMapper;
	private final ICassandraConnector cassandraConnector;
	private final IReadPropertiesFile readPropertiesFile;
	@InjectLogger
	Logger logger;

	@Inject
	public ColdFishServiceRepository(IColdFishServiceRepositoryMapper coldFishServiceRepositoryMapper,
			ICassandraConnector cassandraConnector, IReadPropertiesFile readPropertiesFile) {
		this.coldFishServiceRepositoryMapper = coldFishServiceRepositoryMapper;
		this.cassandraConnector = cassandraConnector;
		this.readPropertiesFile = readPropertiesFile;
	}

	public List<IncometypeDAO> GetIncometypeByUserId(String userId) {
		List<IncometypeDAO> incometypeDAOs = new ArrayList<>();
		try {
			cassandraConnector.connect(null, 0);
			String applicationQuery = coldFishServiceRepositoryMapper.getIncometypeByUserIdQuery(userId);
			final ResultSet resultSet = cassandraConnector.getSession().execute(applicationQuery);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row incometypeDAOResult = resultSet.one();
				IncometypeDAO incometypeDAO = coldFishServiceRepositoryMapper.mapIncometypeDAO(incometypeDAOResult);
				incometypeDAOs.add(incometypeDAO);
			}
		} catch (Exception exception) {
			logger.error("");
		}
		return incometypeDAOs;
	}

	public List<IncometypeDAO> GetDefaultIncometype() {
		List<IncometypeDAO> incometypeDAOs = new ArrayList<>();
		try {
			cassandraConnector.connect(null, 0);
			String applicationQuery = coldFishServiceRepositoryMapper.getDefaultIncometypeQuery();
			final ResultSet resultSet = cassandraConnector.getSession().execute(applicationQuery);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row incometypeDAOResult = resultSet.one();
				IncometypeDAO incometypeDAO = coldFishServiceRepositoryMapper.mapIncometypeDAO(incometypeDAOResult);
				incometypeDAOs.add(incometypeDAO);
			}
		} catch (Exception exception) {
			logger.error("");
		}
		return incometypeDAOs;
	}
}
