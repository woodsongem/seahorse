/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceMapper {

	CredentialsResponseMessageEntity mapCredentialsResponseMessageEntity(Result result, Status badRequest);

	CredentialsResponseMessageEntity mapCredentialsResponseMessageEntity(Result result,CredentialsRequestMessageEntity credentialsRequestMessageEntity);

}
