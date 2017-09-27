/**
 * 
 */
package seahorse.internal.business.coldfishservice.dal.datacontracts;

import java.util.Date;
import java.util.UUID;

import com.datastax.driver.core.LocalDate;

/**
 * @author sajanmje
 *
 */
public class IncometypeDAO {

	public String Name;
	public String Status;
	public UUID Id;
	public String CreatedBy;
	public LocalDate CreatedDate;
	public String Description;
	public String ModifiedBy;
	public LocalDate ModifiedDate;
	public UUID UserId;
	public String Category;	
}
