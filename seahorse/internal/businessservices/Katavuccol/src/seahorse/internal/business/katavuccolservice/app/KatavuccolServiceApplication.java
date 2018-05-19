/**
 * 
 */

package seahorse.internal.business.katavuccolservice.app;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author admin
 *
 */
public class KatavuccolServiceApplication  extends ResourceConfig {
	
	 public KatavuccolServiceApplication() {	        
	        packages("seahorse.internal.business.katavuccolservice.api.KatavuccolServiceApi");
	    }
}
