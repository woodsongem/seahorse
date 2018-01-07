/**
 * 
 */
package seahorse.internal.business.applicationservice.api.datacontracts;

import java.util.UUID;

/**
 * @author admin
 *
 */
public class EmailAddress extends Base {
	
	private String id;
	private String emailId;
	private String status;
	/**
	 * @return the _id
	 */
	public String getid() {
		return id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void setid(UUID _id) {
		if(_id != null)
		{
			this.id = _id.toString();
		}		
	}
	/**
	 * @return the _emailAddress
	 */
	public String getemailAddress() {
		return emailId;
	}
	/**
	 * @param _emailAddress the _emailAddress to set
	 */
	public void setemailAddress(String _emailAddress) {
		this.emailId = _emailAddress;
	}
	/**
	 * @return the _status
	 */
	public String getstatus() {
		return status;
	}
	/**
	 * @param _status the _status to set
	 */
	public void setstatus(String _status) {
		this.status = _status;
	}
	

}
