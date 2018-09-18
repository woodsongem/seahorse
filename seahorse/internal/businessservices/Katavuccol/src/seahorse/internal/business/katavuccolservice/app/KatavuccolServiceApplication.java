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
	        packages("seahorse.internal.business.credentialservice.api.CredentialServiceApi");
	        packages("seahorse.internal.business.categoryservice.api.CategoryServiceApi");
	        packages("seahorse.internal.business.credentialtypeservice.api.CredentialTypeServiceApi");
	    }
}
