/**
 * 
 */
package seahorse.internal.business.shared.aop;

import org.glassfish.jersey.server.ResourceConfig;

import seahorse.internal.business.shared.aop.requestfilter.AopLoggingRequestFilter;

/**
 * @author admin
 *
 */
public class SeahorseApplication extends ResourceConfig{
	
	public SeahorseApplication() {
               
        register(AopLoggingRequestFilter.class);
    }

}
