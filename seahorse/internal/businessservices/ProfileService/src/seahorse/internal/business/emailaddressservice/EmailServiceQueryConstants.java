/**
 * 
 */
package seahorse.internal.business.emailaddressservice;

/**
 * @author SMJE
 *
 */
public class EmailServiceQueryConstants {

	public static final String GET_EMAILADDRESS_BY_USERID_QUERY = "select userid,id,emailaddress,isprimary,status,createdby,createddate,modifiedby,modifieddate from emailaddress where userid=?";
	public static final String GET_CREATE_EMAIL_ADDRESS_QUERY = "INSERT INTO emailaddress( id, createdby, createddate, emailaddress, isprimary, modifiedby, modifieddate, status, userid) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";
	public static final String GET_UPDATE_EMAILADDRESS_QUERY = "UPDATE emailaddress SET  modifiedby=?, modifieddate=?,emailaddress=?,isprimary=? WHERE id=?";
	public static final String GET_DELETE_EMAILADDRESS_EMAILADDRESS_ID_QUERY = "UPDATE emailaddress SET  modifiedby=?, modifieddate=?,status=? WHERE id=?";
	public static final String GET_EMAILADDRESS_BY_ID_QUERY = "select userid,id,emailaddress,isprimary,status,createdby,createddate,modifiedby,modifieddate from emailaddress where id=?";
	public static final String GET_EMAILADDRESS_BY_EMAILADDRESS_QUERY = "";
	public static final String GET_EMAILADDRESS_BY_EMAILADDRESS_ID_QUERY = "";

}
