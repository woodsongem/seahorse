/**
 * 
 */
package seahorse.internal.business.coldfishservice.common.datacontracts;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * @author admin
 *
 */
public class BaseMessageEntity extends ResultMessageEntity {

	private UUID createdBy;
	private UUID modifiedBy;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private String httpMethod;
	private String ipAddress;

	public UUID getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UUID createdBy) {
		this.createdBy = createdBy;
	}

	public UUID getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(UUID modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}
