/**
 * 
 */
package seahorse.internal.business.customerservice.api.datacontracts;

import java.util.List;

/**
 * @author admin
 *
 */
public class ResponseBase {

	private  List<ResultMessage> _resultMessage;

	/**
	 * @return the _resultMessage
	 */
	public List<ResultMessage> getresultMessage() {
		return _resultMessage;
	}

	/**
	 * @param _resultMessage the _resultMessage to set
	 */
	public void setresultMessage(List<ResultMessage> _resultMessage) {
		this._resultMessage = _resultMessage;
	}
}
