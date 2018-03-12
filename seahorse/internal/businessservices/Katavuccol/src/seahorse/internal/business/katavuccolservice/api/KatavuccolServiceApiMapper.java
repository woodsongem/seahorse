/**
 * 
 */
package seahorse.internal.business.katavuccolservice.api;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.Credential;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialResponse;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultMessage;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialsMessageEntity;

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
		return credentialRequestMessageEntity;
	}

	@Override
	public GetCredentialMessageEntity mapGetCredentialMessageEntity(String userid, HttpServletRequest httpRequest) {
		// TODO Auto-generated method stub
		return null;
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
}
