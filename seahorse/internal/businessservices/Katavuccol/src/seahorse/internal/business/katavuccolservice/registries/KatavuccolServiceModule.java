/**
 * 
 */
package seahorse.internal.business.katavuccolservice.registries;

import com.google.inject.AbstractModule;
import seahorse.internal.business.katavuccolservice.IKatavuccolService;
import seahorse.internal.business.katavuccolservice.KatavuccolService;
import seahorse.internal.business.katavuccolservice.api.IKatavuccolServiceApiMapper;
import seahorse.internal.business.katavuccolservice.api.KatavuccolServiceApiMapper;
import seahorse.internal.business.katavuccolservice.postprocessors.IKatavuccolServicePostProcessor;
import seahorse.internal.business.katavuccolservice.postprocessors.KatavuccolServicePostProcessor;
import seahorse.internal.business.katavuccolservice.processors.IKatavuccolServiceProcessor;
import seahorse.internal.business.katavuccolservice.processors.KatavuccolServiceProcessor;
import seahorse.internal.business.katavuccolservice.validators.IKatavuccolServiceValidator;
import seahorse.internal.business.katavuccolservice.validators.KatavuccolServiceValidator;
import seahorse.internal.business.katavuccolservice.verifiers.IKatavuccolServiceVerifier;
import seahorse.internal.business.katavuccolservice.verifiers.KatavuccolServiceVerifier;


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
	}
}
