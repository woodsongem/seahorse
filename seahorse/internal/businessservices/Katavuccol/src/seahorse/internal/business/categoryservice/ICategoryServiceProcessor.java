/**
 * 
 */
package seahorse.internal.business.categoryservice;

import seahorse.internal.business.categoryservice.datacontracts.CreateCategoryMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.*;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;

/**
 * @author admin
 *
 */
public interface ICategoryServiceProcessor {

	Result createCategory(CreateCategoryMessageEntity categoryRequestMessageEntity);

	Result processorDeleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);
	
	Result deleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);

	Result processorGetCategory(GetCategoryMessageEntity getCategoryMessageEntity);
	
	Result getCategory(GetCategoryMessageEntity getCategoryMessageEntity) ;

	Result processorUpdateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity);
	
	Result updateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity);

	Result processorCreateCategory(CreateCategoryMessageEntity categoryRequestMessageEntity);
}
