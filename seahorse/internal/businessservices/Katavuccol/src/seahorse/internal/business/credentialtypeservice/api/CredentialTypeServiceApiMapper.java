/**
 * 
 */
package seahorse.internal.business.credentialtypeservice.api;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialResponseMessageEntity;
import seahorse.internal.business.credentialtypeservice.api.datacontracts.CreateCredentialTypeRequestModel;
import seahorse.internal.business.credentialtypeservice.api.datacontracts.CreateCredentialTypeResponseModel;
import seahorse.internal.business.credentialtypeservice.api.datacontracts.DeleteCredentialTypeResponseModel;
import seahorse.internal.business.credentialtypeservice.api.datacontracts.UpdateCredentialTypeRequestModel;
import seahorse.internal.business.credentialtypeservice.api.datacontracts.UpdateCredentialTypeResponseModel;
import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeResMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByUserIdMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.DeleteCredentialTypeReqMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.DeleteCredentialTypeResMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.UpdateCredentialTypeMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultMessage;
import seahorse.internal.business.katavuccolservice.utilities.KatavuccolServiceUtility;

/**
 * @author SMJE
 *
 */
public class CredentialTypeServiceApiMapper implements ICredentialTypeServiceApiMapper {

	@Override
	public CreateCredentialTypeMsgEntity mapCreateCredentialTypeMsgEntity(CreateCredentialTypeRequestModel credentialTypeRequest, HttpServletRequest httpRequest) {
		CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity=new CreateCredentialTypeMsgEntity();
		if(credentialTypeRequest==null)
		{
			return createCredentialTypeMsgEntity;
		}
		createCredentialTypeMsgEntity.setUserId(credentialTypeRequest.getUserId());		
		createCredentialTypeMsgEntity.setName(credentialTypeRequest.getName());
		createCredentialTypeMsgEntity.setDescription(credentialTypeRequest.getDescription());
		createCredentialTypeMsgEntity.setIsDuplicationAllowed(credentialTypeRequest.getIsDuplicationAllowed());
		createCredentialTypeMsgEntity.setIsSubitemAllowed(credentialTypeRequest.getIsSubitemAllowed());
		return createCredentialTypeMsgEntity;
	}
	@Override
	public CreateCredentialTypeResponseModel mapCredentialTypeResponse(
			CreateCredentialTypeResMsgEntity createCredentialTypeResMsgEntity,
			CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {
		CreateCredentialTypeResponseModel createCredentialTypeResponse=new CreateCredentialTypeResponseModel();
		
		if(createCredentialTypeResMsgEntity == null)
		{
			return createCredentialTypeResponse;
		}		
		if(createCredentialTypeResMsgEntity.getId() !=null)
		{
			createCredentialTypeResponse.setId(KatavuccolServiceUtility.getString(createCredentialTypeResMsgEntity.getId()));
		}
		
		if(createCredentialTypeResMsgEntity.getResultMessages() == null)
		{
			return	createCredentialTypeResponse;
		}
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : createCredentialTypeResMsgEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(MessageFormat.format(resultMessageMS.getErrorCode(),createCredentialTypeMsgEntity.getHttpMethod(),"CreateCredentialType"));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		createCredentialTypeResponse.setResultMessages(resultMessages);		
		
		return	createCredentialTypeResponse;
	}
	
	@Override
	public UpdateCredentialTypeMessageEntity mapUpdateCredentialRequestMessageEntity(UpdateCredentialTypeRequestModel updateCredentialTypeRequest, String userid, String credentialId,HttpServletRequest httpRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UpdateCredentialTypeResponseModel mapUpdateCredentialTypeResponse(
			UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity,
			UpdateCredentialTypeMessageEntity updateCredentialTypeMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DeleteCredentialTypeResponseModel mapDeleteCredentialTypeResponse(
			DeleteCredentialTypeResMsgEntity deleteCredentialTypeResMsgEntity,
			DeleteCredentialTypeReqMsgEntity deleteCredentialTypeReqMsgEntity) {
		DeleteCredentialTypeResponseModel deleteCredentialTypeResponse=new DeleteCredentialTypeResponseModel();
	
		if(deleteCredentialTypeReqMsgEntity.getResultMessages()== null)
		{
			return deleteCredentialTypeResponse;	
		}
		
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : deleteCredentialTypeReqMsgEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(String.format(resultMessageMS.getErrorCode(),deleteCredentialTypeReqMsgEntity.getHttpMethod(),"DeleteCredentialType"));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		deleteCredentialTypeResponse.setResultMessages(resultMessages);
		return deleteCredentialTypeResponse;
	}
	
	@Override
	public DeleteCredentialTypeReqMsgEntity mapDeleteCredentialTypeRequestMessageEntity(String userid,
			String credentialTypeId, HttpServletRequest httpRequest) {
		DeleteCredentialTypeReqMsgEntity deleteCredentialTypeRequestMessageEntity=new DeleteCredentialTypeReqMsgEntity();
		deleteCredentialTypeRequestMessageEntity.setUserId(userid);
		deleteCredentialTypeRequestMessageEntity.setCredentialTypeId(credentialTypeId);
		deleteCredentialTypeRequestMessageEntity.setHttpRequest(httpRequest);
		return deleteCredentialTypeRequestMessageEntity;
	}
	@Override
	public CredentialTypeByUserIdMsgEntity mapCredentialTypeByUserIdMsgEntity(String userid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CredentialTypeByUserIdMsgEntity mapCredentialTypeByUserIdMsgEntity(String userid, String id) {
		CredentialTypeByUserIdMsgEntity credentialTypeByUserIdMsgEntity=new CredentialTypeByUserIdMsgEntity();
		credentialTypeByUserIdMsgEntity.setUserId(userid);
		credentialTypeByUserIdMsgEntity.setId(id);
		return credentialTypeByUserIdMsgEntity;
	}

}
