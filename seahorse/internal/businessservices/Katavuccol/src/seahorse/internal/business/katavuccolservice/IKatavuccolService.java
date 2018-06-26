/**
 * 
 */
package seahorse.internal.business.katavuccolservice;


import java.util.List;

import seahorse.internal.business.katavuccolservice.api.datacontracts.*;
import seahorse.internal.business.katavuccolservice.datacontracts.*;
/**
 * @author sajanmje
 *
 */
public interface IKatavuccolService {

	CredentialResponseMessageEntity createCredential(CredentialRequestMessageEntity credentialRequestMessageEntity);

	List<Credential> getCredentialsByCategoryId(GetCredentialMessageEntity getCredentialMessageEntity);

	UpdateCredentialResponseMessageEntity updateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity);

	DeleteCredentialResponseMessageEntity deleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);

	CategoryResponseMessageEntity createCategory(CategoryRequestMessageEntity categoryMessageEntity);

	DeleteCategoryResponseMessageEntity deleteCategory(
			DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);

	UpdateCategoryResponseMessageEntity updateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity);

	CredentialTypeResponseMessageEntity createCredentialType(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity);

	UpdateCredentialResponseMessageEntity updateCredentialType(
			UpdateCredentialTypeMessageEntity updateCredentialTypeMessageEntity);

	DeleteCredentialResponseMessageEntity deleteCredentialType(
			DeleteCredentialTypeRequestMessageEntity deleteCredentialTypeRequestMessageEntity);

	List<Category> getCategory(GetCategoryMessageEntity getCategoryMessageEntity);

	CredentialValueDetail getCredentialValueByCredentialId(GetCredentialValueMessageEntity getCredentialValueMessageEntity);
	
}
