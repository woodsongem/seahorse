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
public interface ICredentialServiceRepository {

	List<CredentialDAO> getCredentialByUserId(UUID parsedUserId);

	OutPutResponse createCredential(CreateCredentialRequestMessageEntity credentialRequestMessageEntity);

	OutPutResponse updateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity);

	CredentialDAO getCredentialById(DeleteCredentialMessageEntity deleteCredentialMessageEntity);

	OutPutResponse deleteCredential(DeleteCredentialMessageEntity deleteCredentialMessageEntity);

}
