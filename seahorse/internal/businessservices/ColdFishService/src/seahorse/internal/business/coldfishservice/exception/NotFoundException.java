/**
 * 
 */
package seahorse.internal.business.coldfishservice.exception;

/**
 * @author sajanmje
 *
 */
public class NotFoundException extends ApiException {

	private int code;

	public NotFoundException(int code, String msg) {
		super(code, msg);
		this.code = code;
	}

}
