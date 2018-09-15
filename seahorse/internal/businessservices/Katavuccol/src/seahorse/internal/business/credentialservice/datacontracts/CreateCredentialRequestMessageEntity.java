/**
 * 
 */
package seahorse.internal.business.credentialservice.datacontracts;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.categoryservice.datacontracts.CategoryMessageEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeMsgEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.BaseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class CreateCredentialRequestMessageEntity extends BaseMessageEntity {

	private String categoryId;
	private String typeId;
	private String value;	
	private String userId;
	private UUID parsedUserId;
	private UUID parsedCategoryId;
	private UUID parsedCredentialTypeId;
	private UUID id;	
	private String description;
	private CredentialTypeMsgEntity credentialType;
	private CategoryMessageEntity category;
	private String status;
	private List<CredentialMessageEntity> credential;
	private Boolean isCredentialNull;
	private String parentCredentialId;
	private UUID parsedParentCredentialId;
	private String userEncryptKey;
	private String encryptValue;
	private String encryptKey;
	
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
	 * @return the typeid
	 */
	public String getTypeId() {
		return typeId;
	}
	/**
	 * @param typeid the typeid to set
	 */
	public void setTypeId(String typeid) {
		this.typeId = typeid;
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
	 * @return the parsedTypeId
	 */
	public UUID getParsedCredentialTypeId() {
		return parsedCredentialTypeId;
	}
	/**
	 * @param parsedTypeId the parsedTypeId to set
	 */
	public void setParsedCredentialTypeId(UUID parsedCredentialTypeId) {
		this.parsedCredentialTypeId = parsedCredentialTypeId;
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
	 * @return the credential
	 */
	public List<CredentialMessageEntity> getCredential() {
		return credential;
	}
	/**
	 * @param credential the credential to set
	 */
	public void setCredential(List<CredentialMessageEntity> credential) {
		this.credential = credential;
	}
	/**
	 * @return the isCredentialNull
	 */
	public Boolean getIsCredentialNull() {
		return isCredentialNull;
	}
	/**
	 * @param isCredentialNull the isCredentialNull to set
	 */
	public void setIsCredentialNull(Boolean isCredentialNull) {
		this.isCredentialNull = isCredentialNull;
	}
	/**
	 * @return the parentCredentialId
	 */
	public String getParentCredentialId() {
		return parentCredentialId;
	}
	/**
	 * @param parentCredentialId the parentCredentialId to set
	 */
	public void setParentCredentialId(String parentCredentialId) {
		this.parentCredentialId = parentCredentialId;
	}
	/**
	 * @return the parsedParentCredentialId
	 */
	public UUID getParsedParentCredentialId() {
		return parsedParentCredentialId;
	}
	/**
	 * @param parsedParentCredentialId the parsedParentCredentialId to set
	 */
	public void setParsedParentCredentialId(UUID parsedParentCredentialId) {
		this.parsedParentCredentialId = parsedParentCredentialId;
	}
	/**
	 * @return the encryptValue
	 */
	public String getEncryptValue() {
		return encryptValue;
	}
	/**
	 * @param encryptValue the encryptValue to set
	 */
	public void setEncryptValue(String encryptValue) {
		this.encryptValue = encryptValue;
	}
	/**
	 * @return the encryptKey
	 */
	public String getEncryptKey() {
		return encryptKey;
	}
	/**
	 * @param encryptKey the encryptKey to set
	 */
	public void setEncryptKey(String encryptKey) {
		this.encryptKey = encryptKey;
	}
	/**
	 * @return the userEncryptKey
	 */
	public String getUserEncryptKey() {
		return userEncryptKey;
	}
	/**
	 * @param userEncryptKey the userEncryptKey to set
	 */
	public void setUserEncryptKey(String userEncryptKey) {
		this.userEncryptKey = userEncryptKey;
	}	
}
