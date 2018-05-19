/**
 * 
 */
package seahorse.internal.business.katavuccolservice.datacontracts;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.katavuccolservice.common.datacontracts.BaseMessageEntity;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;

/**
 * @author sajanmje
 *
 */
public class GetCategoryMessageEntity extends BaseMessageEntity {
	
	private String userId;
	private UUID parsedUserId;
	private List<CategoryDAO> category;
	
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
	 * @return the category
	 */
	public List<CategoryDAO> getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(List<CategoryDAO> category) {
		this.category = category;
	}
}
