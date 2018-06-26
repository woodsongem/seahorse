/**
 * 
 */
package seahorse.internal.business.katavuccolservice.datacontracts;

/**
 * @author admin
 *
 */
public class GetCredentialByUserIdMessageEntity extends RequestMessageEntity {

	private String userId;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
