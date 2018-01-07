/**
 * 
 */
package seahorse.internal.business.coldfishservice.common.datacontracts;

/**
 * @author sajanmje
 *
 */
public class ResultMessage {
	
	private String parameter;
	private String errorCode;

	/**
	 * @return the _parameter
	 */
	public String getParameter() {
		return parameter;
	}

	/**
	 * @param _parameter the _parameter to set
	 */
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	/**
	 * @return the _errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param _errorCode the _errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
