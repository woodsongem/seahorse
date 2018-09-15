/**
 * 
 */
package seahorse.internal.business.categoryservice;

import seahorse.internal.business.categoryservice.datacontracts.CreateCategoryMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;

/**
 * @author admin
 *
 */
public class CategoryServicePostProcessor implements ICategoryServicePostProcessor {

	@Override
	public Result postProcessorCreateCategory(CreateCategoryMessageEntity categoryRequestMessageEntity) {
		// TODO Auto-generated method stub
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result postProcessorDeleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		// TODO Auto-generated method stub
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result postProcessorUpdateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		// TODO Auto-generated method stub
		return new Result(ResultStatus.SUCCESS);
	}
}
