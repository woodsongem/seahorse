/**
 * 
 */
package seahorse.internal.business.coldfishservice.common.datacontracts;

import java.util.Date;

/**
 * @author admin
 *
 */
public class BaseMessageEntity extends ResultMessageEntity {
	
	public String CreatedBy;
	public String ModifiedBy;
	public Date CreatedDate;
	public Date ModifiedDate;
	public String HttpMethod;
	public String IpAddress;	

}
