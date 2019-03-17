/**
 * 
 */
package seahorse.internal.business.credentialtypeservice.datacontracts;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import seahorse.internal.business.katavuccolservice.common.datacontracts.BaseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class DeleteCredentialTypeReqMsgEntity extends BaseMessageEntity {
	private String userId;
	private String credentialTypeId;
	private UUID parsedUserId;
	private UUID parsedCredentialTypeId;
	private HttpServletRequest httpRequest; 
	private String status;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCredentialTypeId() {
		return credentialTypeId;
	}

	public void setCredentialTypeId(String credentialTypeId) {
		this.credentialTypeId = credentialTypeId;
	}

	public UUID getParsedCredentialTypeId() {
		return parsedCredentialTypeId;
	}

	public void setParsedCredentialTypeId(UUID parsedCredentialTypeId) {
		this.parsedCredentialTypeId = parsedCredentialTypeId;
	}

	public UUID getParsedUserId() {
		return parsedUserId;
	}

	public void setParsedUserId(UUID parsedUserId) {
		this.parsedUserId = parsedUserId;
	}

	public HttpServletRequest getHttpRequest() {
		return httpRequest;
	}

	public void setHttpRequest(HttpServletRequest httpRequest) {
		this.httpRequest = httpRequest;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
