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
	private String categoryIdIsInValidErrorCode="Katavuccol.API.CreateCredentials.{0}.Category.InValid";
	private String typeIdIsInValidErrorCode="Katavuccol.API.CreateCredentials.{0}.TypeId.InValid";
	private String valueIsEmptyErrorCode="Katavuccol.API.CreateCredentials.{0}.Value.Empty";
	private String internalErrorErrorCode="Katavuccol.API.{0}.InternalError";
	
	@Context
	private HttpServletRequest httpRequest;
	
	@Override
	public String internalError() {		
		return internalErrorErrorCode;
	}
	
	public String getPasswordIsNullErrorCode()
	{		
		return passwordIsNullErrorCode;                                                   
	}
	
	public String getPasswordIsToShortErrorCode(String httpsMethod)
	{		
		return passwordIsToShortErrorCode;                                                   
	}
	
	public String getPasswordIsToLongErrorCode(String httpsMethod)
	{		
		return passwordIsToLongErrorCode;                                                   
	}

	@Override
	public String inCategoryIdInValidErrorCode() {		
		return categoryIdIsInValidErrorCode;
	}

	@Override
	public String inTypeIdInValidErrorCode() {		
		return typeIdIsInValidErrorCode;
	}

	@Override
	public String inValueEmptyErrorCode() {
		return valueIsEmptyErrorCode;
	}
}
