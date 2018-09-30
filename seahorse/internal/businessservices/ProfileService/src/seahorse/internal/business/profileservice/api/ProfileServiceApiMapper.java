/**
 * 
 */
package seahorse.internal.business.profileservice.api;

import seahorse.internal.business.profileservice.api.datacontracts.CreateProfileRequestModel;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.GetUserCredentialByUserIdMsgEntity;

/**
 * @author SMJE
 *
 */
public class ProfileServiceApiMapper implements IProfileServiceApiMapper {

	@Override
	public CreateUserCredentialMsgEntity MapCreateUserCredentialMsgEntity(CreateProfileRequestModel createProfileRequestModel) {
		
		if (createProfileRequestModel == null) {
			return null;
		}
		CreateUserCredentialMsgEntity createUserCredentialMsgEntity = new CreateUserCredentialMsgEntity();
		createUserCredentialMsgEntity.setUsername(createProfileRequestModel.getUserName());
		createUserCredentialMsgEntity.setPassword(createProfileRequestModel.getPassword());
		createUserCredentialMsgEntity.setEmailAddress(createProfileRequestModel.getEmailAddress());
		createUserCredentialMsgEntity.setPhoneNumber(createProfileRequestModel.getPhoneNumber());
		createUserCredentialMsgEntity.setProductItemId(createProfileRequestModel.getProductItemId());
		return createUserCredentialMsgEntity;
	}

	@Override
	public GetUserCredentialByUserIdMsgEntity MapGetUserCredentialByUserIdMsgEntity(String userid) {
		GetUserCredentialByUserIdMsgEntity getUserCredentialByUserIdMsgEntity=new GetUserCredentialByUserIdMsgEntity();
		getUserCredentialByUserIdMsgEntity.setUserId(userid);
		return getUserCredentialByUserIdMsgEntity;
	}

}
