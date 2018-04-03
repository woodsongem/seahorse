/**
 * 
 */
package seahorse.internal.business.katavuccolservice.common;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceErrorCode {

	String updateCredentialInValidUserIdErrorCode();
	String internalError();
	String getPasswordIsNullErrorCode();
	String inCategoryIdInValidErrorCode();
	String inTypeIdInValidErrorCode();
	String inValueEmptyErrorCode();
	String categoryIdEmptyErrorCode();
	String categoryIdNotFoundErrorCode();
	String categoryTypeIdNotFoundErrorCode();
	String categoryTypeIdExcitedMultipleErrorCode();
	String categoryTypeDuplicateNotAllowedErrorCode();
	String parentIdInValidErrorCode();
	String categoryTypeSubEntryNotAllowedErrorCode();
	String parentIdNotFoundErrorCode();
	String credentialSubEntryNotAllowedErrorCode();
	String credentialSubEntryExceedLimitationErrorCode();
	String getCredentialMessageEntityEmptyErrorCode();
	String deleteCredentialRequestMessageEntityIsEmptyErrorCode();
	String userIdEmptyErrorCode();
	String credentialIdEmptyErrorCode();
	String credentialIdInValidErrorCode();
	String credentialIdNotFoundErrorCode();
	String updateCredentialMessageEntityIsEmptyErrorCode();
	String updateCredentialEmptyUserIdErrorCode();
	String deleteCredentialEmptyUserIdErrorCode();
	String deleteCredentialInValidUserIdErrorCode();
	String getCredentialEmptyUserIdErrorCode();
	String getCredentialInValidUserIdErrorCode();
	String createCredentialEmptyUserIdErrorCode();
	String createCredentialInValidUserIdErrorCode();
	String updateCategoryIdEmptyErrorCode();
	String updateCategoryIdInValidErrorCode();
	String updateCategoryTypeIdEmptyErrorCode();
	String updateCategoryTypeIdInValidErrorCode();
	String updateCategoryTypeIdNotFoundErrorCode();
	String updateCategoryIdNotFoundErrorCode();	
}
