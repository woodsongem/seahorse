/**
 * 
 */
package seahorse.internal.business.emailaddressservice.datacontracts;

import java.util.UUID;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.emailaddressservice.dal.datacontracts.EmailAddressDAO;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.BaseMessageEntity;
import seahorse.internal.business.usercredentialservice.dal.datacontracts.UserCredentialDAO;

/**
 * @author SMJE
 *
 */
public class UpdateEmailAddressRequestMsgEntity extends BaseMessageEntity {
	private UUID id;
	private String emailAddress;
	private Status httpStatus;
	private Boolean isPrimary;
	private UUID userId;
	private UserCredentialDAO userCredential;
	private EmailAddressDAO emailAddressDetail;
	
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
	/**
	 * @return the emailAddressDetail
	 */
	public EmailAddressDAO getEmailAddressDetail() {
		return emailAddressDetail;
	}
	/**
	 * @param emailAddressDetail the emailAddressDetail to set
	 */
	public void setEmailAddressDetail(EmailAddressDAO emailAddressDetail) {
		this.emailAddressDetail = emailAddressDetail;
	}
}
