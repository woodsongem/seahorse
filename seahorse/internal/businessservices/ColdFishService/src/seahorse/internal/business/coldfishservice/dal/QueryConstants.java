/**
 * 
 */
package seahorse.internal.business.coldfishservice.dal;

/**
 * @author sajanmje
 *
 */
public class QueryConstants {
	
	private QueryConstants() {
		throw new IllegalStateException("QueryConstants class");
	}

	public static final String GETINCOMETYPEBYUSERIDQUERY = "SELECT userid, status, id, category, createdby, createddate, description, modifiedby, modifieddate, name FROM coldfish_dev.incometype where userid=";
	public static final String GETINCOMETYPEQUERY = "SELECT userid, status, id, category, createdby, createddate, description, modifiedby, modifieddate, name FROM coldfish_dev.incometype"; 
	
}
