/**
 * 
 */
package seahorse.internal.business.categoryservice;

import seahorse.internal.business.categoryservice.datacontracts.*;
import java.util.List;
import seahorse.internal.business.categoryservice.api.datacontracts.CategoryModel;


/**
 * @author admin
 *
 */
public interface ICategoryService {
	
	CategoryResponseMessageEntity createCategory(CategoryRequestMessageEntity categoryRequestMessageEntity);
	
	DeleteCategoryResponseMessageEntity deleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);
	
	UpdateCategoryResponseMessageEntity updateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity);
	
	List<CategoryModel> getCategory(GetCategoryMessageEntity getCategoryMessageEntity);

}
