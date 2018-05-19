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
public class GetIncomeDetailMessageEntity extends BaseMessageEntity {
	
	private String userId;
	private String id;
	private UUID parsedUserId;
	private int incomeYear;
	private String incomeMonth;
	private UserCredentialMessageEntity userCredential;
	private List<IncomeDetailMessageEntity> incomeDetails;

	/**
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userid the user id to set
	 */
	public void setUserId(String userid) {
		this.userId = userid;
	}

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
	 * @return the incomeDetails
	 */
	public List<IncomeDetailMessageEntity> getIncomeDetails() {
		return incomeDetails;
	}

	/**
	 * @param incomeDetails the incomeDetails to set
	 */
	public void setIncomeDetails(List<IncomeDetailMessageEntity> incomeDetails) {
		this.incomeDetails = incomeDetails;
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
}
