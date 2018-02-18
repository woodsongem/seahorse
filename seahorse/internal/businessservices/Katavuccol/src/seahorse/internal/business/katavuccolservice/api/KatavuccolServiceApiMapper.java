/**
 * 
 */
package seahorse.internal.business.katavuccolservice.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import seahorse.internal.business.katavuccolservice.api.datacontracts.Credential;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialsRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialsResponse;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialsMessageEntity;

/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceApiMapper implements IKatavuccolServiceApiMapper {

	@Override
	public CredentialsResponse mapCredentialsResponse(CredentialsResponseMessageEntity credentialsResMessageEntity) {
		CredentialsResponse credentialsResponse=new CredentialsResponse();
		if(credentialsResMessageEntity == null)
		{
			return credentialsResponse;
		}
		if(credentialsResMessageEntity.getId() != null)
		{
			credentialsResponse.setId(credentialsResMessageEntity.getId().toString());
		}
		return	credentialsResponse;
	}

	@Override
	public CredentialsRequestMessageEntity mapCredentialsRequestMessageEntity(CredentialsRequest credentialsRequest,String userid, HttpServletRequest httpRequest) {
		CredentialsRequestMessageEntity credentialsRequestMessageEntity=new CredentialsRequestMessageEntity();
		credentialsRequestMessageEntity.setUserid(userid);
		credentialsRequestMessageEntity.setHttpRequest(httpRequest);
		if(credentialsRequest == null)
		{
			return credentialsRequestMessageEntity;
		}
		credentialsRequestMessageEntity.setName(credentialsRequest.getName());
		credentialsRequestMessageEntity.setPassword(credentialsRequest.getPassword());
		credentialsRequestMessageEntity.setUrl(credentialsRequest.getUrl());
		credentialsRequestMessageEntity.setUsername(credentialsRequest.getUsername());		
		return credentialsRequestMessageEntity;
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
}
