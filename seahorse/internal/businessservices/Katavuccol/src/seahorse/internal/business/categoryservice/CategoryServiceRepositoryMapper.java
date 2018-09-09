/**
 * 
 */
package seahorse.internal.business.categoryservice;

import java.text.MessageFormat;
import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;

import seahorse.internal.business.categoryservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.dal.DataBaseColumn;
import seahorse.internal.business.katavuccolservice.dal.QueryConstants;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;

/**
 * @author SMJE
 *
 */
public class CategoryServiceRepositoryMapper implements ICategoryServiceRepositoryMapper {

	@Override
	public String getCategoryDetailByIdQuery(UUID categoryId,UUID userId) {
		Object[] args = { categoryId,userId };
		return new MessageFormat(QueryConstants.GET_CATEGORY_DETAIL_BY_ID_QUERY).format(args);
	}

	@Override
	public BoundStatement mapBoundStatement(PreparedStatement preparedStatement, UUID userId) {
		BoundStatement bound = preparedStatement.bind();		
		bound.setUUID(DataBaseColumn.USERID,userId);
		return bound;
	}
	
	@Override
	public CategoryDAO mapCategoryDAO(Row categoryDAOResult) {
		CategoryDAO categoryDAO =new CategoryDAO();
		categoryDAO.setCreatedBy(categoryDAOResult.getUUID(DataBaseColumn.CREATEDBY));
		categoryDAO.setCreatedDate(categoryDAOResult.getTimestamp(DataBaseColumn.CREATEDDATE));
		categoryDAO.setDescription(categoryDAOResult.getString(DataBaseColumn.CATEGORY_DESCRIPTION));
		categoryDAO.setId(categoryDAOResult.getUUID(DataBaseColumn.ID));
		categoryDAO.setModifiedBy(categoryDAOResult.getUUID(DataBaseColumn.MODIFIEDBY));
		categoryDAO.setModifiedDate(categoryDAOResult.getTimestamp(DataBaseColumn.MODIFIEDDATE));
		categoryDAO.setName(categoryDAOResult.getString(DataBaseColumn.CATEGORY_NAME));
		categoryDAO.setStatus(categoryDAOResult.getString(DataBaseColumn.STATUS));
		categoryDAO.setUserId(categoryDAOResult.getUUID(DataBaseColumn.USERID));		
		return categoryDAO;
	}
	
	@Override
	public String getCategoryDetailByUserIdQuery(UUID userId) {
		Object[] args = { userId };
		return new MessageFormat(QueryConstants.GET_CATEGORY_DETAIL_BY_USERID_QUERY).format(args);
	}
	
	@Override
	public BoundStatement mapBoundStatement(PreparedStatement preparedStatement, UUID categoryId, UUID userId) {
		BoundStatement bound = preparedStatement.bind();
		bound.setUUID(DataBaseColumn.ID, categoryId);
		bound.setUUID(DataBaseColumn.USERID,userId);
		return bound;
	}

	@Override
	public BoundStatement mapBoundStatementRequest(PreparedStatement preparedStatement,CategoryRequestMessageEntity categoryRequestMessageEntity) {
		BoundStatement bound = preparedStatement.bind();
		bound.setUUID(DataBaseColumn.ID,categoryRequestMessageEntity.getId());
		bound.setUUID(DataBaseColumn.USERID,categoryRequestMessageEntity.getParsedUserId());
		bound.setString(DataBaseColumn.CATEGORY_NAME,categoryRequestMessageEntity.getName());
		bound.setUUID(DataBaseColumn.CREATEDBY,categoryRequestMessageEntity.getCreatedBy());
		bound.setTimestamp(DataBaseColumn.CREATEDDATE,categoryRequestMessageEntity.getCreatedDate());		
		bound.setString(DataBaseColumn.STATUS,categoryRequestMessageEntity.getStatus());
		bound.setString(DataBaseColumn.CATEGORY_DESCRIPTION,categoryRequestMessageEntity.getDescription());		
		return bound;
	}

	@Override
	public BoundStatement mapBoundStatement(PreparedStatement preparedStatement,DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		BoundStatement bound = preparedStatement.bind();		
		bound.setUUID(DataBaseColumn.USERID,deleteCategoryRequestMessageEntity.getParsedUserId());
		bound.setUUID(DataBaseColumn.ID,deleteCategoryRequestMessageEntity.getParsedCategoryId());
		bound.setString(DataBaseColumn.STATUS,deleteCategoryRequestMessageEntity.getStatus());
		bound.setUUID(DataBaseColumn.MODIFIEDBY,deleteCategoryRequestMessageEntity.getModifiedBy());
		bound.setTimestamp(DataBaseColumn.MODIFIEDDATE,deleteCategoryRequestMessageEntity.getModifiedDate());		
		return bound;
	}

	@Override
	public BoundStatement mapBoundStatement(PreparedStatement preparedStatement,UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		BoundStatement bound = preparedStatement.bind();		
		bound.setUUID(DataBaseColumn.USERID,updateCategoryMessageEntity.getParsedUserId());
		bound.setUUID(DataBaseColumn.ID,updateCategoryMessageEntity.getParsedCategoryId());
		bound.setString(DataBaseColumn.CATEGORY_DESCRIPTION,updateCategoryMessageEntity.getDescription());
		bound.setString(DataBaseColumn.CATEGORY_NAME,updateCategoryMessageEntity.getName());
		bound.setUUID(DataBaseColumn.MODIFIEDBY,updateCategoryMessageEntity.getModifiedBy());
		bound.setTimestamp(DataBaseColumn.MODIFIEDDATE,updateCategoryMessageEntity.getModifiedDate());		
		return bound;
	}
}
