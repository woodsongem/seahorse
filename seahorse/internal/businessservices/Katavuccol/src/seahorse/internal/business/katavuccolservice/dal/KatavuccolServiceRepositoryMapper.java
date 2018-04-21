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

import seahorse.internal.business.katavuccolservice.common.KatavuccolConstant;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;

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
		return new MessageFormat(QueryConstants.GET_CATEGORY_TYPE_DETAILS_BY_ID_QUERY).format(args);
	}

	@Override
	public CredentialTypeDAO mapCredentialTypeDAO(Row typeDAOResult) {
		CredentialTypeDAO typeDAO =new CredentialTypeDAO();
		typeDAO.setCreatedBy(typeDAOResult.getUUID(DataBaseColumn.CREATEDBY));
		typeDAO.setCreatedDate(typeDAOResult.getTimestamp(DataBaseColumn.CREATEDDATE));
		typeDAO.setDescription(typeDAOResult.getString(DataBaseColumn.CREDENTIALTYPE_DESCRIPTION));
		typeDAO.setId(typeDAOResult.getUUID(DataBaseColumn.ID));
		typeDAO.setModifiedBy(typeDAOResult.getUUID(DataBaseColumn.MODIFIEDBY));
		typeDAO.setModifiedDate(typeDAOResult.getTimestamp(DataBaseColumn.MODIFIEDDATE));
		typeDAO.setName(typeDAOResult.getString(DataBaseColumn.CREDENTIALTYPE_NAME));		
		typeDAO.setStatus(typeDAOResult.getString(DataBaseColumn.STATUS));
		typeDAO.setUserId(typeDAOResult.getUUID(DataBaseColumn.USERID));
		typeDAO.setIsDuplicationAllowed(typeDAOResult.getBool(DataBaseColumn.CREDENTIALTYPE_ISDUPLICATIONALLOWED));
		typeDAO.setIsSubitemAllowed(typeDAOResult.getBool(DataBaseColumn.CREDENTIALTYPE_ISSUBITEMALLOWED));	
		return typeDAO;
	}

	@Override
	public String getCreateCredentialQuery(CredentialRequestMessageEntity credentialRequestMessageEntity) {
		Object[] args = {  
				credentialRequestMessageEntity.getParsedUserId(),credentialRequestMessageEntity.getParsedCategoryId(),
				credentialRequestMessageEntity.getCreatedBy(),credentialRequestMessageEntity.getCreatedDate(),
				credentialRequestMessageEntity.getDescription(),KatavuccolConstant.ACTIVESTATUS,
				credentialRequestMessageEntity.getParsedCredentialTypeId()};
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
		return new MessageFormat(QueryConstants.GET_CREDENTIALTYPE_DETAIL_BY_USERID_QUERY).format(args);
	}

	@Override
	public BoundStatement mapBoundStatement(PreparedStatement preparedStatement,CredentialRequestMessageEntity credentialRequestMessageEntity) {
		BoundStatement bound = preparedStatement.bind();
		bound.setUUID(DataBaseColumn.ID, credentialRequestMessageEntity.getId());
		bound.setUUID(DataBaseColumn.USERID,credentialRequestMessageEntity.getParsedUserId());
		bound.setUUID(DataBaseColumn.CREATEDBY,credentialRequestMessageEntity.getCreatedBy());		
		bound.setTimestamp(DataBaseColumn.CREATEDDATE,credentialRequestMessageEntity.getCreatedDate());
		bound.setString(DataBaseColumn.STATUS,credentialRequestMessageEntity.getStatus());		
		bound.setString(DataBaseColumn.CREDENTIAL_DESCRIPTION,credentialRequestMessageEntity.getDescription());
		bound.setUUID(DataBaseColumn.CREDENTIAL_CATEGORYID,credentialRequestMessageEntity.getParsedCategoryId());
		bound.setUUID(DataBaseColumn.CREDENTIAL_CREDENTIAL_TYPEID,credentialRequestMessageEntity.getParsedCredentialTypeId());
		return bound;
	}

	@Override
	public BoundStatement mapBoundStatement(PreparedStatement preparedStatement, UUID categoryId, UUID userId) {
		BoundStatement bound = preparedStatement.bind();
		bound.setUUID(DataBaseColumn.ID, categoryId);
		bound.setUUID(DataBaseColumn.USERID,userId);
		return bound;
	}

	@Override
	public BoundStatement mapCredentialTypeBoundStatement(PreparedStatement preparedStatement, UUID typeId,UUID userId) {
		BoundStatement bound = preparedStatement.bind();
		bound.setUUID(DataBaseColumn.ID, typeId);
		bound.setUUID(DataBaseColumn.USERID,userId);
		return bound;
	}

	@Override
	public BoundStatement mapBoundStatement(PreparedStatement preparedStatement, UUID userId) {
		BoundStatement bound = preparedStatement.bind();		
		bound.setUUID(DataBaseColumn.USERID,userId);
		return bound;
	}

	@Override
	public BoundStatement mapCredentialTypeBoundStatement(PreparedStatement preparedStatement, UUID userId) {
		BoundStatement bound = preparedStatement.bind();		
		bound.setUUID(DataBaseColumn.USERID,userId);
		return bound;
	}

	@Override
	public CredentialDAO mapCredentialDAO(Row typeDAOResult) {
		CredentialDAO credentialDAO=new CredentialDAO();
		credentialDAO.setCreatedBy(typeDAOResult.getUUID(DataBaseColumn.CREATEDBY));
		credentialDAO.setCreatedDate(typeDAOResult.getTimestamp(DataBaseColumn.CREATEDDATE));
		credentialDAO.setDescription(typeDAOResult.getString(DataBaseColumn.CREDENTIAL_DESCRIPTION));
		credentialDAO.setId(typeDAOResult.getUUID(DataBaseColumn.ID));
		credentialDAO.setModifiedBy(typeDAOResult.getUUID(DataBaseColumn.MODIFIEDBY));
		credentialDAO.setModifiedDate(typeDAOResult.getTimestamp(DataBaseColumn.MODIFIEDDATE));		
		credentialDAO.setStatus(typeDAOResult.getString(DataBaseColumn.STATUS));
		credentialDAO.setUserId(typeDAOResult.getUUID(DataBaseColumn.USERID));
		credentialDAO.setCategoryId(typeDAOResult.getUUID(DataBaseColumn.CREDENTIAL_CATEGORYID));
		credentialDAO.setCredentialTypeId(typeDAOResult.getUUID(DataBaseColumn.CREDENTIAL_CREDENTIAL_TYPEID));
		credentialDAO.setParentId(typeDAOResult.getUUID(DataBaseColumn.CREDENTIAL_PARENTID));
		return credentialDAO;
	}

	@Override
	public BoundStatement mapCredentialBoundStatement(PreparedStatement preparedStatement, UUID userId) {
		BoundStatement bound = preparedStatement.bind();		
		bound.setUUID(DataBaseColumn.USERID,userId);
		return bound;
	}

	@Override
	public BoundStatement mapGetCredentialByIdBoundStatement(PreparedStatement preparedStatement,
			DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
		BoundStatement bound = preparedStatement.bind();		
		bound.setUUID(DataBaseColumn.USERID,deleteCredentialMessageEntity.getParsedUserId());
		bound.setUUID(DataBaseColumn.ID,deleteCredentialMessageEntity.getParsedCredentialId());
		return bound;
	}

	@Override
	public BoundStatement mapBoundStatement(PreparedStatement preparedStatement,
			DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
		BoundStatement bound = preparedStatement.bind();		
		bound.setUUID(DataBaseColumn.USERID,deleteCredentialMessageEntity.getParsedUserId());
		bound.setUUID(DataBaseColumn.ID,deleteCredentialMessageEntity.getParsedCredentialId());
		bound.setString(DataBaseColumn.STATUS,deleteCredentialMessageEntity.getStatus());
		bound.setUUID(DataBaseColumn.MODIFIEDBY,deleteCredentialMessageEntity.getModifiedBy());
		bound.setTimestamp(DataBaseColumn.MODIFIEDDATE,deleteCredentialMessageEntity.getModifiedDate());		
		return bound;
	}

	@Override
	public BoundStatement mapBoundStatement(PreparedStatement preparedStatement,UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		BoundStatement bound = preparedStatement.bind();
		bound.setUUID(DataBaseColumn.ID, updateCredentialMessageEntity.getParsedCategoryId());
		bound.setUUID(DataBaseColumn.USERID,updateCredentialMessageEntity.getParsedUserId());
		bound.setUUID(DataBaseColumn.MODIFIEDBY,updateCredentialMessageEntity.getModifiedBy());		
		bound.setTimestamp(DataBaseColumn.MODIFIEDDATE,updateCredentialMessageEntity.getModifiedDate());			
		bound.setString(DataBaseColumn.CREDENTIAL_DESCRIPTION,updateCredentialMessageEntity.getDescription());
		bound.setUUID(DataBaseColumn.CREDENTIAL_CATEGORYID,updateCredentialMessageEntity.getParsedCategoryId());
		bound.setUUID(DataBaseColumn.CREDENTIAL_CREDENTIAL_TYPEID,updateCredentialMessageEntity.getParsedCredentialTypeId());
		bound.setString(DataBaseColumn.CREDENTIAL_DESCRIPTION,updateCredentialMessageEntity.getDescription());
		return bound;
	}

	@Override
	public BoundStatement mapGetCredentialByIdBoundStatement(PreparedStatement preparedStatement, UUID userId,UUID credentialId) {
		BoundStatement bound = preparedStatement.bind();		
		bound.setUUID(DataBaseColumn.USERID,userId);
		bound.setUUID(DataBaseColumn.ID,credentialId);
		return bound;
	}

	@Override
	public BoundStatement mapGetCredentialTypeByUserIdBoundStatement(PreparedStatement preparedStatement,UUID parsedUserId) {
		// TODO Auto-generated method stub
		return null;
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
	public BoundStatement mapBoundStatement(PreparedStatement preparedStatement,
			UpdateCategoryMessageEntity updateCategoryMessageEntity) {
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
