/**
 * 
 */
package seahorse.internal.business.katavuccolservice.verifiers;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.GetUserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IUserCredentialServiceVerifier {

	Result verifyGetUserCredential(GetUserCredentialMessageEntity getUserCredentialMessageEntity);

	Result isUserIdValid(GetUserCredentialMessageEntity getUserCredentialMessageEntity);
}
