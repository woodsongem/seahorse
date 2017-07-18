/**
 * 
 */
package seahorse.internal.business.customerservice.api.datacontracts;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 *
 */
public class ResponseBase {

	private  List<ResultMessage> messages;
	private String status;

	/**
	 * @return the _resultMessage
	 */
	public List<ResultMessage> getresultMessage() {
		return messages;
	}

	/**
	 * @param _resultMessage the _resultMessage to set
	 */
	public void setresultMessage(List<ResultMessage> resultMessages) {
		this.messages = resultMessages;
	}

	/**
	 * @return the resultstatus
	 */
	public String getResultStatus() {
		return status;
	}

	/**
	 * @param resultstatus the resultstatus to set
	 */
	public void setResultStatus(String resultstatus) {
		this.status = resultstatus;
	}
	
	/**
	 * @param _resultMessage the _resultMessage to set
	 */
	public void setresultMessage(ResultMessage resultMessage) {
		if (this.messages == null) {
			this.messages = new ArrayList<>();
		}
		this.messages.add(resultMessage);
	}


	
}
