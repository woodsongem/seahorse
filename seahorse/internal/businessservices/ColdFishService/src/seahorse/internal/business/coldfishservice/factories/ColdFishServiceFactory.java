/**
 * 
 */
package seahorse.internal.business.coldfishservice.factories;

import seahorse.internal.business.coldfishservice.IColdFishService;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceFactory {
	
	 private ColdFishServiceFactory() {
		    throw new IllegalStateException("ColdFishServiceFactory class");
		  }

	public static IColdFishService getColdFishService() {
		
		return null;
	}

}
