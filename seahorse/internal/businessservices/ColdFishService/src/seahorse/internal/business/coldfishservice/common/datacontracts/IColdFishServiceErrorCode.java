/**
 * 
 */
package seahorse.internal.business.coldfishservice.common.datacontracts;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceErrorCode {
	
	String incomeTypeNotFound();

	String emptyIncomeTypeId();

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

	String emptyIncomeDetailMessageEntityErrorCode();

	String inValidIncomeTypeIdErrorCode();

	String zeroAmountErrorCode();

	String negativeAmountErrorCode();

	String emptyGetincomeDetailMessageEntityErrorCode();

	String emptyIncomeCategoryMessageEntityErrorCode();

	String duplicateIncomeCategoryInDefault();

	String duplicateIncomeCategory();

	String emptyIncomeCategoryIdErrorCode();

	String inValidIncomeCategoryIdErrorCode();

	String incomeCategoryIdNotFound();

	String incomeCategoryIdNotActiveStatus();

	String emptyIncomeMonthMessageEntityErrorCode();

	String invalidIncomeMonthMessageEntityErrorCode();

	String invalidIncomeYearMessageEntityErrorCode();

	String moreThanOneUserIdErrorCode();
}
