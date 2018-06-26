/**
 * 
 */
package seahorse.internal.business.categoryservice;

import org.apache.logging.log4j.Logger;
import com.google.inject.Inject;
import seahorse.internal.business.shared.aop.InjectLogger;

/**
 * @author admin
 *
 */
public class CategoryService implements  ICategoryService {

	private ICategoryServiceMapper categoryServiceMapper;
	private ICategoryServiceVerifier categoryServiceVerifier;
	private ICategoryServiceValidator categoryServiceValidator;
	private ICategoryServiceProcessor categoryServiceProcessor;
	private ICategoryServicePostProcessor categoryServicePostProcessor;	
	
	@InjectLogger  Logger logger;

	@Inject
	public CategoryService(ICategoryServiceMapper categoryServiceMapper,
			ICategoryServiceVerifier categoryServiceVerifier,
			ICategoryServiceValidator categoryServiceValidator,
			ICategoryServiceProcessor categoryServiceProcessor,
			ICategoryServicePostProcessor categoryServicePostProcessor)
	{
		this.categoryServiceMapper=categoryServiceMapper;
		this.categoryServiceVerifier=categoryServiceVerifier;
		this.categoryServiceValidator=categoryServiceValidator;
		this.categoryServiceProcessor=categoryServiceProcessor;
		this.categoryServicePostProcessor=categoryServicePostProcessor;		
	}
}
