/**
 * 
 */
package seahorse.internal.business.katavuccolservice.common.datacontracts;

import java.util.List;

/**
 * @author sajanmje
 *
 */
public class Result {
	
	private ResultStatus resultStatus;
	private List<ResultMessage> resultMessages;

	
	public Result()
	{
		
	}
	
	public Result(ResultStatus resultStatus)
	{
		this.resultStatus=resultStatus;
	}

	
	/**
	 * @return the resultStatus
	 */
	public ResultStatus getResultStatus() {
		return resultStatus;
	}

	/**
	 * @param resultStatus the resultStatus to set
	 */
	public void setResultStatus(ResultStatus resultStatus) {
		this.resultStatus = resultStatus;
	}

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
}
