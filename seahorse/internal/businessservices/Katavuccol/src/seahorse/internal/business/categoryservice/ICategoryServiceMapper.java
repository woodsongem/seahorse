/**
 * 
 */
package seahorse.internal.business.categoryservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response.Status;

import com.google.api.client.auth.oauth2.Credential;

import seahorse.internal.business.categoryservice.api.datacontracts.CategoryModel;
import seahorse.internal.business.categoryservice.api.datacontracts.DeleteCategoryResponseModel;
import seahorse.internal.business.categoryservice.api.datacontracts.UpdateCategoryRequestModel;
import seahorse.internal.business.categoryservice.api.datacontracts.UpdateCategoryResponseModel;
import seahorse.internal.business.categoryservice.datacontracts.CategoryMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.CreateCategoryMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.CreateCategoryResponseMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryResponseMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.GetCategoryMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.UpdateCategoryResponseMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.GetCredentialValueMessageEntity;
import seahorse.internal.business.katavuccolservice.api.datacontracts.Category;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CategoryRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CategoryResponse;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;

/**
 * @author admin
 *
 */
public interface ICategoryServiceMapper {
	CreateCategoryResponseMessageEntity mapCategoryResponseMessageEntity(Result result, Status badRequest);

	CreateCategoryResponseMessageEntity mapCategoryResponseMessageEntity(Result result,CreateCategoryMessageEntity categoryRequestMessageEntity);

	DeleteCategoryResponseMessageEntity mapDeleteCategoryResponseMessageEntity(Result result, Status badRequest);

	DeleteCategoryResponseMessageEntity mapDeleteCategoryResponseMessageEntity(Result result,DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);

	List<CategoryModel> mapCategory(Result result, GetCategoryMessageEntity getCategoryMessageEntity);

	List<Category> mapCategory(Result result, Status forbidden);

	UpdateCategoryResponseMessageEntity mapUpdateCategoryResponseMessageEntity(Result result, Status badRequest);

	UpdateCategoryResponseMessageEntity mapUpdateCategoryResponseMessageEntity(Result result,UpdateCategoryMessageEntity updateCategoryMessageEntity);

	Credential mapCategory(Result result, GetCredentialValueMessageEntity getCredentialValueMessageEntity);

	CreateCategoryMessageEntity mapCategoryRequestMessageEntity(CategoryRequest categoryRequest, String userid,HttpServletRequest httpRequest);

	CategoryResponse mapCategoryResponse(CreateCategoryResponseMessageEntity categoryResponseMessageEntity,CreateCategoryMessageEntity categoryMessageEntity);

	DeleteCategoryRequestMessageEntity mapDeleteCategoryRequestMessageEntity(String userid, String categoryId,HttpServletRequest httpRequest);

	DeleteCategoryResponseModel mapDeleteCategoryResponse(DeleteCategoryResponseMessageEntity deleteCategoryResponseMessageEntity,DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);

	UpdateCategoryMessageEntity mapUpdateCategoryRequestMessageEntity(UpdateCategoryRequestModel updateCategoryRequest,String userid, String categoryId, HttpServletRequest httpRequest);

	UpdateCategoryResponseModel mapUpdateCategoryResponse(UpdateCategoryResponseMessageEntity updateCategoryResponseMessageEntity,UpdateCategoryMessageEntity updateCategoryMessageEntity);

	GetCategoryMessageEntity mapGetCategoryMessageEntity(String userid, HttpServletRequest httpRequest);

	CategoryMessageEntity mapCategoryMessageEntity(CategoryDAO categoryDAO);

	//com.google.api.client.auth.oauth2.Credential mapCategory(Result result,
			//seahorse.internal.business.credentialservice.datacontracts.GetCredentialValueMessageEntity getCredentialValueMessageEntity);

}
