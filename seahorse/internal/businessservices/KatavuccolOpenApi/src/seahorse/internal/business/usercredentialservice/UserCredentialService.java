/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import com.google.inject.Inject;

import seahorse.internal.business.shared.katavuccol.common.IKatavuccolClient;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultResponse;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateProfileApiMsgEntity;
import seahorse.internal.business.usercredentialservice.external.datacontracts.CreateUserCredentialApi;
import seahorse.internal.business.usercredentialservice.rest.datacontracts.CreateUserCredentialIPost;

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
		CreateUserCredentialApi createUserCredential = userCredentialServiceMapper.mapCreateUserCredentialApi(createProfileApiMsgEntity);
		CreateUserCredentialIPost createUserCredentialIPost = userCredentialServiceMapper.mapCreateUserCredentialIPost(createUserCredential);
		ResultResponse resultResponse = katavuccolClient.Post(createUserCredentialIPost);
		if (resultResponse.getResultStatus() != ResultStatus.SUCCESS) {

		}
		return null;
	}
}
