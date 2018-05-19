/**
 * 
 */
package seahorse.internal.business.katavuccolservice.datacontracts;

import java.util.UUID;

/**
 * @author sajanmje
 *
 */
public class GetUserCredentialMessageEntity {

	private UUID userId;
	private UserCredentialMessageEntity userCredential;

	/**
	 * @return the userId
	 */
	public UUID getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	/**
	 * @return the userCredential
	 */
	public UserCredentialMessageEntity getUserCredential() {
		return userCredential;
	}

	/**
	 * @param userCredential the userCredential to set
	 */
	public void setUserCredential(UserCredentialMessageEntity userCredential) {
		this.userCredential = userCredential;
	}
}
