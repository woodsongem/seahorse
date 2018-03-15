/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import javax.ws.rs.core.Response.Status;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
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
		credentialsResponseMessageEntity.setHttpStatus(badRequest);
		return credentialsResponseMessageEntity;
	}

	@Override
	public CredentialResponseMessageEntity mapCredentialResponseMessageEntity(Result result,CredentialRequestMessageEntity credentialRequestMessageEntity) {
		CredentialResponseMessageEntity credentialsResponseMessageEntity=new CredentialResponseMessageEntity();
		credentialsResponseMessageEntity.setResultStatus(result.getResultStatus());
		credentialsResponseMessageEntity.setResultMessages(result.getResultMessages());
		credentialsResponseMessageEntity.setHttpStatus(Status.OK);
		credentialsResponseMessageEntity.setId(credentialRequestMessageEntity.getId());
		if (credentialRequestMessageEntity.getHttpStatus() == null) {
			if (result.getResultStatus() == ResultStatus.SUCCESS)
				credentialsResponseMessageEntity.setHttpStatus(Status.OK);
			else
				credentialsResponseMessageEntity.setHttpStatus(Status.FORBIDDEN);
		}
		else
		{
			credentialsResponseMessageEntity.setHttpStatus(credentialRequestMessageEntity.getHttpStatus());
		}
		return credentialsResponseMessageEntity;
	}

}
