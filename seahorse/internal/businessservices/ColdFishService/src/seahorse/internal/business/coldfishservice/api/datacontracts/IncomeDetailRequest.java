/**
 * 
 */
package seahorse.internal.business.coldfishservice.api.datacontracts;

/**
 * @author sajanmje
 *
 */
public class IncomeDetailRequest extends RequestBase {
	
	private String name;
	private String userId;
	private String description;	
	private String incomeTypeId;
	private double amount;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the incomeTypeId
	 */
	public String getIncomeTypeId() {
		return incomeTypeId;
	}

	/**
	 * @param incomeTypeId the incomeTypeId to set
	 */
	public void setIncomeTypeId(String incomeTypeId) {
		this.incomeTypeId = incomeTypeId;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}


}
