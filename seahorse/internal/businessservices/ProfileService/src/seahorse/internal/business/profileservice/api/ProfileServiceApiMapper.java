/**
 * 
 */
package seahorse.internal.business.profileservice.api;

import seahorse.internal.business.profileservice.api.datacontracts.CreateProfileRequestModel;
import seahorse.internal.business.profileservice.datacontracts.CreateUserProfileMsgEntity;

/**
 * @author SMJE
 *
 */
public class ProfileServiceApiMapper implements IProfileServiceApiMapper {

	@Override
	public CreateUserProfileMsgEntity MapCreateUserProfileMsgEntity(CreateProfileRequestModel createProfileRequestModel) {
		CreateUserProfileMsgEntity createUserProfileMsgEntity = new CreateUserProfileMsgEntity();
		if(createProfileRequestModel==null)
		{
			return createUserProfileMsgEntity;
		}
		createUserProfileMsgEntity.setUserName(createProfileRequestModel.getUserName());
		createUserProfileMsgEntity.setPassword(createProfileRequestModel.getPassword());
		createUserProfileMsgEntity.setEmailAddress(createProfileRequestModel.getEmailAddress());
		createUserProfileMsgEntity.setPhoneNumber(createProfileRequestModel.getPhoneNumber());
		createUserProfileMsgEntity.setProductItemId(createProfileRequestModel.getProductItemId());
		return createUserProfileMsgEntity;
	}

}
