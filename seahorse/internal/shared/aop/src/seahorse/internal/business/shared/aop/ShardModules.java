/**
 * 
 */
package seahorse.internal.business.shared.aop;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/**
 * @author SMJE
 *
 */
public class ShardModules extends AbstractModule {

	@Override
	protected void configure() {
		LoggingEventHandler loggingEventHandler = new LoggingEventHandler();
		bindInterceptor(Matchers.any(), Matchers.annotatedWith(Report.class), loggingEventHandler);
		bindListener(Matchers.any(), new Log4JTypeListener());
		
	}
}
