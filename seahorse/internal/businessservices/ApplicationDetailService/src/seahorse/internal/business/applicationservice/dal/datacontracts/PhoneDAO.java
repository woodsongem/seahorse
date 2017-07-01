/**
 * 
 */
package seahorse.internal.business.applicationservice.dal.datacontracts;

import java.util.UUID;

/**
 * @author admin
 *
 */
public class PhoneDAO extends  BaseDAO {
	
	private UUID id;
	private String phoneNumber;
	private String phoneType;
	private String status;
	private String areaCode;
	private String number;
	private String verified;
	private String countryCode;
	private String fullPhoneNumber;
	
	/**
	 * @return the _id
	 */
	public UUID getId() {
		return id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void setId(UUID uuid) {
		this.id = uuid;
	}
	/**
	 * @return the _phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param _phoneNumber the _phoneNumber to set
	 */
	public void setPhoneNumber(String _phoneNumber) {
		this.phoneNumber = _phoneNumber;
	}
	/**
	 * @return the _phoneType
	 */
	public String getPhoneType() {
		return phoneType;
	}
	/**
	 * @param _phoneType the _phoneType to set
	 */
	public void setPhoneType(String _phoneType) {
		this.phoneType = _phoneType;
	}
	/**
	 * @return the _status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param _status the _status to set
	 */
	public void setStatus(String _status) {
		this.status = _status;
	}
	/**
	 * @return the _areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * @param _areaCode the _areaCode to set
	 */
	public void setAreaCode(String _areaCode) {
		this.areaCode = _areaCode;
	}
	/**
	 * @return the _Number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param _Number the _Number to set
	 */
	public void setNumber(String _Number) {
		this.number = _Number;
	}
	/**
	 * @return the verified
	 */
	public String getVerified() {
		return verified;
	}
	/**
	 * @param verified the verified to set
	 */
	public void setVerified(String verified) {
		this.verified = verified;
	}
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return the fullPhoneNumber
	 */
	public String getFullPhoneNumber() {
		return fullPhoneNumber;
	}
	/**
	 * @param fullPhoneNumber the fullPhoneNumber to set
	 */
	public void setFullPhoneNumber(String fullPhoneNumber) {
		this.fullPhoneNumber = fullPhoneNumber;
	}

}
