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
public class KatavuccolServiceErrorCode implements IKatavuccolServiceErrorCode {

	@Context
	private HttpServletRequest httpRequest;
	private String passwordIsNullErrorCode="Katavuccol.API.CreateCredentials.{0}.Password.Empty";
	
	@Override
	public String internalError() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String GetPasswordIsNullErrorCode(String httpsMethod)
	{
		String httpMethod= httpRequest.getMethod();
		return passwordIsNullErrorCode;                                                   
	}
}
