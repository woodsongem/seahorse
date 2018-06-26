/**
 * 
 */
package seahorse.internal.business.credentialservice;

import java.security.GeneralSecurityException;

import com.google.crypto.tink.Config;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.inject.AbstractModule;

/**
 * @author admin
 *
 */
public class CredentialServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(ICredentialService.class).to(CredentialService.class);
		bind(ICredentialServiceValidator.class).to(CredentialServiceValidator.class);
		bind(ICredentialServiceVerifier.class).to(CredentialServiceVerifier.class);
		bind(ICredentialServiceProcessor.class).to(CredentialServiceProcessor.class);
		bind(ICredentialServicePostProcessor.class).to(CredentialServicePostProcessor.class);
		bind(ICredentialServiceMapper.class).to(CredentialServiceMapper.class);			
		
		
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
