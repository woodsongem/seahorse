/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceMapper {

	CredentialResponseMessageEntity mapCredentialResponseMessageEntity(Result result, Status badRequest);

	CredentialResponseMessageEntity mapCredentialResponseMessageEntity(Result result,CredentialRequestMessageEntity credentialRequestMessageEntity);

}
