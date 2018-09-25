/**
 * 
 */
package seahorse.internal.business.profileservice;

import java.util.UUID;

import seahorse.internal.business.katavuccolservice.common.datacontracts.OutPutResponse;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.profileservice.api.datacontracts.UserProfileModel;
import seahorse.internal.business.profileservice.dal.datacontracts.UserCredentialDAO;

/**
 * @author admin
 *
 */
public class ProfileServiceRepository implements IProfileServiceRepository {

	@Override
	public OutPutResponse createUserProfile(UserCredentialDAO userCredentialDAO)
	{
		return null;
		
	}
	
	@Override
	public Result deleteUserProfile(UserCredentialDAO userCredentialDAO)
	{
		return null;
		
	}
	
	@Override
	public Result updateUserProfile(UserCredentialDAO userCredentialDAO)
	{
		return null;
		
	}
	
	@Override
	public UserCredentialDAO getUserProfileByUserId(UUID userId)
	{
		return null;
		
	}
	
	@Override
	public UserProfileModel getUserProfileModelByUserId(UUID userId)
	{
		return null;
		
	}
}
