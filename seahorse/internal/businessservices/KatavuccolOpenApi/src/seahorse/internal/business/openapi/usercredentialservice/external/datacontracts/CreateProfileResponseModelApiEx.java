/**
 * 
 */
package seahorse.internal.business.openapi.usercredentialservice.external.datacontracts;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultModel;

/**
 * @author SMJE
 *
 */
public class CreateProfileResponseModelApiEx extends ResultModel {
	private String id;

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
}
