/**
 * 
 */
package seahorse.internal.business.openapi.usercredentialservice;

import com.google.inject.Inject;

import seahorse.internal.business.openapi.katavuccolopenapi.common.KatavuccolOpenApiErrorCode;
import seahorse.internal.business.openapi.katavuccolopenapi.common.KatavuccolServiceOpenApiUtility;
import seahorse.internal.business.openapi.usercredentialservice.datacontracts.CreateProfileApiMsgEntity;
import seahorse.internal.business.openapi.usercredentialservice.external.datacontracts.CreateUserCredentialApi;
import seahorse.internal.business.openapi.usercredentialservice.rest.datacontracts.CreateUserCredentialIPost;
import seahorse.internal.business.shared.katavuccol.common.IKatavuccolClient;
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
			return KatavuccolServiceOpenApiUtility.getOutPutResponse(KatavuccolOpenApiErrorCode.CreateProfileApiMsgEntityIsEmpty, "CreateProfileApiMsgEntity",ResultStatus.ERROR);
		}
		CreateUserCredentialApi createUserCredential = userCredentialServiceMapper.mapCreateUserCredentialApi(createProfileApiMsgEntity);
		CreateUserCredentialIPost createUserCredentialIPost = userCredentialServiceMapper.mapCreateUserCredentialIPost(createUserCredential);
		ResultResponse resultResponse = katavuccolClient.Post(createUserCredentialIPost);
		if (resultResponse.getResultStatus() != ResultStatus.SUCCESS) {
			return KatavuccolServiceOpenApiUtility.getOutPutResponse(KatavuccolOpenApiErrorCode.ErrorMakingProfileServiceExternalCall, "", ResultStatus.ERROR);
		}
		OutPutResponse exOutPutResponse = KatavuccolServiceOpenApiUtility.getGson().fromJson(resultResponse.getResponseText(), OutPutResponse.class);
		return exOutPutResponse;
	}
}
