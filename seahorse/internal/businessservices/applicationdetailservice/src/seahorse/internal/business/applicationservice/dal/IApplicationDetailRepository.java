/**
 * 
 */
package seahorse.internal.business.applicationservice.dal;

import seahorse.internal.business.applicationservice.dal.datacontracts.ApplicationDetailDAO;
import seahorse.internal.business.applicationservice.datacontracts.ApplicationDetailResponseMessageEntity;

/**
 * @author admin
 *
 */
public interface IApplicationDetailRepository {

	ApplicationDetailDAO GetApplicationByApplicationId(String applicationId);

	ApplicationDetailResponseMessageEntity CreateApplication(ApplicationDetailDAO _applicationDetailDAO);

	ApplicationDetailResponseMessageEntity UpdateApplication(ApplicationDetailDAO _applicationDetailDAO);

}
