/**
 * 
 */
package seahorse.internal.business.applicationservice.api.datacontracts;

import seahorse.internal.business.applicationservice.common.datacontracts.NationalIdentifierType;

/**
 * @author admin
 *
 */
public class NationalIdentifier {

	private String _id;
	private NationalIdentifierType _type;
	private String _value;
	private String _status;

	/**
	 * @return the id
	 */
	public String getId() {
		return _id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		_id = id;
	}

	/**
	 * @return the type
	 */
	public NationalIdentifierType getType() {
		return _type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(NationalIdentifierType type) {
		_type = type;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return _value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		_value = value;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return _status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this._status = status;
	}

	/**
	 * @return the nationalIdentifierType
	 */

}
