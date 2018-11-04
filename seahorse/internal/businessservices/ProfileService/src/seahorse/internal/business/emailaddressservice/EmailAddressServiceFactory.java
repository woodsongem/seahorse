/**
 * 
 */
package seahorse.internal.business.emailaddressservice;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author SMJE
 *
 */
public class EmailAddressServiceFactory {

	public static IEmailAddressService getIEmailAddressService() {
		Injector parent = Guice.createInjector(new EmailAddressServiceModule());
		//Injector child =parent.createChildInjector();
		//Injector injector = child.createChildInjector();		
		return parent.getInstance(IEmailAddressService.class);	
	}

}
