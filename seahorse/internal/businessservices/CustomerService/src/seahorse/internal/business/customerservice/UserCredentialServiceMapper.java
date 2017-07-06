/**
 * 
 */
package seahorse.internal.business.customerservice;

import seahorse.internal.business.customerservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.LoginResponseMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public class UserCredentialServiceMapper implements IUserCredentialServiceMapper {

	@Override
	public UserCredentialMessageEntity MapUserCredentialMessageEntity(UserCredentialDAO userCredentialServiceDAO) {
		if(userCredentialServiceDAO == null)
		{
			return null;
		}
		UserCredentialMessageEntity userCredentialMessageEntity = new UserCredentialMessageEntity();
		userCredentialMessageEntity.setId(userCredentialServiceDAO.getId());
		userCredentialMessageEntity.setUsername(userCredentialServiceDAO.getUsername());
		userCredentialMessageEntity.setStatus(userCredentialServiceDAO.getStatus());
		return userCredentialMessageEntity;
	}

	@Override
	public LoginResponseMessageEntity MapLoginResponseMessageEntity(ResultMessageEntity resultMessageEntity,LoginDetailMessageEntity loginDetailMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}
}
