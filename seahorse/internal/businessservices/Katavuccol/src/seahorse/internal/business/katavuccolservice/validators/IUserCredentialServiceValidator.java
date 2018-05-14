/**
 * 
 */
package seahorse.internal.business.katavuccolservice.validators;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.GetUserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IUserCredentialServiceValidator {

	Result validateGetUserCredential(GetUserCredentialMessageEntity getUserCredentialMessageEntity);

	Result isUserIdValid(GetUserCredentialMessageEntity getUserCredentialMessageEntity);

	Result isGetUserCredentialMessageEntityValid(GetUserCredentialMessageEntity getUserCredentialMessageEntity);
}
