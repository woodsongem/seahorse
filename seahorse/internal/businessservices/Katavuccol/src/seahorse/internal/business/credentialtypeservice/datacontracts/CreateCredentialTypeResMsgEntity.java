/**
 * 
 */
package seahorse.internal.business.credentialtypeservice.datacontracts;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResponseBaseMsgEntity;

/**
 * @author admin
 *
 */
public class CreateCredentialTypeResMsgEntity extends ResponseBaseMsgEntity  {

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
