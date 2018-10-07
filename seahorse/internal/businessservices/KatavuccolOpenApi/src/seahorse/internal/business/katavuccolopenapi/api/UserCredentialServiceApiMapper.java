/**
 * 
 */
package seahorse.internal.business.katavuccolopenapi.api;

import javax.servlet.http.HttpServletRequest;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;
import seahorse.internal.business.usercredentialapi.api.datacontracts.CreateProfileApiModel;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateProfileApiMsgEntity;

/**
 * @author SMJE
 *
 */
public class UserCredentialServiceApiMapper implements IUserCredentialServiceApiMapper {

	@Override
	public CreateProfileApiMsgEntity MapCreateProfileApiMsgEntity(CreateProfileApiModel createProfileApiModel) {
		if (createProfileApiModel == null) {
			return null;
		}
		CreateProfileApiMsgEntity createProfileApiMsgEntity = new CreateProfileApiMsgEntity();
		createProfileApiMsgEntity.setEmailAddress(createProfileApiModel.getEmailAddress());
		createProfileApiMsgEntity.setPassword(createProfileApiModel.getPassword());
		createProfileApiMsgEntity.setPhoneNumber(createProfileApiModel.getPhoneNumber());
		createProfileApiMsgEntity.setProductItemId(createProfileApiModel.getProductItemId());
		createProfileApiMsgEntity.setUserName(createProfileApiModel.getUserName());
		return createProfileApiMsgEntity;
	}

	@Override
	public OutPutResponse MapOutPutResponse(OutPutResponse outPutResponse,
			CreateProfileApiMsgEntity createProfileApiMsgEntity, HttpServletRequest httpRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
