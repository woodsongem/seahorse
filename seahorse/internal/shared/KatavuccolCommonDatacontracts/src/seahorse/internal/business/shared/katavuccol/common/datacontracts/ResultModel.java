/**
 * 
 */
package seahorse.internal.business.shared.katavuccol.common.datacontracts;

import java.util.List;

/**
 * @author SMJE
 *
 */
public class ResultModel {

	private String status;
	private List<String> errorCode;
	
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the errorCode
	 */
	public List<String> getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(List<String> errorCode) {
		this.errorCode = errorCode;
	}
}
