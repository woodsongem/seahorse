/**
 * 
 */
package seahorse.internal.business.katavuccolservice.registries;

import com.google.inject.Guice;
import com.google.inject.Injector;
import seahorse.internal.business.katavuccolservice.IKatavuccolService;
import seahorse.internal.business.shared.aop.ShardModules;

/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceFactory {

	 private KatavuccolServiceFactory() {
		    throw new IllegalStateException("KatavuccolServiceFactory class");
		  }
	 
	public static IKatavuccolService getKatavuccolService() {		
		Injector injector = Guice.createInjector(new ShardModules());
		injector = injector.createChildInjector(new KatavuccolServiceModule());
		return injector.getInstance(IKatavuccolService.class);		
	}	
}
