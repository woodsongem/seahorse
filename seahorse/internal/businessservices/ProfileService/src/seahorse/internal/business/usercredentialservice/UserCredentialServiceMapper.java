/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import seahorse.internal.business.usercredentialservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;

/**
 * @author SMJE
 *
 */
public class UserCredentialServiceMapper implements IUserCredentialServiceMapper {

	@Override
	public UserCredentialDAO mapUserCredentialDAO(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		UserCredentialDAO userCredentialDAO = new UserCredentialDAO();
		userCredentialDAO.setId(createUserCredentialMsgEntity.getId());
		userCredentialDAO.setUsername(createUserCredentialMsgEntity.getUsername());
		userCredentialDAO.setPassword(createUserCredentialMsgEntity.getPassword());
		userCredentialDAO.setProductItemId(createUserCredentialMsgEntity.getParsedProductItemId());
		userCredentialDAO.setCreatedDate(createUserCredentialMsgEntity.getCreatedDate());
		userCredentialDAO.setStatus(createUserCredentialMsgEntity.getStatus());
		return userCredentialDAO;
	}

}
