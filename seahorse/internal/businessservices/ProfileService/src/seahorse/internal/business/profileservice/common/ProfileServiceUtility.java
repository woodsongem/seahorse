/**
 * 
 */
package seahorse.internal.business.profileservice.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author SMJE
 *
 */
public class ProfileServiceUtility {

	public static boolean isUserNameValid(String username) {

		if (username.length() <= 4 || username.length() >= 31) {
			return false;
		}
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]_");
		Matcher matcher = pattern.matcher(username);

		if (!matcher.matches()) {
			return false;
		}

		return true;
	}
//one or more uppercase characters
//one or more lowercase characters
//one or more digits
//one or more special characters (like $, @, or !)
//8 or more characters, but not more than 30 characters
	public static boolean isPasswordValid(String password) {
		if (password.length() <= 7 || password.length() >= 30) {
			return false;
		}
		int min = 8;
		int max = 16;
		int digit = 0;
		int special = 0;
		int upCount = 0;
		int loCount = 0;
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if (Character.isUpperCase(c)) {
				upCount++;
			}
			if (Character.isLowerCase(c)) {
				loCount++;
			}
			if (Character.isDigit(c)) {
				digit++;
			}
			if (c >= 33 && c <= 46 || c == 64) {
				special++;
			}
		}
		if (!(special >= 1 && loCount >= 1 && upCount >= 1 && digit >= 1)) {
			return false;
		}
		return true;
	}

}
