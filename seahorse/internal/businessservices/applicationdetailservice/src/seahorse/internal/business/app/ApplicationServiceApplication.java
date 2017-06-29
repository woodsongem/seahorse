/**
 * 
 */
package seahorse.internal.business.app;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author admin
 *
 */
public class ApplicationServiceApplication  extends ResourceConfig {
	
	 public ApplicationServiceApplication() {
	        // Define the package which contains the service classes.
	        packages("seahorse.internal.business.applicationservice.api.ApplicationDetailServiceApi");	        
	       // register(AopLoggingRequestFilter.class);
	    }

}
