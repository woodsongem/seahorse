/**
 * 
 */
package seahorse.internal.business.katavuccolservice.datacontracts;

import java.util.Map;

/**
 * @author admin
 *
 */
public class RequestMessageEntity extends BaseRequestMessageEntity {
	
	private Map<String, String> headers;
	private String httpMethod;
	private String ipAddress;
	
	/**
	 * @return the headers
	 */
	public Map<String, String> getHeaders() {
		return headers;
	}
	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	/**
	 * @return the httpMethod
	 */
	public String getHttpMethod() {
		return httpMethod;
	}
	/**
	 * @param httpMethod the httpMethod to set
	 */
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}
	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
}
