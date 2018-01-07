/**
 * 
 */
package seahorse.internal.business.applicationservice.datacontracts;

import java.util.UUID;

/**
 * @author admin
 *
 */
public class EmailAddressMessageEntity extends BaseMessageEntity {
	
	private UUID id;
	private String emailAddress;
	private String status;
	/**
	 * @return the id
	 */
	public UUID getid() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setid(UUID id) {
		this.id = id;
	}
	/**
	 * @return the emailAddress
	 */
	public String getemailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setemailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the status
	 */
	public String getstatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setstatus(String status) {
		this.status = status;
	}
	

}
