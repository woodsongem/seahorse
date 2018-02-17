/**
 * 
 */
package seahorse.internal.business.katavuccolservice.api;

import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialsRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialsResponse;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceApiMapper implements IKatavuccolServiceApiMapper {

	@Override
	public CredentialsRequestMessageEntity mapCredentialsRequestMessageEntity(CredentialsRequest credentialsRequest,String userid) {
		CredentialsRequestMessageEntity credentialsRequestMessageEntity=new CredentialsRequestMessageEntity();
		credentialsRequestMessageEntity.setUserid(userid);
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
}
