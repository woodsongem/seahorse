/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import java.security.GeneralSecurityException;

import com.google.crypto.tink.Config;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.inject.AbstractModule;

/**
 * @author SMJE
 *
 */
public class UserCredentialServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(IUserCredentialService.class).to(UserCredentialService.class);
		bind(IUserCredentialServiceMapper.class).to(UserCredentialServiceMapper.class);
		
		
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
