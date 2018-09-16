/**
 * 
 */
package seahorse.internal.business.credentialservice;

import java.util.List;

import com.google.api.client.auth.oauth2.Credential;

import seahorse.internal.business.credentialservice.datacontracts.CreateCredentialRequestMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.CreateCredentialResponseMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.DeleteCredentialResMsgEntity;
import seahorse.internal.business.credentialservice.datacontracts.GetCredentialByUserIdMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialValueDetail;

/**
 * @author admin
 *
 */
public interface ICredentialService {

	CredentialValueDetail getCredentialsByUserId(GetCredentialByUserIdMessageEntity getCredentialByUserIdMessageEntity);

	CreateCredentialResponseMessageEntity createCredential(CreateCredentialRequestMessageEntity credentialRequestMessageEntity);

	UpdateCredentialResponseMessageEntity updateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity);

	DeleteCredentialResMsgEntity deleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);

	List<Credential> getCredentialsByCategoryId(GetCredentialMessageEntity getCredentialMessageEntity);

}
