/**
 * 
 */
package seahorse.internal.business.coldfishservice.dal;

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

import seahorse.internal.business.coldfishservice.common.CassandraConnector;
import seahorse.internal.business.coldfishservice.common.ICassandraConnector;
import seahorse.internal.business.coldfishservice.common.IReadPropertiesFile;
import seahorse.internal.business.coldfishservice.constants.Constant;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeCategoryDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeDetailDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.coldfishservice.datacontracts.DeleteIncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.LoginDetailMessageEntity;
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

	public List<IncometypeDAO> getIncometypeByUserId(String userId) {
		List<IncometypeDAO> incometypeDAOs = new ArrayList<>();
		try {
			cassandraConnector.connect(null, 0,null);
			String applicationQuery = coldFishServiceRepositoryMapper.getIncometypeByUserIdQuery(userId);
			final ResultSet resultSet = cassandraConnector.getSession().execute(applicationQuery);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row incometypeDAOResult = resultSet.one();
				IncometypeDAO incometypeDAO = coldFishServiceRepositoryMapper.mapIncometypeDAO(incometypeDAOResult);
				incometypeDAOs.add(incometypeDAO);
			}
		} catch (Exception exception) {
			logger.error("Exception in ColdFishServiceRepository::getIncometypeByUserId" + exception);
		}
		return incometypeDAOs;
	}

	public List<IncometypeDAO> getDefaultIncometype() {
		List<IncometypeDAO> incometypeDAOs = new ArrayList<>();
		try {
			cassandraConnector.connect(null, 0,null);
			String applicationQuery = coldFishServiceRepositoryMapper.getDefaultIncometypeQuery();
			final ResultSet resultSet = cassandraConnector.getSession().execute(applicationQuery);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row incometypeDAOResult = resultSet.one();
				IncometypeDAO incometypeDAO = coldFishServiceRepositoryMapper.mapIncometypeDAO(incometypeDAOResult);
				incometypeDAOs.add(incometypeDAO);
			}
		} catch (Exception exception) {
			logger.error("Exception in ColdFishServiceRepository::getDefaultIncometype" + exception);
		}
		return incometypeDAOs;
	}

	public List<UserCredentialDAO> getUserCredential(LoginDetailMessageEntity loginDetailMessageEntity) {

		List<UserCredentialDAO> userCredentialDAOs = new ArrayList<>();

		try {
			cassandraConnector.connect(null, 0,null);
			PreparedStatement prepared=cassandraConnector.getSession().prepare(QueryConstants.GETUSERCREDENTIALBYUSERIDQUERY);
			BoundStatement bound=coldFishServiceRepositoryMapper.mapBoundStatement(prepared,loginDetailMessageEntity);
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row userCredentialDAOResult = resultSet.one();
				UserCredentialDAO userCredentialDAO = coldFishServiceRepositoryMapper
						.mapUserCredentialDAO(userCredentialDAOResult);
				userCredentialDAOs.add(userCredentialDAO);
			}
		} catch (Exception exception) {
			logger.error("Exception in getUserCredential error=" + exception);
		}
		return userCredentialDAOs;
	}

	@Override
	public IncometypeDAO createIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		IncometypeDAO incometypeDAO = new IncometypeDAO();
		cassandraConnector.connect(null, 0,null);
		String applicationQuery = coldFishServiceRepositoryMapper.createIncomeTypeQuery(incomeTypeMessageEntity);
		cassandraConnector.getSession().execute(applicationQuery);
		cassandraConnector.close();
		incometypeDAO.setId(incomeTypeMessageEntity.getId());
		return incometypeDAO;
	}

	public IncometypeDAO getIncomeTypeById(IncomeTypeMessageEntity incomeTypeMessageEntity)
	{
		IncometypeDAO incometypeDAO = new IncometypeDAO();
		try {
			cassandraConnector.connect(null, 0,null);
			String incomeTypeQuery = coldFishServiceRepositoryMapper.getIncomeTypeById(incomeTypeMessageEntity);
			final ResultSet resultSet = cassandraConnector.getSession().execute(incomeTypeQuery);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row incometypeDAOResult = resultSet.one();
				incometypeDAO = coldFishServiceRepositoryMapper.mapIncometypeDAO(incometypeDAOResult);				
			}
		} catch (Exception exception) {
			logger.error("Exception in getIncomeTypeById error=" + exception);
		}
		return incometypeDAO;
	}

	@Override
	public IncomeDetailDAO createIncomeDetail(IncomeDetailMessageEntity incomeDetailMessageEntity) {
		IncomeDetailDAO incomeDetailDAO = new IncomeDetailDAO();
		cassandraConnector.connect(null, 0,null);
		String incomeDetailDAOQuery = coldFishServiceRepositoryMapper.createIncomeDetailQuery(incomeDetailMessageEntity);
		cassandraConnector.getSession().execute(incomeDetailDAOQuery);
		cassandraConnector.close();
		incomeDetailDAO.setId(incomeDetailMessageEntity.getId());
		return incomeDetailDAO;
	}

	@Override
	public List<IncomeDetailDAO> getIncomeDetailByUserId(String userId) {
		List<IncomeDetailDAO> incomeDetailDAOs = new ArrayList<>();

		try {
			cassandraConnector.connect(null, 0,null);
			String applicationQuery = coldFishServiceRepositoryMapper.getIncomeDetailByUserIdQuery(userId);
			final ResultSet resultSet = cassandraConnector.getSession().execute(applicationQuery);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row incomeDetailResult = resultSet.one();
				IncomeDetailDAO incomeDetailDAO = coldFishServiceRepositoryMapper.mapIncomeDetailDAO(incomeDetailResult);
				incomeDetailDAOs.add(incomeDetailDAO);
			}
		} catch (Exception exception) {
			logger.error("Exception in getIncomeDetailByUserId error=" + exception);
		}
		return incomeDetailDAOs;
	}

	@Override
	public List<IncometypeDAO> getIncomeTypeByIds(List<String> incomeTypeIds) {
		List<IncometypeDAO> incometypeDAOs = new ArrayList<>();
		try {
			cassandraConnector.connect(null, 0,null);
			String incomeTypeQuery = coldFishServiceRepositoryMapper.getIncomeTypeByIdsQuery(incomeTypeIds);
			final ResultSet resultSet = cassandraConnector.getSession().execute(incomeTypeQuery);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row incometypeDAOResult = resultSet.one();
				IncometypeDAO incometypeDAO = coldFishServiceRepositoryMapper.mapIncometypeDAO(incometypeDAOResult);	
				incometypeDAOs.add(incometypeDAO);
			}
		} catch (Exception exception) {
			logger.error("Exception in getIncomeTypeByIds error=" + exception);
		}
		return incometypeDAOs;
	}

	@Override
	public List<IncomeCategoryDAO> getDefaultIncomeCategory() {
		List<IncomeCategoryDAO> incomeCategoryDAOs = new ArrayList<>();
		try {
			cassandraConnector.connect(null, 0,null);
			String incomeCategoryQuery = coldFishServiceRepositoryMapper.getDefaultIncomeCategoryQuery();
			final ResultSet resultSet = cassandraConnector.getSession().execute(incomeCategoryQuery);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row incomeCategoryDAOResult = resultSet.one();
				IncomeCategoryDAO incomeCategoryDAO = coldFishServiceRepositoryMapper.mapIncomeCategoryDAO(incomeCategoryDAOResult);	
				incomeCategoryDAOs.add(incomeCategoryDAO);
			}
		} catch (Exception exception) {
			logger.error("Exception in getDefaultIncomeCategory error=" + exception);
		}
		return incomeCategoryDAOs;
	}

	@Override
	public List<IncomeCategoryDAO> getIncomeCategoryByUserId(UUID userId,String month,int year) {
		List<IncomeCategoryDAO> incomeCategoryDAOs = new ArrayList<>();
		try {
			cassandraConnector.connect(null, 0,null);			
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GETINCOMECATEGORYBYUSERIDQUERY);
			BoundStatement bound=coldFishServiceRepositoryMapper.mapBoundStatement(preparedStatement,userId,month,year);
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row incomeCategoryDAOResult = resultSet.one();
				IncomeCategoryDAO incomeCategoryDAO = coldFishServiceRepositoryMapper.mapIncomeCategoryDAO(incomeCategoryDAOResult);	
				incomeCategoryDAOs.add(incomeCategoryDAO);
			}
		} catch (Exception exception) {
			logger.error("Exception in getIncomeCategoryByUserId error=" + exception);
		}
		return incomeCategoryDAOs;
	}

	@Override
	public IncomeCategoryDAO createIncomeCategory(IncomeCategoryMessageEntity incomeDetailMessageEntity) {
		IncomeCategoryDAO incomeCategoryDAO = new IncomeCategoryDAO();
		cassandraConnector.connect(null, 0,null);
		PreparedStatement pstmt=cassandraConnector.getSession().prepare(QueryConstants.CREATEINCOMECATEGORYQUERY);
		BoundStatement bound=coldFishServiceRepositoryMapper.mapCreateCategoryBoundStatement(pstmt,incomeDetailMessageEntity);		
		cassandraConnector.getSession().execute(bound);
		cassandraConnector.close();
		incomeCategoryDAO.setId(incomeDetailMessageEntity.getId());
		return incomeCategoryDAO;
	}

	@Override
	public IncomeCategoryDAO getIncomeCategoryById(UUID incomeCategoryId) {
		IncomeCategoryDAO incomeCategoryDAO = new IncomeCategoryDAO();
		try {
			cassandraConnector.connect(null, 0,null);			
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GETINCOMECATEGORYBYIDQUERY);
			BoundStatement bound=coldFishServiceRepositoryMapper.mapBoundStatement(preparedStatement,incomeCategoryId);
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row incomeCategoryDAOResult = resultSet.one();
				incomeCategoryDAO = coldFishServiceRepositoryMapper.mapIncomeCategoryDAO(incomeCategoryDAOResult);	
				
			}
		} catch (Exception exception) {
			logger.error("Exception in getIncomeCategoryByUserId error=" + exception);
		}
		return incomeCategoryDAO;
	}

	@Override
	public void DeleteIncomeCategory(DeleteIncomeCategoryMessageEntity deleteIncomeCategoryMessageEntity) {
		
		try {
			cassandraConnector.connect(null, 0,null);			
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.DELETEINCOMECATEGORYBYIDQUERY);
			BoundStatement bound=coldFishServiceRepositoryMapper.mapBoundStatement(preparedStatement,deleteIncomeCategoryMessageEntity);
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {						
			}
		} catch (Exception exception) {
			logger.error("Exception in getIncomeCategoryByUserId error=" + exception);
			throw exception;
		}			
	}
	@Override
	public List<IncomeCategoryDAO> getIncomeCategoryByParentId(IncomeCategoryMessageEntity incomeCategory) {
		List<IncomeCategoryDAO> incomeCategoryDAOs = new ArrayList<>();
		try {
			cassandraConnector.connect(null, 0,null);			
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GETINCOMECATEGORYBYPARENTIDQUERY);
			BoundStatement bound=coldFishServiceRepositoryMapper.mapGetIncomeCategoryBoundStatement(preparedStatement,incomeCategory);
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row incomeCategoryDAOResult = resultSet.one();
				incomeCategoryDAOs.add(coldFishServiceRepositoryMapper.mapIncomeCategoryDAO(incomeCategoryDAOResult));	
				
			}
		} catch (Exception exception) {
			logger.error("Exception in getIncomeCategoryByParentId error=" + exception);
		}
		return incomeCategoryDAOs;
	}

	@Override
	public void deleteSubIncomeCategory(DeleteIncomeCategoryMessageEntity deleteIncomeCategoryMessageEntity) {
		try {
			cassandraConnector.connect(null, 0,null);			
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.DELETEPARENTINCOMECATEGORYBYIDQUERY);
			BoundStatement bound=coldFishServiceRepositoryMapper.mapDeleteSubIncomeCategoryBoundStatement(preparedStatement,deleteIncomeCategoryMessageEntity);
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {						
			}
		} catch (Exception exception) {
			logger.error("Exception in getIncomeCategoryByUserId error=" + exception);
			throw exception;
		}			
	}

	@Override
	public List<IncomeCategoryDAO> getIncomeCategoryDetail(IncomeCategoryDAO incomeCategoryDAO) {
		List<IncomeCategoryDAO> incomeCategoryDAOs = new ArrayList<>();
		try {
			cassandraConnector.connect(null, 0,null);			
			PreparedStatement preparedStatement=cassandraConnector.getSession().prepare(QueryConstants.GETINCOMECATEGORYQUERY);
			BoundStatement bound=coldFishServiceRepositoryMapper.mapGetIncomeCategoryBoundStatement(preparedStatement,incomeCategoryDAO);
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row incomeCategoryDAOResult = resultSet.one();
				if(StringUtils.compareIgnoreCase(StringUtils.trim(incomeCategoryDAOResult.getString(DataBaseColumn.STATUS)),Constant.ACTIVESTATUS)==0)
				{
					incomeCategoryDAOs.add(coldFishServiceRepositoryMapper.mapIncomeCategoryDAO(incomeCategoryDAOResult));	
				}								
			}
		} catch (Exception exception) {
			logger.error("Exception in getIncomeCategoryByParentId error=" + exception);
		}
		return incomeCategoryDAOs;
	}
}
