/**
 * 
 */
package seahorse.internal.business.katavuccolservice.api;

import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialsRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialsResponse;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceApiMapper {

	CredentialsRequestMessageEntity mapCredentialsRequestMessageEntity(CredentialsRequest credentialsRequest,String userid);

	CredentialsResponse mapCredentialsResponse(CredentialsResponseMessageEntity credentialsResMessageEntity);

}
