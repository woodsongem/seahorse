/**
 * 
 */

package seahorse.internal.business.katavuccolservice.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.google.inject.Inject;

import seahorse.internal.business.katavuccolservice.common.ICassandraConnector;
import seahorse.internal.business.katavuccolservice.common.IReadPropertiesFile;
import seahorse.internal.business.shared.aop.InjectLogger;

/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceRepository implements IKatavuccolServiceRepository {

	private final IKatavuccolServiceRepositoryMapper katavuccolServiceRepositoryMapper;
	private final ICassandraConnector cassandraConnector;
	private final IReadPropertiesFile readPropertiesFile;

	@InjectLogger
	Logger logger;

	@Inject
	public KatavuccolServiceRepository(IKatavuccolServiceRepositoryMapper katavuccolServiceRepositoryMapper,
			ICassandraConnector cassandraConnector, IReadPropertiesFile readPropertiesFile) {
		this.katavuccolServiceRepositoryMapper = katavuccolServiceRepositoryMapper;
		this.cassandraConnector = cassandraConnector;
		this.readPropertiesFile = readPropertiesFile;
	}
	
}
