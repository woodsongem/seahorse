/**
 * 
 */
package seahorse.internal.business.credentialservice;

import seahorse.internal.business.credentialservice.datacontracts.CreateCredentialRequestMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.DeleteCredentialMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.GetCredentialByUserIdMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;

/**
 * @author admin
 *
 */
public class CredentialServicePostProcessor implements ICredentialServicePostProcessor {

	@Override
	public Result postProcessorGetCredentialsByUserId(GetCredentialByUserIdMessageEntity getCredentialByUserIdMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result postProcessorCreateCredentials(CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result postProcessorUpdateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result postProcessorDeleteCredential(DeleteCredentialMessageEntity deleteCredentialMessageEntity) {
		return new Result(ResultStatus.SUCCESS);
	}

}
