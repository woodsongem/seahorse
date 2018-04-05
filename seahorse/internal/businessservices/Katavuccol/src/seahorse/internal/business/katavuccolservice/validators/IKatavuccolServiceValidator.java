/**
 * 
 */
package seahorse.internal.business.katavuccolservice.validators;

import seahorse.internal.business.katavuccolservice.api.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;


/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceValidator {

	Result validateCreateCredentials(CredentialRequestMessageEntity credentialRequestMessageEntity);
	
	Result isCredentialsRequestMessageEntityValid(CredentialRequestMessageEntity credentialRequestMessageEntity);
	
	Result isUserIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity);
	
    Result isTypeIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity); 

	Result isCategoryIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity);
	
	Result isValueValid(CredentialRequestMessageEntity credentialRequestMessageEntity);
	
	Result isParentIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity);

	Result validateGetCredentials(GetCredentialMessageEntity getCredentialMessageEntity);
	
	Result isGetCredentialMessageEntityValid(GetCredentialMessageEntity getCredentialMessageEntity);
	
	Result isUserIdValid(GetCredentialMessageEntity getCredentialMessageEntity);

	Result validateDeleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);
	
	Result isCredentialIdValid(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);

	Result isUserIdValid(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);

	Result isDeleteCredentialRequestMessageEntityValid(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);

	Result validateUpdateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity);			

	Result isCategoryIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity); 

	Result isUserIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity); 

	Result isUpdateCredentialMessageEntityValid(UpdateCredentialMessageEntity updateCredentialMessageEntity); 
	
	Result isUserIdValid(String userId,String errorCode,String nullErrorCode);
	
	Result isCategoryTypeIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity);
	
	Result isCredentialIdValid(UpdateCredentialMessageEntity updateCredentialMessageEntity);
}
