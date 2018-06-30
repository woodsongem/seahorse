/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.Logger;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.google.inject.Inject;

import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeModel;
import seahorse.internal.business.katavuccolservice.common.ICassandraConnector;
import seahorse.internal.business.katavuccolservice.common.IReadPropertiesFile;
import seahorse.internal.business.katavuccolservice.common.KatavuccolConstant;
import seahorse.internal.business.katavuccolservice.dal.QueryConstants;
import seahorse.internal.business.katavuccolservice.utilities.KatavuccolServiceUtility;
import seahorse.internal.business.shared.aop.InjectLogger;

/**
 * @author admin
 *
 */
public class CredentialTypeServiceRepository implements ICredentialTypeServiceRepository {

	private final ICredentialTypeServiceRepositoryMapper credentialTypeServiceRepositoryMapper;
	private final ICassandraConnector cassandraConnector;
	private final IReadPropertiesFile readPropertiesFile;
	
	@InjectLogger
	Logger logger;
	
	@Inject
	public CredentialTypeServiceRepository(
			ICredentialTypeServiceRepositoryMapper credentialTypeServiceRepositoryMapper,
			ICassandraConnector cassandraConnector,
			IReadPropertiesFile readPropertiesFile
			)
	{
		this.credentialTypeServiceRepositoryMapper=credentialTypeServiceRepositoryMapper;
		this.cassandraConnector=cassandraConnector;
		this.readPropertiesFile=readPropertiesFile;
	}
	
	public List<CredentialTypeModel> getCredentialTypeByUserId(UUID userId,Boolean includeInActiveStatus) {
		List<CredentialTypeModel> credentialTypeModels = new ArrayList<>();
		try {
			cassandraConnector.connect(null, 0,null);
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_CATEGORY_TYPE_DETAILS_BY_USER_ID_QUERY);
			BoundStatement bound=credentialTypeServiceRepositoryMapper.mapCredentialTypeByUserIdBoundStatement(preparedStatement,userId);			
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row typeDAOResult = resultSet.one();
				CredentialTypeModel credentialTypeModel = credentialTypeServiceRepositoryMapper.mapCredentialTypeModel(typeDAOResult);	
				if(!KatavuccolServiceUtility.isEqual(credentialTypeModel.getStatus(), KatavuccolConstant.ACTIVESTATUS) && !includeInActiveStatus)
				{
					continue;
				}	
				credentialTypeModels.add(credentialTypeModel);
			}
		} catch (Exception exception) {
			logger.error("Exception in getCredentialTypeByUserId error=" + exception);
			throw exception;
		}
		return credentialTypeModels;
	}
}
