/**
 * 
 */
package seahorse.internal.business.credentialservice;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.credentialservice.dal.datacontracts.CredentialDAO;
import seahorse.internal.business.credentialservice.datacontracts.CreateCredentialRequestMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.DeleteCredentialMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.OutPutResponse;

/**
 * @author SMJE
 *
 */
public class CredentialServiceRepository implements ICredentialServiceRepository {

	@Override
	public List<CredentialDAO> getCredentialByUserId(UUID parsedUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutPutResponse createCredential(CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutPutResponse updateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CredentialDAO getCredentialById(DeleteCredentialMessageEntity deleteCredentialMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutPutResponse deleteCredential(DeleteCredentialMessageEntity deleteCredentialMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
