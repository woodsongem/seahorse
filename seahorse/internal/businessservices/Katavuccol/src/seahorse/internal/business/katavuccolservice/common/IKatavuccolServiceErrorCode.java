/**
 * 
 */
package seahorse.internal.business.katavuccolservice.common;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceErrorCode {

	String internalError();
	String GetPasswordIsNullErrorCode();
}
