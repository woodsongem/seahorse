/**
 * 
 */
package seahorse.internal.business.applicationservice.module;

import com.google.inject.AbstractModule;

import seahorse.internal.business.applicationservice.ApplicationDetailService;
import seahorse.internal.business.applicationservice.ApplicationDetailServiceMapper;
import seahorse.internal.business.applicationservice.IApplicationDetailService;
import seahorse.internal.business.applicationservice.IApplicationDetailServiceMapper;
import seahorse.internal.business.applicationservice.constants.ApplicationServiceErrorCode;
import seahorse.internal.business.applicationservice.constants.IApplicationServiceErrorCode;
import seahorse.internal.business.applicationservice.dal.ApplicationDetailRepository;
import seahorse.internal.business.applicationservice.dal.ApplicationDetailRepositoryMapper;
import seahorse.internal.business.applicationservice.dal.IApplicationDetailRepository;
import seahorse.internal.business.applicationservice.dal.IApplicationDetailRepositoryMapper;
import seahorse.internal.business.applicationservice.validators.ApplicationServiceValidator;
import seahorse.internal.business.applicationservice.validators.IApplicationServiceValidator;
import seahorse.internal.business.applicationservice.verifiers.ApplicationServiceVerifier;
import seahorse.internal.business.applicationservice.verifiers.IApplicationServiceVerifier;

/**
 * @author admin
 *
 */
public class ApplicationServiceModule extends AbstractModule
{

	@Override
	protected void configure() {
		 /*
	      * This tells Guice that whenever it sees a dependency on a ApplicationDetailRepository,
	      * it should satisfy the dependency using a ApplicationDetailService.
	      */
		bind(IApplicationDetailRepositoryMapper.class).to(ApplicationDetailRepositoryMapper.class);
		bind(IApplicationDetailRepository.class).to(ApplicationDetailRepository.class);
		bind(IApplicationDetailServiceMapper.class).to(ApplicationDetailServiceMapper.class);
		bind(IApplicationDetailService.class).to(ApplicationDetailService.class);
		bind(IApplicationServiceValidator.class).to(ApplicationServiceValidator.class);
		bind(IApplicationServiceVerifier.class).to(ApplicationServiceVerifier.class);
		bind(IApplicationServiceErrorCode.class).to(ApplicationServiceErrorCode.class);
	}

}
