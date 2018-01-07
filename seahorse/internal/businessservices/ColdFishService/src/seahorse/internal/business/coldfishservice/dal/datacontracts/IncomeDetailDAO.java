/**
 * 
 */
package seahorse.internal.business.coldfishservice.dal.datacontracts;

import java.util.UUID;

/**
 * @author sajanmje
 *
 */
public class IncomeDetailDAO extends BaseDAO {
	private UUID id;
	private double amount;
	private String description;
	private UUID incometypeId;
	private String status;
	private UUID userId;
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
	 * @return the incometypeId
	 */
	public UUID getIncometypeId() {
		return incometypeId;
	}
	/**
	 * @param incometypeId the incometypeId to set
	 */
	public void setIncometypeId(UUID incometypeId) {
		this.incometypeId = incometypeId;
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
	 * @return the userId
	 */
	public UUID getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
}
