/**
 * 
 */
package seahorse.internal.business.openapi.usercredentialservice;

import com.google.inject.Guice;
import com.google.inject.Injector;

import seahorse.internal.business.shared.katavuccol.common.KatavuccolCommonModule;

/**
 * @author SMJE
 *
 */
public class UserCredentialServiceFactory {

	public static IUserCredentialService GetIUserCredentialService() {
		Injector parent = Guice.createInjector(new KatavuccolCommonModule(),new UserCredentialServiceModule());
		//Injector child =parent.createChildInjector();
		//Injector injector = child.createChildInjector();		
		return parent.getInstance(IUserCredentialService.class);
	}

}
