/**
 * 
 */

package seahorse.internal.business.katavuccolservice.utilities;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import com.datastax.driver.core.LocalDate;
import com.google.crypto.tink.Config;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.crypto.tink.daead.DeterministicAeadFactory;
import com.google.crypto.tink.daead.DeterministicAeadKeyTemplates;
import com.google.gson.Gson;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultMessage;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceUtility {

	private KatavuccolServiceUtility() {
		  throw new IllegalAccessError("KatavuccolServiceUtility class");
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
		if (errorCode != null || parameter != null) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(errorCode);
			resultMessage.setParameter(parameter);
			resultMessageEntity.setResultMessages(resultMessage);
		}
		return resultMessageEntity;
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

	
	public static boolean isEqual(UUID source, UUID des)
	{
		if(source == null || des == null)
		{
			return false;
		}
		
		return source.equals(des);
	}
	public static String getString(Object value)
	{
		Gson gson = new Gson();
		return gson.toJson(value);		
	}
	
	public static String getString(UUID value)
	{
		if(value ==null)
		{
			return null;
		}
		return value.toString();
	}
	public static boolean isEqual(String source, String des)
	{
		if(source == null || des == null)
		{
			return false;
		}
		
		return source.equals(des);
	}
	public static String encrypt(String key,String value)
	{
		String cp = null;
		
		try {
			DeterministicAeadConfig.init();
		    Config.register(DeterministicAeadConfig.TINK_1_1_0);
			KeysetHandle keysetHandle = KeysetHandle.generateNew(DeterministicAeadKeyTemplates.AES256_SIV);
			DeterministicAead daead = DeterministicAeadFactory.getPrimitive(keysetHandle);
			byte[] plaintext = null;
			byte[] associatedData=null;
			try {
				plaintext = value.getBytes("UTF-8");
				associatedData = key.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {				
			
			}
			
			byte[] ciphertext = daead.encryptDeterministically(plaintext, associatedData);
			cp = Arrays.toString(ciphertext);			
		} catch (GeneralSecurityException e) {
			
		}
	  return cp;
	}
	public static String decrypt(String key,String value)
	{
		String cp = null;
		
		try {
			DeterministicAeadConfig.init();
		    Config.register(DeterministicAeadConfig.TINK_1_1_0);
			KeysetHandle keysetHandle = KeysetHandle.generateNew(DeterministicAeadKeyTemplates.AES256_SIV);
			DeterministicAead daead = DeterministicAeadFactory.getPrimitive(keysetHandle);
			byte[] encrypttext = null;
			byte[] associatedData=null;
			try {
				encrypttext = value.getBytes("UTF-8");
				associatedData = key.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {				
			
			}
			byte[] decrypted = daead.decryptDeterministically(encrypttext, associatedData);
			cp = cp + Arrays.toString(decrypted);
		} catch (GeneralSecurityException e) {
			
		}
	  return cp;
	}
}
