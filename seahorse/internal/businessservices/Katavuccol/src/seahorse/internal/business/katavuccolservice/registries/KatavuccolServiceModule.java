/**
 * 
 */
package seahorse.internal.business.katavuccolservice.registries;

import com.google.inject.AbstractModule;

import seahorse.internal.business.katavuccolservice.IKatavuccolService;
import seahorse.internal.business.katavuccolservice.KatavuccolService;



/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IKatavuccolService.class).to(KatavuccolService.class);		
	}
}
