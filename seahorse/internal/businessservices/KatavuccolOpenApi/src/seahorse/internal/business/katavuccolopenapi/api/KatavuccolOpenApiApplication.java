/**
 * 
 */
package seahorse.internal.business.katavuccolopenapi.api;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author SMJE
 *
 */
public class KatavuccolOpenApiApplication extends ResourceConfig {
	public KatavuccolOpenApiApplication() {
		packages("seahorse.internal.business.katavuccolopenapi.api.UserCredentialServiceApi");
	}
}
