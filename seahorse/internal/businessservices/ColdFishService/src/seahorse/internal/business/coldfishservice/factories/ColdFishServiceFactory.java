/**
 * 
 */
package seahorse.internal.business.coldfishservice.factories;

import com.google.inject.Guice;
import com.google.inject.Injector;

import seahorse.internal.business.coldfishservice.IColdFishService;
import seahorse.internal.business.coldfishservice.module.ColdFishServiceModule;
import seahorse.internal.business.shared.aop.ShardModules;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceFactory {
	
	 private ColdFishServiceFactory() {
		    throw new IllegalStateException("ColdFishServiceFactory class");
		  }

	public static IColdFishService getColdFishService() {
		
		Injector injector = Guice.createInjector(new ShardModules());
		injector = injector.createChildInjector(new ColdFishServiceModule());
		return injector.getInstance(IColdFishService.class);		
	}	
}
