/**
 * 
 */
package seahorse.internal.business.applicationservice.dal;


import com.datastax.driver.core.Row;

import seahorse.internal.business.applicationservice.dal.datacontracts.AddressDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.ApplicationDetailDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.EmailAddressDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.PhoneDAO;

/**
 * @author admin
 *
 */
public interface IApplicationDetailRepositoryMapper {

	ApplicationDetailDAO mapGetApplicationByApplicationId(Row applicationResult);

	String getApplicationByApplicationIdQuery(String applicationId);
	
	EmailAddressDAO mapEmailAddressDAO(Row emailAddress);
	
	PhoneDAO mapPhoneDAO(Row phoneResult);
	
	AddressDAO mapAddressDAO(Row addressResult);

}
