/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import java.util.UUID;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.usercredentialservice.dal.datacontracts.UserCredentialDAO;

/**
 * @author SMJE
 *
 */
public class UserCredentialRepository implements IUserCredentialRepository {

	@Override
	public UserCredentialDAO getUserCredentialByUserId(UUID userId)
	{
		return null;
		
	}
	
	@Override
	public Result createUserCredential(UserCredentialDAO userCredentialDAO)
	{
		return null;
		
	}
	
	@Override
	public Result deleteUserCredential(UUID userId)
	{
		return null;
		
	}
	
	@Override
	public Result updateUserCredential(UserCredentialDAO userCredentialDAO)
	{
		return null;
		
	}
	
}
