/**
 * 
 */

package seahorse.internal.business.katavuccolservice.dal;
/**
 * @author sajanmje
 *
 */
public class QueryConstants {	
	
	private QueryConstants() {
		throw new IllegalStateException("QueryConstants class");
	}
	
	public static final String GET_CATEGORY_DETAIL_BY_ID_QUERY = "SELECT userid, id, createdby, createddate, description, modifiedby, modifieddate, name, status FROM category where id=? and userid=?";
	public static final String GET_CREDENTIAL_TYPE_DETAILS_BY_ID_QUERY = "SELECT userid, id, createdby, createddate, description, modifiedby, modifieddate, name, status FROM credentialtype where id=? and userid=?";
	public static final String GET_CREATE_CREDENTIAL_QUERY = "INSERT INTO credential (userid, categoryid, createdby, createddate, description, status, credentialtypeid) VALUES(?,?, ?, '', '','', ?)";
	public static final String GET_CATEGORY_DETAIL_BY_USERID_QUERY = "SELECT userid, id, createdby, createddate, description, modifiedby, modifieddate, name, status FROM category where userid=?";
	public static final String GET_CREDENTIAL_TYPE_DETAIL_BY_USERID_QUERY = "SELECT userid, id, createdby, createddate, description, modifiedby, modifieddate, name, status FROM credentialtype where userid=?";
}
