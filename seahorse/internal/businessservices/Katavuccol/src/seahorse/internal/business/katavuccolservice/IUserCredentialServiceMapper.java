/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import java.util.UUID;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.GetUserCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IUserCredentialServiceMapper {

	UserCredentialMessageEntity mapUserCredentialMessageEntity(Result result,GetUserCredentialMessageEntity getUserCredentialMessageEntity);

	GetUserCredentialMessageEntity MapGetUserCredentialMessageEntity(UUID userId);

}
