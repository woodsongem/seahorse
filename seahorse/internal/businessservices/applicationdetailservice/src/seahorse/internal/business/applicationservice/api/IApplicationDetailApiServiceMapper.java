/**
 * 
 */
package seahorse.internal.business.applicationservice.api;

import seahorse.internal.business.applicationservice.api.datacontracts.ApplicationDetail;
import seahorse.internal.business.applicationservice.api.datacontracts.ApplicationDetailResponse;
import seahorse.internal.business.applicationservice.datacontracts.ApplicationDetailMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.ApplicationDetailResponseMessageEntity;

/**
 * @author admin
 *
 */
public interface IApplicationDetailApiServiceMapper {

	ApplicationDetail MapApplicationDetail(ApplicationDetailMessageEntity _applicationDetailsMessageEntity);

	ApplicationDetailMessageEntity MapApplicationDetailMessageEntity(ApplicationDetail applicationDetail);

	ApplicationDetailResponse MapApplicationDetailResponse(ApplicationDetailResponseMessageEntity _applicationDetailResponseMessageEntity);

	

}
