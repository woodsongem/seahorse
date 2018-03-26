/**
 * 
 */
package seahorse.internal.business.katavuccolservice;


import java.util.List;

import seahorse.internal.business.katavuccolservice.api.datacontracts.Credential;
import seahorse.internal.business.katavuccolservice.api.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolService {

	CredentialResponseMessageEntity createCredential(CredentialRequestMessageEntity credentialRequestMessageEntity);

	List<Credential> getCredentials(GetCredentialMessageEntity getCredentialMessageEntity);

	UpdateCredentialResponseMessageEntity updateCredential(UpdateCredentialRequestMessageEntity updateCredentialMessageEntity);

	DeleteCredentialResponseMessageEntity deleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);
}
