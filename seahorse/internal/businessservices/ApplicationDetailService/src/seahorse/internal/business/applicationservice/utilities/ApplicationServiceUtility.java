/**
 * 
 */
package seahorse.internal.business.applicationservice.utilities;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.applicationservice.common.datacontracts.PhoneType;
import seahorse.internal.business.applicationservice.datacontracts.ApplicationDetailMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.ResultMessage;
import seahorse.internal.business.applicationservice.datacontracts.ResultMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.ResultStatus;

/**
 * @author sajanmje
 *
 */
public class ApplicationServiceUtility {
	
	private ApplicationServiceUtility()
	{
		
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
			sb.append("ErrorCode=" + resultMessage.get_errorCode() + " ");
			sb.append("Parameter" + resultMessage.get_parameter() + " ");
			sb.append(" ]");
		}
		sb.append(" ]");
		return sb.toString();
	}

	public static ResultMessage GetResultMessage(String errorCode, String parameter) {
		ResultMessage resultMessage = new ResultMessage();
		if (errorCode != null)
			resultMessage.set_errorCode(errorCode);
		if (parameter != null)
			resultMessage.set_parameter(parameter);
		return resultMessage;
	}

	public static ApplicationDetailMessageEntity GetApplicationDetailMessageEntity(ResultMessageEntity resultMessageEntity,Status httpStatus) {
		ApplicationDetailMessageEntity applicationDetailMessageEntity = new ApplicationDetailMessageEntity();
		applicationDetailMessageEntity.SetHttpStatus(httpStatus);
		if (resultMessageEntity == null) {
			applicationDetailMessageEntity.SetResultStatus(ResultStatus.Error);
			return applicationDetailMessageEntity;
		}
		
		applicationDetailMessageEntity.SetResultStatus(resultMessageEntity.GetResultStatus());
		applicationDetailMessageEntity.SetResultMessages(resultMessageEntity.GetResultMessages());

		return applicationDetailMessageEntity;

	}

    public static Boolean TryPhoneTypeParse(String value)
    {    	
		try {
			if (value == null) {
				return false;
			}

			PhoneType fPhoneType = PhoneType.valueOf(value);

		} catch (Exception ex) {
			return false;
		}
		return true;
    }
}
