/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.katavuccolservice.api.datacontracts.Credential;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialsMessageEntity;

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
			credential.setCategoryId(credentialDAO.getCategoryId().toString());
			credential.setCreatedBy(credentialDAO.getCreatedBy().toString());
			credential.setCreatedDate(credentialDAO.getCreatedDate());
			credential.setCredentialTypeId(credentialDAO.getCredentialTypeId().toString());
			credential.setDescription(credentialDAO.getDescription());
			credential.setId(credentialDAO.getId().toString());
			credential.setModifiedBy(credentialDAO.getModifiedBy().toString());
			credential.setModifiedDate(credentialDAO.getModifiedDate());
			credential.setParentId(credentialDAO.getParentId().toString());
			credential.setStatus(credentialDAO.getStatus());
			credential.setUserId(credentialDAO.getUserId().toString());
			credentials.add(credential);
		}		
		return credentials;
	}

}
