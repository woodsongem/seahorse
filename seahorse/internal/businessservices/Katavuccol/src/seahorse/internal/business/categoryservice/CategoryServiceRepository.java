/**
 * 
 */
package seahorse.internal.business.categoryservice;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.Logger;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.google.inject.Inject;
import seahorse.internal.business.categoryservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.common.ICassandraConnector;
import seahorse.internal.business.katavuccolservice.common.IReadPropertiesFile;
import seahorse.internal.business.katavuccolservice.common.KatavuccolConstant;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.OutPutResponse;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.QueryConstants;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.shared.aop.InjectLogger;

/**
 * @author SMJE
 *
 */
public class CategoryServiceRepository implements ICategoryServiceRepository {
	private final ICategoryServiceRepositoryMapper categoryServiceRepositoryMapper;
	private final ICassandraConnector cassandraConnector;
	private final IReadPropertiesFile readPropertiesFile;

	@InjectLogger
	Logger logger;

	@Inject
	public CategoryServiceRepository(ICategoryServiceRepositoryMapper categoryServiceRepositoryMapper,
			ICassandraConnector cassandraConnector, IReadPropertiesFile readPropertiesFile) {
		this.categoryServiceRepositoryMapper = categoryServiceRepositoryMapper;
		this.cassandraConnector = cassandraConnector;
		this.readPropertiesFile = readPropertiesFile;
	}

	public List<CategoryDAO> getCategoryDetailByUserId(UUID userId) {
		List<CategoryDAO> categoryDAOs = new ArrayList<>();
		try {
			cassandraConnector.connect(null, 0, null);
			PreparedStatement preparedStatement = cassandraConnector.getSession()
					.prepare(QueryConstants.GET_CATEGORY_DETAIL_BY_USERID_QUERY);
			BoundStatement bound = categoryServiceRepositoryMapper.mapBoundStatement(preparedStatement, userId);
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row categoryDAOResult = resultSet.one();
				CategoryDAO categoryDAO = categoryServiceRepositoryMapper.mapCategoryDAO(categoryDAOResult);
				if (KatavuccolServiceUtility.isEqual(categoryDAO.getStatus(), KatavuccolConstant.ACTIVESTATUS)) {
					categoryDAOs.add(categoryDAO);
				}
			}
		} catch (Exception exception) {
			logger.error("Exception in getCategoryDetailByUserId error=" + exception);
		}
		return categoryDAOs;
	}

	@Override
	public OutPutResponse createCategory(CategoryRequestMessageEntity categoryRequestMessageEntity) {
		OutPutResponse outPutResponse = new OutPutResponse();
		outPutResponse.setResultStatus(ResultStatus.SUCCESS);
		cassandraConnector.connect(null, 0, null);
		PreparedStatement preparedStatement = cassandraConnector.getSession()
				.prepare(QueryConstants.GET_CREATE_CATEGORY_QUERY);
		BoundStatement bound = categoryServiceRepositoryMapper.mapBoundStatementRequest(preparedStatement,
				categoryRequestMessageEntity);
		cassandraConnector.getSession().execute(bound);
		cassandraConnector.close();
		return outPutResponse;
	}

	@Override
	public OutPutResponse deleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		OutPutResponse outPutResponse = new OutPutResponse();
		outPutResponse.setResultStatus(ResultStatus.SUCCESS);
		cassandraConnector.connect(null, 0, null);
		PreparedStatement preparedStatement = cassandraConnector.getSession()
				.prepare(QueryConstants.GET_DELETE_CATEGORY_QUERY);
		BoundStatement bound = categoryServiceRepositoryMapper.mapBoundStatement(preparedStatement,
				deleteCategoryRequestMessageEntity);
		cassandraConnector.getSession().execute(bound);
		cassandraConnector.close();
		return outPutResponse;
	}

	@Override
	public Result updateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		Result result = new Result();
		result.setResultStatus(ResultStatus.SUCCESS);
		cassandraConnector.connect(null, 0, null);
		PreparedStatement preparedStatement = cassandraConnector.getSession()
				.prepare(QueryConstants.GET_UPDATE_CATEGORY_QUERY);
		BoundStatement bound = categoryServiceRepositoryMapper.mapBoundStatement(preparedStatement,
				updateCategoryMessageEntity);
		cassandraConnector.getSession().execute(bound);
		cassandraConnector.close();
		return result;
	}

	@Override
	public CategoryDAO getCategoryDetailById(UUID categoryId, UUID userId) {
		CategoryDAO categoryDAO = null;
		try {
			cassandraConnector.connect(null, 0, null);
			PreparedStatement preparedStatement = cassandraConnector.getSession()
					.prepare(QueryConstants.GET_CATEGORY_DETAIL_BY_ID_QUERY);
			BoundStatement bound = categoryServiceRepositoryMapper.mapBoundStatement(preparedStatement, categoryId,
					userId);
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row categoryDAOResult = resultSet.one();
				categoryDAO = categoryServiceRepositoryMapper.mapCategoryDAO(categoryDAOResult);
				if (!KatavuccolServiceUtility.isEqual(categoryDAO.getStatus(), KatavuccolConstant.ACTIVESTATUS)) {
					categoryDAO = null;
				}
			}
		} catch (Exception exception) {
			logger.error("Exception in getCategoryDetailById error=" + exception);
		}
		return categoryDAO;
	}
}
