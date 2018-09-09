/**
 * 
 */
package seahorse.internal.business.categoryservice;

import java.util.List;

import com.datastax.driver.core.utils.UUIDs;
import com.google.inject.Inject;

import seahorse.internal.business.categoryservice.datacontracts.*;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.OutPutResponse;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;

/**
 * @author admin
 *
 */
public class CategoryServiceProcessor implements ICategoryServiceProcessor {

	private final IKatavuccolServiceErrorCode katavuccolServiceErrorCode;
	private final ICategoryServiceRepository categoryServiceRepository;
	//private final ICategoryServiceProcessorMapper categoryServiceProcessorMapper;
	
	@Inject
	public CategoryServiceProcessor(IKatavuccolServiceErrorCode katavuccolServiceErrorCode, 
			ICategoryServiceRepository categoryServiceRepository
			)
	{
		this.katavuccolServiceErrorCode = katavuccolServiceErrorCode;
		this.categoryServiceRepository = categoryServiceRepository;
		//this.katavuccolServiceProcessorMapper=katavuccolServiceProcessorMapper;
	}

	@Override
	public Result processorCreateCategory(CategoryRequestMessageEntity categoryRequestMessageEntity) {
		Result result;
		result=createCategory(categoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}

	@Override
	public Result createCategory(CategoryRequestMessageEntity categoryRequestMessageEntity) {
		categoryRequestMessageEntity.setId(UUIDs.timeBased());
		OutPutResponse outPutResponse=categoryServiceRepository.createCategory(categoryRequestMessageEntity);
		if(outPutResponse.getResultStatus() != ResultStatus.SUCCESS)
		{
			return new Result(ResultStatus.ERROR);
		}
		
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result processorDeleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		Result result;
		result=deleteCategory(deleteCategoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}

	@Override
	public Result deleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		OutPutResponse outPutResponse=categoryServiceRepository.deleteCategory(deleteCategoryRequestMessageEntity);
		if(outPutResponse.getResultStatus() != ResultStatus.SUCCESS)
		{
			return new Result(ResultStatus.ERROR);
		}
		
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result processorGetCategory(GetCategoryMessageEntity getCategoryMessageEntity) {
		Result result;
		result=getCategory(getCategoryMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}

	@Override
	public Result getCategory(GetCategoryMessageEntity getCategoryMessageEntity) {
		List<CategoryDAO> categoryDAO=categoryServiceRepository.getCategoryDetailByUserId(getCategoryMessageEntity.getParsedUserId());
		if(categoryDAO==null || categoryDAO.isEmpty())
		{
			return new Result(ResultStatus.ERROR);
		}
		getCategoryMessageEntity.setCategory(categoryDAO);
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}

	@Override
	public Result processorUpdateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		Result result;
		result=updateCategory(updateCategoryMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}

	@Override
	public Result updateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		Result result=categoryServiceRepository.updateCategory(updateCategoryMessageEntity);
		if(result.getResultStatus() != ResultStatus.SUCCESS)
		{
			return new Result(ResultStatus.ERROR);
		}
		
		return new Result(ResultStatus.SUCCESS);
	}
}
