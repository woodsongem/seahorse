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

	private String passwordIsNullErrorCode="Katavuccol.API.CreateCredentials.{0}.Password.Empty";
	private String passwordIsToShortErrorCode="Katavuccol.API.CreateCredentials.{0}.Password.ToShort";
	private String passwordIsToLongErrorCode="Katavuccol.API.CreateCredentials.{0}.Password.ToLong";
	
	@Context
	private HttpServletRequest httpRequest;
	
	@Override
	public String internalError() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String GetPasswordIsNullErrorCode()
	{		
		return passwordIsNullErrorCode;                                                   
	}
	
	public String GetPasswordIsToShortErrorCode(String httpsMethod)
	{		
		return passwordIsToShortErrorCode;                                                   
	}
	
	public String GetPasswordIsToLongErrorCode(String httpsMethod)
	{		
		return passwordIsToLongErrorCode;                                                   
	}
}
