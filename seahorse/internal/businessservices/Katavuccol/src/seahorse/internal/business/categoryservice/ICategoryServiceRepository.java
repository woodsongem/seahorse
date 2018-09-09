/**
 * 
 */
package seahorse.internal.business.categoryservice;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.categoryservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.OutPutResponse;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;


/**
 * @author SMJE
 *
 */
public interface ICategoryServiceRepository {

	List<CategoryDAO> getCategoryDetailByUserId(UUID userId);
	OutPutResponse createCategory(CategoryRequestMessageEntity categoryRequestMessageEntity);
	OutPutResponse deleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);
	Result updateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity);	
	CategoryDAO getCategoryDetailById(UUID categoryId,UUID userId);
	
}
