/**
 * 
 */
package seahorse.internal.business.katavuccolservice.common;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceErrorCode {

	String CredentialTypeByUserIdMsgEntityIsEmpty();
	String createCredentialUserEncryptKeySmall();
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
	String updateCredentialIdNotFoundErrorCode();
	String updateCredentialIdEmptyErrorCode();
	String updateCredentialIdInValidErrorCode();
	String credentialTypeMessageEntityIsEmptyErrorCode();
	String credentialTypeNameIsEmptyErrorCode();
	String nameDuplicatedNotAllowed();
	String createCategoryRequestMessageEntityIsEmptyErrorCode();
	String createCategoryEmptyUserIdErrorCode();
	String createCategoryInValidUserIdErrorCode();
	String categoryNameDuplicateErrorCode();
	String deleteCategoryInValidUserIdErrorCode();
	String deleteCategoryEmptyUserIdErrorCode();
	String deleteCategoryRequestMessageEntityIsEmptyErrorCode();
	String deleteCategoryIdEmptyErrorCode();
	String deleteCategoryIdInValidErrorCode();
	String deleteCategoryIdNotFoundErrorCode();
	String createCredentialTypeMsgEntityIsEmpty();
	String createCategoryNameIsEmptyErrorCode();
	String getCategoryMessageEntityIsEmptyErrorCode();
	String getCategoryEmptyUserIdErrorCode();
	String getCategoryInValidUserIdErrorCode();
	String updateCategoryEmptyUserIdErrorCode();
	String updateCategoryInValidUserIdErrorCode();
	String updateCategoryMessageEntityIsEmptyErrorCode();
	String updateCredentialCategoryIdEmptyErrorCode();
	String updateCategoryInCategoryIdInValidErrorCode();
	String updateCategoryIdNotFoundErrorCode();
	String updateCategoryNameDuplicateErrorCode();
	String getCredentialKeyisSmallErrorCode();
	String getCredentialValueInValidUserIdErrorCode();
	String getCredentialValueEmptyUserIdErrorCode();
	String getCredentialValueCategoryIdEmptyErrorCode();
	String getCredentialValueCategoryIdInValidErrorCode();
	String getCredentialValueMessageEntityIsEmptyErrorCode();
	String getCredentialValueCategoryIdNotFoundErrorCode();
	String getCredentialValueCredentialNotFoundErrorCode();
	String getCredentialValueCredentialIdEmptyErrorCode();
	String getCredentialValueCredentialIdInValidErrorCode();
	String createCredentialEncryptErrorCode();
	String createCredentialUserEncryptKeyLong();
	String getCredentialUserEncryptKeySmall();
	String getCredentialUserEncryptKeyLong();
	String createCredentialUserIdNotFoundErrorCode();
	String userIdIsEmpty();	
	String userIdInValidFormat();
	String userIdNotFound();
	String NameIsEmpty();	
}
