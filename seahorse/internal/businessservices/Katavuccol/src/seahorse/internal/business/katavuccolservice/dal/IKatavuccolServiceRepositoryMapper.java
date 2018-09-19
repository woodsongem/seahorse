/**
 * 
 */

package seahorse.internal.business.katavuccolservice.dal;

import java.util.UUID;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;

import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialRequestMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceRepositoryMapper {
	
	String getCategoryDetailByIdQuery(UUID categoryId,UUID userId);

	CategoryDAO mapCategoryDAO(Row categoryDAOResult);

	String getCredentialTypeDetailsByIdQuery(UUID typeId,UUID userId);

	CredentialTypeDAO mapCredentialTypeDAO(Row typeDAOResult);

	String getCreateCredentialQuery(CredentialRequestMessageEntity credentialRequestMessageEntity);

	String getCategoryDetailByUserIdQuery(UUID userId);

	String getTypeDetailsByUserIdQuery(UUID userId);

	BoundStatement mapBoundStatement(PreparedStatement preparedStatement,CredentialRequestMessageEntity credentialRequestMessageEntity);

	BoundStatement mapBoundStatement(PreparedStatement preparedStatement, UUID categoryId, UUID userId);

	BoundStatement mapCredentialTypeBoundStatement(PreparedStatement preparedStatement, UUID typeId, UUID userId);

	BoundStatement mapBoundStatement(PreparedStatement preparedStatement, UUID userId);

	BoundStatement mapCredentialTypeBoundStatement(PreparedStatement preparedStatement, UUID userId);

	CredentialDAO mapCredentialDAO(Row typeDAOResult);

	BoundStatement mapCredentialBoundStatement(PreparedStatement preparedStatement, UUID userId);

	BoundStatement mapGetCredentialByIdBoundStatement(PreparedStatement preparedStatement,DeleteCredentialMessageEntity deleteCredentialMessageEntity);

	BoundStatement mapBoundStatement(PreparedStatement preparedStatement,DeleteCredentialMessageEntity deleteCredentialMessageEntity);

	BoundStatement mapBoundStatement(PreparedStatement preparedStatement,UpdateCredentialMessageEntity updateCredentialMessageEntity);

	BoundStatement mapGetCredentialByIdBoundStatement(PreparedStatement preparedStatement, UUID userId,UUID credentialId);

	BoundStatement mapGetCredentialTypeByUserIdBoundStatement(PreparedStatement preparedStatement, UUID parsedUserId);

	BoundStatement mapBoundStatementRequest(PreparedStatement preparedStatement,CategoryRequestMessageEntity categoryRequestMessageEntity);

	BoundStatement mapBoundStatement(PreparedStatement preparedStatement,DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);

	BoundStatement mapBoundStatement(PreparedStatement preparedStatement,UpdateCategoryMessageEntity updateCategoryMessageEntity);	
}
