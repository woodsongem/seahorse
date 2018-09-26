/**
 * 
 */
package seahorse.internal.business.shared.katavuccol.common.datacontracts;

import java.util.ArrayList;
import java.util.List;


/**
 * @author sajanmje
 *
 */
public class ResultMessageEntity  {

	private ResultStatus resultStatus;
	private List<ResultMessage> resultMessages;

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
