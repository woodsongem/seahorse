/**
 * 
 */
package seahorse.internal.business.katavuccolservice.common;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceErrorCode {

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
}
