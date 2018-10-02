/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

/**
 * @author SMJE
 *
 */
public class UserCredentialServiceQueryConstants {

	public static final String GET_CREATE_USER_CREDENTIAL_QUERY = "INSERT INTO usercredential (id, createdby, createddate, username, password, status,productitemid) VALUES(?, ?, ?, ?,?,?,?)";
	public static final String GET_USERCREDENTIAL_BY_USERNAME_QUERY = " select id,username,password,productitemid,status,createdby,createddate,modifiedby,modifieddate from usercredential_username where username=? ";
	public static final String GET_USERCREDENTIAL_BY_USERID_QUERY = "select id,username,password,productitemid,status,createdby,createddate,modifiedby,modifieddate from usercredential_username where id=?";

}
