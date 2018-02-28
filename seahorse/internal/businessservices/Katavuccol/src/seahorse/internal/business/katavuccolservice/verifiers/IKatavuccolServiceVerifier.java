/**
 * 
 */
package seahorse.internal.business.katavuccolservice.verifiers;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceVerifier {

	Result verifyCreateCredentials(CredentialRequestMessageEntity credentialRequestMessageEntity);
	Result isTypeIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity);
	Result isCategoryIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity);
	Result isUserIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity);
}
