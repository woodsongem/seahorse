/**
 * 
 */
package seahorse.internal.business.katavuccolservice.api;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import seahorse.internal.business.katavuccolservice.api.datacontracts.CategoryRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CategoryResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.Credential;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.DeleteCategoryResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.DeleteCredentialResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.DeleteCredentialTypeResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.UpdateCategoryRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.UpdateCategoryResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.UpdateCredentialRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.UpdateCredentialResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.UpdateCredentialTypeRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.UpdateCredentialTypeResponse;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultMessage;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialTypeRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialsMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCategoryResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialTypeMessageEntity;

/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceApiMapper implements IKatavuccolServiceApiMapper {

	@Override
	public CredentialResponse mapCredentialsResponse(CredentialResponseMessageEntity credentialsResMessageEntity) {
		CredentialResponse credentialsResponse=new CredentialResponse();
		if(credentialsResMessageEntity == null)
		{
			return credentialsResponse;
		}
		if(credentialsResMessageEntity.getId() != null)
		{
			credentialsResponse.setId(credentialsResMessageEntity.getId().toString());
		}
		if (credentialsResMessageEntity.getResultMessages() == null) {
			return credentialsResponse;
		}
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : credentialsResMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(resultMessageMS.getErrorCode());
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		credentialsResponse.setResultMessages(resultMessages);		
		
		return	credentialsResponse;
	}

	@Override
	public CredentialRequestMessageEntity mapCredentialRequestMessageEntity(CredentialRequest credentialRequest,String userid, HttpServletRequest httpRequest) {
		CredentialRequestMessageEntity credentialRequestMessageEntity=new CredentialRequestMessageEntity();
		credentialRequestMessageEntity.setUserId(userid);
		credentialRequestMessageEntity.setHttpRequest(httpRequest);
		if(credentialRequest == null)
		{
			return credentialRequestMessageEntity;
		}
		credentialRequestMessageEntity.setCategoryId(credentialRequest.getCategoryId());
		credentialRequestMessageEntity.setTypeId(credentialRequest.getTypeId());
		credentialRequestMessageEntity.setValue(credentialRequest.getValue());
		credentialRequestMessageEntity.setDescription(credentialRequest.getDescription());
		credentialRequestMessageEntity.setParentCredentialId(credentialRequest.getParentId());
		return credentialRequestMessageEntity;
	}

	@Override
	public GetCredentialMessageEntity mapGetCredentialMessageEntity(String userid, HttpServletRequest httpRequest) {
		GetCredentialMessageEntity getCredentialMessageEntity=new GetCredentialMessageEntity();
		getCredentialMessageEntity.setUserId(userid);
		return getCredentialMessageEntity;
	}

	@Override
	public List<Credential> mapCredential(GetCredentialsMessageEntity getCredentialsMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CredentialResponse mapCredentialsResponse(CredentialResponseMessageEntity credentialsResMessageEntity, CredentialRequestMessageEntity credentialMessageEntity) {
		CredentialResponse credentialsResponse=new CredentialResponse();
		if(credentialsResMessageEntity == null)
		{
			return credentialsResponse;
		}
		if(credentialsResMessageEntity.getId() != null)
		{
			credentialsResponse.setId(credentialsResMessageEntity.getId().toString());
		}
		if (credentialsResMessageEntity.getResultMessages() == null) {
			return credentialsResponse;
		}
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : credentialsResMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(String.format(resultMessageMS.getErrorCode(),credentialMessageEntity.getHttpMethod()));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		credentialsResponse.setResultMessages(resultMessages);		
		
		return	credentialsResponse;
	}

	@Override
	public UpdateCredentialMessageEntity mapUpdateCredentialRequestMessageEntity(
			UpdateCredentialRequest updateCredentialRequest, String userid, String credentialId,
			HttpServletRequest httpRequest) {
		UpdateCredentialMessageEntity updateCredentialRequestMessageEntity=new UpdateCredentialMessageEntity();
		if(updateCredentialRequest == null)
		{
			return updateCredentialRequestMessageEntity;
		}		
		updateCredentialRequestMessageEntity.setUserId(userid);
		updateCredentialRequestMessageEntity.setCredentialId(credentialId);
		updateCredentialRequestMessageEntity.setValue(updateCredentialRequest.getValue());
		updateCredentialRequestMessageEntity.setDescription(updateCredentialRequest.getDescription());		
		updateCredentialRequestMessageEntity.setCredentialTypeId(updateCredentialRequest.getCredentialTypeId());
		return updateCredentialRequestMessageEntity;
	}

	@Override
	public UpdateCredentialResponse mapUpdateCredentialResponse(
			UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity,
			UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		UpdateCredentialResponse updateCredentialResponse=new UpdateCredentialResponse();
		if(updateCredentialResponseMessageEntity == null)
		{
			return updateCredentialResponse;
		}		
		if (updateCredentialResponseMessageEntity.getResultMessages() == null) {
			return updateCredentialResponse;
		}
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : updateCredentialResponseMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(String.format(resultMessageMS.getErrorCode(),updateCredentialMessageEntity.getHttpMethod()));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		updateCredentialResponse.setResultMessages(resultMessages);		
		
		return	updateCredentialResponse;
	}

	@Override
	public DeleteCredentialRequestMessageEntity mapDeleteCredentialRequestMessageEntity(String userid,String credentialId, HttpServletRequest httpRequest) {
		DeleteCredentialRequestMessageEntity deleteCredentialRequestMessageEntity=new DeleteCredentialRequestMessageEntity();
		deleteCredentialRequestMessageEntity.setUserId(userid);
		deleteCredentialRequestMessageEntity.setCredentialId(credentialId);		
		return deleteCredentialRequestMessageEntity;
	}

	@Override
	public DeleteCredentialResponse mapDeleteCredentialResponse(
			DeleteCredentialResponseMessageEntity deleteCredentialResponseMessageEntity,
			DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
		DeleteCredentialResponse deleteCredentialResponse=new DeleteCredentialResponse();
		if(deleteCredentialResponseMessageEntity == null || deleteCredentialResponseMessageEntity.getResultMessages() == null)
		{
			return deleteCredentialResponse;
		}		
		
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : deleteCredentialResponseMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(String.format(resultMessageMS.getErrorCode(),deleteCredentialMessageEntity.getHttpMethod()));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		deleteCredentialResponse.setResultMessages(resultMessages);		
		
		return	deleteCredentialResponse;
	}

	@Override
	public CategoryRequestMessageEntity mapCategoryRequestMessageEntity(CategoryRequest categoryRequest, String userid,HttpServletRequest httpRequest) {
		CategoryRequestMessageEntity categoryRequestMessageEntity=new CategoryRequestMessageEntity();
		return categoryRequestMessageEntity;
	}

	@Override
	public CategoryResponse mapCategoryResponse(CategoryResponseMessageEntity categoryResponseMessageEntity,CategoryRequestMessageEntity categoryMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteCategoryRequestMessageEntity mapDeleteCategoryRequestMessageEntity(String userid, String categoryId,HttpServletRequest httpRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteCategoryResponse mapDeleteCategoryResponse(
			DeleteCredentialResponseMessageEntity deleteCredentialResponseMessageEntity,
			DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateCategoryMessageEntity mapUpdateCategoryRequestMessageEntity(
			UpdateCategoryRequest updateCategoryRequest, String userid, String categoryId,
			HttpServletRequest httpRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateCategoryResponse mapUpdateCategoryResponse(
			UpdateCategoryResponseMessageEntity updateCategoryResponseMessageEntity,
			UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CredentialTypeRequestMessageEntity mapCredentialTypeRequestMessageEntity(CredentialTypeRequest credentialTypeRequest, String userid, HttpServletRequest httpRequest) {
		CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity=new CredentialTypeRequestMessageEntity();
		credentialTypeRequestMessageEntity.setUserId(userid);
		credentialTypeRequestMessageEntity.setName(credentialTypeRequest.getName());
		credentialTypeRequestMessageEntity.setDescription(credentialTypeRequest.getDescription());
		credentialTypeRequestMessageEntity.setIsDuplicationAllowed(credentialTypeRequest.getIsDuplicationAllowed());
		credentialTypeRequestMessageEntity.setIsSubitemAllowed(credentialTypeRequest.getIsSubitemAllowed());		
		return credentialTypeRequestMessageEntity;
	}

	@Override
	public CredentialTypeResponse mapCredentialTypeResponse(
			CredentialTypeResponseMessageEntity credentialTypeResponseMessageEntity,
			CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateCredentialTypeMessageEntity mapUpdateCredentialRequestMessageEntity(
			UpdateCredentialTypeRequest updateCredentialTypeRequest, String userid, String credentialId,
			HttpServletRequest httpRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateCredentialTypeResponse mapUpdateCredentialTypeResponse(
			UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity,
			UpdateCredentialTypeMessageEntity updateCredentialTypeMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteCredentialTypeResponse mapDeleteCredentialTypeResponse(
			DeleteCredentialResponseMessageEntity deleteCredentialResponseMessageEntity,
			DeleteCredentialTypeRequestMessageEntity deleteCredentialTypeRequestMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteCredentialTypeRequestMessageEntity mapDeleteCredentialTypeRequestMessageEntity(String userid,
			String credentialTypeId, HttpServletRequest httpRequest) {
		// TODO Auto-generated method stub
		return null;
	}
}
