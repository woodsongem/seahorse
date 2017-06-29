/**
 * 
 */
package seahorse.internal.business.shared.aop;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

import seahorse.internal.business.applicationservice.common.CassandraConnector;
import seahorse.internal.business.applicationservice.common.ICassandraConnector;
import seahorse.internal.business.applicationservice.common.IReadPropertiesFile;
import seahorse.internal.business.applicationservice.common.ReadPropertiesFile;

/**
 * @author admin
 *
 */
public class ShardModules extends AbstractModule {

	@Override
	protected void configure() {
		LoggingEventHandler loggingEventHandler = new LoggingEventHandler();
		bindInterceptor(Matchers.any(), Matchers.annotatedWith(Report.class), loggingEventHandler);
		bindListener(Matchers.any(), new Log4JTypeListener());
		bind(IReadPropertiesFile.class).to(ReadPropertiesFile.class);
		bind(ICassandraConnector.class).to(CassandraConnector.class);
	}

}
