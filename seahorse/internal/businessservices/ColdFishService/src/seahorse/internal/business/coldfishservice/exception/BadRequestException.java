/**
 * 
 */
package seahorse.internal.business.coldfishservice.exception;

/**
 * @author sajanmje
 *
 */
public class BadRequestException extends ApiException {
	private int code;

	public BadRequestException(int code, String msg) {
		super(code, msg);
		this.code = code;
	}

}
