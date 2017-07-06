/**
 * 
 */
package seahorse.internal.business.customerservice.datacontracts;

/**
 * @author sajanmje
 *
 */
public class LoginDetailMessageEntity {
	private String username;
	private String password;
	private String productitem;
	private String encryptedpassword;
	private UserCredentialMessageEntity usercredentialmessageEntity;
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
	 * @return the productitem
	 */
	public String getProductitem() {
		return productitem;
	}
	/**
	 * @param productitem the productitem to set
	 */
	public void setProductitem(String productitem) {
		this.productitem = productitem;
	}
	/**
	 * @return the encryptedpassword
	 */
	public String getEncryptedpassword() {
		return encryptedpassword;
	}
	/**
	 * @param encryptedpassword the encryptedpassword to set
	 */
	public void setEncryptedpassword(String encryptedpassword) {
		this.encryptedpassword = encryptedpassword;
	}
	/**
	 * @return the usercredentialmessageEntity
	 */
	public UserCredentialMessageEntity getUsercredentialmessageEntity() {
		return usercredentialmessageEntity;
	}
	/**
	 * @param usercredentialmessageEntity the usercredentialmessageEntity to set
	 */
	public void setUsercredentialmessageEntity(UserCredentialMessageEntity usercredentialmessageEntity) {
		this.usercredentialmessageEntity = usercredentialmessageEntity;
	}
}
