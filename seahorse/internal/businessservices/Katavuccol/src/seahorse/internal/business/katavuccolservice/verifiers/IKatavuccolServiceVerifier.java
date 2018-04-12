/**
 * 
 */
package seahorse.internal.business.katavuccolservice.verifiers;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;

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

	Result verifyDeleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);
	
	Result isCredentialIdValid(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);

	Result isUserIdValid(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);

	Result verifyUpdateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity);
	
	Result isCredentialTypeIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity);
	
	Result isCategoryIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity);

	Result isUserIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity);
	
	Result isCredentialIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity);

	Result verifyCreateCredentialType(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity);
	
	Result isUserIdValid(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity);
	
	Result isNameValid(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity);
}
