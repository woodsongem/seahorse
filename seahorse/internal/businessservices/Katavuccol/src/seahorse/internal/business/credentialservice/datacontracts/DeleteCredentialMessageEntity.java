/**
 * 
 */
package seahorse.internal.business.credentialservice.datacontracts;

import java.util.UUID;

import seahorse.internal.business.credentialservice.dal.datacontracts.CredentialDAO;
import seahorse.internal.business.katavuccolservice.common.datacontracts.BaseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class DeleteCredentialMessageEntity extends BaseMessageEntity {
	private String categoryId;
	private String userId;		
	private String credentialId;
	private UUID parsedUserId;
	private UUID parsedCredentialId;
	private String status;
	private CredentialDAO credentialMessageEntity;
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the parsedUserId
	 */
	public UUID getParsedUserId() {
		return parsedUserId;
	}
	/**
	 * @param parsedUserId the parsedUserId to set
	 */
	public void setParsedUserId(UUID parsedUserId) {
		this.parsedUserId = parsedUserId;
	}
	/**
	 * @return the credentialId
	 */
	public String getCredentialId() {
		return credentialId;
	}
	/**
	 * @param credentialId the credentialId to set
	 */
	public void setCredentialId(String credentialId) {
		this.credentialId = credentialId;
	}
	/**
	 * @return the parsedCredentialId
	 */
	public UUID getParsedCredentialId() {
		return parsedCredentialId;
	}
	/**
	 * @param parsedCredentialId the parsedCredentialId to set
	 */
	public void setParsedCredentialId(UUID parsedCredentialId) {
		this.parsedCredentialId = parsedCredentialId;
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
	/**
	 * @return the credentialDAO
	 */
	public CredentialDAO getCredential() {
		return credentialMessageEntity;
	}
	/**
	 * @param credentialDAO the credentialDAO to set
	 */
	public void setCredential(CredentialDAO credentialMessageEntity) {
		this.credentialMessageEntity = credentialMessageEntity;
	}
	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
}
