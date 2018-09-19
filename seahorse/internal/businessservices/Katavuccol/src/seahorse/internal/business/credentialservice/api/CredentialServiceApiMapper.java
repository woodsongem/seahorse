/**
 * 
 */
package seahorse.internal.business.credentialservice.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import seahorse.internal.business.credentialservice.api.datacontracts.CreateCredentialRequestModel;
import seahorse.internal.business.credentialservice.api.datacontracts.CreateCredentialResponseModel;
import seahorse.internal.business.credentialservice.api.datacontracts.DeleteCredentialResponse;
import seahorse.internal.business.credentialservice.api.datacontracts.GetCredentialValueRequest;
import seahorse.internal.business.credentialservice.api.datacontracts.UpdateCredentialRequestModel;
import seahorse.internal.business.credentialservice.api.datacontracts.UpdateCredentialResponseModel;
import seahorse.internal.business.credentialservice.datacontracts.CreateCredentialRequestMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.CreateCredentialResponseMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.DeleteCredentialMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.DeleteCredentialResMsgEntity;
import seahorse.internal.business.credentialservice.datacontracts.GetCredentialByUserIdMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.GetCredentialValueMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultMessage;

/**
 * @author SMJE
 *
 */
public class CredentialServiceApiMapper implements ICredentialServiceApiMapper {

	public CreateCredentialRequestMessageEntity mapCreateCredentialRequestMessageEntity(CreateCredentialRequestModel credentialRequest, String userid, String categoryid,
			HttpServletRequest httpRequest) {
		CreateCredentialRequestMessageEntity createCredentialRequestMessageEntity=new CreateCredentialRequestMessageEntity();
		createCredentialRequestMessageEntity.setUserId(userid);		
		createCredentialRequestMessageEntity.setCategoryId(categoryid);		
		if(credentialRequest == null)
		{
			return createCredentialRequestMessageEntity;
		}		
		createCredentialRequestMessageEntity.setTypeId(credentialRequest.getTypeId());
		createCredentialRequestMessageEntity.setValue(credentialRequest.getValue());
		createCredentialRequestMessageEntity.setDescription(credentialRequest.getDescription());
		createCredentialRequestMessageEntity.setParentCredentialId(credentialRequest.getParentId());
		createCredentialRequestMessageEntity.setUserEncryptKey(credentialRequest.getEncryptKey());
		return createCredentialRequestMessageEntity;
	}

	@Override
	public CreateCredentialResponseModel mapCreateCredentialResponseMessageEntity(CreateCredentialResponseMessageEntity createCredentialResponseMessageEntity,CreateCredentialRequestMessageEntity credentialMessageEntity) {
		CreateCredentialResponseModel createCredentialResponseModel=new CreateCredentialResponseModel();
		if(createCredentialResponseMessageEntity == null)
		{
			return createCredentialResponseModel;
		}
		if(createCredentialResponseMessageEntity.getId() != null)
		{
			createCredentialResponseModel.setId(createCredentialResponseMessageEntity.getId().toString());
		}
		if (createCredentialResponseMessageEntity.getResultMessages() == null) {
			return createCredentialResponseModel;
		}
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : createCredentialResponseMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(String.format(resultMessageMS.getErrorCode(),credentialMessageEntity.getHttpMethod()));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		createCredentialResponseModel.setResultMessages(resultMessages);		
		
		return	createCredentialResponseModel;
	}

	@Override
	public UpdateCredentialMessageEntity mapUpdateCredentialRequestMessageEntity(UpdateCredentialRequestModel updateCredentialRequest, String userid, String categoryid, String credentialId,HttpServletRequest httpRequest) {
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
	public UpdateCredentialResponseModel mapUpdateCredentialResponse(UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity,UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		UpdateCredentialResponseModel updateCredentialResponseModel=new UpdateCredentialResponseModel();
		if(updateCredentialResponseMessageEntity == null)
		{
			return updateCredentialResponseModel;
		}		
		if (updateCredentialResponseMessageEntity.getResultMessages() == null) {
			return updateCredentialResponseModel;
		}
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : updateCredentialResponseMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(String.format(resultMessageMS.getErrorCode(),updateCredentialMessageEntity.getHttpMethod()));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		updateCredentialResponseModel.setResultMessages(resultMessages);		
		
		return	updateCredentialResponseModel;
	}

	@Override
	public DeleteCredentialMessageEntity mapDeleteCredentialMessageEntity(String userid, String categoryid,String credentialId, HttpServletRequest httpRequest) {
		DeleteCredentialMessageEntity deleteCredentialMessageEntity=new DeleteCredentialMessageEntity();
		deleteCredentialMessageEntity.setUserId(userid);
		deleteCredentialMessageEntity.setCategoryId(categoryid);
		deleteCredentialMessageEntity.setCredentialId(credentialId);		
		return deleteCredentialMessageEntity;
	}

	@Override
	public DeleteCredentialResponse mapDeleteCredentialResponse(DeleteCredentialResMsgEntity deleteCredentialResponseMessageEntity,DeleteCredentialMessageEntity deleteCredentialMessageEntity) {
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
	public GetCredentialMessageEntity mapGetCredentialMessageEntity(String userid, String categoryid,HttpServletRequest httpRequest) {
		GetCredentialMessageEntity getCredentialMessageEntity=new GetCredentialMessageEntity();
		getCredentialMessageEntity.setUserId(userid);
		getCredentialMessageEntity.setCategoryId(categoryid);
		return getCredentialMessageEntity;
	}

	@Override
	public GetCredentialValueMessageEntity mapGetCredentialValueMessageEntity(String userid, String categoryid,
			String credentialId, HttpServletRequest httpRequest, GetCredentialValueRequest getCredentialValueRequest) {
		GetCredentialValueMessageEntity getCredentialValueMessageEntity=new GetCredentialValueMessageEntity();
		getCredentialValueMessageEntity.setUserId(userid);
		getCredentialValueMessageEntity.setCredentialId(credentialId);
		getCredentialValueMessageEntity.setCategoryId(categoryid);
		if(getCredentialValueRequest == null)
		{
			return getCredentialValueMessageEntity;
		}
		getCredentialValueMessageEntity.setKey(getCredentialValueMessageEntity.getKey());
		
		return getCredentialValueMessageEntity;
	}

	@Override
	public GetCredentialByUserIdMessageEntity mapGetCredentialByUserIdMessageEntity(String userid) {
		GetCredentialByUserIdMessageEntity getCredentialByUserIdMessageEntity=new GetCredentialByUserIdMessageEntity();
		getCredentialByUserIdMessageEntity.setUserId(userid);
		return getCredentialByUserIdMessageEntity;
	}

}
