/**
 * 
 */
package seahorse.internal.business.usercredentialservice.datacontracts;

import java.util.UUID;
import javax.ws.rs.core.Response.Status;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.BaseMessageEntity;

/**
 * @author SMJE
 *
 */
public class CreateUserCredentialMsgEntity extends BaseMessageEntity {

	private String status;
	private UUID id;
	private String username;
	private String password;
	private String productItemId;
	private UUID parsedProductItemId;
	private String emailAddress;
	private String phoneNumber;
	private Status httpStatus;

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
	 * @return the parsedProductItemId
	 */
	public UUID getParsedProductItemId() {
		return parsedProductItemId;
	}

	/**
	 * @param parsedProductItemId the parsedProductItemId to set
	 */
	public void setParsedProductItemId(UUID parsedProductItemId) {
		this.parsedProductItemId = parsedProductItemId;
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

	/**
	 * @return the httpStatus
	 */
	public Status getHttpStatus() {
		return httpStatus;
	}

	/**
	 * @param httpStatus the httpStatus to set
	 */
	public void setHttpStatus(Status httpStatus) {
		this.httpStatus = httpStatus;
	}
}
