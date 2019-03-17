/**
 * 
 */
package seahorse.internal.business.emailaddressservice.datacontracts;

import java.util.UUID;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.BaseMessageEntity;
import seahorse.internal.business.usercredentialservice.dal.datacontracts.UserCredentialDAO;

/**
 * @author SMJE
 *
 */
public class CreateEmailAddressRequestMsgEntity extends BaseMessageEntity {

	private String status;
	private UUID id;
	private String emailAddress;
	private Status httpStatus;
	private UUID userId;
	private Boolean isPrimary;
	private UserCredentialDAO userCredential;
	
	
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
	/**
	 * @return the userId
	 */
	public UUID getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	/**
	 * @return the isPrimary
	 */
	public Boolean getIsPrimary() {
		return isPrimary;
	}
	/**
	 * @param isPrimary the isPrimary to set
	 */
	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	/**
	 * @return the userCredential
	 */
	public UserCredentialDAO getUserCredential() {
		return userCredential;
	}
	/**
	 * @param userCredential the userCredential to set
	 */
	public void setUserCredential(UserCredentialDAO userCredential) {
		this.userCredential = userCredential;
	}
}
