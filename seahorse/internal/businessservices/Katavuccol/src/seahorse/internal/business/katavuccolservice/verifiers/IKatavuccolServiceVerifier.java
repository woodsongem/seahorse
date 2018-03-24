/**
 * 
 */
package seahorse.internal.business.katavuccolservice.verifiers;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceVerifier {

	Result verifyCreateCredentials(CredentialRequestMessageEntity credentialRequestMessageEntity);
	
	Result isCredentialTypeIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity);
	
	Result isCategoryIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity);
	
	Result isUserIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity);
	
	Result isCredentialTypeSubItemAllowedValid(CredentialRequestMessageEntity credentialRequestMessageEntity);

	Result isCredentialTypeDuplicateAllowedValid(CredentialRequestMessageEntity credentialRequestMessageEntity);

	Result verifyGetCredentials(GetCredentialMessageEntity getCredentialMessageEntity);
	
	Result isUserIdValid(GetCredentialMessageEntity getCredentialMessageEntity);
	
	Result isCredentialValid(GetCredentialMessageEntity getCredentialMessageEntity);
}
