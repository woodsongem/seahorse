/**
 * 
 */
package seahorse.internal.business.coldfishservice.datacontracts;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.coldfishservice.common.datacontracts.BaseMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public class GetIncomeCategoryMessageEntity extends BaseMessageEntity {	
	private String userId;	
	private String incomeMonth;	
	private int incomeYear;
	private UUID parsedUserId;
	private UserCredentialMessageEntity userCredential;
	private List<IncomeCategoryMessageEntity> incomeCategoryMessageEntity;
	
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
	/**
	 * @return the incomeCategoryMessageEntity
	 */
	public List<IncomeCategoryMessageEntity> getIncomeCategoryMessageEntity() {
		return incomeCategoryMessageEntity;
	}
	/**
	 * @param incomeCategoryMessageEntity the incomeCategoryMessageEntity to set
	 */
	public void setIncomeCategoryMessageEntity(List<IncomeCategoryMessageEntity> incomeCategoryMessageEntity) {
		this.incomeCategoryMessageEntity = incomeCategoryMessageEntity;
	}
	
}
