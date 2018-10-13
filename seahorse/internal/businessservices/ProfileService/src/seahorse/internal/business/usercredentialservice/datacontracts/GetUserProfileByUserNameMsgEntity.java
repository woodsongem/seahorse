/**
 * 
 */
package seahorse.internal.business.usercredentialservice.datacontracts;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.BaseMessageEntity;

/**
 * @author SMJE
 *
 */
public class GetUserProfileByUserNameMsgEntity extends BaseMessageEntity {

	private String username;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}
