/**
 * 
 */
package seahorse.internal.business.coldfishservice.common.datacontracts;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

/**
 * @author sajanmje
 *
 */
public class ResultMessageEntity  {

	private ResultStatus resultStatus;
	private List<ResultMessage> resultMessages;
	private Response.Status httpstatus;

	public Response.Status GetHttpStatus() {
		return httpstatus;
	}

	public void SetHttpStatus(Response.Status _httpstatus) {
		this.httpstatus = _httpstatus;
	}

	public ResultStatus GetResultStatus() {
		return resultStatus;
	}

	public void SetResultStatus(ResultStatus _resultStatus) {
		this.resultStatus = _resultStatus;
	}

	/**
	 * @return the _resultMessages
	 */
	public List<ResultMessage> GetResultMessages() {
		return resultMessages;
	}

	/**
	 * @param _resultMessages
	 *            the _resultMessages to set
	 */
	public void SetResultMessages(List<ResultMessage> _resultMessages) {
		this.resultMessages = _resultMessages;
	}

	/**
	 * @param resultMessages
	 *            the _resultMessages to set
	 */
	public void SetResultMessages(ResultMessage _resultMessage) {
		if (this.resultMessages == null) {
			this.resultMessages = new ArrayList<>();
		}
		this.resultMessages.add(_resultMessage);
	}

}
