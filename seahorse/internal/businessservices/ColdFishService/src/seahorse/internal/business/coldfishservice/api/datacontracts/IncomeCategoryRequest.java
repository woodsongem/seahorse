/**
 * 
 */
package seahorse.internal.business.coldfishservice.api.datacontracts;

/**
 * @author sajanmje
 *
 */
public class IncomeCategoryRequest extends RequestBase{
	
	private String name;
	private String userId;
	private String incomeMonth;
	private int incomeyear;
	private String status;	
	private String description;
	
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
	public String getIncomeMonth() {
		return incomeMonth;
	}
	public void setIncomeMonth(String incomeMonth) {
		this.incomeMonth = incomeMonth;
	}
	public int getIncomeyear() {
		return incomeyear;
	}
	public void setIncomeyear(int incomeyear) {
		this.incomeyear = incomeyear;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}		
}
