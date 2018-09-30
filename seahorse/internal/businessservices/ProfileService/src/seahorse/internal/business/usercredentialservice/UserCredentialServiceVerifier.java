/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import com.google.inject.Inject;

import seahorse.internal.business.profileservice.datacontracts.ProfileServiceErrorCode;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolServiceUtility;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.UserCredentialMsgEntity;

/**
 * @author SMJE
 *
 */
public class UserCredentialServiceVerifier implements IUserCredentialServiceVerifier {

	private final IUserCredentialRepository userCredentialRepository;
	private final IUserCredentialServiceMapper userCredentialServiceMapper;
	private final IBaseUserCredentialService baseUserCredentialService;

	@Inject
	public UserCredentialServiceVerifier(IUserCredentialRepository userCredentialRepository,
			IUserCredentialServiceMapper userCredentialServiceMapper,
			IBaseUserCredentialService baseUserCredentialService) {
		this.userCredentialRepository = userCredentialRepository;
		this.userCredentialServiceMapper = userCredentialServiceMapper;
		this.baseUserCredentialService = baseUserCredentialService;
	}

	@Override
	public Result verifyCreateUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		Result result = IsUserNameValid(createUserCredentialMsgEntity);
		if (result.getResultStatus() == ResultStatus.ERROR) {
			return result;
		}
		result = IsProductItemValid(createUserCredentialMsgEntity);
		if (result.getResultStatus() == ResultStatus.ERROR) {
			return result;
		}

		return result;
	}

	@Override
	public Result IsUserNameValid(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		UserCredentialMsgEntity userCredentialMsgEntity = baseUserCredentialService
				.getUserCredentialByUserName(createUserCredentialMsgEntity.getUsername());
		if (userCredentialMsgEntity != null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UserName",
					ProfileServiceErrorCode.UserNameIsNotAvailable);
		}
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result IsProductItemValid(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		return null;
	}

}
