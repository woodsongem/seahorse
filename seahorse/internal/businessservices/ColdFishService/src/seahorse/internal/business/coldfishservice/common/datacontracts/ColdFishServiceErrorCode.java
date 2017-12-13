/**
 * 
 */
package seahorse.internal.business.coldfishservice.common.datacontracts;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceErrorCode implements IColdFishServiceErrorCode {

	public String internalError() {
		return getErrorCodeMapping("InternalError");
	}
	
	private String getErrorCodeMapping(String errorCode) {
		StringBuilder sb = new StringBuilder();
		sb.append("Seahorse.ColdFishAPI._httpmethod");
		sb.append("." + errorCode);
		return sb.toString();
	}

	@Override
	public String emptyIncomeTypeMessageEntityErrorCode() {		
		return getErrorCodeMapping("IncomeTypeMessageEntity.Empty");
	}

	@Override
	public String emptyNameErrorCode() {
		return getErrorCodeMapping("Name.Empty");
	}

	@Override
	public String emptyUseridErrorCode() {
		return getErrorCodeMapping("UserId.Empty");
	}

	@Override
	public String inValidUserIdErrorCode() {
		return getErrorCodeMapping("UserId.InValid");
	}

	@Override
	public String emptyDescriptionErrorCode() {
		return getErrorCodeMapping("Description.Empty");
	}

	@Override
	public String duplicateIncomeTypeInDefault() {
		return getErrorCodeMapping("Name.AlreadyExist.Default");
	}

	@Override
	public String duplicateIncomeType() {
		return getErrorCodeMapping("Name.AlreadyExist");
	}

	@Override
	public String emptyCategoryErrorCode() {
		return getErrorCodeMapping("Category.Empty");
	}

	@Override
	public String inValidCategoryErrorCode() {
		return getErrorCodeMapping("Category.InValid");
	}

	@Override
	public String emptyGetIncomeTypeMessageEntityErrorCode() {
		return getErrorCodeMapping("GetIncomeTypeMessageEntity.Empty");
	}

	@Override
	public String emptyIncomeDetailMessageEntityErrorCode() {
		return getErrorCodeMapping("IncomeDetailMessageEntity.Empty");
	}

	@Override
	public String emptyIncomeTypeId() {
		return getErrorCodeMapping("IncomeTypeId.Empty");
	}

	@Override
	public String inValidIncomeTypeIdErrorCode() {
		return getErrorCodeMapping("IncomeTypeId.InValid");
	}

	@Override
	public String zeroAmountErrorCode() {
		return getErrorCodeMapping("Amount.Zero");
	}

	@Override
	public String negativeAmountErrorCode() {
		return getErrorCodeMapping("Amount.Negative");
	}

	@Override
	public String emptyGetincomeDetailMessageEntityErrorCode() {
		return getErrorCodeMapping("GetincomeDetailMessageEntity.Empty");
	}

	@Override
	public String incomeTypeNotFound() {
		return getErrorCodeMapping("IncomeType.NotFound");
	}

	@Override
	public String emptyIncomeCategoryMessageEntityErrorCode() {
		return getErrorCodeMapping("IncomeCategoryMessageEntity.Empty");
	}

	@Override
	public String duplicateIncomeCategoryInDefault() {
		return getErrorCodeMapping("IncomeCategoryName.AlreadyExist.Default");
	}

	@Override
	public String duplicateIncomeCategory() {
		return getErrorCodeMapping("IncomeCategoryName.AlreadyExist");
	}

	@Override
	public String emptyIncomeCategoryIdErrorCode() {
		return getErrorCodeMapping("IncomeCategoryId.Empty");
	}

	@Override
	public String inValidIncomeCategoryIdErrorCode() {
		return getErrorCodeMapping("IncomeCategoryId.InValid");
	}

	@Override
	public String incomeCategoryIdNotFound() {
		return getErrorCodeMapping("IncomeCategoryId.NotFound");
	}

	@Override
	public String incomeCategoryIdNotActiveStatus() {
		return getErrorCodeMapping("IncomeCategoryId.NotActiveStatus");
	}

	@Override
	public String emptyIncomeMonthMessageEntityErrorCode() {
		return getErrorCodeMapping("IncomeMonth.Empty");
	}

	@Override
	public String invalidIncomeMonthMessageEntityErrorCode() {
		return getErrorCodeMapping("IncomeMonth.InValid");
	}

	@Override
	public String invalidIncomeYearMessageEntityErrorCode() {
		return getErrorCodeMapping("IncomeYear.InValid");
	}

	@Override
	public String moreThanOneUserIdErrorCode() {
		return getErrorCodeMapping("UserId.MoreThanOne");
	}
}
