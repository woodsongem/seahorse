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
	
	private String _createdBy;
	private String _modifiedBy;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _httpMethod;
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return _createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}
	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return _modifiedBy;
	}
	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return _createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}
	/**
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {
		return _modifiedDate;
	}
	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}
	/**
	 * @return the _httpMethod
	 */
	public String gethttpMethod() {
		return _httpMethod;
	}
	/**
	 * @param _httpMethod the _httpMethod to set
	 */
	public void sethttpMethod(String _httpMethod) {
		this._httpMethod = _httpMethod;
	}

}
