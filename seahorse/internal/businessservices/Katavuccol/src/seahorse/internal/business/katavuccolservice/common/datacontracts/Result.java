/**
 * 
 */
package seahorse.internal.business.katavuccolservice.common.datacontracts;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response.Status;

/**
 * @author sajanmje
 *
 */
public class Result {
	
	private ResultStatus resultStatus;
	private List<ResultMessage> resultMessages;
	private Status httpStatus;
	
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

	public void setResultMessage(ResultMessage resultMessage) {
		if(resultMessages ==null || resultMessages.isEmpty())
		{
			resultMessages=new ArrayList<>();			
		}
		resultMessages.add(resultMessage);
	}

	/**
	 * @return the httpStatus
	 */
	public Status getHttpStatus() {
		return httpStatus;
	}

	/**
	 * @param httpStatus the httpStatus to set
	 */
	public void setHttpStatus(Status httpStatus) {
		this.httpStatus = httpStatus;
	}	
}
