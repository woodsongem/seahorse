package seahorse.internal.business.shared.aop;
/**
 * 
 */


import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author admin
 *
 */
public class ColdFishFilters extends ResourceConfig{
	
	public ColdFishFilters() {
               
        register(AopLoggingRequestFilter.class);
    }

}
