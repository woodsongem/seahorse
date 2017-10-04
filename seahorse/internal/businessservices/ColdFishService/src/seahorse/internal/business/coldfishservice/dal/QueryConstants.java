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

	public static final String GETINCOMETYPEBYUSERIDQUERY = "SELECT userid, status, id, category, createdby, createddate, description, modifiedby, modifieddate, name FROM coldfish_dev.incometype where userid= {0}";
	public static final String GETINCOMETYPEQUERY = "SELECT userid, status, id, category, createdby, createddate, description, modifiedby, modifieddate, name FROM coldfish_dev.incometype";
	public static final String CREATEINCOMETYPEQUERY="INSERT INTO coldfish_dev.incometype (userid, status, id, category, createdby, createddate, description, name) VALUES({0}, '{1}', {2}, '{3}', '{4}', '{5}','{6}', '{7}')";
	public static final String GETUSERCREDENTIALQUERY = "SELECT id, username, password, createdby, createddate, modifiedby, modifieddate, productitemid, status FROM coldfish_dev.usercredential where id= {0}";
	
}
