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
}
