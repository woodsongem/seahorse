/**
 * 
 */
package seahorse.internal.business.usercredentialservice.datacontracts;

/**
 * @author SMJE
 *
 */
public class CreateProfileApiMsgEntity {
	private String userName;
	private String password;
	private String productItemId;
	private String emailAddress;
	private String phoneNumber;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getProductItemId() {
		return productItemId;
	}
	/**
	 * @param productItemId the productItemId to set
	 */
	public void setProductItemId(String productItemId) {
		this.productItemId = productItemId;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
