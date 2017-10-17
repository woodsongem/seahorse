/**
 * 
 */
package seahorse.internal.business.coldfishservice.datacontracts;

import java.util.List;
import java.util.UUID;

/**
 * @author sajanmje
 *
 */
public class GetIncomeTypeMessageEntity {

	private String userId;
	private UUID  formatUserId;
	private List<IncomeTypeMessageEntity> incomeTypeMessageEntity;
	
	/**
	 * @return the formatUserId
	 */
	public UUID getFormatUserId() {
		return formatUserId;
	}
	/**
	 * @param formatUserId the formatUserId to set
	 */
	public void setFormatUserId(UUID formatUserId) {
		this.formatUserId = formatUserId;
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
	 * @return the incomeTypeMessageEntity
	 */
	public List<IncomeTypeMessageEntity> getIncomeTypeMessageEntity() {
		return incomeTypeMessageEntity;
	}
	/**
	 * @param incomeTypeMessageEntity the incomeTypeMessageEntity to set
	 */
	public void setIncomeTypeMessageEntity(List<IncomeTypeMessageEntity> incomeTypeMessageEntity) {
		this.incomeTypeMessageEntity = incomeTypeMessageEntity;
	}
}
