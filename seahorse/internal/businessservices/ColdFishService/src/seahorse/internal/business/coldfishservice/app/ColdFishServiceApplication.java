/**
 * 
 */

package seahorse.internal.business.coldfishservice.app;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author admin
 *
 */
public class ColdFishServiceApplication  extends ResourceConfig {
	
	 public ColdFishServiceApplication() {
	        
	        packages("seahorse.internal.business.coldfishservice.api.ColdFishServiceAPI");	        
	       
	    }

}
