/**
 * 
 */



package seahorse.internal.business.customerservice.app;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author admin
 *
 */
public class CustomerServiceApplication  extends ResourceConfig {
	
	 public CustomerServiceApplication() {
	        // Define the package which contains the service classes.
	        packages("seahorse.internal.business.customerservice.api.CustomerServiceApi");	        
	       // register(AopLoggingRequestFilter.class);
	    }

}
