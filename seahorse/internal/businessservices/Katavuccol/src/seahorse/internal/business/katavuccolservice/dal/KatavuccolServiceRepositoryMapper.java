/**
 * 
 */

package seahorse.internal.business.katavuccolservice.dal;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
public class KatavuccolServiceRepositoryMapper implements IKatavuccolServiceRepositoryMapper {

	@Override
	public String getCategoryDetailByIdQuery(UUID categoryId,UUID userId) {
		Object[] args = { categoryId,userId };
		return new MessageFormat(QueryConstants.GET_CATEGORY_DETAIL_BY_ID_QUERY).format(args);
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
	public String getCredentialTypeDetailsByIdQuery(UUID typeId,UUID userId) {
		Object[] args = { typeId,userId };
		return new MessageFormat(QueryConstants.GET_CREDENTIAL_TYPE_DETAILS_BY_ID_QUERY).format(args);
	}

	@Override
	public TypeDAO mapCredentialTypeDAO(Row typeDAOResult) {
		TypeDAO typeDAO =new TypeDAO();
		typeDAO.setCreatedBy(typeDAOResult.getUUID(DataBaseColumn.CREATEDBY));
		typeDAO.setCreatedDate(typeDAOResult.getTimestamp(DataBaseColumn.CREATEDDATE));
		typeDAO.setDescription(typeDAOResult.getString(DataBaseColumn.CREDENTIALTYPE_DESCRIPTION));
		typeDAO.setId(typeDAOResult.getUUID(DataBaseColumn.ID));
		typeDAO.setModifiedBy(typeDAOResult.getUUID(DataBaseColumn.MODIFIEDBY));
		typeDAO.setModifiedDate(typeDAOResult.getTimestamp(DataBaseColumn.MODIFIEDDATE));
		typeDAO.setName(typeDAOResult.getString(DataBaseColumn.CREDENTIALTYPE_NAME));		
		typeDAO.setStatus(typeDAOResult.getString(DataBaseColumn.STATUS));
		typeDAO.setUserId(typeDAOResult.getUUID(DataBaseColumn.USERID));		
		return typeDAO;
	}

	@Override
	public String getCreateCredentialQuery(CredentialRequestMessageEntity credentialRequestMessageEntity) {
		Object[] args = {  
				credentialRequestMessageEntity.getId(),credentialRequestMessageEntity.getCreatedBy(),
				credentialRequestMessageEntity.getCreatedDate(),credentialRequestMessageEntity.getDescription(),
				"ACTIVE",credentialRequestMessageEntity.getParsedUserId()};
		return new MessageFormat(QueryConstants.GET_CREATE_CREDENTIAL_QUERY).format(args);
	}

	@Override
	public String getCategoryDetailByUserIdQuery(UUID userId) {
		Object[] args = { userId };
		return new MessageFormat(QueryConstants.GET_CATEGORY_DETAIL_BY_USERID_QUERY).format(args);
	}

	@Override
	public String getTypeDetailsByUserIdQuery(UUID userId) {
		Object[] args = { userId };
		return new MessageFormat(QueryConstants.GET_CREDENTIAL_TYPE_DETAIL_BY_USERID_QUERY).format(args);
	}	
}
