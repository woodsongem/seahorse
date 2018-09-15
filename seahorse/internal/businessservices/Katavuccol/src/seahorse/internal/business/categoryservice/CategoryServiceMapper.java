/**
 * 
 */
package seahorse.internal.business.categoryservice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.categoryservice.api.datacontracts.CategoryModel;
import seahorse.internal.business.categoryservice.api.datacontracts.DeleteCategoryResponseModel;
import seahorse.internal.business.categoryservice.api.datacontracts.UpdateCategoryRequestModel;
import seahorse.internal.business.categoryservice.api.datacontracts.UpdateCategoryResponseModel;
import seahorse.internal.business.categoryservice.datacontracts.CreateCategoryMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.CreateCategoryResponseMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryResponseMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.GetCategoryMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.UpdateCategoryResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.api.datacontracts.Category;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CategoryRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CategoryResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.Credential;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultMessage;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialValueMessageEntity;

/**
 * @author admin
 *
 */
public class CategoryServiceMapper implements ICategoryServiceMapper {
	@Override
	public CreateCategoryResponseMessageEntity mapCategoryResponseMessageEntity(Result result, Status badRequest) {
		CreateCategoryResponseMessageEntity categoryResponseMessageEntity = new CreateCategoryResponseMessageEntity();
		categoryResponseMessageEntity.setResultStatus(result.getResultStatus());
		categoryResponseMessageEntity.setResultMessages(result.getResultMessages());
		categoryResponseMessageEntity.setHttpStatus(badRequest);
		return categoryResponseMessageEntity;
	}

	@Override
	public CreateCategoryResponseMessageEntity mapCategoryResponseMessageEntity(Result result,CreateCategoryMessageEntity categoryRequestMessageEntity) {
		// TODO Auto-generated method stub
		CreateCategoryResponseMessageEntity categoryResponseMessageEntity = new CreateCategoryResponseMessageEntity();
		categoryResponseMessageEntity.setResultStatus(result.getResultStatus());
		categoryResponseMessageEntity.setResultMessages(result.getResultMessages());
		categoryResponseMessageEntity.setHttpStatus(Status.OK);
		if (categoryRequestMessageEntity.getHttpStatus() == null) {
			if (result.getResultStatus() == ResultStatus.SUCCESS)
				categoryResponseMessageEntity.setHttpStatus(Status.OK);
			else
				categoryResponseMessageEntity.setHttpStatus(Status.FORBIDDEN);
		} else {
			categoryResponseMessageEntity.setHttpStatus(categoryRequestMessageEntity.getHttpStatus());
		}
		return categoryResponseMessageEntity;
	}

	@Override
	public DeleteCategoryResponseMessageEntity mapDeleteCategoryResponseMessageEntity(Result result,Status badRequest) {
		// TODO Auto-generated method stub
		DeleteCategoryResponseMessageEntity deleteCategoryResponseMessageEntity = new DeleteCategoryResponseMessageEntity();
		deleteCategoryResponseMessageEntity.setResultStatus(result.getResultStatus());
		deleteCategoryResponseMessageEntity.setResultMessages(result.getResultMessages());
		deleteCategoryResponseMessageEntity.setHttpStatus(badRequest);
		return deleteCategoryResponseMessageEntity;
	}

	@Override
	public DeleteCategoryResponseMessageEntity mapDeleteCategoryResponseMessageEntity(Result result,DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		// TODO Auto-generated method stub
		DeleteCategoryResponseMessageEntity deleteCategoryResponseMessageEntity = new DeleteCategoryResponseMessageEntity();
		deleteCategoryResponseMessageEntity.setResultStatus(result.getResultStatus());
		deleteCategoryResponseMessageEntity.setResultMessages(result.getResultMessages());
		deleteCategoryResponseMessageEntity.setHttpStatus(Status.OK);
		if (deleteCategoryRequestMessageEntity.getHttpStatus() == null) {
			if (result.getResultStatus() == ResultStatus.SUCCESS)
				deleteCategoryResponseMessageEntity.setHttpStatus(Status.OK);
			else
				deleteCategoryResponseMessageEntity.setHttpStatus(Status.FORBIDDEN);
		} else {
			deleteCategoryResponseMessageEntity.setHttpStatus(deleteCategoryRequestMessageEntity.getHttpStatus());
		}
		return deleteCategoryResponseMessageEntity;
	}

	@Override
	public List<CategoryModel> mapCategory(Result result, GetCategoryMessageEntity getCategoryMessageEntity) {
		// TODO Auto-generated method stub
		List<CategoryModel> categorys = new ArrayList<>();
		if (getCategoryMessageEntity.getCategory() == null || getCategoryMessageEntity.getCategory().isEmpty()) {
			return categorys;
		}
		for (seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO categoryDAO : getCategoryMessageEntity
				.getCategory()) {
			CategoryModel category = new CategoryModel();
			category.setName(categoryDAO.getName());
			category.setUserId(KatavuccolServiceUtility.getString(categoryDAO.getUserId()));
			category.setDescription(categoryDAO.getDescription());
			category.setId(KatavuccolServiceUtility.getString(categoryDAO.getId()));
			category.setCreatedBy(KatavuccolServiceUtility.getString(categoryDAO.getCreatedBy()));
			category.setCreatedDate(categoryDAO.getCreatedDate());
			category.setModifiedBy(KatavuccolServiceUtility.getString(categoryDAO.getModifiedBy()));
			category.setModifiedDate(categoryDAO.getModifiedDate());
			category.setStatus(categoryDAO.getStatus());
			categorys.add(category);
		}
		return categorys;
	}

	@Override
	public List<Category> mapCategory(Result result, Status forbidden) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateCategoryResponseMessageEntity mapUpdateCategoryResponseMessageEntity(Result result,
			Status badRequest) {
		// TODO Auto-generated method stub
		UpdateCategoryResponseMessageEntity updateCategoryResponseMessageEntity = new UpdateCategoryResponseMessageEntity();
		updateCategoryResponseMessageEntity.setResultStatus(result.getResultStatus());
		updateCategoryResponseMessageEntity.setResultMessages(result.getResultMessages());
		updateCategoryResponseMessageEntity.setHttpStatus(badRequest);
		return updateCategoryResponseMessageEntity;
	}

	@Override
	public UpdateCategoryResponseMessageEntity mapUpdateCategoryResponseMessageEntity(Result result,
			UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		// TODO Auto-generated method stub
		UpdateCategoryResponseMessageEntity updateCategoryResponseMessageEntity = new UpdateCategoryResponseMessageEntity();
		updateCategoryResponseMessageEntity.setResultStatus(result.getResultStatus());
		updateCategoryResponseMessageEntity.setResultMessages(result.getResultMessages());
		updateCategoryResponseMessageEntity.setHttpStatus(Status.OK);
		if (updateCategoryMessageEntity.getHttpStatus() == null) {
			if (result.getResultStatus() == ResultStatus.SUCCESS)
				updateCategoryResponseMessageEntity.setHttpStatus(Status.OK);
			else
				updateCategoryResponseMessageEntity.setHttpStatus(Status.FORBIDDEN);
		} else {
			updateCategoryResponseMessageEntity.setHttpStatus(updateCategoryMessageEntity.getHttpStatus());
		}
		return updateCategoryResponseMessageEntity;
	}

	@Override
	public Credential mapCategory(Result result, GetCredentialValueMessageEntity getCredentialValueMessageEntity) {
		// TODO Auto-generated method stub
		Credential credential = new Credential();
		return credential;
	}

	@Override
	public CreateCategoryMessageEntity mapCategoryRequestMessageEntity(CategoryRequest categoryRequest, String userid,
			HttpServletRequest httpRequest) {
		// TODO Auto-generated method stub
		CreateCategoryMessageEntity categoryRequestMessageEntity = new CreateCategoryMessageEntity();
		categoryRequestMessageEntity.setUserId(userid);
		categoryRequestMessageEntity.setName(categoryRequest.getName());
		categoryRequestMessageEntity.setDescription(categoryRequest.getDescription());
		return categoryRequestMessageEntity;
	}

	@Override
	public CategoryResponse mapCategoryResponse(CreateCategoryResponseMessageEntity categoryResponseMessageEntity,
			CreateCategoryMessageEntity categoryMessageEntity) {
		// TODO Auto-generated method stub
		CategoryResponse categoryResponse = new CategoryResponse();
		if (categoryResponseMessageEntity == null) {
			return categoryResponse;
		}
		if (categoryMessageEntity.getId() != null) {
			categoryResponse.setId(categoryMessageEntity.getId().toString());
		}
		if (categoryResponseMessageEntity.getResultMessages() == null) {
			return categoryResponse;
		}
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : categoryResponseMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage
					.setErrorCode(String.format(resultMessageMS.getErrorCode(), categoryMessageEntity.getHttpMethod()));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		categoryResponse.setResultMessages(resultMessages);

		return categoryResponse;
	}

	@Override
	public DeleteCategoryRequestMessageEntity mapDeleteCategoryRequestMessageEntity(String userid, String categoryId,
			HttpServletRequest httpRequest) {
		// TODO Auto-generated method stub
		DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity = new DeleteCategoryRequestMessageEntity();
		deleteCategoryRequestMessageEntity.setUserId(userid);
		deleteCategoryRequestMessageEntity.setCategoryId(categoryId);
		return deleteCategoryRequestMessageEntity;
	}

	@Override
	public DeleteCategoryResponseModel mapDeleteCategoryResponse(
			DeleteCategoryResponseMessageEntity deleteCategoryResponseMessageEntity,
			DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		// TODO Auto-generated method stub
		DeleteCategoryResponseModel deleteCategoryResponse = new DeleteCategoryResponseModel();
		if (deleteCategoryResponseMessageEntity == null
				|| deleteCategoryResponseMessageEntity.getResultMessages() == null) {
			return deleteCategoryResponse;
		}

		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : deleteCategoryResponseMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(
					String.format(resultMessageMS.getErrorCode(), deleteCategoryRequestMessageEntity.getHttpMethod()));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		deleteCategoryResponse.setResultMessages(resultMessages);

		return deleteCategoryResponse;
	}

	@Override
	public UpdateCategoryMessageEntity mapUpdateCategoryRequestMessageEntity(
			UpdateCategoryRequestModel updateCategoryRequest, String userid, String categoryId,
			HttpServletRequest httpRequest) {
		// TODO Auto-generated method stub
		UpdateCategoryMessageEntity updateCategoryMessageEntity = new UpdateCategoryMessageEntity();
		updateCategoryMessageEntity.setUserId(userid);
		updateCategoryMessageEntity.setCategoryId(categoryId);
		if (updateCategoryRequest == null) {
			return updateCategoryMessageEntity;
		}
		updateCategoryMessageEntity.setName(updateCategoryRequest.getName());
		updateCategoryMessageEntity.setDescription(updateCategoryRequest.getDescription());
		return updateCategoryMessageEntity;
	}

	@Override
	public UpdateCategoryResponseModel mapUpdateCategoryResponse(
			UpdateCategoryResponseMessageEntity updateCategoryResponseMessageEntity,
			UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		// TODO Auto-generated method stub
		UpdateCategoryResponseModel updateCategoryResponse = new UpdateCategoryResponseModel();
		if (updateCategoryResponseMessageEntity == null
				|| updateCategoryResponseMessageEntity.getResultMessages() == null) {
			return updateCategoryResponse;
		}

		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : updateCategoryResponseMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(
					String.format(resultMessageMS.getErrorCode(), updateCategoryMessageEntity.getHttpMethod()));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		updateCategoryResponse.setResultMessages(resultMessages);

		return updateCategoryResponse;
	}

	@Override
	public GetCategoryMessageEntity mapGetCategoryMessageEntity(String userid, HttpServletRequest httpRequest) {
		// TODO Auto-generated method stub
		GetCategoryMessageEntity getCategoryMessageEntity = new GetCategoryMessageEntity();
		getCategoryMessageEntity.setUserId(userid);
		return getCategoryMessageEntity;
	}

	@Override
	public CategoryMessageEntity mapCategoryMessageEntity(CategoryDAO categoryDAO) {
		CategoryMessageEntity categoryMessageEntity = new CategoryMessageEntity();
		categoryMessageEntity.setCreatedBy(categoryDAO.getCreatedBy());
		categoryMessageEntity.setCreatedDate(categoryDAO.getCreatedDate());
		categoryMessageEntity.setDescription(categoryDAO.getDescription());
		categoryMessageEntity.setId(categoryDAO.getId());
		categoryMessageEntity.setModifiedBy(categoryDAO.getModifiedBy());
		categoryMessageEntity.setModifiedDate(categoryDAO.getModifiedDate());
		categoryMessageEntity.setName(categoryDAO.getName());
		categoryMessageEntity.setStatus(categoryDAO.getStatus());
		categoryMessageEntity.setUserId(categoryDAO.getUserId());
		return categoryMessageEntity;
	}
	
}
