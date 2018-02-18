package seahorse.internal.business.katavuccolservice.common;
/**
 * 
 */


/**
 * @author sajanmje
 *
 */
public class ColdFishUtilities {
	
	 private ColdFishUtilities() {
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

}
