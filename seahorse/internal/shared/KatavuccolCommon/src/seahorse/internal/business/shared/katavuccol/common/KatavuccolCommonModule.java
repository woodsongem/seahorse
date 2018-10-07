/**
 * 
 */
package seahorse.internal.business.shared.katavuccol.common;

import com.google.inject.AbstractModule;


/**
 * @author SMJE
 *
 */
public class KatavuccolCommonModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ICassandraConnector.class).to(CassandraConnector.class);
		bind(IKatavuccolClient.class).to(KatavuccolClient.class);
		bind(Ikatavuccolredis.class).to(Katavuccolredis.class);
		bind(IKatavuccolServiceErrorCode.class).to(KatavuccolServiceErrorCode.class);
		bind(IReadPropertiesFile.class).to(ReadPropertiesFile.class);
		bind(IUserCredentialErrorCode.class).to(UserCredentialErrorCode.class);
		
		
	}

}
