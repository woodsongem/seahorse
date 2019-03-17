/**
 * 
 */
package seahorse.internal.business.categoryservice;

import java.security.GeneralSecurityException;

import com.google.crypto.tink.Config;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.inject.AbstractModule;

/**
 * @author admin
 *
 */
public class CategoryServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(ICategoryService.class).to(CategoryService.class);
		bind(ICategoryServiceValidator.class).to(CategoryServiceValidator.class);
		bind(ICategoryServiceVerifier.class).to(CategoryServiceVerifier.class);
		bind(ICategoryServiceProcessor.class).to(CategoryServiceProcessor.class);
		bind(ICategoryServicePostProcessor.class).to(CategoryServicePostProcessor.class);
		bind(ICategoryServiceMapper.class).to(CategoryServiceMapper.class);			
		
		
		try {
			DeterministicAeadConfig.init();
		} catch (GeneralSecurityException e) {
			
		}
	    try {
			Config.register(DeterministicAeadConfig.TINK_1_1_0);
		} catch (GeneralSecurityException e) {
			
		}
		
	}

}
