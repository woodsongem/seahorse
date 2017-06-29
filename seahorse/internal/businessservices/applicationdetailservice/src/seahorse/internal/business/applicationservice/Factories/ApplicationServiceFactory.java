/**
 * 
 */
package seahorse.internal.business.applicationservice.Factories;

import com.google.inject.Guice;
import com.google.inject.Injector;

import seahorse.internal.business.applicationservice.IApplicationDetailService;
import seahorse.internal.business.applicationservice.module.ApplicationServiceModule;
import seahorse.internal.business.shared.aop.ShardModules;

/**
 * @author admin
 *
 */
public class ApplicationServiceFactory {

	public static IApplicationDetailService GetApplicationDetailService() {	
		
		Injector injector = Guice.createInjector(new ShardModules());
		injector = injector.createChildInjector(new ApplicationServiceModule());
		return injector.getInstance(IApplicationDetailService.class);				
	}

}
