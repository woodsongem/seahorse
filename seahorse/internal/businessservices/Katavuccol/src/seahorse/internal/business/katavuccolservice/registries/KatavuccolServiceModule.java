/**
 * 
 */
package seahorse.internal.business.katavuccolservice.registries;

import com.google.inject.AbstractModule;
import seahorse.internal.business.katavuccolservice.IKatavuccolService;
import seahorse.internal.business.katavuccolservice.IKatavuccolServiceMapper;
import seahorse.internal.business.katavuccolservice.KatavuccolService;
import seahorse.internal.business.katavuccolservice.KatavuccolServiceMapper;
import seahorse.internal.business.katavuccolservice.api.IKatavuccolServiceApiMapper;
import seahorse.internal.business.katavuccolservice.api.KatavuccolServiceApiMapper;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.dal.IKatavuccolServiceRepository;
import seahorse.internal.business.katavuccolservice.dal.IKatavuccolServiceRepositoryMapper;
import seahorse.internal.business.katavuccolservice.dal.KatavuccolServiceRepository;
import seahorse.internal.business.katavuccolservice.dal.KatavuccolServiceRepositoryMapper;
import seahorse.internal.business.katavuccolservice.postprocessors.IKatavuccolServicePostProcessor;
import seahorse.internal.business.katavuccolservice.postprocessors.KatavuccolServicePostProcessor;
import seahorse.internal.business.katavuccolservice.processors.IKatavuccolServiceProcessor;
import seahorse.internal.business.katavuccolservice.processors.IKatavuccolServiceProcessorMapper;
import seahorse.internal.business.katavuccolservice.processors.KatavuccolServiceProcessor;
import seahorse.internal.business.katavuccolservice.processors.KatavuccolServiceProcessorMapper;
import seahorse.internal.business.katavuccolservice.validators.BaseValidator;
import seahorse.internal.business.katavuccolservice.validators.IBaseValidator;
import seahorse.internal.business.katavuccolservice.validators.IKatavuccolServiceValidator;
import seahorse.internal.business.katavuccolservice.validators.KatavuccolServiceValidator;
import seahorse.internal.business.katavuccolservice.verifiers.BaseVerifier;
import seahorse.internal.business.katavuccolservice.verifiers.IBaseVerifier;
import seahorse.internal.business.katavuccolservice.verifiers.IKatavuccolServiceVerifier;
import seahorse.internal.business.katavuccolservice.verifiers.IKatavuccolServiceVerifierMapper;
import seahorse.internal.business.katavuccolservice.verifiers.KatavuccolServiceVerifier;
import seahorse.internal.business.katavuccolservice.verifiers.KatavuccolServiceVerifierMapper;


/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IKatavuccolService.class).to(KatavuccolService.class);
		bind(IKatavuccolServiceValidator.class).to(KatavuccolServiceValidator.class);
		bind(IKatavuccolServiceVerifier.class).to(KatavuccolServiceVerifier.class);
		bind(IKatavuccolServiceProcessor.class).to(KatavuccolServiceProcessor.class);
		bind(IKatavuccolServicePostProcessor.class).to(KatavuccolServicePostProcessor.class);
		bind(IKatavuccolServiceApiMapper.class).to(KatavuccolServiceApiMapper.class);
		bind(IKatavuccolServiceMapper.class).to(KatavuccolServiceMapper.class);		
		bind(IKatavuccolServiceErrorCode.class).to(KatavuccolServiceErrorCode.class);
		bind(IKatavuccolServiceRepository.class).to(KatavuccolServiceRepository.class);
		bind(IKatavuccolServiceRepositoryMapper.class).to(KatavuccolServiceRepositoryMapper.class);	
		bind(IKatavuccolServiceProcessorMapper.class).to(KatavuccolServiceProcessorMapper.class);
		bind(IKatavuccolServiceVerifierMapper.class).to(KatavuccolServiceVerifierMapper.class);		
		bind(IBaseValidator.class).to(BaseValidator.class);
		bind(IBaseVerifier.class).to(BaseVerifier.class);
	}
}
