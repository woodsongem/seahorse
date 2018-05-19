/**
 * 
 */
package seahorse.internal.business.katavuccolservice.verifiers;

import seahorse.internal.business.katavuccolservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.GetUserCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public class UserCredentialVerifierMapper implements IUserCredentialVerifierMapper {

	@Override
	public UserCredentialMessageEntity mapUserCredentialMessageEntity(GetUserCredentialMessageEntity getUserCredentialMessageEntity) {
		UserCredentialMessageEntity userCredentialMessageEntity=new UserCredentialMessageEntity();
		userCredentialMessageEntity.setUserId(getUserCredentialMessageEntity.getUserId());
		return userCredentialMessageEntity;
	}

	@Override
	public UserCredentialMessageEntity mapUserCredentialMessageEntity(UserCredentialDAO userCredentialDAO) {
		UserCredentialMessageEntity userCredentialMessageEntity=new UserCredentialMessageEntity();
		userCredentialMessageEntity.setEncryptedPassword(userCredentialDAO.getEncryptedPassword());
		userCredentialMessageEntity.setLoginAttempts(userCredentialDAO.getLoginAttempts());
		userCredentialMessageEntity.setUserId(userCredentialDAO.getId());
		userCredentialMessageEntity.setStatus(userCredentialDAO.getStatus());
		userCredentialMessageEntity.setUserName(userCredentialDAO.getUsername());
		return userCredentialMessageEntity;
	}
}
