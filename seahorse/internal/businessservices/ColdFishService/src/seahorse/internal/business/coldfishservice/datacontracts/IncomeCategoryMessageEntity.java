/**
 * 
 */
package seahorse.internal.business.coldfishservice.datacontracts;

import java.math.BigDecimal;
import java.util.UUID;

import seahorse.internal.business.coldfishservice.common.datacontracts.BaseMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public class IncomeCategoryMessageEntity  extends BaseMessageEntity {

	private UUID id;
	private String name;
	private String userId;
	private UUID parsedUserId;
	private String incomeMonth;
	private int incomeyear;
	private String status;		
	private String description;	
	private String parentid;
	private UUID parsedParentid;
	private BigDecimal amount;
	private UserCredentialMessageEntity userCredential;
	private IncomeCategoryMessageEntity incomeCategory;		

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
	 * @return the userCredential
	 */
	public UserCredentialMessageEntity getUserCredential() {
		return userCredential;
	}
	/**
	 * @param userCredential the userCredential to set
	 */
	public void setUserCredential(UserCredentialMessageEntity userCredential) {
		this.userCredential = userCredential;
	}

	public IncomeCategoryMessageEntity getIncomeCategory() {
		return incomeCategory;
	}
	public void setIncomeCategory(IncomeCategoryMessageEntity incomeCategory) {
		this.incomeCategory = incomeCategory;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIncomeMonth() {
		return incomeMonth;
	}
	public void setIncomeMonth(String incomeMonth) {
		this.incomeMonth = incomeMonth;
	}
	public int getIncomeYear() {
		return incomeyear;
	}
	public void setIncomeYear(int incomeyear) {
		this.incomeyear = incomeyear;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	/**
	 * @return the parentid
	 */
	public String getParentid() {
		return parentid;
	}
	/**
	 * @param parentid the parentid to set
	 */
	public void setParentid(String parentid) {
		this.parentid = parentid;
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
	 * @return the parsedParentid
	 */
	public UUID getParsedParentid() {
		return parsedParentid;
	}
	/**
	 * @param parsedParentid the parsedParentid to set
	 */
	public void setParsedParentid(UUID parsedParentid) {
		this.parsedParentid = parsedParentid;
	}
}
