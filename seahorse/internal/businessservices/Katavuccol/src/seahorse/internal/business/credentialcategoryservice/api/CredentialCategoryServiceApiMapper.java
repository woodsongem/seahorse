/**
 * 
 */
package seahorse.internal.business.credentialcategoryservice.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import seahorse.internal.business.categoryservice.api.datacontracts.CreateCategoryRequestModel;
import seahorse.internal.business.categoryservice.api.datacontracts.CreateCategoryResponseModel;
import seahorse.internal.business.categoryservice.api.datacontracts.DeleteCategoryResponseModel;
import seahorse.internal.business.categoryservice.datacontracts.CreateCategoryMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.CreateCategoryResponseMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultMessage;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryResponseMessageEntity;

/**
 * @author SMJE
 *
 */
public class CredentialCategoryServiceApiMapper implements ICredentialCategoryServiceApiMapper {

	@Override
	public CreateCategoryMessageEntity mapCategoryRequestMessageEntity(CreateCategoryRequestModel createCategoryRequestModel, String userId,HttpServletRequest httpRequest) {
		// TODO Auto-generated method stub
		CreateCategoryMessageEntity categoryRequestMessageEntity=new CreateCategoryMessageEntity();
		categoryRequestMessageEntity.setUserId(userId);
		categoryRequestMessageEntity.setName(createCategoryRequestModel.getName());
		categoryRequestMessageEntity.setDescription(createCategoryRequestModel.getDescription());		
		return categoryRequestMessageEntity;
	}
	
	@Override
	public CreateCategoryResponseModel mapCategoryResponse(CreateCategoryResponseMessageEntity categoryResponseMessageEntity,
			CreateCategoryMessageEntity categoryMessageEntity) {
		// TODO Auto-generated method stub
		CreateCategoryResponseModel categoryResponse=new CreateCategoryResponseModel();
		if(categoryResponseMessageEntity == null)
		{
			return categoryResponse;
		}
		if(categoryMessageEntity.getId() != null)
		{
			categoryResponse.setId(categoryMessageEntity.getId().toString());
		}
		if (categoryResponseMessageEntity.getResultMessages() == null) {
			return categoryResponse;
		}
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : categoryResponseMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(String.format(resultMessageMS.getErrorCode(),categoryMessageEntity.getHttpMethod()));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		categoryResponse.setResultMessages(resultMessages);		
		
		return	categoryResponse;
	}
	@Override
	public DeleteCategoryRequestMessageEntity mapDeleteCategoryRequestMessageEntity(String userid, String categoryId,HttpServletRequest httpRequest) {
		// TODO Auto-generated method stub
		DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity=new DeleteCategoryRequestMessageEntity();
		deleteCategoryRequestMessageEntity.setUserId(userid);
		deleteCategoryRequestMessageEntity.setCategoryId(categoryId);
		return deleteCategoryRequestMessageEntity;
	}
	@Override
	public DeleteCategoryResponseModel mapDeleteCategoryResponse(DeleteCategoryResponseMessageEntity deleteCategoryResponseMessageEntity,DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		// TODO Auto-generated method stub
		DeleteCategoryResponseModel deleteCategoryResponse=new DeleteCategoryResponseModel();
		if(deleteCategoryResponseMessageEntity == null || deleteCategoryResponseMessageEntity.getResultMessages() == null)
		{
			return deleteCategoryResponse;
		}		
		
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : deleteCategoryResponseMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(String.format(resultMessageMS.getErrorCode(),deleteCategoryRequestMessageEntity.getHttpMethod()));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		deleteCategoryResponse.setResultMessages(resultMessages);		
		
		return	deleteCategoryResponse;
	}
}
