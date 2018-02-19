package seahorse.internal.business.katavuccolservice.common;
/**
 * 
 */

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

}
