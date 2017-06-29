/**
 * 
 */
package seahorse.internal.business.applicationservice.api.datacontracts;

/**
 * @author admin
 *
 */
public class EmailAddress extends Base {
	
	private String _id;
	private String _emailAddress;
	private String _status;
	/**
	 * @return the _id
	 */
	public String getid() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void setid(String _id) {
		this._id = _id;
	}
	/**
	 * @return the _emailAddress
	 */
	public String getemailAddress() {
		return _emailAddress;
	}
	/**
	 * @param _emailAddress the _emailAddress to set
	 */
	public void setemailAddress(String _emailAddress) {
		this._emailAddress = _emailAddress;
	}
	/**
	 * @return the _status
	 */
	public String getstatus() {
		return _status;
	}
	/**
	 * @param _status the _status to set
	 */
	public void setstatus(String _status) {
		this._status = _status;
	}
	

}
