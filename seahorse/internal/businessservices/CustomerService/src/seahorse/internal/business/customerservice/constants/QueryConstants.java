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
	
	public final static  String getUserCredentialbyUserNameQuery ="SELECT id, created_by, created_date, modified_by, modified_date, status, user_name FROM seahorsedev.usercredential where user_name='{0}' and password='{1}' and status='ACTIVE' ALLOW FILTERING";

	
}
