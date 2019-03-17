/**
 * 
 */
package seahorse.internal.business.openapi.katavuccolopenapi.api;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author SMJE
 *
 */
public class KatavuccolOpenApiApplication extends ResourceConfig {
	public KatavuccolOpenApiApplication() {
		packages("seahorse.internal.business.openapi.katavuccolopenapi.api.UserCredentialServiceApi");
	}
}
