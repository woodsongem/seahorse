/**
 * 
 */
package seahorse.internal.business.openapi.usercredentialapi.api.datacontracts;

import seahorse.internal.business.openapi.katavuccolopenapi.api.datacontracts.BaseApiModel;

/**
 * @author SMJE
 *
 */
public class UserCredentialApiModel extends BaseApiModel {
	private String id;
	private String userName;
	private String productItemId;
	private String status;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
	public String getProductItemId() {
		return productItemId;
	}
	/**
	 * @param productItemId the productItemId to set
	 */
	public void setProductItemId(String productItemId) {
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
