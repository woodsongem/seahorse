/**
 * 
 */
package seahorse.internal.business.katavuccolservice.common.datacontracts;

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

	public Response.Status getHttpStatus() {
		return httpstatus;
	}

	public void setHttpStatus(Response.Status httpstatus) {
		this.httpstatus = httpstatus;
	}

	public ResultStatus getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(ResultStatus resultStatus) {
		this.resultStatus = resultStatus;
	}

	/**
	 * @return the _resultMessages
	 */
	public List<ResultMessage> getResultMessages() {
		return resultMessages;
	}

	/**
	 * @param _resultMessages
	 *            the _resultMessages to set
	 */
	public void setResultMessages(List<ResultMessage> resultMessages) {
		this.resultMessages = resultMessages;
	}

	/**
	 * @param resultMessages
	 *            the _resultMessages to set
	 */
	public void setResultMessages(ResultMessage resultMessage) {
		if (this.resultMessages == null) {
			this.resultMessages = new ArrayList<>();
		}
		this.resultMessages.add(resultMessage);
	}

}
