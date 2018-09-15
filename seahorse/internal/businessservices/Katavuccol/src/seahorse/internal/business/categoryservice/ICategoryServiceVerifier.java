/**
 * 
 */
package seahorse.internal.business.categoryservice;

import seahorse.internal.business.categoryservice.datacontracts.CreateCategoryMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.GetCategoryMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;

/**
 * @author admin
 *
 */
public interface ICategoryServiceVerifier {

	Result verifyCreateCategory(CreateCategoryMessageEntity categoryRequestMessageEntity);
	Result verifyDeleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);
	Result isCategoryIdValid(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);
	Result isUserIdValid(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);
	Result verifyUpdateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity);
	Result isNameValid(UpdateCategoryMessageEntity updateCategoryMessageEntity);
	Result isCategoryIdValid(UpdateCategoryMessageEntity updateCategoryMessageEntity);
	Result isUserIdValid(UpdateCategoryMessageEntity updateCategoryMessageEntity);
	Result verifyGetCategory(GetCategoryMessageEntity getCategoryMessageEntity);
	Result isUserIdValid(GetCategoryMessageEntity getCategoryMessageEntity);
}
