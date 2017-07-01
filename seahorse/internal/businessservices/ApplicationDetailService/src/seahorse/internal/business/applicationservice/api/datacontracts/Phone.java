/**
 * 
 */
package seahorse.internal.business.applicationservice.api.datacontracts;

import java.util.UUID;

/**
 * @author admin
 *
 */
public class Phone extends  Base {
	
	private String id;
	private String _phoneNumber;
	private String _phoneType;
	private String _status;
	private String _areaCode;
	private String _Number;
	
	/**
	 * @return the _id
	 */
	public String getid() {
		return id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void setid(UUID id) {
		
		if(id != null)
		{
			this.id =id.toString();
		}	
	}
	/**
	 * @return the _phoneNumber
	 */
	public String getphoneNumber() {
		return _phoneNumber;
	}
	/**
	 * @param _phoneNumber the _phoneNumber to set
	 */
	public void setphoneNumber(String _phoneNumber) {
		this._phoneNumber = _phoneNumber;
	}
	/**
	 * @return the _phoneType
	 */
	public String getphoneType() {
		return _phoneType;
	}
	/**
	 * @param _phoneType the _phoneType to set
	 */
	public void setphoneType(String _phoneType) {
		this._phoneType = _phoneType;
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
	/**
	 * @return the _areaCode
	 */
	public String getareaCode() {
		return _areaCode;
	}
	/**
	 * @param _areaCode the _areaCode to set
	 */
	public void setareaCode(String _areaCode) {
		this._areaCode = _areaCode;
	}
	/**
	 * @return the _Number
	 */
	public String getNumber() {
		return _Number;
	}
	/**
	 * @param _Number the _Number to set
	 */
	public void setNumber(String _Number) {
		this._Number = _Number;
	}

}
