/**
 * 
 */
package seahorse.internal.business.katavuccolservice.postprocessors;

import seahorse.internal.business.katavuccolservice.api.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialRequestMessageEntity;


/**
 * @author sajanmje
 *
 */
public class KatavuccolServicePostProcessor implements IKatavuccolServicePostProcessor {

	@Override
	public Result PostProcessorCreateCredentials(CredentialRequestMessageEntity credentialsRequestMessageEntity) {
		
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result PostProcessorDeleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
		
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result PostProcessorUpdateCredential(UpdateCredentialRequestMessageEntity updateCredentialMessageEntity) {
		return new Result(ResultStatus.SUCCESS);
	}

}
