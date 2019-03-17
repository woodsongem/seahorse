package seahorse.internal.business.shared.aop;
/**
 * 
 */


import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

import seahorse.internal.business.shared.aop.LoggingEventHandler;
import seahorse.internal.business.shared.aop.Report;

/**
 * @author admin
 *
 */
public class ReportModule extends AbstractModule  {

	protected void configure() {
		LoggingEventHandler loggingEventHandler = new LoggingEventHandler();		    
		bindInterceptor(Matchers.any(), Matchers.annotatedWith(Report.class),loggingEventHandler);		
	}

}
