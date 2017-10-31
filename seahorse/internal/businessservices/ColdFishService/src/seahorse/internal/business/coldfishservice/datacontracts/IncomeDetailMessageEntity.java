/**
 * 
 */
package seahorse.internal.business.coldfishservice.datacontracts;

import java.util.UUID;

import seahorse.internal.business.coldfishservice.common.datacontracts.BaseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class IncomeDetailMessageEntity extends BaseMessageEntity {
	private UUID id;
	private String name;
	private String userId;
	private String description;	
	private String category;
	private String incomeTypeId;
	private double amount;
	private UUID parsedUserId;

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



}
