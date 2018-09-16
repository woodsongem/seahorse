/**
 * 
 */
package seahorse.internal.business.credentialservice;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.credentialservice.datacontracts.CreateCredentialRequestMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.CreateCredentialResponseMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.DeleteCredentialResMsgEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;

/**
 * @author admin
 *
 */
public class CredentialServiceMapper implements ICredentialServiceMapper {

	@Override
	public CreateCredentialResponseMessageEntity mapCreateCredentialResponseMessageEntity(Result result,Status badRequest) {
		CreateCredentialResponseMessageEntity credentialsResponseMessageEntity=new CreateCredentialResponseMessageEntity();
		credentialsResponseMessageEntity.setResultStatus(result.getResultStatus());
		credentialsResponseMessageEntity.setResultMessages(result.getResultMessages());
		credentialsResponseMessageEntity.setHttpStatus(badRequest);
		return credentialsResponseMessageEntity;
	}

	@Override
	public CreateCredentialResponseMessageEntity mapCreateCredentialResponseMessageEntity(Result result,CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {
		CreateCredentialResponseMessageEntity credentialsResponseMessageEntity=new CreateCredentialResponseMessageEntity();
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

	@Override
	public UpdateCredentialResponseMessageEntity mapUpdateCredentialResponseMessageEntity(Result result,Status badRequest) {
		UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity=new UpdateCredentialResponseMessageEntity();
		updateCredentialResponseMessageEntity.setResultStatus(result.getResultStatus());
		updateCredentialResponseMessageEntity.setResultMessages(result.getResultMessages());
		updateCredentialResponseMessageEntity.setHttpStatus(badRequest);
		return updateCredentialResponseMessageEntity;
	}

	@Override
	public UpdateCredentialResponseMessageEntity mapUpdateCredentialResponseMessageEntity(Result result,UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity=new UpdateCredentialResponseMessageEntity();
		updateCredentialResponseMessageEntity.setResultStatus(result.getResultStatus());
		updateCredentialResponseMessageEntity.setResultMessages(result.getResultMessages());
		updateCredentialResponseMessageEntity.setHttpStatus(Status.OK);		
		if (updateCredentialResponseMessageEntity.getHttpStatus() == null) {
			if (result.getResultStatus() == ResultStatus.SUCCESS)
				updateCredentialResponseMessageEntity.setHttpStatus(Status.OK);
			else
				updateCredentialResponseMessageEntity.setHttpStatus(Status.FORBIDDEN);
		}
		else
		{
			updateCredentialResponseMessageEntity.setHttpStatus(updateCredentialResponseMessageEntity.getHttpStatus());
		}
		return updateCredentialResponseMessageEntity;
	}

	@Override
	public DeleteCredentialResMsgEntity mapDeleteCredentialResponseMessageEntity(Result result, Status badRequest) {
		DeleteCredentialResMsgEntity deleteCredentialResponseMessageEntity=new DeleteCredentialResMsgEntity();
		deleteCredentialResponseMessageEntity.setResultStatus(result.getResultStatus());
		deleteCredentialResponseMessageEntity.setResultMessages(result.getResultMessages());
		deleteCredentialResponseMessageEntity.setHttpStatus(badRequest);
		return deleteCredentialResponseMessageEntity;
	}

	@Override
	public DeleteCredentialResMsgEntity mapDeleteCredentialResponseMessageEntity(Result result,DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
		DeleteCredentialResMsgEntity deleteCredentialResponseMessageEntity=new DeleteCredentialResMsgEntity();
		deleteCredentialResponseMessageEntity.setResultStatus(result.getResultStatus());
		deleteCredentialResponseMessageEntity.setResultMessages(result.getResultMessages());
		deleteCredentialResponseMessageEntity.setHttpStatus(Status.OK);		
		if (deleteCredentialResponseMessageEntity.getHttpStatus() == null) {
			if (result.getResultStatus() == ResultStatus.SUCCESS)
				deleteCredentialResponseMessageEntity.setHttpStatus(Status.OK);
			else
				deleteCredentialResponseMessageEntity.setHttpStatus(Status.FORBIDDEN);
		}
		else
		{
			deleteCredentialResponseMessageEntity.setHttpStatus(deleteCredentialResponseMessageEntity.getHttpStatus());
		}
		return deleteCredentialResponseMessageEntity;
	}

}
