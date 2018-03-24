/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.katavuccolservice.api.datacontracts.Credential;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialsMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceMapper {

	CredentialResponseMessageEntity mapCredentialResponseMessageEntity(Result result, Status badRequest);

	CredentialResponseMessageEntity mapCredentialResponseMessageEntity(Result result,CredentialRequestMessageEntity credentialRequestMessageEntity);

	GetCredentialsMessageEntity mapGetCredentialsMessageEntity(Result result, Status badRequest);

	List<Credential> mapCredentials(Result result, GetCredentialMessageEntity getCredentialMessageEntity);

}
