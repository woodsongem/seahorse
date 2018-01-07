/**
 * 
 */
package seahorse.internal.business.customerservice;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.customerservice.dal.datacontracts.LoginAttemptDAO;
import seahorse.internal.business.customerservice.dal.datacontracts.LoginHistoryDAO;
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
		LoginResponseMessageEntity loginResponseMessageEntity=new LoginResponseMessageEntity();
		loginResponseMessageEntity.SetResultStatus(resultMessageEntity.GetResultStatus());
		loginResponseMessageEntity.SetHttpStatus(Status.OK);		
		return loginResponseMessageEntity;
	}

	@Override
	public LoginAttemptDAO MapLoginAttemptDAO(LoginDetailMessageEntity loginDetailMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginHistoryDAO MapLoginHistoryDAO(LoginDetailMessageEntity loginDetailMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessageEntity MapResultMessageEntity(LoginAttemptDAO loginAttemptDAO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessageEntity MapResultMessageEntity(LoginHistoryDAO loginHistoryDAO) {
		// TODO Auto-generated method stub
		return null;
	}
}
