/**
 * 
 */
package seahorse.internal.business.customerservice.datacontracts;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

/**
 * @author sajanmje
 *
 */
public class ResultMessageEntity  {

	private ResultStatus _resultStatus;
	private List<ResultMessage> _resultMessages;
	private Response.Status _httpstatus;

	public Response.Status GetHttpStatus() {
		return _httpstatus;
	}

	public void SetHttpStatus(Response.Status _httpstatus) {
		this._httpstatus = _httpstatus;
	}

	public ResultStatus GetResultStatus() {
		return _resultStatus;
	}

	public void SetResultStatus(ResultStatus _resultStatus) {
		this._resultStatus = _resultStatus;
	}

	/**
	 * @return the _resultMessages
	 */
	public List<ResultMessage> GetResultMessages() {
		return _resultMessages;
	}

	/**
	 * @param _resultMessages
	 *            the _resultMessages to set
	 */
	public void SetResultMessages(List<ResultMessage> _resultMessages) {
		this._resultMessages = _resultMessages;
	}

	/**
	 * @param _resultMessages
	 *            the _resultMessages to set
	 */
	public void SetResultMessages(ResultMessage _resultMessage) {
		if (this._resultMessages == null) {
			this._resultMessages = new ArrayList<>();
		}
		this._resultMessages.add(_resultMessage);
	}

}
