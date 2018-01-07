/**
 * 
 */
package seahorse.internal.business.coldfishservice.api.datacontracts;

/**
 * @author sajanmje
 *
 */
public class IncomeTypeRequest extends RequestBase {

	private String name;

	private String userId;

	private String description;
	
	private String category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
}
