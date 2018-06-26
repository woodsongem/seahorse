/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.security.GeneralSecurityException;

import com.google.crypto.tink.Config;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.inject.AbstractModule;
import seahorse.internal.business.credentialtypeservice.dal.*;

/**
 * @author admin
 *
 */
public class CredentialTypeServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(ICredentialTypeService.class).to(CredentialTypeService.class);
		bind(ICredentialTypeServiceValidator.class).to(CredentialTypeServiceValidator.class);
		bind(ICredentialTypeServiceVerifier.class).to(CredentialTypeServiceVerifier.class);
		bind(ICredentialTypeServiceProcessor.class).to(CredentialTypeServiceProcessor.class);
		bind(ICredentialTypeServicePostProcessor.class).to(CredentialTypeServicePostProcessor.class);
		bind(ICredentialTypeServiceMapper.class).to(CredentialTypeServiceMapper.class);			
		bind(IBaseCredentialTypeService.class).to(BaseCredentialTypeService.class);
		bind(ICredentialTypeServiceRepository.class).to(CredentialTypeServiceRepository.class);
		bind(ICredentialTypeServiceRepositoryMapper.class).to(CredentialTypeServiceRepositoryMapper.class);		
		
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
