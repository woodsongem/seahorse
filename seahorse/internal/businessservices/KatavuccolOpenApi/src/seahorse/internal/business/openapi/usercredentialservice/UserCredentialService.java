/**
 * 
 */
package seahorse.internal.business.openapi.usercredentialservice;

import com.google.inject.Inject;

import seahorse.internal.business.openapi.katavuccolopenapi.common.KatavuccolOpenApiErrorCode;
import seahorse.internal.business.openapi.katavuccolopenapi.common.KatavuccolServiceOpenApiUtility;
import seahorse.internal.business.openapi.usercredentialapi.api.datacontracts.UserCredentialApiModel;
import seahorse.internal.business.openapi.usercredentialservice.datacontracts.CreateProfileApiMsgEntity;
import seahorse.internal.business.openapi.usercredentialservice.external.datacontracts.CreateProfileRequestModelApiEx;
import seahorse.internal.business.openapi.usercredentialservice.external.datacontracts.CreateProfileResponseModelApiEx;
import seahorse.internal.business.openapi.usercredentialservice.rest.datacontracts.CreateUserCredentialIPost;
import seahorse.internal.business.openapi.usercredentialservice.rest.datacontracts.GetUserProfileByUserNameIGet;
import seahorse.internal.business.shared.katavuccol.common.IKatavuccolClient;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolServiceUtility;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultResponse;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;

/**
 * @author SMJE
 *
 */
public class UserCredentialService implements IUserCredentialService {

	private final IUserCredentialServiceMapper userCredentialServiceMapper;
	private final IKatavuccolClient katavuccolClient;

	@Inject
	public UserCredentialService(IUserCredentialServiceMapper userCredentialServiceMapper,
			IKatavuccolClient katavuccolClient) {

		this.userCredentialServiceMapper = userCredentialServiceMapper;
		this.katavuccolClient = katavuccolClient;
	}

	@Override
	public OutPutResponse createUserCredential(CreateProfileApiMsgEntity createProfileApiMsgEntity) {
		if (createProfileApiMsgEntity == null) {
			return KatavuccolServiceOpenApiUtility.getOutPutResponse(
					KatavuccolOpenApiErrorCode.CreateProfileApiMsgEntityIsEmpty, "CreateProfileApiMsgEntity",
					ResultStatus.ERROR);
		}
		CreateProfileRequestModelApiEx createProfileRequestModelApi = userCredentialServiceMapper
				.mapCreateUserCredentialApi(createProfileApiMsgEntity);
		CreateUserCredentialIPost createUserCredentialIPost = userCredentialServiceMapper
				.mapCreateUserCredentialIPost(createProfileRequestModelApi);
		ResultResponse resultResponse = katavuccolClient.Post(createUserCredentialIPost);
		if (resultResponse.getResultStatus() != ResultStatus.SUCCESS) {
			return KatavuccolServiceOpenApiUtility.getOutPutResponse(
					KatavuccolOpenApiErrorCode.ErrorMakingProfileServiceExternalCall, "", ResultStatus.ERROR);
		}
		CreateProfileResponseModelApiEx createProfileResponseModelApiEx = KatavuccolServiceOpenApiUtility.getGson()
				.fromJson(resultResponse.getResponseText(), CreateProfileResponseModelApiEx.class);
		return userCredentialServiceMapper.mapOutPutResponse(createProfileResponseModelApiEx);
	}

	@Override
	public UserCredentialApiModel getUserProfileByUserName(String username) {
		if (KatavuccolServiceUtility.isNullOrWhitespace(username)) {
			return null;
		}
		GetUserProfileByUserNameIGet getUserProfileByUserNameIGet = userCredentialServiceMapper
				.mapGetUserProfileByUserNameIGet(username);
		ResultResponse resultResponse = katavuccolClient.Get(getUserProfileByUserNameIGet);
		if (resultResponse.getResultStatus() != ResultStatus.SUCCESS) {
			return null;
		}
		UserCredentialApiModel userCredentialApiModel = KatavuccolServiceOpenApiUtility.getGson()
				.fromJson(resultResponse.getResponseText(), UserCredentialApiModel.class);
		return userCredentialApiModel;
	}
}
