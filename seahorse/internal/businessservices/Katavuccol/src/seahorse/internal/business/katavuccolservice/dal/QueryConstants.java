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
	public static final String GET_CATEGORY_TYPE_DETAILS_BY_ID_QUERY = "SELECT userid, id, createdby, createddate, description, isduplicationallowed, issubitemallowed, modifiedby, modifieddate, name, status FROM credentialtype where id=? and userid=? ";
	public static final String GET_CREATE_CREDENTIAL_QUERY = "INSERT INTO credential (userid, id, categoryid, createdby, createddate, credentialtypeid, description, status,value,encryptkey,userencryptkey) VALUES(?, ?, ?, ?, ?, ?,?,?,?,?,?)";
	public static final String GET_CATEGORY_DETAIL_BY_USERID_QUERY = "SELECT userid, id, createdby, createddate, description, modifiedby, modifieddate, name, status FROM category where userid=? ";
	public static final String GET_CREDENTIALTYPE_DETAIL_BY_USERID_QUERY = "SELECT userid, id, createdby, createddate, description, modifiedby, modifieddate, name, status FROM credentialtype where userid=? ";
	public static final String GET_CREDENTIAL_DETAIL_BY_USERID_QUERY = "SELECT userid,parentId, id, categoryid, createdby, createddate, credentialtypeid, description, modifiedby, modifieddate, status,value,encryptkey,userencryptkey FROM credential where userid=? ";
	public static final String GET_CREDENTIAL_DETAIL_BY_USERID_ID_QUERY = "SELECT userid,parentId, id, categoryid, createdby, createddate, credentialtypeid, description, modifiedby, modifieddate, status, value,encryptkey,userencryptkey FROM credential where id=? and userid=? ";
	public static final String GET_DELETE_CREDENTIAL_QUERY = "UPDATE credential SET modifiedby=?, modifieddate=?,status=? where id=? and userid=? ";
	public static final String GET_UPDATE_CREDENTIAL_QUERY = "UPDATE credential SET value=?,categoryid=?,credentialtypeid=?, modifiedby=?, modifieddate=?,description=? where id=? and userid=? ";
	public static final String GET_CREATE_CATEGORY_QUERY = "INSERT INTO category (userid, id, createdby, createddate, description, name, status) VALUES(?, ?, ?, ?,?,?,?)";
	public static final String GET_DELETE_CATEGORY_QUERY = "UPDATE category SET modifiedby=?, modifieddate=?, status=? where userid=? and id=?";
	public static final String GET_UPDATE_CATEGORY_QUERY = "UPDATE category SET description=?, modifiedby=?, modifieddate=?, name=? where userid=? and id=?";
	public static final String GET_USER_CREDENTIAL_BY_USERIDQUERY = "SELECT id, createdby, createddate, modifiedby, modifieddate, password, productitemid, status, username FROM usercredential where id=?";
	public static final String GET_CATEGORY_TYPE_DETAILS_BY_USER_ID_QUERY = "SELECT userid, id, createdby, createddate, description, isduplicationallowed, issubitemallowed, modifiedby, modifieddate, name, status FROM credentialtype where userid=? ";
	public static final String GET_CREATE_CREDENTIALTYPE_QUERY ="INSERT INTO credentialtype(userid, id, createdby, createddate, description, isduplicationallowed, issubitemallowed, name, status) VALUES (?,?,?,?,?,?,?,?,?)";
	
}
