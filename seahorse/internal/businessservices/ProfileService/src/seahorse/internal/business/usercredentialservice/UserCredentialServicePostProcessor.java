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
public class UserCredentialServicePostProcessor implements IUserCredentialServicePostProcessor {

	@Override
	public Result postProcessCreateUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		return new Result(ResultStatus.SUCCESS);
	}

}
