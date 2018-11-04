/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import com.google.inject.Guice;
import com.google.inject.Injector;


/**
 * @author SMJE
 *
 */
public class UserCredentialServiceFactory {

	public static IUserCredentialService getIUserCredentialService() {
		Injector parent = Guice.createInjector(new UserCredentialServiceModule());
		//Injector child =parent.createChildInjector();
		//Injector injector = child.createChildInjector();		
		return parent.getInstance(IUserCredentialService.class);	
	}


}
