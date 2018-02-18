/**
 * 
 */
package seahorse.internal.business.katavuccolservice.common.datacontracts;

/**
 * @author sajanmje
 *
 */
public class ResultMessage {

	private String parameter;
	private String errorCode;
	/**
	 * @return the parameter
	 */
	public String getParameter() {
		return parameter;
	}
	/**
	 * @param parameter the parameter to set
	 */
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
