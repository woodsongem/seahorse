/**
 * 
 */
package seahorse.internal.business.coldfishservice.dal.datacontracts;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author sajanmje
 *
 */
public class BaseDAO {
	
	private UUID createdBy;
	private UUID modifiedBy;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;	
	private String ipAddress;
	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}
	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	/**
	 * @return the modifiedDate
	 */
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	/**
	 * @return the createdDate
	 */
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the modifiedBy
	 */
	public UUID getModifiedBy() {
		return modifiedBy;
	}
	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(UUID modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	/**
	 * @return the createdBy
	 */
	public UUID getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(UUID createdBy) {
		this.createdBy = createdBy;
	}
}
