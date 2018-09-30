/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;

/**
 * @author SMJE
 *
 */
public class UserCredentialServiceProcessor implements IUserCredentialServiceProcessor {

	private final IBaseUserCredentialService baseUserCredentialService;

	public UserCredentialServiceProcessor(IBaseUserCredentialService baseUserCredentialService) {
		this.baseUserCredentialService = baseUserCredentialService;
	}

	@Override
	public Result processCreateUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		Result result = CreateUserCredential(createUserCredentialMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		return result;
	}

	@Override
	public Result CreateUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		return baseUserCredentialService.createUserCredential(createUserCredentialMsgEntity);

	}

}
