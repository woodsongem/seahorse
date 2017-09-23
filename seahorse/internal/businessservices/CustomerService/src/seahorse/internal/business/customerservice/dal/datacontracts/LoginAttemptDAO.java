/**
 * 
 */
package seahorse.internal.business.customerservice.dal.datacontracts;

import java.util.UUID;

import seahorse.internal.business.customerservice.datacontracts.BaseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class LoginAttemptDAO extends BaseMessageEntity {
	private UUID id;
	private UUID userid;
	private int loginattempts;
	private String username;
	
	/**
	 * @return the loginattempts
	 */
	public int getLoginAttempts() {
		return loginattempts;
	}
	/**
	 * @param loginattempts the loginattempts to set
	 */
	public void setLoginAttempts(int loginattempts) {
		this.loginattempts = loginattempts;
	}
	/**
	 * @return the userid
	 */
	public UUID getUserId() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserId(UUID userid) {
		this.userid = userid;
	}
	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}	
	/**
	 * @return the username
	 */
	public String getUserName() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUserName(String username) {
		this.username = username;
	}	
}
