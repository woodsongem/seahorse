/**
 * 
 */
package seahorse.internal.business.applicationservice.datacontracts;

import java.util.UUID;

import seahorse.internal.business.applicationservice.common.datacontracts.PhoneType;

/**
 * @author admin
 *
 */
public class PhoneMessageEntity extends  BaseMessageEntity {
	
	private UUID id;
	private String phoneNumber;
	private PhoneType phoneType;
	private String status;
	private String areaCode;
	private String Number;
	
	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the phoneType
	 */
	public PhoneType getPhoneType() {
		return phoneType;
	}
	/**
	 * @param phoneType the phoneType to set
	 */
	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
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
	 * @return the areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * @param areaCode the areaCode to set
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	/**
	 * @return the Number
	 */
	public String getNumber() {
		return Number;
	}
	/**
	 * @param Number the Number to set
	 */
	public void setNumber(String Number) {
		this.Number = Number;
	}

}
