/**
 * 
 */
package seahorse.internal.business.coldfishservice.processors.datacontracts;

import java.util.UUID;

/**
 * @author sajanmje
 *
 */
public class LoginDetailMessageEntity {

	private UUID userId;

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

}
