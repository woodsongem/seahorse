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
}
