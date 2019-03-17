/**
 * 
 */
package seahorse.internal.business.categoryservice;

import seahorse.internal.business.categoryservice.datacontracts.*;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;

/**
 * @author admin
 *
 */
public interface ICategoryServiceValidator {

	Result validateCreateCategory(CreateCategoryMessageEntity categoryRequestMessageEntity);
	Result validateDeleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);
	Result isDeleteCategoryRequestMessageEntityValid(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);
	Result isUserIdValid(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);
	Result validateUpdateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity);
	Result isUserIdValid(UpdateCategoryMessageEntity updateCategoryMessageEntity);
	Result isUpdateCategoryMessageEntityValid(UpdateCategoryMessageEntity updateCategoryMessageEntity);
	Result isCategoryIdValid(UpdateCategoryMessageEntity updateCategoryMessageEntity);
	Result validateGetCategory(GetCategoryMessageEntity getCategoryMessageEntity);
	Result isGetCategoryMessageEntityValid(GetCategoryMessageEntity getCategoryMessageEntity);
	Result isUserIdValid(GetCategoryMessageEntity getCategoryMessageEntity);
}
