/**
 * 
 */

package seahorse.internal.business.katavuccolservice.dal;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.OutPutResponse;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialRequestMessageEntity;
/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceRepository {
	
	CategoryDAO getCategoryDetailById(UUID categoryId,UUID userId);
	
	CredentialTypeDAO getCredentialTypeDetailById(UUID typeId, UUID userId);
	
	List<CategoryDAO> getCategoryDetailByUserId(UUID userId);
	
	List<CredentialTypeDAO>  getCredentialTypeByUserId(UUID userId);
	
	List<CredentialDAO>  getCredentialByUserId(UUID userId);
	
	OutPutResponse createCredential(CredentialRequestMessageEntity credentialRequestMessageEntity);

	CredentialDAO getCredentialById(DeleteCredentialMessageEntity deleteCredentialMessageEntity);

	OutPutResponse deleteCredential(DeleteCredentialMessageEntity deleteCredentialMessageEntity);

	OutPutResponse updateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity);

	CredentialDAO getCredentialById(UUID userId, UUID credentialId);

	OutPutResponse createCategory(CategoryRequestMessageEntity categoryRequestMessageEntity);

	OutPutResponse deleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);

	Result updateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity);	
}
