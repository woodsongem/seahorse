package seahorse.internal.business.katavuccolservice.registries;

import java.security.GeneralSecurityException;

import com.google.crypto.tink.Config;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.inject.AbstractModule;
import seahorse.internal.business.katavuccolservice.*;
import seahorse.internal.business.katavuccolservice.api.IKatavuccolServiceApiMapper;
import seahorse.internal.business.katavuccolservice.api.KatavuccolServiceApiMapper;
import seahorse.internal.business.katavuccolservice.common.*;
import seahorse.internal.business.katavuccolservice.dal.*;
import seahorse.internal.business.katavuccolservice.postprocessors.IKatavuccolServicePostProcessor;
import seahorse.internal.business.katavuccolservice.postprocessors.KatavuccolServicePostProcessor;
import seahorse.internal.business.katavuccolservice.processors.*;
import seahorse.internal.business.katavuccolservice.validators.*;
import seahorse.internal.business.katavuccolservice.verifiers.*;


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
		bind(Ikatavuccolredis.class).to(Katavuccolredis.class);
		
		try {
			DeterministicAeadConfig.init();
		} catch (GeneralSecurityException e) {
			
		}
	    try {
			Config.register(DeterministicAeadConfig.TINK_1_1_0);
		} catch (GeneralSecurityException e) {
			
		}
	}
}
