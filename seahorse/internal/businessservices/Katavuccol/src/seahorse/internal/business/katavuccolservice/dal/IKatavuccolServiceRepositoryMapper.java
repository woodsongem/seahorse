/**
 * 
 */

package seahorse.internal.business.katavuccolservice.dal;

import java.util.List;
import java.util.UUID;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;

import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.TypeDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceRepositoryMapper {
	
	String getCategoryDetailByIdQuery(UUID categoryId,UUID userId);

	CategoryDAO mapCategoryDAO(Row categoryDAOResult);

	String getCredentialTypeDetailsByIdQuery(UUID typeId,UUID userId);

	TypeDAO mapCredentialTypeDAO(Row typeDAOResult);

	String getCreateCredentialQuery(CredentialRequestMessageEntity credentialRequestMessageEntity);

	String getCategoryDetailByUserIdQuery(UUID userId);

	String getTypeDetailsByUserIdQuery(UUID userId);	
}
