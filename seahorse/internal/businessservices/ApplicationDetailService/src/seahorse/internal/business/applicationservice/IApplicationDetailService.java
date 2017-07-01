package seahorse.internal.business.applicationservice;

import seahorse.internal.business.applicationservice.datacontracts.ApplicationDetailMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.ApplicationDetailResponseMessageEntity;

public interface IApplicationDetailService {
	
	public ApplicationDetailMessageEntity GetApplicationByApplicationId(String applicationId);
	
	public ApplicationDetailResponseMessageEntity CreateApplication(ApplicationDetailMessageEntity _applicationDetailMessageEntity);
	
	
	public ApplicationDetailResponseMessageEntity UpdateApplication(ApplicationDetailMessageEntity _applicationDetailMessageEntity);
	

}
