/**
 * 
 */
package seahorse.internal.business.coldfishservice.exception;

/**
 * @author sajanmje
 *
 */
public class ApiException extends Exception {
	
	private int code;

	public ApiException(int code, String msg) {
		super(msg);
		this.code = code;
	}
}
