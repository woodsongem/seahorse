/**
 * 
 */
package seahorse.internal.business.customerservice.datacontracts;

import java.util.Date;

/**
 * @author admin
 *
 */
public class BaseMessageEntity extends ResultMessageEntity {
	
	private String createdBy;
	private String modifiedBy;
	private Date createdDate;
	private Date modifiedDate;
	private String httpMethod;
	private String ipaddress;
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}
	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}
	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	/**
	 * @return the _httpMethod
	 */
	public String gethttpMethod() {
		return httpMethod;
	}
	/**
	 * @param _httpMethod the _httpMethod to set
	 */
	public void sethttpMethod(String _httpMethod) {
		this.httpMethod = _httpMethod;
	}
	/**
	 * @return the ipaddress
	 */
	public String getIpAddress() {
		return ipaddress;
	}
	/**
	 * @param ipaddress the ipaddress to set
	 */
	public void setIpAddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

}
