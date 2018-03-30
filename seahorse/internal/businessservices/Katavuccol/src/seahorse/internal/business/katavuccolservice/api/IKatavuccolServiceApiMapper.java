/**
 * 
 */
package seahorse.internal.business.katavuccolservice.api;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.Credential;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.api.datacontracts.DeleteCredentialResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.UpdateCredentialRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.UpdateCredentialResponse;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialsMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceApiMapper {	

	CredentialResponse mapCredentialsResponse(CredentialResponseMessageEntity credentialsResMessageEntity);

	CredentialRequestMessageEntity mapCredentialRequestMessageEntity(CredentialRequest credentialRequest,String userid, HttpServletRequest httpRequest);

	GetCredentialMessageEntity mapGetCredentialMessageEntity(String userid, HttpServletRequest httpRequest);

	List<Credential> mapCredential(GetCredentialsMessageEntity getCredentialsMessageEntity);

	CredentialResponse mapCredentialsResponse(CredentialResponseMessageEntity credentialsResMessageEntity, CredentialRequestMessageEntity credentialMessageEntity);

	UpdateCredentialMessageEntity mapUpdateCredentialRequestMessageEntity(
			UpdateCredentialRequest updateCredentialRequest, String userid, String credentialId,
			HttpServletRequest httpRequest);

	UpdateCredentialResponse mapUpdateCredentialResponse(UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity,
			UpdateCredentialMessageEntity updateCredentialMessageEntity);

	DeleteCredentialRequestMessageEntity mapDeleteCredentialRequestMessageEntity(String userid, String credentialId,
			HttpServletRequest httpRequest);

	DeleteCredentialResponse mapDeleteCredentialResponse(DeleteCredentialResponseMessageEntity deleteCredentialResponseMessageEntity,
			DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);

}
