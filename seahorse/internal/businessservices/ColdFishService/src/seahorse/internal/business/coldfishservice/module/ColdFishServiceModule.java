/**
 * 
 */
package seahorse.internal.business.coldfishservice.module;

import com.google.inject.AbstractModule;

import seahorse.internal.business.coldfishservice.ColdFishService;
import seahorse.internal.business.coldfishservice.ColdFishServiceMapper;
import seahorse.internal.business.coldfishservice.IColdFishService;
import seahorse.internal.business.coldfishservice.IColdFishServiceMapper;
import seahorse.internal.business.coldfishservice.common.datacontracts.ColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.IColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.dal.ColdFishServiceRepository;
import seahorse.internal.business.coldfishservice.dal.ColdFishServiceRepositoryMapper;
import seahorse.internal.business.coldfishservice.dal.IColdFishServiceRepository;
import seahorse.internal.business.coldfishservice.dal.IColdFishServiceRepositoryMapper;
import seahorse.internal.business.coldfishservice.postprocessors.ColdFishServicePostProcessor;
import seahorse.internal.business.coldfishservice.postprocessors.ColdFishServicePostProcessorMapper;
import seahorse.internal.business.coldfishservice.postprocessors.IColdFishServicePostProcessor;
import seahorse.internal.business.coldfishservice.postprocessors.IColdFishServicePostProcessorMapper;
import seahorse.internal.business.coldfishservice.processors.ColdFishServiceProcessor;
import seahorse.internal.business.coldfishservice.processors.ColdFishServiceProcessorMapper;
import seahorse.internal.business.coldfishservice.processors.IColdFishServiceProcessor;
import seahorse.internal.business.coldfishservice.processors.IColdFishServiceProcessorMapper;
import seahorse.internal.business.coldfishservice.validators.ColdFishServiceValidator;
import seahorse.internal.business.coldfishservice.validators.IColdFishServiceValidator;
import seahorse.internal.business.coldfishservice.verifiers.ColdFishServiceVerifier;
import seahorse.internal.business.coldfishservice.verifiers.ColdFishServiceVerifierMapper;
import seahorse.internal.business.coldfishservice.verifiers.IColdFishServiceVerifier;
import seahorse.internal.business.coldfishservice.verifiers.IColdFishServiceVerifierMapper;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceModule extends AbstractModule {

	@Override
	protected void configure() {

		bind(IColdFishService.class).to(ColdFishService.class);
		bind(IColdFishServiceMapper.class).to(ColdFishServiceMapper.class);
		bind(IColdFishServiceVerifier.class).to(ColdFishServiceVerifier.class);
		bind(IColdFishServiceValidator.class).to(ColdFishServiceValidator.class);
		bind(IColdFishServiceProcessor.class).to(ColdFishServiceProcessor.class);
		bind(IColdFishServicePostProcessor.class).to(ColdFishServicePostProcessor.class);
		
		
		bind(IColdFishServiceVerifierMapper.class).to(ColdFishServiceVerifierMapper.class);
		bind(IColdFishServiceErrorCode.class).to(ColdFishServiceErrorCode.class);
		bind(IColdFishServiceRepository.class).to(ColdFishServiceRepository.class);
		
		bind(IColdFishServiceProcessorMapper.class).to(ColdFishServiceProcessorMapper.class);
		bind(IColdFishServiceErrorCode.class).to(ColdFishServiceErrorCode.class);
		
		bind(IColdFishServiceRepositoryMapper.class).to(ColdFishServiceRepositoryMapper.class);
		bind(IColdFishServicePostProcessorMapper.class).to(ColdFishServicePostProcessorMapper.class);
	
	}

}
