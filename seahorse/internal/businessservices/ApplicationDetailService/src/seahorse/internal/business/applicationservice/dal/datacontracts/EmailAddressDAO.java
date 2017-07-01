/**
 * 
 */
package seahorse.internal.business.applicationservice.dal.datacontracts;

import java.util.UUID;

/**
 * @author admin
 *
 */
public class EmailAddressDAO extends BaseDAO {
	
	private UUID id;
	private String emailAddress;
	private String status;
	private boolean isPrimary;
	private String verified;	
	
	
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
	 * @return the _emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param _emailAddress the _emailAddress to set
	 */
	public void setEmailAddress(String _emailAddress) {
		this.emailAddress = _emailAddress;
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
	 * @return the isPrimary
	 */
	public boolean isPrimary() {
		return isPrimary;
	}
	/**
	 * @param isPrimary the isPrimary to set
	 */
	public void setIsPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
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
	

}
