/**
 * 
 */
package seahorse.internal.business.categoryservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.Logger;
import com.google.inject.Inject;
import seahorse.internal.business.categoryservice.datacontracts.*;
import seahorse.internal.business.katavuccolservice.common.KatavuccolConstant;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.shared.aop.InjectLogger;
import seahorse.internal.business.categoryservice.api.datacontracts.CategoryModel;

/**
 * @author admin
 *
 */
public class CategoryService implements  ICategoryService {

	private ICategoryServiceMapper categoryServiceMapper;
	private ICategoryServiceVerifier categoryServiceVerifier;
	private ICategoryServiceValidator categoryServiceValidator;
	private ICategoryServiceProcessor categoryServiceProcessor;
	private ICategoryServicePostProcessor categoryServicePostProcessor;	
	
	@InjectLogger  Logger logger;

	@Inject
	public CategoryService(ICategoryServiceMapper categoryServiceMapper,
			ICategoryServiceVerifier categoryServiceVerifier,
			ICategoryServiceValidator categoryServiceValidator,
			ICategoryServiceProcessor categoryServiceProcessor,
			ICategoryServicePostProcessor categoryServicePostProcessor)
	{
		this.categoryServiceMapper=categoryServiceMapper;
		this.categoryServiceVerifier=categoryServiceVerifier;
		this.categoryServiceValidator=categoryServiceValidator;
		this.categoryServiceProcessor=categoryServiceProcessor;
		this.categoryServicePostProcessor=categoryServicePostProcessor;		
	}

	@Override
	public CreateCategoryResponseMessageEntity createCategory(CreateCategoryMessageEntity categoryRequestMessageEntity) {
		//Set
		categoryRequestMessageEntity.setStatus(KatavuccolConstant.ACTIVESTATUS);
		categoryRequestMessageEntity.setCreatedDate(new Date());		
		
		//Validator	    
	    Result result = categoryServiceValidator.validateCreateCategory(categoryRequestMessageEntity);
	    if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return categoryServiceMapper.mapCategoryResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
	    //Verifier
	    result = categoryServiceVerifier.verifyCreateCategory(categoryRequestMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return categoryServiceMapper.mapCategoryResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
		//Processor
		result=categoryServiceProcessor.processorCreateCategory(categoryRequestMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return categoryServiceMapper.mapCategoryResponseMessageEntity(result, Status.FORBIDDEN);
		}
		
		//Post Processor
		Result postresult=categoryServicePostProcessor.postProcessorCreateCategory(categoryRequestMessageEntity);
				
		return categoryServiceMapper.mapCategoryResponseMessageEntity(result, categoryRequestMessageEntity);
	}

	@Override
	public DeleteCategoryResponseMessageEntity deleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		//Set
		deleteCategoryRequestMessageEntity.setStatus(KatavuccolConstant.INACTIVESTATUS);
		deleteCategoryRequestMessageEntity.setModifiedDate(new Date());
		
		//Validator	    
	    Result result = categoryServiceValidator.validateDeleteCategory(deleteCategoryRequestMessageEntity);
	    if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return categoryServiceMapper.mapDeleteCategoryResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
	    //Verifier
	    result = categoryServiceVerifier.verifyDeleteCategory(deleteCategoryRequestMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return categoryServiceMapper.mapDeleteCategoryResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
		//Processor
		result=categoryServiceProcessor.processorDeleteCategory(deleteCategoryRequestMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return categoryServiceMapper.mapDeleteCategoryResponseMessageEntity(result, Status.FORBIDDEN);
		}
		
		//Post Processor
		Result postresult=categoryServicePostProcessor.postProcessorDeleteCategory(deleteCategoryRequestMessageEntity);
				
		return categoryServiceMapper.mapDeleteCategoryResponseMessageEntity(result, deleteCategoryRequestMessageEntity);
	}

	@Override
	public UpdateCategoryResponseMessageEntity updateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		//Set		
		updateCategoryMessageEntity.setModifiedDate(new Date());
		
		//Validator	    
	    Result result = categoryServiceValidator.validateUpdateCategory(updateCategoryMessageEntity);
	    if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return categoryServiceMapper.mapUpdateCategoryResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
	    //Verifier
	    result = categoryServiceVerifier.verifyUpdateCategory(updateCategoryMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return categoryServiceMapper.mapUpdateCategoryResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
		//Processor
		result=categoryServiceProcessor.processorUpdateCategory(updateCategoryMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return categoryServiceMapper.mapUpdateCategoryResponseMessageEntity(result, Status.FORBIDDEN);
		}
		
		//Post Processor
		Result postresult=categoryServicePostProcessor.postProcessorUpdateCategory(updateCategoryMessageEntity);
		
		return categoryServiceMapper.mapUpdateCategoryResponseMessageEntity(result, updateCategoryMessageEntity);
	}

	@Override
	public List<CategoryModel> getCategory(GetCategoryMessageEntity getCategoryMessageEntity) {
		//Validator	    
	    Result result = categoryServiceValidator.validateGetCategory(getCategoryMessageEntity);
	    if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return new ArrayList<>();
		}
	    
	    //Verifier
	    result = categoryServiceVerifier.verifyGetCategory(getCategoryMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return new ArrayList<>();
		}
		
		//Processor
		result=categoryServiceProcessor.processorGetCategory(getCategoryMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return new ArrayList<>();
		}
		
		return categoryServiceMapper.mapCategory(result, getCategoryMessageEntity);
	}

	@Override
	public CategoryMessageEntity getCategoryDetailById(UUID parsedCategoryId, UUID parsedUserId) {
		// TODO Auto-generated method stub
		return null;
	}
}
