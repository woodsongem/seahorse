/**
 * 
 */
package seahorse.internal.business.customerservice.dal.datacontracts;

import com.datastax.driver.core.Row;

import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;

/**
 * @author sajanmje
 *
 */
public class UserCredentialServiceRepositoryMapper implements IUserCredentialServiceRepositoryMapper {

	@Override
	public String getUserCredentialbyUserNameQuery(LoginDetailMessageEntity loginDetailMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserCredentialServiceDAO mapUserCredentialServiceDAO(Row userCredentialResult) {
		// TODO Auto-generated method stub
		return null;
	}

}
