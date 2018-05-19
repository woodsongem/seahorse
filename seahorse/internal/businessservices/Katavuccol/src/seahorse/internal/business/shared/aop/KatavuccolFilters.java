package seahorse.internal.business.shared.aop;
/**
 * 
 */


import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author admin
 *
 */
public class KatavuccolFilters extends ResourceConfig{
	
	public KatavuccolFilters() {
               
        register(AopLoggingRequestFilter.class);
    }

}
