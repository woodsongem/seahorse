/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import java.util.UUID;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.GetUserCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public class UserCredentialServiceMapper implements IUserCredentialServiceMapper {

	@Override
	public UserCredentialMessageEntity mapUserCredentialMessageEntity(Result result,GetUserCredentialMessageEntity getUserCredentialMessageEntity) {
		if(getUserCredentialMessageEntity ==null)
		{
			return new UserCredentialMessageEntity();
		}
		return	getUserCredentialMessageEntity.getUserCredential();
	}

	@Override
	public GetUserCredentialMessageEntity MapGetUserCredentialMessageEntity(UUID userId) {
		GetUserCredentialMessageEntity getUserCredentialMessageEntity=new GetUserCredentialMessageEntity();
		getUserCredentialMessageEntity.setUserId(userId);
		return getUserCredentialMessageEntity;
	}
}
