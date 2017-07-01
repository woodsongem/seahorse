/**
 * 
 */
package seahorse.internal.business.applicationservice;

import seahorse.internal.business.applicationservice.dal.datacontracts.ApplicationDetailDAO;
import seahorse.internal.business.applicationservice.datacontracts.ApplicationDetailMessageEntity;

/**
 * @author admin
 *
 */
public interface IApplicationDetailServiceMapper {

	ApplicationDetailMessageEntity MapApplicationDetailMessageEntity(ApplicationDetailDAO _applicationDetailDAO);

}
