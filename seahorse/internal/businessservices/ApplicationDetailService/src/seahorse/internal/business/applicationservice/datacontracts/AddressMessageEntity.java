/**
 * 
 */
package seahorse.internal.business.applicationservice.datacontracts;

/**
 * @author admin
 *
 */
public class AddressMessageEntity extends BaseMessageEntity {

	private String id;
	private String addressLine1;
	private String addressLine2;
	private String cityId;
	private String cityName;
	private String stateId;
	private String stateName;
	private String countryId;
	private String countryName;
	private String zipCode;
	private String status;

	/**
	 * @return the _id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param _id
	 *            the _id to set
	 */
	public void setId(String _id) {
		this.id = _id;
	}

	/**
	 * @return the _addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param _addressLine1
	 *            the _addressLine1 to set
	 */
	public void setAddressLine1(String _addressLine1) {
		this.addressLine1 = _addressLine1;
	}

	/**
	 * @return the _addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param _addressLine2
	 *            the _addressLine2 to set
	 */
	public void setAddressLine2(String _addressLine2) {
		this.addressLine2 = _addressLine2;
	}

	/**
	 * @return the _cityId
	 */
	public String getCityId() {
		return cityId;
	}

	/**
	 * @param _cityId
	 *            the _cityId to set
	 */
	public void setCityId(String _cityId) {
		this.cityId = _cityId;
	}

	/**
	 * @return the _cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param _cityName
	 *            the _cityName to set
	 */
	public void setcityName(String _cityName) {
		this.cityName = _cityName;
	}

	/**
	 * @return the _stateId
	 */
	public String getstateId() {
		return stateId;
	}

	/**
	 * @param _stateId
	 *            the _stateId to set
	 */
	public void setStateId(String _stateId) {
		this.stateId = _stateId;
	}

	/**
	 * @return the _stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param _stateName
	 *            the _stateName to set
	 */
	public void setStateName(String _stateName) {
		this.stateName = _stateName;
	}

	/**
	 * @return the _countryId
	 */
	public String getCountryId() {
		return countryId;
	}

	/**
	 * @param _countryId
	 *            the _countryId to set
	 */
	public void setCountryId(String _countryId) {
		this.countryId = _countryId;
	}

	/**
	 * @return the _countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param _countryName
	 *            the _countryName to set
	 */
	public void setCountryName(String _countryName) {
		this.countryName = _countryName;
	}

	/**
	 * @return the _zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param _zipCode
	 *            the _zipCode to set
	 */
	public void setZipCode(String _zipCode) {
		this.zipCode = _zipCode;
	}

	/**
	 * @return the _status
	 */
	public String getstatus() {
		return status;
	}

	/**
	 * @param _status
	 *            the _status to set
	 */
	public void setstatus(String _status) {
		this.status = _status;
	}

}
