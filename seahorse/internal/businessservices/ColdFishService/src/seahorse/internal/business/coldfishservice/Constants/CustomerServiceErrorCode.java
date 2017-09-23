package seahorse.internal.business.coldfishservice.Constants;
/**
 * 
 */


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author sajanmje
 *
 */
@Singleton
public class CustomerServiceErrorCode implements ICustomerServiceErrorCode {

	// @Context
	// private final HttpServletRequest httpRequest;

	/*
	 * @Inject public ApplicationServiceErrorCode(@Context HttpServletRequest
	 * httpRequest) { this.httpRequest=httpRequest; }
	 */

	public String InternalError() {
		return GetErrorCodeMapping("InternalError");
	}
	
	public String InValidUsernameAndPassword() {
		return GetErrorCodeMapping("InValid.UsernameAndPassword");
	}

	public String EmptyPasswordErrorCode() {
		return GetErrorCodeMapping("Empty.Password");
	}

	public String EmptyUserNameErrorCode() {
		return GetErrorCodeMapping("Empty.Username");
	}

	public String InValidLoginDetailMessageEntityErrorCode() {
		/*
		 * String httpMethod=httpRequest.getMethod(); if(httpMethod == null) {
		 * 
		 * }
		 */
		return GetErrorCodeMapping("Empty.LoginDetailMessageEntity");
	}

	private String GetErrorCodeMapping(String errorCode) {

		StringBuilder sb = new StringBuilder();
		sb.append("Seahorse.CustomerServiceAPI._httpmethod");
		// sb.append("." + httpRequest.);
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
