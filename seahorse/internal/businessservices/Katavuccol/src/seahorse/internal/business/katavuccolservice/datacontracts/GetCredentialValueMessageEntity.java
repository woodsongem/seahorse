/**
 * 
 */
package seahorse.internal.business.katavuccolservice.datacontracts;

import seahorse.internal.business.katavuccolservice.common.datacontracts.BaseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class GetCredentialValueMessageEntity extends BaseMessageEntity {

	private String userId;
	private String categoryId;
	private String parsedUserId;
	private String parsedCategoryId;

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
	public String getParsedUserId() {
		return parsedUserId;
	}

	/**
	 * @param parsedUserId the parsedUserId to set
	 */
	public void setParsedUserId(String parsedUserId) {
		this.parsedUserId = parsedUserId;
	}

	/**
	 * @return the parsedCategoryId
	 */
	public String getParsedCategoryId() {
		return parsedCategoryId;
	}

	/**
	 * @param parsedCategoryId the parsedCategoryId to set
	 */
	public void setParsedCategoryId(String parsedCategoryId) {
		this.parsedCategoryId = parsedCategoryId;
	}
}
