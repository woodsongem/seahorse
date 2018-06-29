/**
 * 
 */
package seahorse.internal.business.profileservice;

import java.security.GeneralSecurityException;
import com.google.crypto.tink.Config;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.inject.AbstractModule;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceErrorCode;

/**
 * @author admin
 *
 */
public class ProfileServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IProfileService.class).to(ProfileService.class);
		bind(IProfileServiceValidator.class).to(ProfileServiceValidator.class);
		bind(IProfileServiceVerifier.class).to(ProfileServiceVerifier.class);
		bind(IProfileServiceProcessor.class).to(ProfileServiceProcessor.class);
		bind(IProfileServicePostProcessor.class).to(ProfileServicePostProcessor.class);
		bind(IProfileServiceMapper.class).to(ProfileServiceMapper.class);			
		bind(IBaseProfileService.class).to(BaseProfileService.class);
		bind(IProfileServiceRepository.class).to(ProfileServiceRepository.class);
		bind(IProfileServiceRepositoryMapper.class).to(ProfileServiceRepositoryMapper.class);	
		bind(IKatavuccolServiceErrorCode.class).to(KatavuccolServiceErrorCode.class);
		
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
