/**
 * 
 */
package seahorse.internal.business.openapi.usercredentialservice.rest.datacontracts;

import java.util.Map;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.IGet;

/**
 * @author SMJE
 *
 */
public class GetUserProfileByUserNameIGet implements IGet {

	private String endPoint;
	private Map<String, String> headers;
	private String userName;

	@Override
	public String getEndPoint() {
		return endPoint;
	}

	/**
	 * @param endPoint the endPoint to set
	 */
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	@Override
	public String getUrl() {
		return "/profile/type=username&value=" + this.getUserName();
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
