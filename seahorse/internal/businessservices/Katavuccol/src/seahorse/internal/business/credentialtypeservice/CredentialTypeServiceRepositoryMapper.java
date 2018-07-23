/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;

import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeModel;
import seahorse.internal.business.katavuccolservice.common.KatavuccolConstant;
import seahorse.internal.business.katavuccolservice.dal.DataBaseColumn;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;

/**
 * @author admin
 *
 */
public class CredentialTypeServiceRepositoryMapper implements ICredentialTypeServiceRepositoryMapper {

	@Override
	public BoundStatement mapCredentialTypeByUserIdBoundStatement(PreparedStatement preparedStatement, UUID userId) {
		BoundStatement bound = preparedStatement.bind();		
		bound.setUUID(DataBaseColumn.USERID,userId);
		return bound;
	}

	@Override
	public CredentialTypeModel mapCredentialTypeModel(Row typeDAOResult) {
		CredentialTypeModel credentialTypeModel = new CredentialTypeModel();		
		credentialTypeModel.setCreatedBy(typeDAOResult.getUUID(DataBaseColumn.CREATEDBY).toString());
		credentialTypeModel.setCreatedDate(typeDAOResult.getTimestamp(DataBaseColumn.CREATEDDATE));
		credentialTypeModel.setDescription(typeDAOResult.getString(DataBaseColumn.CREDENTIALTYPE_DESCRIPTION));
		credentialTypeModel.setId(typeDAOResult.getUUID(DataBaseColumn.ID).toString());
		credentialTypeModel.setModifiedBy(typeDAOResult.getUUID(DataBaseColumn.MODIFIEDBY).toString());
		credentialTypeModel.setModifiedDate(typeDAOResult.getTimestamp(DataBaseColumn.MODIFIEDDATE));
		credentialTypeModel.setName(typeDAOResult.getString(DataBaseColumn.CREDENTIALTYPE_NAME));		
		credentialTypeModel.setStatus(typeDAOResult.getString(DataBaseColumn.STATUS));
		credentialTypeModel.setUserId(typeDAOResult.getUUID(DataBaseColumn.USERID).toString());
		credentialTypeModel.setIsDuplicationAllowed(typeDAOResult.getBool(DataBaseColumn.CREDENTIALTYPE_ISDUPLICATIONALLOWED));
		credentialTypeModel.setIsSubitemAllowed(typeDAOResult.getBool(DataBaseColumn.CREDENTIALTYPE_ISSUBITEMALLOWED));
		credentialTypeModel.setType(typeDAOResult.getString(DataBaseColumn.CREDENTIALTYPE_TYPE));
		return credentialTypeModel;
	}

	@Override
	public CredentialTypeDAO mapCredentialTypeDAO(Row typeDAOResult) {
		CredentialTypeDAO credentialTypeDAO = new CredentialTypeDAO();		
		credentialTypeDAO.setCreatedBy(typeDAOResult.getUUID(DataBaseColumn.CREATEDBY));
		credentialTypeDAO.setCreatedDate(typeDAOResult.getTimestamp(DataBaseColumn.CREATEDDATE));
		credentialTypeDAO.setDescription(typeDAOResult.getString(DataBaseColumn.CREDENTIALTYPE_DESCRIPTION));
		credentialTypeDAO.setId(typeDAOResult.getUUID(DataBaseColumn.ID));
		credentialTypeDAO.setModifiedBy(typeDAOResult.getUUID(DataBaseColumn.MODIFIEDBY));
		credentialTypeDAO.setModifiedDate(typeDAOResult.getTimestamp(DataBaseColumn.MODIFIEDDATE));
		credentialTypeDAO.setName(typeDAOResult.getString(DataBaseColumn.CREDENTIALTYPE_NAME));		
		credentialTypeDAO.setStatus(typeDAOResult.getString(DataBaseColumn.STATUS));
		credentialTypeDAO.setUserId(typeDAOResult.getUUID(DataBaseColumn.USERID));
		credentialTypeDAO.setIsDuplicationAllowed(typeDAOResult.getBool(DataBaseColumn.CREDENTIALTYPE_ISDUPLICATIONALLOWED));
		credentialTypeDAO.setIsSubitemAllowed(typeDAOResult.getBool(DataBaseColumn.CREDENTIALTYPE_ISSUBITEMALLOWED));		
		return credentialTypeDAO;
	}

	@Override
	public BoundStatement mapBoundStatementRequest(PreparedStatement preparedStatement,CredentialTypeDAO credentialTypeDAO) {
		BoundStatement bound = preparedStatement.bind();		
		bound.setUUID(DataBaseColumn.USERID,credentialTypeDAO.getUserId());
		bound.setString(DataBaseColumn.CREDENTIALTYPE_DESCRIPTION,credentialTypeDAO.getDescription());
		bound.setString(DataBaseColumn.CREDENTIALTYPE_NAME,credentialTypeDAO.getName());
		bound.setBool(DataBaseColumn.CREDENTIALTYPE_ISDUPLICATIONALLOWED,credentialTypeDAO.getIsDuplicationAllowed());
		bound.setBool(DataBaseColumn.CREDENTIALTYPE_ISSUBITEMALLOWED,credentialTypeDAO.getIsSubitemAllowed());
		bound.setString(DataBaseColumn.STATUS,credentialTypeDAO.getStatus());
		bound.setUUID(DataBaseColumn.ID,credentialTypeDAO.getId());
		bound.setUUID(DataBaseColumn.CREATEDBY,credentialTypeDAO.getCreatedBy());
		bound.setTimestamp(DataBaseColumn.CREATEDDATE,credentialTypeDAO.getCreatedDate());		
		return bound;
	}

	@Override
	public BoundStatement mapGetDefaultCredentialTypeDAOBoundStatement(PreparedStatement preparedStatement) {
		BoundStatement bound = preparedStatement.bind();		
		bound.setString(DataBaseColumn.CREDENTIALTYPE_TYPE,KatavuccolConstant.DEFAULT);
		return bound;
	}

	@Override
	public BoundStatement mapgetCredentialTypeByUserIdAndIdBoundStatement(PreparedStatement preparedStatement,UUID userId, UUID id) {
		BoundStatement bound = preparedStatement.bind();		
		bound.setUUID(DataBaseColumn.USERID,userId);
		bound.setUUID(DataBaseColumn.ID,id);
		return bound;
	}

}
