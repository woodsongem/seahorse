/**
 * 
 */

package seahorse.internal.business.customerservice.constants;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;


import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author sajanmje
 *
 */
@Singleton
public class CustomerServiceErrorCode  implements ICustomerServiceErrorCode{
	
	 // @Context
	 //private final HttpServletRequest httpRequest;
	  
/*	@Inject
	public ApplicationServiceErrorCode(@Context HttpServletRequest httpRequest)
	{
		this.httpRequest=httpRequest;
	}*/
	

	public String EmptyPasswordErrorCode()
	{
		return GetErrorCodeMapping("Password.Empty");
	}
	
	public String EmptyUserNameErrorCode()
	{
		return GetErrorCodeMapping("Username.Empty");
	}
	
	public String InValidLoginDetailMessageEntityErrorCode()
	{
	/*	String httpMethod=httpRequest.getMethod();
		if(httpMethod == null)
		{
			
		}*/
		return GetErrorCodeMapping("LoginDetailMessageEntity.Empty");
	}

	private static String GetErrorCodeMapping(String errorCode) {

		StringBuilder sb = new StringBuilder();
		sb.append("Seahorse.CustomerService.API");
		//sb.append("." + httpRequest.);
		sb.append("." + errorCode);
		return sb.toString();
	}

	@Override
	public String InValidUserNameErrorCode() {
		return GetErrorCodeMapping("InValidUsername");
	}

	@Override
	public String InValidPasswordErrorCode() {
		return GetErrorCodeMapping("InValidPassword");
	}	

}
