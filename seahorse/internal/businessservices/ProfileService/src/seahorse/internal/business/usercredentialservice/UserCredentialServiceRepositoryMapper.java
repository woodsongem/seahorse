/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;

import seahorse.internal.business.usercredentialservice.dal.datacontracts.UserCredentialDAO;

/**
 * @author SMJE
 *
 */
public class UserCredentialServiceRepositoryMapper implements IUserCredentialServiceRepositoryMapper {

	@Override
	public BoundStatement mapUserCredentialBoundStatement(PreparedStatement preparedStatement,UserCredentialDAO userCredentialDAO) {
		BoundStatement bound = preparedStatement.bind();		
		bound.setString(UserCredentialDataBaseColumn.USERNAME,userCredentialDAO.getUsername());
		bound.setString(UserCredentialDataBaseColumn.PASSWORD,userCredentialDAO.getPassword());
		bound.setUUID(UserCredentialDataBaseColumn.PRODUCTITEMID,userCredentialDAO.getProductItemId());
		bound.setString(UserCredentialDataBaseColumn.STATUS,userCredentialDAO.getStatus());
		bound.setUUID(UserCredentialDataBaseColumn.ID,userCredentialDAO.getId());
		bound.setUUID(UserCredentialDataBaseColumn.CREATEDBY,userCredentialDAO.getCreatedBy());
		bound.setTimestamp(UserCredentialDataBaseColumn.CREATEDDATE,userCredentialDAO.getCreatedDate());		
		return bound;
	}

}
