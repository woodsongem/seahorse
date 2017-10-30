/**
 * 
 */
package seahorse.internal.business.coldfishservice.api.datacontracts;

/**
 * @author sajanmje
 *
 */
public class RequestBase extends Base {
	
	private String ipAddress;
	

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}
