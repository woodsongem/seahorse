/**
 * 
 */

package seahorse.internal.business.katavuccolservice.utilities;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import com.datastax.driver.core.LocalDate;
import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.Config;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.JsonKeysetReader;
import com.google.crypto.tink.JsonKeysetWriter;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.crypto.tink.daead.DeterministicAeadFactory;
import com.google.crypto.tink.daead.DeterministicAeadKeyTemplates;
import com.google.crypto.tink.proto.Keyset;
import com.google.gson.Gson;

import seahorse.internal.business.katavuccolservice.common.KatavuccolConstant;
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
	public static Map<String,String> encrypt(String key,String value)
	{
		String cp = null;
		String encryptKey=null;
		Map<String,String> result=new HashMap<>();		
		try {
			DeterministicAeadConfig.init();
		    Config.register(DeterministicAeadConfig.TINK_1_1_0);
			KeysetHandle keysetHandle = KeysetHandle.generateNew(DeterministicAeadKeyTemplates.AES256_SIV);
			DeterministicAead daead = DeterministicAeadFactory.getPrimitive(keysetHandle);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			try {
				CleartextKeysetHandle.write(keysetHandle, JsonKeysetWriter.withOutputStream(outputStream));
				encryptKey=outputStream.toString();
				
			} catch (IOException e1) {
				
			}

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
			encryptKey=null;
			cp=null;
		}
		result.put(KatavuccolConstant.CREDENTIAL_ENCRYPT_KEY, encryptKey);
		result.put(KatavuccolConstant.CREDENTIAL_ENCRYPT_VALUE, cp);
	  return result;
	}
	public static String decrypt(String encryptKey,String value,String userkey)
	{
		String cp = null;
		String error=null;
		
		try {
			DeterministicAeadConfig.init();
		    Config.register(DeterministicAeadConfig.TINK_1_1_0);
		    ByteArrayInputStream inputStream = new ByteArrayInputStream(encryptKey.getBytes());
			KeysetHandle keysetHandle=null;
			try {
				keysetHandle = CleartextKeysetHandle.read(JsonKeysetReader.withInputStream(inputStream));
			} catch(IOException e1) {
				e1.printStackTrace();
			}					
			DeterministicAead daead = DeterministicAeadFactory.getPrimitive(keysetHandle);
			byte[] encrypttext = null;
			byte[] associatedData=null;
			try {
				encrypttext = value.getBytes("UTF-8");
				associatedData = userkey.getBytes("UTF-8");
			} catch (Exception e) {				
				e.printStackTrace();
			}
			byte[] decrypted = daead.decryptDeterministically(encrypttext, associatedData);
			cp = Arrays.toString(decrypted);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
	  return cp;
	}
}
