/**
 * 
 */
package seahorse.internal.business.katavuccolservice.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import seahorse.internal.business.katavuccolservice.api.datacontracts.Credential;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialsRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialsResponse;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialsMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceApiMapper {	

	CredentialsResponse mapCredentialsResponse(CredentialsResponseMessageEntity credentialsResMessageEntity);

	CredentialsRequestMessageEntity mapCredentialsRequestMessageEntity(CredentialsRequest credentialsRequest,String userid, HttpServletRequest httpRequest);

	GetCredentialMessageEntity mapGetCredentialMessageEntity(String userid, HttpServletRequest httpRequest);

	List<Credential> mapCredential(GetCredentialsMessageEntity getCredentialsMessageEntity);

}
