/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.katavuccolservice.api.datacontracts.Credential;
import seahorse.internal.business.katavuccolservice.api.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialsMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.utilities.KatavuccolServiceUtility;

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

	@Override
	public GetCredentialsMessageEntity mapGetCredentialsMessageEntity(Result result, Status badRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Credential> mapCredentials(Result result, GetCredentialMessageEntity getCredentialMessageEntity) {
		List<Credential> credentials=new ArrayList<>();
		
		if(getCredentialMessageEntity.getCredentialDAO() == null || getCredentialMessageEntity.getCredentialDAO().isEmpty())
		{
			return credentials;
		}
		
		for (CredentialDAO credentialDAO : getCredentialMessageEntity.getCredentialDAO()) {
			Credential credential=new Credential();
			credential.setCategoryId(KatavuccolServiceUtility.getString(credentialDAO.getCategoryId()));
			credential.setCreatedBy(KatavuccolServiceUtility.getString(credentialDAO.getCreatedBy()));
			credential.setCreatedDate(credentialDAO.getCreatedDate());
			credential.setCredentialTypeId(KatavuccolServiceUtility.getString(credentialDAO.getCredentialTypeId()));
			credential.setDescription(credentialDAO.getDescription());
			credential.setId(KatavuccolServiceUtility.getString(credentialDAO.getId()));
			credential.setModifiedBy(KatavuccolServiceUtility.getString(credentialDAO.getModifiedBy()));
			credential.setModifiedDate(credentialDAO.getModifiedDate());
			credential.setParentId(KatavuccolServiceUtility.getString(credentialDAO.getParentId()));
			credential.setStatus(credentialDAO.getStatus());
			credential.setUserId(KatavuccolServiceUtility.getString(credentialDAO.getUserId()));
			credentials.add(credential);
		}		
		return credentials;
	}

	@Override
	public DeleteCredentialResponseMessageEntity mapDeleteCredentialResponseMessageEntity(Result result,Status badRequest) {
		DeleteCredentialResponseMessageEntity deleteCredentialResponseMessageEntity=new DeleteCredentialResponseMessageEntity();
		deleteCredentialResponseMessageEntity.setResultStatus(result.getResultStatus());
		deleteCredentialResponseMessageEntity.setResultMessages(result.getResultMessages());
		deleteCredentialResponseMessageEntity.setHttpStatus(badRequest);
		return deleteCredentialResponseMessageEntity;
	}

	@Override
	public DeleteCredentialResponseMessageEntity mapDeleteCredentialResponseMessageEntity(Result result,DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
		DeleteCredentialResponseMessageEntity deleteCredentialResponseMessageEntity=new DeleteCredentialResponseMessageEntity();
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

	@Override
	public UpdateCredentialResponseMessageEntity mapUpdateCredentialResponseMessageEntity(Result result,
			Status badRequest) {
		UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity=new UpdateCredentialResponseMessageEntity();
		updateCredentialResponseMessageEntity.setResultStatus(result.getResultStatus());
		updateCredentialResponseMessageEntity.setResultMessages(result.getResultMessages());				
		if (updateCredentialResponseMessageEntity.getHttpStatus() == null) {
			if (result.getResultStatus() == ResultStatus.SUCCESS)
				updateCredentialResponseMessageEntity.setHttpStatus(Status.OK);
			else
				updateCredentialResponseMessageEntity.setHttpStatus(badRequest);
		}
		else
		{
			updateCredentialResponseMessageEntity.setHttpStatus(updateCredentialResponseMessageEntity.getHttpStatus());
		}
		return updateCredentialResponseMessageEntity;
	}

	@Override
	public UpdateCredentialResponseMessageEntity mapUpdateCredentialResponseMessageEntity(Result result,
			UpdateCredentialMessageEntity updateCredentialMessageEntity) {
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

}
