/**
 * 
 */
package seahorse.internal.business.coldfishservice.common.datacontracts;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceErrorCode {
	
	String DuplicateIncomeTypeInDefault();;

	String InternalError() ;

	String EmptyIncomeTypeMessageEntityErrorCode();

	String EmptyNameErrorCode();

	String EmptyUseridErrorCode();

	String InValidUserIdErrorCode();

	String EmptyDescriptionErrorCode();

	String DuplicateIncomeType();
}
