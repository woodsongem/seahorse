/**
 * 
 */
package seahorse.internal.business.katavuccolservice.postprocessors;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;


/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServicePostProcessor {

	Result postProcessorCreateCredentials(CredentialRequestMessageEntity credentialRequestMessageEntity);

	Result postProcessorDeleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);

	Result postProcessorUpdateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity);

	Result postProcessorCreateCredentialType(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity);

	Result postProcessorCreateCategory(CategoryRequestMessageEntity categoryRequestMessageEntity);

	Result postProcessorDeleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);

	Result postProcessorUpdateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity);

}
