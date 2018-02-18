/**
 * 
 */
package seahorse.internal.business.katavuccolservice.api.datacontracts;

import java.util.ArrayList;
import java.util.List;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultMessage;

/**
 * @author sajanmje
 *
 */
public class ResponseBase extends Base {
	private List<ResultMessage> resultMessages;

	/**
	 * @return the resultMessages
	 */
	public List<ResultMessage> getResultMessages() {
		return resultMessages;
	}

	/**
	 * @param resultMessages the resultMessages to set
	 */
	public void setResultMessages(List<ResultMessage> resultMessages) {
		this.resultMessages = resultMessages;
	}

	/**
	 * @param _resultMessage
	 *            the _resultMessage to set
	 */
	public void setResultMessages(ResultMessage resultMessage) {
		if (this.resultMessages == null) {
			this.resultMessages = new ArrayList<>();
		}
		this.resultMessages.add(resultMessage);
	}
}
