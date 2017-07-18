/**
 * 
 */

package seahorse.internal.business.customerservice.constants;

/**
 * @author sajanmje
 *
 */
public class QueryConstants {

	private QueryConstants() {
		throw new IllegalAccessError("QueryConstants class");
	}

	public static final String getUserCredentialbyUserNameQuery = "SELECT id, created_by, created_date, modified_by, modified_date, status, user_name FROM seahorsedev.usercredential where user_name='{0}' and password='{1}' and status='ACTIVE' ALLOW FILTERING";
	public static final String getInsertLoginAttemptHistoryQuery = "INSERT INTO seahorsedev.loginhistory (id, created_by, created_date, ipaddress, login, type, user_id) VALUES(now(), '{0}', '{1}', '{2}', '{3}', '{4}',{5})";
	public static final String getInsertLoginAttemptQuery = "INSERT INTO seahorsedev.loginattempts (id, created_by, created_date, loginattempts, status, user_id) VALUES(now(), '{0}', '{1}', {2},'{3}', {4})";
	public static final String getUpdateLoginAttemptQuery = "UPDATE seahorsedev.loginattempts SET loginattempts={0}, modified_by='{1}', modified_date='{2}', status='{3}' where user_id={4}";

}
