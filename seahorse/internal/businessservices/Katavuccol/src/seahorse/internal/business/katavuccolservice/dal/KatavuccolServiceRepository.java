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
import seahorse.internal.business.katavuccolservice.common.datacontracts.OutPutResponse;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.TypeDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
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
	
	public CategoryDAO getCategoryDetailsById(UUID categoryId)
	{
		CategoryDAO categoryDAO = new CategoryDAO();
		try {
			cassandraConnector.connect(null, 0,null);
			String categoryQuery = katavuccolServiceRepositoryMapper.getCategoryDetailsByIdQuery(categoryId);
			final ResultSet resultSet = cassandraConnector.getSession().execute(categoryQuery);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row categoryDAOResult = resultSet.one();
				categoryDAO = katavuccolServiceRepositoryMapper.mapCategoryDAO(categoryDAOResult);				
			}
		} catch (Exception exception) {
			logger.error("Exception in GetCategoryDetailsById error=" + exception);
		}
		return categoryDAO;
	}
	public TypeDAO getTypeDetailsById(UUID typeId)
	{
		TypeDAO typeDAO = new TypeDAO();
		try {
			cassandraConnector.connect(null, 0,null);
			String categoryQuery = katavuccolServiceRepositoryMapper.getTypeDetailsByIdQuery(typeId);
			final ResultSet resultSet = cassandraConnector.getSession().execute(categoryQuery);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row typeDAOResult = resultSet.one();
				typeDAO = katavuccolServiceRepositoryMapper.mapTypeDAO(typeDAOResult);				
			}
		} catch (Exception exception) {
			logger.error("Exception in getTypeDetailsById error=" + exception);
		}
		return typeDAO;
	}
	public OutPutResponse createCredential(CredentialRequestMessageEntity credentialRequestMessageEntity)
	{
		OutPutResponse outPutResponse=new OutPutResponse();		
		cassandraConnector.connect(null, 0,null);
		String credentialQuery = katavuccolServiceRepositoryMapper.getCreateCredentialQuery(credentialRequestMessageEntity);
		cassandraConnector.getSession().execute(credentialQuery);
		cassandraConnector.close();
		outPutResponse.setId(credentialRequestMessageEntity.getId());
		return outPutResponse;		
	}
}
