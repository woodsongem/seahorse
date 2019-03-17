/**
 * 
 */
package seahorse.internal.business.categoryservice;

import seahorse.internal.business.categoryservice.datacontracts.CreateCategoryMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;

/**
 * @author admin
 *
 */
public interface ICategoryServicePostProcessor {
	
	Result postProcessorCreateCategory(CreateCategoryMessageEntity categoryRequestMessageEntity);

	Result postProcessorDeleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);

	Result postProcessorUpdateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity);

}
