/**
 * 
 */
package seahorse.internal.business.profileservice.api;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author SMJE
 *
 */
public class ProfileServiceApplication extends ResourceConfig {
	public ProfileServiceApplication() {
		packages("seahorse.internal.business.profileservice.api.ProfileServiceApi");
	}
}
