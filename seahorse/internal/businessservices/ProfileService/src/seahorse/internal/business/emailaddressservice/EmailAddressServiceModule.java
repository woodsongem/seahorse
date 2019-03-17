/**
 * 
 */
package seahorse.internal.business.emailaddressservice;

import java.security.GeneralSecurityException;

import com.google.crypto.tink.Config;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.inject.AbstractModule;

import seahorse.internal.business.shared.katavuccol.common.CassandraConnector;
import seahorse.internal.business.shared.katavuccol.common.ICassandraConnector;
import seahorse.internal.business.shared.katavuccol.common.IReadPropertiesFile;
import seahorse.internal.business.shared.katavuccol.common.ReadPropertiesFile;

/**
 * @author SMJE
 *
 */
public class EmailAddressServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(IEmailAddressService.class).to(EmailAddressService.class);
		bind(IEmailAddressServiceValidator.class).to(EmailAddressServiceValidator.class);
		bind(IEmailAddressServiceVerifier.class).to(EmailAddressServiceVerifier.class);
		bind(IEmailAddressServiceProcessor.class).to(EmailAddressServiceProcessor.class);
		bind(IEmailAddressServicePostProcessor.class).to(EmailAddressServicePostProcessor.class);
		bind(IEmailAddressServiceMapper.class).to(EmailAddressServiceMapper.class);
		bind(IEmailAddressServiceRepository.class).to(EmailAddressServiceRepository.class);
		bind(IReadPropertiesFile.class).to(ReadPropertiesFile.class);
		bind(ICassandraConnector.class).to(CassandraConnector.class);
		bind(IBaseEmailAddressService.class).to(BaseEmailAddressService.class);
		bind(IEmailAddressServiceRepositoryMapper.class).to(EmailAddressServiceRepositoryMapper.class);
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
