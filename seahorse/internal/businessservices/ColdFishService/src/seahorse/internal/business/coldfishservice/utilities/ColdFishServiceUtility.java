/**
 * 
 */

package seahorse.internal.business.coldfishservice.utilities;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessage;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;

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

	public static <E extends Enum<E>> boolean isInEnum(String value, Class<E> enumClass) {
		  for (E e : enumClass.getEnumConstants()) {
		    if(e.name().equalsIgnoreCase(value)) { return true; }
		  }
		  return false;
		}
	
	public static Date getCurrentDateTimeUTC()
	{
		ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
		return Date.from(utc.toInstant());		
	}	
}
