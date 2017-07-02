/**
 * 
 */
package seahorse.internal.business.applicationservice.dal;

import java.util.UUID;

import seahorse.internal.business.applicationservice.dal.datacontracts.ApplicationDetailDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.EmailAddressDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.PhoneDAO;
import seahorse.internal.business.applicationservice.datacontracts.ApplicationDetailResponseMessageEntity;

/**
 * @author admin
 *
 */
public interface IApplicationDetailRepository {

	ApplicationDetailDAO GetApplicationByApplicationId(String applicationId);

	ApplicationDetailResponseMessageEntity CreateApplication(ApplicationDetailDAO _applicationDetailDAO);

	ApplicationDetailResponseMessageEntity UpdateApplication(ApplicationDetailDAO _applicationDetailDAO);
	
	EmailAddressDAO GetEmailAddressById(UUID emailid) ;
	
	PhoneDAO GetPhoneById(UUID phoneid);

}
