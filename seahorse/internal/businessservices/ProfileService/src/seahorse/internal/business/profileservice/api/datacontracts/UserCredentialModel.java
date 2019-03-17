/**
 * 
 */
package seahorse.internal.business.profileservice.api.datacontracts;

import java.util.UUID;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.BaseModel;

/**
 * @author SMJE
 *
 */
public class UserCredentialModel extends BaseModel {
	private UUID id;
	private String userName;
	private UUID productItemId;
	private String status;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the productItemId
	 */
	public UUID getProductItemId() {
		return productItemId;
	}
	/**
	 * @param productItemId the productItemId to set
	 */
	public void setProductItemId(UUID productItemId) {
		this.productItemId = productItemId;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
