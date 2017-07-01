package seahorse.internal.business.applicationservice;

import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import seahorse.internal.business.applicationservice.dal.IApplicationDetailRepository;
import seahorse.internal.business.applicationservice.dal.datacontracts.ApplicationDetailDAO;
import seahorse.internal.business.applicationservice.datacontracts.ApplicationDetailMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.ApplicationDetailResponseMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.ResultMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.ResultStatus;
import seahorse.internal.business.applicationservice.utilities.ApplicationServiceUtility;
import seahorse.internal.business.applicationservice.validators.IApplicationServiceValidator;
import seahorse.internal.business.applicationservice.verifiers.IApplicationServiceVerifier;
import seahorse.internal.business.shared.aop.InjectLogger;
import seahorse.internal.business.shared.aop.Report;

public class ApplicationDetailService implements IApplicationDetailService {
	private final IApplicationDetailRepository _applicationDetailRepository;
	private final IApplicationDetailServiceMapper _applicationDetailServiceMapper;
	private final IApplicationServiceValidator _applicationServiceValidator;
	private final IApplicationServiceVerifier _applicationServiceVerifier;
	@InjectLogger  Logger logger;

	@Inject
	ApplicationDetailService(IApplicationDetailRepository applicationDetailRepository,
			IApplicationDetailServiceMapper applicationDetailServiceMapper,
			IApplicationServiceValidator applicationservicevalidator,
			IApplicationServiceVerifier applicationserviceverifier
			) {
		this._applicationDetailRepository = applicationDetailRepository;
		this._applicationDetailServiceMapper = applicationDetailServiceMapper;
		this._applicationServiceValidator=applicationservicevalidator;
		this._applicationServiceVerifier=applicationserviceverifier;		
	}

	@Report
	public ApplicationDetailMessageEntity GetApplicationByApplicationId(String applicationId) {
		
		ResultMessageEntity resultMessageEntity = _applicationServiceValidator.ValidateApplicationByApplicationId(applicationId);
		if(resultMessageEntity == null || resultMessageEntity.GetResultStatus() != ResultStatus.Success)
		{
			return ApplicationServiceUtility.GetApplicationDetailMessageEntity(resultMessageEntity,Status.BAD_REQUEST);
		}		
		ApplicationDetailDAO _applicationDetailDt = _applicationDetailRepository.GetApplicationByApplicationId(applicationId);
		ApplicationDetailMessageEntity applicationDetailMessageEntity=_applicationDetailServiceMapper.MapApplicationDetailMessageEntity(_applicationDetailDt);
		applicationDetailMessageEntity.SetResultStatus(ResultStatus.Success);
		applicationDetailMessageEntity.SetHttpStatus(Status.OK);
		return applicationDetailMessageEntity;
		
	}

	public ApplicationDetailResponseMessageEntity CreateApplication(ApplicationDetailMessageEntity _applicationDetailMessageEntity) {
		return null;
	}

	public ApplicationDetailResponseMessageEntity UpdateApplication(ApplicationDetailMessageEntity _applicationDetailMessageEntity) {
		return null;
	}

}
