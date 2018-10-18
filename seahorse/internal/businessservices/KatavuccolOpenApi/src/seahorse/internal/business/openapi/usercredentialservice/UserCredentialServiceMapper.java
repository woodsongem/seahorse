/**
 * 
 */
package seahorse.internal.business.openapi.usercredentialservice;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import seahorse.internal.business.openapi.katavuccolopenapi.common.datacontracts.ExternalEndPoint;
import seahorse.internal.business.openapi.usercredentialservice.datacontracts.CreateProfileApiMsgEntity;
import seahorse.internal.business.openapi.usercredentialservice.external.datacontracts.CreateProfileRequestModelApiEx;
import seahorse.internal.business.openapi.usercredentialservice.external.datacontracts.CreateProfileResponseModelApiEx;
import seahorse.internal.business.openapi.usercredentialservice.rest.datacontracts.CreateUserCredentialIPost;
import seahorse.internal.business.openapi.usercredentialservice.rest.datacontracts.GetUserProfileByUserNameIGet;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolServiceUtility;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultMessage;

/**
 * @author SMJE
 *
 */
public class UserCredentialServiceMapper implements IUserCredentialServiceMapper {

	@Override
	public CreateProfileRequestModelApiEx mapCreateUserCredentialApi(
			CreateProfileApiMsgEntity createProfileApiMsgEntity) {
		CreateProfileRequestModelApiEx createProfileRequestModelApiEx = new CreateProfileRequestModelApiEx();
		createProfileRequestModelApiEx.setEmailAddress(createProfileApiMsgEntity.getEmailAddress());
		createProfileRequestModelApiEx.setPassword(createProfileApiMsgEntity.getPassword());
		createProfileRequestModelApiEx.setPhoneNumber(createProfileApiMsgEntity.getPhoneNumber());
		createProfileRequestModelApiEx.setProductItemId(createProfileApiMsgEntity.getProductItemId());
		createProfileRequestModelApiEx.setUserName(createProfileApiMsgEntity.getUserName());
		return createProfileRequestModelApiEx;
	}

	@Override
	public CreateUserCredentialIPost mapCreateUserCredentialIPost(
			CreateProfileRequestModelApiEx createProfileRequestModelApi) {
		CreateUserCredentialIPost createUserCredentialIPost = new CreateUserCredentialIPost();
		createUserCredentialIPost.setEndPoint(ExternalEndPoint.ProfileService.toString());
		createUserCredentialIPost.setRequest(createProfileRequestModelApi);
		return createUserCredentialIPost;
	}

	@Override
	public OutPutResponse mapOutPutResponse(CreateProfileResponseModelApiEx createProfileResponseModelApiEx) {
		if (createProfileResponseModelApiEx == null) {
			return null;
		}
		OutPutResponse outPutResponse = new OutPutResponse();
		if (KatavuccolServiceUtility.isValidUUID(createProfileResponseModelApiEx.getId())) {
			outPutResponse.setId(UUID.fromString(createProfileResponseModelApiEx.getId()));
		}
		if (createProfileResponseModelApiEx.getErrorCode() == null) {
			return outPutResponse;
		}
		List<ResultMessage> resultMessages = new ArrayList<ResultMessage>();
		for (String errorcode : createProfileResponseModelApiEx.getErrorCode()) {
			ResultMessage ResultMessage = new ResultMessage();
			ResultMessage.setErrorCode(errorcode);
			resultMessages.add(ResultMessage);
		}
		outPutResponse.setResultMessages(resultMessages);
		return outPutResponse;
	}

	@Override
	public GetUserProfileByUserNameIGet mapGetUserProfileByUserNameIGet(String username) {
		GetUserProfileByUserNameIGet getUserProfileByUserNameIGet = new GetUserProfileByUserNameIGet();
		getUserProfileByUserNameIGet.setEndPoint(ExternalEndPoint.ProfileService.toString());
		getUserProfileByUserNameIGet.setUserName(username);
		return getUserProfileByUserNameIGet;
	}

}
