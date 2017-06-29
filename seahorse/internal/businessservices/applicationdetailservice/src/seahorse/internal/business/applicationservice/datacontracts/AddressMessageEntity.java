/**
 * 
 */
package seahorse.internal.business.applicationservice.datacontracts;

/**
 * @author admin
 *
 */
public class AddressMessageEntity extends BaseMessageEntity {

	private String _id;
	private String _addressLine1;
	private String _addressLine2;
	private String _cityId;
	private String _cityName;
	private String _stateId;
	private String _stateName;
	private String _countryId;
	private String _countryName;
	private String _zipCode;
	private String _status;

	/**
	 * @return the _id
	 */
	public String getId() {
		return _id;
	}

	/**
	 * @param _id
	 *            the _id to set
	 */
	public void setId(String _id) {
		this._id = _id;
	}

	/**
	 * @return the _addressLine1
	 */
	public String getAddressLine1() {
		return _addressLine1;
	}

	/**
	 * @param _addressLine1
	 *            the _addressLine1 to set
	 */
	public void setAddressLine1(String _addressLine1) {
		this._addressLine1 = _addressLine1;
	}

	/**
	 * @return the _addressLine2
	 */
	public String getAddressLine2() {
		return _addressLine2;
	}

	/**
	 * @param _addressLine2
	 *            the _addressLine2 to set
	 */
	public void setAddressLine2(String _addressLine2) {
		this._addressLine2 = _addressLine2;
	}

	/**
	 * @return the _cityId
	 */
	public String getCityId() {
		return _cityId;
	}

	/**
	 * @param _cityId
	 *            the _cityId to set
	 */
	public void setCityId(String _cityId) {
		this._cityId = _cityId;
	}

	/**
	 * @return the _cityName
	 */
	public String getCityName() {
		return _cityName;
	}

	/**
	 * @param _cityName
	 *            the _cityName to set
	 */
	public void setcityName(String _cityName) {
		this._cityName = _cityName;
	}

	/**
	 * @return the _stateId
	 */
	public String getstateId() {
		return _stateId;
	}

	/**
	 * @param _stateId
	 *            the _stateId to set
	 */
	public void setStateId(String _stateId) {
		this._stateId = _stateId;
	}

	/**
	 * @return the _stateName
	 */
	public String getStateName() {
		return _stateName;
	}

	/**
	 * @param _stateName
	 *            the _stateName to set
	 */
	public void setStateName(String _stateName) {
		this._stateName = _stateName;
	}

	/**
	 * @return the _countryId
	 */
	public String getCountryId() {
		return _countryId;
	}

	/**
	 * @param _countryId
	 *            the _countryId to set
	 */
	public void setCountryId(String _countryId) {
		this._countryId = _countryId;
	}

	/**
	 * @return the _countryName
	 */
	public String getCountryName() {
		return _countryName;
	}

	/**
	 * @param _countryName
	 *            the _countryName to set
	 */
	public void setCountryName(String _countryName) {
		this._countryName = _countryName;
	}

	/**
	 * @return the _zipCode
	 */
	public String getZipCode() {
		return _zipCode;
	}

	/**
	 * @param _zipCode
	 *            the _zipCode to set
	 */
	public void setZipCode(String _zipCode) {
		this._zipCode = _zipCode;
	}

	/**
	 * @return the _status
	 */
	public String getstatus() {
		return _status;
	}

	/**
	 * @param _status
	 *            the _status to set
	 */
	public void setstatus(String _status) {
		this._status = _status;
	}

}
