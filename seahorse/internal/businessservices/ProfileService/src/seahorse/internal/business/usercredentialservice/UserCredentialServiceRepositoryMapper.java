/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;

import seahorse.internal.business.usercredentialservice.dal.datacontracts.UserCredentialDAO;

/**
 * @author SMJE
 *
 */
public class UserCredentialServiceRepositoryMapper implements IUserCredentialServiceRepositoryMapper {

	@Override
	public BoundStatement mapUserCredentialBoundStatement(PreparedStatement preparedStatement,
			UserCredentialDAO userCredentialDAO) {
		BoundStatement bound = preparedStatement.bind();
		bound.setString(UserCredentialDataBaseColumn.USERNAME, userCredentialDAO.getUsername());
		bound.setString(UserCredentialDataBaseColumn.PASSWORD, userCredentialDAO.getPassword());
		bound.setUUID(UserCredentialDataBaseColumn.PRODUCTITEMID, userCredentialDAO.getProductItemId());
		bound.setString(UserCredentialDataBaseColumn.STATUS, userCredentialDAO.getStatus());
		bound.setUUID(UserCredentialDataBaseColumn.ID, userCredentialDAO.getId());
		bound.setUUID(UserCredentialDataBaseColumn.CREATEDBY, userCredentialDAO.getCreatedBy());
		bound.setTimestamp(UserCredentialDataBaseColumn.CREATEDDATE, userCredentialDAO.getCreatedDate());
		return bound;
	}

	@Override
	public BoundStatement mapGetUserCredentialByUserNameBoundStatement(PreparedStatement preparedStatement,
			UserCredentialDAO userCredentialDAO) {
		BoundStatement bound = preparedStatement.bind();
		bound.setString(UserCredentialDataBaseColumn.USERNAME, userCredentialDAO.getUsername());
		return bound;
	}

	@Override
	public UserCredentialDAO mapUserCredentialDAO(Row userCredentialDAOResult) {
		UserCredentialDAO userCredentialDAO = new UserCredentialDAO();
		userCredentialDAO.setCreatedBy(userCredentialDAOResult.getUUID(UserCredentialDataBaseColumn.CREATEDBY));
		userCredentialDAO.setCreatedDate(userCredentialDAOResult.getTimestamp(UserCredentialDataBaseColumn.CREATEDDATE));
		userCredentialDAO.setId(userCredentialDAOResult.getUUID(UserCredentialDataBaseColumn.ID));
		userCredentialDAO.setModifiedBy(userCredentialDAOResult.getUUID(UserCredentialDataBaseColumn.MODIFIEDBY));
		userCredentialDAO.setModifiedDate(userCredentialDAOResult.getTimestamp(UserCredentialDataBaseColumn.MODIFIEDDATE));
		userCredentialDAO.setStatus(userCredentialDAOResult.getString(UserCredentialDataBaseColumn.STATUS));
		userCredentialDAO.setUsername(userCredentialDAOResult.getString(UserCredentialDataBaseColumn.USERNAME));
		userCredentialDAO.setPassword(userCredentialDAOResult.getString(UserCredentialDataBaseColumn.PASSWORD));
		userCredentialDAO.setProductItemId(userCredentialDAOResult.getUUID(UserCredentialDataBaseColumn.PRODUCTITEMID));
		return userCredentialDAO;
	}

}
