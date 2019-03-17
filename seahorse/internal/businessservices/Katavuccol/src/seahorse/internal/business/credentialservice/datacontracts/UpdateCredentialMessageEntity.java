/**
 * 
 */
package seahorse.internal.business.credentialservice.datacontracts;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.categoryservice.datacontracts.CategoryMessageEntity;
import seahorse.internal.business.credentialservice.dal.datacontracts.CredentialDAO;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeMessageEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeMsgEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.BaseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class UpdateCredentialMessageEntity extends BaseMessageEntity {
	private String userId;		
	private String credentialId;
	private UUID parsedUserId;
	private UUID parsedCredentialId;
	private String value;	
	private String description;
	private String categoryId;
	private UUID parsedCategoryId;
	private String credentialTypeId;
	private UUID parsedCredentialTypeId;
	private CredentialTypeMsgEntity credentialType;
	private CategoryMessageEntity category;
	private List<CredentialDAO> credential;
	
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
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	/**
	 * @return the parsedCategoryId
	 */
	public UUID getParsedCategoryId() {
		return parsedCategoryId;
	}
	/**
	 * @param parsedCategoryId the parsedCategoryId to set
	 */
	public void setParsedCategoryId(UUID parsedCategoryId) {
		this.parsedCategoryId = parsedCategoryId;
	}
	/**
	 * @return the credentialTypeId
	 */
	public String getCredentialTypeId() {
		return credentialTypeId;
	}
	/**
	 * @param credentialTypeId the credentialTypeId to set
	 */
	public void setCredentialTypeId(String credentialTypeId) {
		this.credentialTypeId = credentialTypeId;
	}
	/**
	 * @return the parsedCredentialTypeId
	 */
	public UUID getParsedCredentialTypeId() {
		return parsedCredentialTypeId;
	}
	/**
	 * @param parsedCredentialTypeId the parsedCredentialTypeId to set
	 */
	public void setParsedCredentialTypeId(UUID parsedCredentialTypeId) {
		this.parsedCredentialTypeId = parsedCredentialTypeId;
	}
	/**
	 * @return the credentialType
	 */
	public CredentialTypeMsgEntity getCredentialType() {
		return credentialType;
	}
	/**
	 * @param credentialType the credentialType to set
	 */
	public void setCredentialType(CredentialTypeMsgEntity credentialType) {
		this.credentialType = credentialType;
	}
	/**
	 * @return the category
	 */
	public CategoryMessageEntity getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(CategoryMessageEntity category) {
		this.category = category;
	}
	/**
	 * @return the credential
	 */
	public List<CredentialDAO> getCredential() {
		return credential;
	}
	/**
	 * @param credential the credential to set
	 */
	public void setCredential(List<CredentialDAO> credential) {
		this.credential = credential;
	}
}
