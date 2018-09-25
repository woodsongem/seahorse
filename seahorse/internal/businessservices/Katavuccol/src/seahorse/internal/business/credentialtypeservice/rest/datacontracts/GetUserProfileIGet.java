/**
 * 
 */
package seahorse.internal.business.credentialtypeservice.rest.datacontracts;

import java.util.Map;

import seahorse.internal.business.shared.aop.datacontracts.IGet;

/**
 * @author SMJE
 *
 */
public class GetUserProfileIGet implements IGet {

	private String endpointName;
	private Map<String, String> headers;
	private String userId;

	@Override
	public void setEndpoint(String endpointName) {
		this.endpointName = endpointName;
	}

	@Override
	public String getEndpoint() {
		return endpointName;
	}

	@Override
	public String getUrl() {
		return "profileservice/profile/" + this.getUserId();
	}

	@Override
	public Map<String, String> getHeaders() {
		return headers;
	}

	@Override
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
