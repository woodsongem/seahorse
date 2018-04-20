/**
 * 
 */
package seahorse.internal.business.katavuccolservice.processors;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceProcessor {

	Result processorCreateCredentials(CredentialRequestMessageEntity credentialRequestMessageEntity);

	Result processorDeleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);

	Result processorUpdateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity);
	
	Result updateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity);

	Result processorCreateCredentialType(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity);

	Result processorCreateCategory(CategoryRequestMessageEntity categoryRequestMessageEntity);
	
	Result createCategory(CategoryRequestMessageEntity categoryRequestMessageEntity);

	Result processorDeleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);
	
	Result deleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);

	Result processorGetCategory(GetCategoryMessageEntity getCategoryMessageEntity);
	
	Result getCategory(GetCategoryMessageEntity getCategoryMessageEntity) ;

}
