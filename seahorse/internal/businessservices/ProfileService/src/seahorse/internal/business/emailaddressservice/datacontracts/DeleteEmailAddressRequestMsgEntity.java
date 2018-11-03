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
public class DeleteEmailAddressRequestMsgEntity extends BaseMessageEntity {

	private UUID id;
	private UUID userId;
	private Status httpStatus;
	private EmailAddressDAO emailAddressDetail;
	private UserCredentialDAO userCredential;

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
