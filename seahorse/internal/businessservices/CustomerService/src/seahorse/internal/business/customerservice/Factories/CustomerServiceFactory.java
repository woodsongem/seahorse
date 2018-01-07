/**
 * 
 */

package seahorse.internal.business.customerservice.Factories;

import com.google.inject.Guice;
import com.google.inject.Injector;

import seahorse.internal.business.customerservice.IAddressService;
import seahorse.internal.business.customerservice.IEmailAddressService;
import seahorse.internal.business.customerservice.IPhoneService;
import seahorse.internal.business.customerservice.IUserCredentialService;
import seahorse.internal.business.customerservice.module.CustomerServiceModule;
import seahorse.internal.business.shared.aop.ShardModules;

/**
 * @author admin
 *
 */
public class CustomerServiceFactory {
	
	  private CustomerServiceFactory() {
		    throw new IllegalAccessError("CustomerServiceFactory class");
		  }

	public static IEmailAddressService GetEmailAddressService() {	
		
		Injector injector = Guice.createInjector(new ShardModules());
		injector = injector.createChildInjector(new CustomerServiceModule());
		return injector.getInstance(IEmailAddressService.class);				
	}
	
	public static IAddressService GetAddressService() {	
		
		Injector injector = Guice.createInjector(new ShardModules());
		injector = injector.createChildInjector(new CustomerServiceModule());
		return injector.getInstance(IAddressService.class);				
	}
	
	public static IPhoneService GetPhoneService() {	
		
		Injector injector = Guice.createInjector(new ShardModules());
		injector = injector.createChildInjector(new CustomerServiceModule());
		return injector.getInstance(IPhoneService.class);				
	}
	
	public static IUserCredentialService GetUserCredentialService() {	
		
		Injector injector = Guice.createInjector(new ShardModules());
		injector = injector.createChildInjector(new CustomerServiceModule());
		return injector.getInstance(IUserCredentialService.class);				
	}

}
