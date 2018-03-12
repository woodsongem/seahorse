/**
 * 
 */
package seahorse.internal.business.katavuccolservice.api;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.Credential;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialResponse;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialsMessageEntity;

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

}
