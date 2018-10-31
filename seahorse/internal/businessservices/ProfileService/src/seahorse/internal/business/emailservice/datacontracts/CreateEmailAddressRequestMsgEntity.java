/**
 * 
 */
package seahorse.internal.business.emailservice.datacontracts;

import java.util.UUID;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.BaseMessageEntity;

/**
 * @author SMJE
 *
 */
public class CreateEmailAddressRequestMsgEntity extends BaseMessageEntity {

	private String status;
	private UUID id;
	private String emailAddress;
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
}
