/**
 * 
 */
package seahorse.internal.business.katavuccolservice.datacontracts;

import seahorse.internal.business.katavuccolservice.common.datacontracts.BaseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class GetCategoryMessageEntity extends BaseMessageEntity {
	
	private String userid;

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
}
