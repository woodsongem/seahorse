/**
 * 
 */
package seahorse.internal.business.katavuccolservice.registries;

import com.google.inject.Guice;
import com.google.inject.Injector;

import seahorse.internal.business.categoryservice.CategoryServiceModule;
import seahorse.internal.business.categoryservice.ICategoryService;
import seahorse.internal.business.credentialservice.CredentialServiceModule;
import seahorse.internal.business.credentialservice.ICredentialService;
import seahorse.internal.business.credentialtypeservice.CredentialTypeServiceModule;
import seahorse.internal.business.credentialtypeservice.ICredentialTypeService;
import seahorse.internal.business.profileservice.IProfileService;
import seahorse.internal.business.profileservice.ProfileServiceModule;
import seahorse.internal.business.shared.aop.ShardModules;

/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceFactory {

	 private KatavuccolServiceFactory() {
		    throw new IllegalStateException("KatavuccolServiceFactory class");
		  }	
	
	public static ICredentialService getICredentialService()
	{
		Injector parent = Guice.createInjector(new ShardModules(),new CredentialServiceModule());
		//Injector child =parent.createChildInjector();
		//Injector injector = child.createChildInjector();		
		return parent.getInstance(ICredentialService.class);	
	}
	public static ICredentialTypeService getICredentialTypeService()
	{
		Injector parent = Guice.createInjector(new ShardModules(),new ProfileServiceModule(),new CredentialTypeServiceModule());
		//Injector child =parent.createChildInjector();
		//Injector injector = child.createChildInjector();		
		return parent.getInstance(ICredentialTypeService.class);	
	}
	public static ICategoryService getICategoryService()
	{
		Injector parent = Guice.createInjector(new ShardModules(),new CategoryServiceModule());
		//Injector child =parent.createChildInjector();
		//Injector injector = child.createChildInjector();		
		return parent.getInstance(ICategoryService.class);	
	}
	
	public static IProfileService getIProfileService()
	{
		Injector parent = Guice.createInjector(new ShardModules(),new ProfileServiceModule());
		//Injector child =parent.createChildInjector();
		//Injector injector = child.createChildInjector();		
		return parent.getInstance(IProfileService.class);	
	}
}
