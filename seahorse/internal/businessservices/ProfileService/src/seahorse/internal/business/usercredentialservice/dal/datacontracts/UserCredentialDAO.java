/**
 * 
 */
package seahorse.internal.business.usercredentialservice.dal.datacontracts;

import java.util.UUID;

/**
 * @author SMJE
 *
 */
public class UserCredentialDAO extends BaseDAO {
	
	private UUID id;
	private String username;
	private String password;
	private UUID productItemId;
	private String status;
	
	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the productItemId
	 */
	public UUID getProductItemId() {
		return productItemId;
	}
	/**
	 * @param productItemId the productItemId to set
	 */
	public void setProductItemId(UUID productItemId) {
		this.productItemId = productItemId;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
