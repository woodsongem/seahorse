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
	
	String getCategoryDetailsByIdQuery(UUID categoryId);

	CategoryDAO mapCategoryDAO(Row categoryDAOResult);

	String getTypeDetailsByIdQuery(UUID typeId);

	TypeDAO mapTypeDAO(Row typeDAOResult);

	String getCreateCredentialQuery(CredentialRequestMessageEntity credentialRequestMessageEntity);	
}
