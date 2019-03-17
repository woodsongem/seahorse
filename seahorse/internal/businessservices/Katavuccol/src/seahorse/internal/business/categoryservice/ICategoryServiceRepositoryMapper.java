/**
 * 
 */
package seahorse.internal.business.categoryservice;

import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;
import seahorse.internal.business.categoryservice.datacontracts.CreateCategoryMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;

/**
 * @author SMJE
 *
 */
public interface ICategoryServiceRepositoryMapper {
	
	String getCategoryDetailByIdQuery(UUID categoryId,UUID userId);
	CategoryDAO mapCategoryDAO(Row categoryDAOResult);
	String getCategoryDetailByUserIdQuery(UUID userId);
	BoundStatement mapBoundStatement(PreparedStatement preparedStatement, UUID categoryId, UUID userId);
	BoundStatement mapBoundStatementRequest(PreparedStatement preparedStatement,CreateCategoryMessageEntity categoryRequestMessageEntity);
	BoundStatement mapBoundStatement(PreparedStatement preparedStatement,DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);
	BoundStatement mapBoundStatement(PreparedStatement preparedStatement,UpdateCategoryMessageEntity updateCategoryMessageEntity);	
	BoundStatement mapBoundStatement(PreparedStatement preparedStatement, UUID userId);

}
