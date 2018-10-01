package seahorse.internal.business.shared.katavuccol.common;
/**
 * 
 */

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import com.datastax.driver.core.LocalDate;
import com.google.gson.Gson;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.*;

/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceUtility {

	private KatavuccolServiceUtility() {
		throw new IllegalAccessError("KatavuccolServiceUtility class");
	}

	public static boolean isNullOrEmpty(String s) {
		return s == null || s.length() == 0;
	}

	public static boolean isNullOrWhitespace(String s) {
		return s == null || isWhitespace(s);

	}

	private static boolean isWhitespace(String s) {
		int length = s.length();
		if (length > 0) {
			for (int i = 0; i < length; i++) {
				if (!Character.isWhitespace(s.charAt(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public static Result getResult(ResultStatus resultStatus, String errorMsg, String parameters, String errorCode) {
		Result result = new Result();
		result.setResultStatus(resultStatus);
		if (StringUtils.isEmpty(errorCode)) {
			return result;
		}
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(errorCode);
		resultMessage.setErrorMsg(errorMsg);
		resultMessage.setParameter(parameters);
		result.setResultMessage(resultMessage);
		return result;
	}

	public static Result getResult(ResultStatus resultStatus, String parameters, String errorCode) {
		Result result = new Result();
		result.setResultStatus(resultStatus);
		if (StringUtils.isEmpty(errorCode)) {
			return result;
		}
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(errorCode);
		resultMessage.setParameter(parameters);
		result.setResultMessage(resultMessage);
		return result;
	}

	public static <E extends Enum<E>> boolean isInEnum(String value, Class<E> enumClass) {
		for (E e : enumClass.getEnumConstants()) {
			if (e.name().equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

	public static Date getCurrentDateTimeUTC() {
		ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
		return Date.from(utc.toInstant());
	}

	public static LocalDate getCurrentDate() {
		Date date = new Date();
		return LocalDate.fromMillisSinceEpoch(date.getTime());
	}

	public static boolean isValidUUID(String uuid) {
		if (uuid == null) {
			return false;
		}
		try {
			UUID.fromString(uuid);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean isValidUUID(UUID uuid) {
		if (uuid == null) {
			return false;
		}
		try {
			String stringUUID = uuid.toString();
			if (StringUtils.isBlank(stringUUID)) {
				return false;
			}
			UUID.fromString(stringUUID);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static ResultMessageEntity getResultMessageEntity(String errorCode, String parameter,
			ResultStatus resultStatus) {
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		resultMessageEntity.setResultStatus(resultStatus);
		if (errorCode != null || parameter != null) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(errorCode);
			resultMessage.setParameter(parameter);
			resultMessageEntity.setResultMessages(resultMessage);
		}
		return resultMessageEntity;
	}

	public static ResultMessage getResultMessage(String errorCode, String parameter, ResultStatus resultStatus) {
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(errorCode);
		resultMessage.setParameter(parameter);
		return resultMessage;
	}

	public static boolean isEqual(UUID source, UUID des) {
		if (source == null || des == null) {
			return false;
		}

		return source.equals(des);
	}

	public static boolean isEqual(String source, String des) {
		if (source == null || des == null) {
			return false;
		}

		return source.equals(des);
	}

	public static String getString(Object value) {
		Gson gson = new Gson();
		return gson.toJson(value);
	}
}
