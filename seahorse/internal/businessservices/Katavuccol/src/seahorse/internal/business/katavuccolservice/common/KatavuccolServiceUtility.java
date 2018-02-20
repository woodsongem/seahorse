package seahorse.internal.business.katavuccolservice.common;
/**
 * 
 */

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.datastax.driver.core.LocalDate;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultMessage;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;

/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceUtility {
	
	 private KatavuccolServiceUtility() {
		    throw new IllegalAccessError("SeahorseUtilities class");
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
		Result result=new Result();
		result.setResultStatus(resultStatus);
		ResultMessage resultMessage=new ResultMessage();
		resultMessage.setErrorCode(errorCode);
		resultMessage.setErrorMsg(errorMsg);
		resultMessage.setParameter(parameters);
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
	
	public static boolean isValidUUID(String uuid)
	{		
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
	public static boolean isValidUUID(UUID uuid)
	{		
		if (uuid == null) {
		 return false;
		}
		try {
			String stringUUID=uuid.toString();
			if(StringUtils.isBlank(stringUUID)) {
				return false;
			}
			UUID.fromString(stringUUID);
		} catch (Exception e) {
			return false;
		}
		return true;		
	}

}
