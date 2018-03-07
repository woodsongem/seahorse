/**
 * 
 */

package seahorse.internal.business.katavuccolservice.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.logging.log4j.Logger;
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
	
	public CategoryDAO getCategoryDetailById(UUID categoryId,UUID userId)
	{
		CategoryDAO categoryDAO = new CategoryDAO();
		try {
			cassandraConnector.connect(null, 0,null);
			String categoryQuery = katavuccolServiceRepositoryMapper.getCategoryDetailByIdQuery(categoryId,userId);
			final ResultSet resultSet = cassandraConnector.getSession().execute(categoryQuery);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row categoryDAOResult = resultSet.one();
				categoryDAO = katavuccolServiceRepositoryMapper.mapCategoryDAO(categoryDAOResult);				
			}
		} catch (Exception exception) {
			logger.error("Exception in getCategoryDetailById error=" + exception);
		}
		return categoryDAO;
	}
	
	public TypeDAO getCredentialTypeDetailById(UUID typeId,UUID userId)
	{
		TypeDAO typeDAO = new TypeDAO();
		try {
			cassandraConnector.connect(null, 0,null);
			String categoryQuery = katavuccolServiceRepositoryMapper.getCredentialTypeDetailsByIdQuery(typeId,userId);
			final ResultSet resultSet = cassandraConnector.getSession().execute(categoryQuery);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row typeDAOResult = resultSet.one();
				typeDAO = katavuccolServiceRepositoryMapper.mapCredentialTypeDAO(typeDAOResult);				
			}
		} catch (Exception exception) {
			logger.error("Exception in getCredentialTypeDetailById error=" + exception);
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

	public List<CategoryDAO> getCategoryDetailByUserId(UUID userId)
	{
		List<CategoryDAO> categoryDAOs = new ArrayList<>();
		try {
			cassandraConnector.connect(null, 0,null);
			String categoryQuery = katavuccolServiceRepositoryMapper.getCategoryDetailByUserIdQuery(userId);
			final ResultSet resultSet = cassandraConnector.getSession().execute(categoryQuery);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row categoryDAOResult = resultSet.one();
				categoryDAOs.add(katavuccolServiceRepositoryMapper.mapCategoryDAO(categoryDAOResult));				
			}
		} catch (Exception exception) {
			logger.error("Exception in getCategoryDetailByUserId error=" + exception);
		}
		return categoryDAOs;
	}
	
	public List<TypeDAO> getTypeDetailsByUserId(UUID userId)
	{
		List<TypeDAO> typeDAOs = new ArrayList<>();
		try {
			cassandraConnector.connect(null, 0,null);
			String categoryQuery = katavuccolServiceRepositoryMapper.getTypeDetailsByUserIdQuery(userId);
			final ResultSet resultSet = cassandraConnector.getSession().execute(categoryQuery);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row typeDAOResult = resultSet.one();
				typeDAOs.add(katavuccolServiceRepositoryMapper.mapCredentialTypeDAO(typeDAOResult));				
			}
		} catch (Exception exception) {
			logger.error("Exception in getTypeDetailsByUserId error=" + exception);
		}
		return typeDAOs;
	}
	
}
