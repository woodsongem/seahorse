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

}
