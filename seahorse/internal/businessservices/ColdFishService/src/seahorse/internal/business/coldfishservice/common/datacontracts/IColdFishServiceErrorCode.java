/**
 * 
 */
package seahorse.internal.business.coldfishservice.common.datacontracts;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceErrorCode {
	
	String duplicateIncomeTypeInDefault();

	String internalError() ;

	String emptyIncomeTypeMessageEntityErrorCode();

	String emptyNameErrorCode();

	String emptyUseridErrorCode();

	String inValidUserIdErrorCode();

	String emptyDescriptionErrorCode();

	String duplicateIncomeType();

	String emptyCategoryErrorCode();

	String inValidCategoryErrorCode();

	String emptyGetIncomeTypeMessageEntityErrorCode();
}
