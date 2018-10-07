/**
 * 
 */
package seahorse.internal.business.openapi.usercredentialservice.rest.datacontracts;

import java.util.Map;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.IPost;

/**
 * @author SMJE
 *
 */
public class CreateUserCredentialIPost implements IPost {
	private String endPoint;
	private Object request;
	private Map<String, String> headers;

	@Override
	public String getEndPoint() {
		return endPoint;
	}

	@Override
	public Object getRequest() {
		return request;
	}

	/**
	 * @param endPoint the endPoint to set
	 */
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(Object request) {
		this.request = request;
	}

	@Override
	public String getUrl() {
		return "profile";
	}

	@Override
	public Map<String, String> getHeaders() {
		return headers;
	}

	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

}
