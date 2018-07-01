/**
 * 
 */
package seahorse.internal.business.katavuccolservice.common.datacontracts;

import javax.ws.rs.core.Response;

/**
 * @author admin
 *
 */
public class ResponseBaseMsgEntity extends Result {
	private Response.Status httpStatus;

	/**
	 * @return the httpStatus
	 */
	public Response.Status getHttpStatus() {
		return httpStatus;
	}

	/**
	 * @param httpStatus the httpStatus to set
	 */
	public void setHttpStatus(Response.Status httpStatus) {
		this.httpStatus = httpStatus;
	}

	

}
