/**
 * 
 */
package seahorse.internal.business.coldfishservice.api.datacontracts;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 *
 */

public class ResponseBase extends Base {

	private List<ResultMessage> messages;


	/**
	 * @return the _resultMessage
	 */
	public List<ResultMessage> getResultMessage() {
		return messages;
	}

	/**
	 * @param _resultMessage
	 *            the _resultMessage to set
	 */
	public void setResultMessage(List<ResultMessage> resultMessages) {
		this.messages = resultMessages;
	}
	

	/**
	 * @param _resultMessage
	 *            the _resultMessage to set
	 */
	public void setResultMessages(ResultMessage resultMessage) {
		if (this.messages == null) {
			this.messages = new ArrayList<>();
		}
		this.messages.add(resultMessage);
	}

}
