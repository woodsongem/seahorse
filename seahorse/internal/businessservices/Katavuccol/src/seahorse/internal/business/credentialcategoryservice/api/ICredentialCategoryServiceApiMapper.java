/**
 * 
 */
package seahorse.internal.business.credentialcategoryservice.api;

import javax.servlet.http.HttpServletRequest;

import seahorse.internal.business.categoryservice.api.datacontracts.CreateCategoryRequestModel;
import seahorse.internal.business.categoryservice.api.datacontracts.CreateCategoryResponseModel;
import seahorse.internal.business.categoryservice.api.datacontracts.DeleteCategoryResponseModel;
import seahorse.internal.business.categoryservice.datacontracts.CreateCategoryMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.CreateCategoryResponseMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryResponseMessageEntity;

/**
 * @author SMJE
 *
 */
public interface ICredentialCategoryServiceApiMapper {
	
	CreateCategoryMessageEntity mapCategoryRequestMessageEntity(CreateCategoryRequestModel createCategoryRequestModel, String userId,HttpServletRequest httpRequest);
	
	CreateCategoryResponseModel mapCategoryResponse(CreateCategoryResponseMessageEntity categoryResponseMessageEntity, CreateCategoryMessageEntity categoryMessageEntity);
	
	DeleteCategoryRequestMessageEntity mapDeleteCategoryRequestMessageEntity(String userid, String categoryId,HttpServletRequest httpRequest);
	
	DeleteCategoryResponseModel mapDeleteCategoryResponse(DeleteCategoryResponseMessageEntity deleteCategoryResponseMessageEntity,DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);

}
