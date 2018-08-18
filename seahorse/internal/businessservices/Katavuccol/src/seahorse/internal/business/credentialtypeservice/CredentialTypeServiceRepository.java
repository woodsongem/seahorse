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
import seahorse.internal.business.katavuccolservice.common.datacontracts.OutPutResponse;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.QueryConstants;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;
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
	
	@Override
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
	
	@Override
	public List<CredentialTypeDAO> getCredentialTypeDAOByUserId(UUID userId,Boolean includeInActiveStatus) {
		List<CredentialTypeDAO> credentialTypeDAOs = new ArrayList<>();
		try {
			cassandraConnector.connect(null, 0,null);
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_CATEGORY_TYPE_DETAILS_BY_USER_ID_QUERY);
			BoundStatement bound=credentialTypeServiceRepositoryMapper.mapCredentialTypeByUserIdBoundStatement(preparedStatement,userId);			
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row typeDAOResult = resultSet.one();
				CredentialTypeDAO credentialTypeDAO = credentialTypeServiceRepositoryMapper.mapCredentialTypeDAO(typeDAOResult);	
				if(!KatavuccolServiceUtility.isEqual(credentialTypeDAO.getStatus(), KatavuccolConstant.ACTIVESTATUS) && !includeInActiveStatus)
				{
					continue;
				}	
				credentialTypeDAOs.add(credentialTypeDAO);
			}
		} catch (Exception exception) {
			logger.error("Exception in getCredentialTypeDAOByUserId error=" + exception);
			throw exception;
		}
		return credentialTypeDAOs;
	}
	
	@Override
	public List<CredentialTypeDAO> getDefaultCredentialTypeDAO() {
		List<CredentialTypeDAO> credentialTypeDAOs = new ArrayList<>();
		try {
			cassandraConnector.connect(null, 0,null);
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_DEFAULT_CATEGORY_TYPE_DETAILS_QUERY);
			BoundStatement bound=credentialTypeServiceRepositoryMapper.mapGetDefaultCredentialTypeDAOBoundStatement(preparedStatement);			
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row typeDAOResult = resultSet.one();
				CredentialTypeDAO credentialTypeDAO = credentialTypeServiceRepositoryMapper.mapCredentialTypeDAO(typeDAOResult);
				credentialTypeDAOs.add(credentialTypeDAO);
			}
		} catch (Exception exception) {
			logger.error("Exception in getDefaultCredentialTypeDAO error=" + exception);
			throw exception;
		}
		return credentialTypeDAOs;
	}
	
	@Override
	public OutPutResponse createCategoryType(CredentialTypeDAO credentialTypeDAO) {
		OutPutResponse outPutResponse=new OutPutResponse();
		outPutResponse.setResultStatus(ResultStatus.SUCCESS);
		cassandraConnector.connect(null, 0,null);
		PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_CREATE_CREDENTIALTYPE_QUERY);
		BoundStatement bound=credentialTypeServiceRepositoryMapper.mapBoundStatementRequest(preparedStatement,credentialTypeDAO);
		cassandraConnector.getSession().execute(bound);
		cassandraConnector.close();
		return outPutResponse;	
	}

	@Override
	public CredentialTypeModel getCredentialTypeByUserIdAndId(UUID userId,UUID id) {
		CredentialTypeModel credentialTypeModel=new CredentialTypeModel();
		try {
			cassandraConnector.connect(null, 0,null);
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_CATEGORY_TYPE_DETAILS_BY_USERID_AND_ID_QUERY);
			BoundStatement bound=credentialTypeServiceRepositoryMapper.mapgetCredentialTypeByUserIdAndIdBoundStatement(preparedStatement,userId,id);			
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row typeDAOResult = resultSet.one();
				credentialTypeModel = credentialTypeServiceRepositoryMapper.mapCredentialTypeModel(typeDAOResult);	
				if(!KatavuccolServiceUtility.isEqual(credentialTypeModel.getStatus(), KatavuccolConstant.ACTIVESTATUS))
				{
					credentialTypeModel=null;
				}
			}
		} catch (Exception exception) {
			logger.error("Exception in getCredentialTypeByUserId error=" + exception);
			throw exception;
		}
		return credentialTypeModel;
	}
	
	@Override
	public CredentialTypeDAO getCredentialTypeDAOByUserIdAndId(UUID userId,UUID id) {
		CredentialTypeDAO credentialTypeDAO=new CredentialTypeDAO();
		try {
			cassandraConnector.connect(null, 0,null);
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_CATEGORY_TYPE_DETAILS_BY_USERID_AND_ID_QUERY);
			BoundStatement bound=credentialTypeServiceRepositoryMapper.mapgetCredentialTypeByUserIdAndIdBoundStatement(preparedStatement,userId,id);			
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row typeDAOResult = resultSet.one();
				credentialTypeDAO = credentialTypeServiceRepositoryMapper.mapCredentialTypeDAO(typeDAOResult);	
				if(!KatavuccolServiceUtility.isEqual(credentialTypeDAO.getStatus(), KatavuccolConstant.ACTIVESTATUS))
				{
					credentialTypeDAO=null;
				}
			}
		} catch (Exception exception) {
			logger.error("Exception in getCredentialTypeByUserId error=" + exception);
			throw exception;
		}
		return credentialTypeDAO;
	}

	@Override
	public Result deleteCredentialType(CredentialTypeDAO credentialTypeDAO) {
		Result result=new Result();
		try {
			
			cassandraConnector.connect(null, 0,null);
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GET_DELETE_CREDENTIAL_TYPE_QUERY);
			BoundStatement bound=credentialTypeServiceRepositoryMapper.mapDeleteCredentialTypeBoundStatement(preparedStatement,credentialTypeDAO);
			cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();		
			
		} catch (Exception exception) {
			logger.error("Exception in getCredentialTypeByUserId error=" + exception);
			throw exception;
		}
		return result;
	}
}
