/**
 * 
 */
package seahorse.internal.business.applicationservice.dal.datacontracts;

/**
 * @author admin
 *
 */
public class NameDAO {
	
	private String _firstName;
	private String _lastName;
	private String _middleName;
	private String _prefix;
	/**
	 * @return the _firstName
	 */
	public String getfirstName() {
		return _firstName;
	}
	/**
	 * @param _firstName the _firstName to set
	 */
	public void setfirstName(String _firstName) {
		this._firstName = _firstName;
	}
	/**
	 * @return the _lastName
	 */
	public String getlastName() {
		return _lastName;
	}
	/**
	 * @param _lastName the _lastName to set
	 */
	public void setlastName(String _lastName) {
		this._lastName = _lastName;
	}
	/**
	 * @return the _middleName
	 */
	public String getmiddleName() {
		return _middleName;
	}
	/**
	 * @param _middleName the _middleName to set
	 */
	public void setmiddleName(String _middleName) {
		this._middleName = _middleName;
	}
	/**
	 * @return the _prefix
	 */
	public String getprefix() {
		return _prefix;
	}
	/**
	 * @param _prefix the _prefix to set
	 */
	public void setprefix(String _prefix) {
		this._prefix = _prefix;
	}
}