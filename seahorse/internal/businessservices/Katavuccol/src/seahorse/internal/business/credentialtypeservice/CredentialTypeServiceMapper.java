/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeResMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.DeleteCredentialTypeReqMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.DeleteCredentialTypeResMsgEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;

/**
 * @author admin
 *
 */
public class CredentialTypeServiceMapper implements ICredentialTypeServiceMapper {

	@Override
	public CredentialTypeDAO MapcredentialTypeDAO(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {
		CredentialTypeDAO credentialTypeDAO=new CredentialTypeDAO();
		credentialTypeDAO.setDescription(createCredentialTypeMsgEntity.getDescription());
		credentialTypeDAO.setId(createCredentialTypeMsgEntity.getId());
		credentialTypeDAO.setIsDuplicationAllowed(createCredentialTypeMsgEntity.getIsDuplicationAllowed());
		credentialTypeDAO.setIsSubitemAllowed(createCredentialTypeMsgEntity.getIsSubitemAllowed());
		credentialTypeDAO.setName(createCredentialTypeMsgEntity.getName());
		credentialTypeDAO.setStatus(createCredentialTypeMsgEntity.getStatus());
		credentialTypeDAO.setUserId(createCredentialTypeMsgEntity.getParsedUserId());
		credentialTypeDAO.setCreatedBy(createCredentialTypeMsgEntity.getCreatedBy());
		credentialTypeDAO.setCreatedDate(createCredentialTypeMsgEntity.getCreatedDate());
		return credentialTypeDAO;
	}

	@Override
	public CreateCredentialTypeResMsgEntity mapCreateCredentialTypeResMsgEntity(Result result,CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {
		CreateCredentialTypeResMsgEntity createCredentialTypeResMsgEntity=new CreateCredentialTypeResMsgEntity();
		createCredentialTypeResMsgEntity.setResultStatus(result.getResultStatus());
		createCredentialTypeResMsgEntity.setResultMessages(result.getResultMessages());
		createCredentialTypeResMsgEntity.setHttpStatus(Status.OK);	
		createCredentialTypeResMsgEntity.setId(createCredentialTypeMsgEntity.getId());
		if (createCredentialTypeMsgEntity.getHttpStatus() == null) {
			if (result.getResultStatus() == ResultStatus.SUCCESS)
				createCredentialTypeResMsgEntity.setHttpStatus(Status.OK);
			else
				createCredentialTypeResMsgEntity.setHttpStatus(Status.FORBIDDEN);
		}
		else
		{
			createCredentialTypeResMsgEntity.setHttpStatus(createCredentialTypeMsgEntity.getHttpStatus());
		}
		return createCredentialTypeResMsgEntity;
	}

	@Override
	public CreateCredentialTypeResMsgEntity mapCreateCredentialTypeResMsgEntity(Result result, Status badRequest) {
		CreateCredentialTypeResMsgEntity createCredentialTypeResMsgEntity=new CreateCredentialTypeResMsgEntity();
		createCredentialTypeResMsgEntity.setResultStatus(result.getResultStatus());
		createCredentialTypeResMsgEntity.setResultMessages(result.getResultMessages());
		createCredentialTypeResMsgEntity.setHttpStatus(badRequest);
		return createCredentialTypeResMsgEntity;
	}

	@Override
	public DeleteCredentialTypeResMsgEntity mapDeleteCredentialTypeResMsgEntity(Result result,Status badRequest) {
		DeleteCredentialTypeResMsgEntity deleteCredentialTypeResMsgEntity=new DeleteCredentialTypeResMsgEntity();
		deleteCredentialTypeResMsgEntity.setResultStatus(result.getResultStatus());
		deleteCredentialTypeResMsgEntity.setResultMessages(result.getResultMessages());
		deleteCredentialTypeResMsgEntity.setHttpStatus(badRequest);
		return deleteCredentialTypeResMsgEntity;
	}

	@Override
	public CredentialTypeDAO mapCredentialTypeDAO(DeleteCredentialTypeReqMsgEntity deleteCredentialTypeReqMsgEntity) {
		CredentialTypeDAO credentialTypeDAO=new CredentialTypeDAO();
		credentialTypeDAO.setUserId(deleteCredentialTypeReqMsgEntity.getParsedUserId());
		credentialTypeDAO.setId(deleteCredentialTypeReqMsgEntity.getParsedCredentialTypeId());
		credentialTypeDAO.setStatus(deleteCredentialTypeReqMsgEntity.getStatus());
		credentialTypeDAO.setModifiedBy(deleteCredentialTypeReqMsgEntity.getModifiedBy());
		credentialTypeDAO.setModifiedDate(deleteCredentialTypeReqMsgEntity.getModifiedDate());
		return credentialTypeDAO;
	}

	@Override
	public DeleteCredentialTypeResMsgEntity mapDeleteCredentialTypeResMsgEntity(Result result,DeleteCredentialTypeReqMsgEntity deleteCredentialTypeReqMsgEntity) {
		DeleteCredentialTypeResMsgEntity deleteCredentialTypeResMsgEntity=new DeleteCredentialTypeResMsgEntity();
		deleteCredentialTypeResMsgEntity.setResultStatus(result.getResultStatus());
		deleteCredentialTypeResMsgEntity.setResultMessages(result.getResultMessages());
		deleteCredentialTypeResMsgEntity.setHttpStatus(Status.OK);	
		if (deleteCredentialTypeReqMsgEntity.getHttpStatus() == null) {
			if (result.getResultStatus() == ResultStatus.SUCCESS)
				deleteCredentialTypeResMsgEntity.setHttpStatus(Status.OK);
			else
				deleteCredentialTypeResMsgEntity.setHttpStatus(Status.FORBIDDEN);
		}
		else
		{
			deleteCredentialTypeResMsgEntity.setHttpStatus(deleteCredentialTypeReqMsgEntity.getHttpStatus());
		}
		return deleteCredentialTypeResMsgEntity;
	}

}
