/**
 * 
 */
package seahorse.internal.business.applicationservice.dal;


import java.util.UUID;

import com.datastax.driver.core.Row;

import seahorse.internal.business.applicationservice.dal.datacontracts.AddressDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.ApplicationDetailDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.EmailAddressDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.PhoneDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.UserSecurityQuestionDAO;

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

	String getEmailAddressByIdQuery(UUID emailid);

	String getPhoneByIdQuery(UUID phoneid);

	String getUserSecurityQuestionQuery(UUID userSecurityQuestionId);

	UserSecurityQuestionDAO mapUserSecurityQuestionDAO(Row phoneResult);

}
