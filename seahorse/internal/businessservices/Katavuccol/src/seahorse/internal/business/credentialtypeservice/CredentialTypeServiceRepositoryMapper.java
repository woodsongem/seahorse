/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;

import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeModel;
import seahorse.internal.business.katavuccolservice.dal.DataBaseColumn;

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
		return credentialTypeModel;
	}

}
