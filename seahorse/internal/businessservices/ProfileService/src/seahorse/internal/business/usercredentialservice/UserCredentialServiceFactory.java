/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import com.google.inject.Guice;
import com.google.inject.Injector;

import seahorse.internal.business.profileservice.common.ShardModules;


/**
 * @author SMJE
 *
 */
public class UserCredentialServiceFactory {

	public static IUserCredentialService getIUserCredentialService() {
		Injector parent = Guice.createInjector(new ShardModules(),new UserCredentialServiceModule());
		//Injector child =parent.createChildInjector();
		//Injector injector = child.createChildInjector();		
		return parent.getInstance(IUserCredentialService.class);	
	}

}
