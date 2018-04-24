/**
 * 
 */
package seahorse.internal.business.katavuccolservice.datacontracts;

import java.util.UUID;

import seahorse.internal.business.katavuccolservice.common.datacontracts.BaseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class GetCredentialValueMessageEntity extends BaseMessageEntity {

	private String userId;
	private String categoryId;
	private UUID parsedUserId;
	private UUID parsedCategoryId;
	private String key;
	private CategoryMessageEntity category;
	private CredentialMessageEntity credential;
	

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
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
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
	public CredentialMessageEntity getCredential() {
		return credential;
	}

	/**
	 * @param credential the credential to set
	 */
	public void setCredential(CredentialMessageEntity credential) {
		this.credential = credential;
	}
}
