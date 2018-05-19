/**
 * 
 */
package seahorse.internal.business.coldfishservice.api.datacontracts;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author sajanmje
 *
 */
public class IncomeCategory extends ResponseBase  {

	private String id;
	private String name;
	private String userId;
	private String description;	
	private String status;
	private String incomeMonth;
	private String parentId;
	private BigDecimal amount;
	private int incomeYear;	
	private List<IncomeCategory> subIncomeCategory;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
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
	 * @return the incomeMonth
	 */
	public String getIncomeMonth() {
		return incomeMonth;
	}
	/**
	 * @param incomeMonth the incomeMonth to set
	 */
	public void setIncomeMonth(String incomeMonth) {
		this.incomeMonth = incomeMonth;
	}
	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * @return the incomeYear
	 */
	public int getIncomeYear() {
		return incomeYear;
	}
	/**
	 * @param incomeYear the incomeYear to set
	 */
	public void setIncomeYear(int incomeYear) {
		this.incomeYear = incomeYear;
	}
	/**
	 * @return the subIncomeCategory
	 */
	public List<IncomeCategory> getSubIncomeCategory() {
		return subIncomeCategory;
	}
	/**
	 * @param subIncomeCategory the subIncomeCategory to set
	 */
	public void setSubIncomeCategory(List<IncomeCategory> subIncomeCategory) {
		this.subIncomeCategory = subIncomeCategory;
	}
}
