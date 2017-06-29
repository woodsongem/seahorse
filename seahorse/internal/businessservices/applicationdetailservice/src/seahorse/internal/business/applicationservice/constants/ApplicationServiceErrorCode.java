/**
 * 
 */
package seahorse.internal.business.applicationservice.constants;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;


import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author sajanmje
 *
 */
@Singleton
public class ApplicationServiceErrorCode  implements IApplicationServiceErrorCode{
	
	 // @Context
	 //private final HttpServletRequest httpRequest;
	  
/*	@Inject
	public ApplicationServiceErrorCode(@Context HttpServletRequest httpRequest)
	{
		this.httpRequest=httpRequest;
	}*/
	


	
	public String InValidApplicationIdErrorCode()
	{
	/*	String httpMethod=httpRequest.getMethod();
		if(httpMethod == null)
		{
			
		}*/
		return GetErrorCodeMapping("InValidApplicationId");
	}

	private static String GetErrorCodeMapping(String errorCode) {

		StringBuilder sb = new StringBuilder();
		sb.append("Seahorse.Application.API");
		//sb.append("." + httpRequest.);
		sb.append("." + errorCode);
		return sb.toString();
	}

}
