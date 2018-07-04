/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeMsgEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;

/**
 * @author admin
 *
 */
public class CredentialTypeServicePostProcessor implements ICredentialTypeServicePostProcessor {

	@Override
	public Result postProcessCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {		
		return new Result(ResultStatus.SUCCESS);
	}

}
