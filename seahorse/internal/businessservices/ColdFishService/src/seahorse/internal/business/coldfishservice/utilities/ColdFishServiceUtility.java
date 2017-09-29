/**
 * 
 */

package seahorse.internal.business.coldfishservice.utilities;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessage;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceUtility {

	private ColdFishServiceUtility() {

	}

	public static String getResultMessageEntityLogString(ResultMessageEntity result) {
		if (result == null)
			return null;

		StringBuilder sb = new StringBuilder();
		sb.append("ResultStatus=" + result.getResultStatus() + " ");
		List<ResultMessage> resultMessages = result.getResultMessages();
		if (resultMessages == null)
			return sb.toString();
		sb.append(" ResultMessages=[ ");
		for (ResultMessage resultMessage : resultMessages) {
			sb.append(" ResultMessage=[ ");
			sb.append("ErrorCode=" + resultMessage.getErrorCode() + " ");
			sb.append("Parameter" + resultMessage.getParameter() + " ");
			sb.append(" ]");
		}
		sb.append(" ]");
		return sb.toString();
	}

	public static ResultMessage getResultMessage(String errorCode, String parameter) {
		ResultMessage resultMessage = new ResultMessage();
		if (errorCode != null)
			resultMessage.setErrorCode(errorCode);
		if (parameter != null)
			resultMessage.setParameter(parameter);
		return resultMessage;
	}

	public static ResultMessageEntity getResultMessageEntity(String errorCode, String parameter,ResultStatus resultStatus) {
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		resultMessageEntity.setResultStatus(resultStatus);
		if(errorCode != null || parameter != null ){
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(errorCode);
			resultMessage.setParameter(parameter);
			resultMessageEntity.setResultMessages(resultMessage);
		}		
		return resultMessageEntity;
	}


	
	public static String getCurrentDateTimeUTC()
	{
		ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
		return utc.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
	}

	public static IncomeTypeResponseMessageEntity getIncomeTypeResponseMessageEntity(
			ResultMessageEntity resultMessageEntity, Status badRequest) {

		return null;
	}
}
