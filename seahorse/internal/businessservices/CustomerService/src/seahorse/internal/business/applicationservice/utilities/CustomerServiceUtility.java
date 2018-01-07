/**
 * 
 */
package seahorse.internal.business.applicationservice.utilities;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.customerservice.datacontracts.LoginResponseMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultMessage;
import seahorse.internal.business.customerservice.datacontracts.ResultMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultStatus;

/**
 * @author sajanmje
 *
 */
public class CustomerServiceUtility {

	private CustomerServiceUtility() {

	}

	public static String GetResultMessageEntityLogString(ResultMessageEntity result) {
		if (result == null)
			return null;

		StringBuilder sb = new StringBuilder();
		sb.append("ResultStatus=" + result.GetResultStatus() + " ");
		List<ResultMessage> resultMessages = result.GetResultMessages();
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

	public static ResultMessage GetResultMessage(String errorCode, String parameter) {
		ResultMessage resultMessage = new ResultMessage();
		if (errorCode != null)
			resultMessage.setErrorCode(errorCode);
		if (parameter != null)
			resultMessage.setParameter(parameter);
		return resultMessage;
	}

	public static ResultMessageEntity GetResultMessageEntity(String errorCode, String parameter,ResultStatus resultStatus) {
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		resultMessageEntity.SetResultStatus(resultStatus);
		if(errorCode != null || parameter != null ){
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(errorCode);
			resultMessage.setParameter(parameter);
			resultMessageEntity.SetResultMessages(resultMessage);
		}		
		return resultMessageEntity;
	}

	public static LoginResponseMessageEntity GetApplicationDetailMessageEntity(ResultMessageEntity resultMessageEntity,Status httpStatus) {
		LoginResponseMessageEntity loginResponseMessageEntity = new LoginResponseMessageEntity();
		loginResponseMessageEntity.SetHttpStatus(httpStatus);
		if (resultMessageEntity == null) {
			loginResponseMessageEntity.SetResultStatus(ResultStatus.Error);
			return loginResponseMessageEntity;
		}

		loginResponseMessageEntity.SetResultStatus(resultMessageEntity.GetResultStatus());
		loginResponseMessageEntity.SetResultMessages(resultMessageEntity.GetResultMessages());

		return loginResponseMessageEntity;
	}
	
	public static String GetCurrentDateTimeUTC()
	{
		ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
		return utc.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
	}
}
