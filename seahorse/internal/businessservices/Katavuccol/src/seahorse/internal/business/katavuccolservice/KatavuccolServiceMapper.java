/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceMapper implements IKatavuccolServiceMapper {

	@Override
	public CredentialResponseMessageEntity mapCredentialResponseMessageEntity(Result result, Status badRequest) {
		CredentialResponseMessageEntity credentialsResponseMessageEntity=new CredentialResponseMessageEntity();
		credentialsResponseMessageEntity.setResultStatus(result.getResultStatus());
		credentialsResponseMessageEntity.setResultMessages(result.getResultMessages());
		return credentialsResponseMessageEntity;
	}

	@Override
	public CredentialResponseMessageEntity mapCredentialResponseMessageEntity(Result result,CredentialRequestMessageEntity credentialRequestMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
