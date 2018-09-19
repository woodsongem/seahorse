/**
 * 
 */
package seahorse.internal.business.katavuccolservice.postprocessors;

import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialRequestMessageEntity;


/**
 * @author sajanmje
 *
 */
public class KatavuccolServicePostProcessor implements IKatavuccolServicePostProcessor {

	@Override
	public Result postProcessorCreateCredentials(CredentialRequestMessageEntity credentialsRequestMessageEntity) {
		
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result postProcessorDeleteCredential(DeleteCredentialMessageEntity deleteCredentialMessageEntity) {
		
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result postProcessorUpdateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result postProcessorCreateCredentialType(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity) {
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result postProcessorCreateCategory(CategoryRequestMessageEntity categoryRequestMessageEntity) {
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result postProcessorDeleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result postProcessorUpdateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		return new Result(ResultStatus.SUCCESS);
	}
}
