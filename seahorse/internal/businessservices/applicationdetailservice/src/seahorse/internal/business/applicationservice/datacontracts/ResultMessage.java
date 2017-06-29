/**
 * 
 */
package seahorse.internal.business.applicationservice.datacontracts;

/**
 * @author sajanmje
 *
 */
public class ResultMessage {
	
	private String _parameter;
	private String _errorCode;

	/**
	 * @return the _parameter
	 */
	public String get_parameter() {
		return _parameter;
	}

	/**
	 * @param _parameter the _parameter to set
	 */
	public void set_parameter(String _parameter) {
		this._parameter = _parameter;
	}

	/**
	 * @return the _errorCode
	 */
	public String get_errorCode() {
		return _errorCode;
	}

	/**
	 * @param _errorCode the _errorCode to set
	 */
	public void set_errorCode(String _errorCode) {
		this._errorCode = _errorCode;
	}

}
