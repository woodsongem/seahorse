/**
 * 
 */
package seahorse.internal.business.coldfishservice.common.datacontracts;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceErrorCode implements IColdFishServiceErrorCode {

	public String InternalError() {
		return GetErrorCodeMapping("InternalError");
	}
	
	private String GetErrorCodeMapping(String errorCode) {
		StringBuilder sb = new StringBuilder();
		sb.append("Seahorse.ColdFishAPI._httpmethod");
		sb.append("." + errorCode);
		return sb.toString();
	}

	@Override
	public String EmptyIncomeTypeMessageEntityErrorCode() {		
		return GetErrorCodeMapping("IncomeTypeMessageEntity.Empty");
	}

	@Override
	public String EmptyNameErrorCode() {
		return GetErrorCodeMapping("Name.Empty");
	}

	@Override
	public String EmptyUseridErrorCode() {
		return GetErrorCodeMapping("UserId.Empty");
	}

	@Override
	public String InValidUserIdErrorCode() {
		return GetErrorCodeMapping("UserId.InValid");
	}

	@Override
	public String EmptyDescriptionErrorCode() {
		return GetErrorCodeMapping("Description.Empty");
	}

	@Override
	public String DuplicateIncomeTypeInDefault() {
		return GetErrorCodeMapping("Name.AlreadyExist.Default");
	}

	@Override
	public String DuplicateIncomeType() {
		return GetErrorCodeMapping("Name.AlreadyExist");
	}
}
