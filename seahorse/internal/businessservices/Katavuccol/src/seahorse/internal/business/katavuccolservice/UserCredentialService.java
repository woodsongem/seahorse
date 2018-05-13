/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import org.apache.logging.log4j.Logger;
import com.google.inject.Inject;

import seahorse.internal.business.katavuccolservice.postprocessors.IUserCredentialServicePostProcessor;
import seahorse.internal.business.katavuccolservice.processors.IUserCredentialServiceProcessor;
import seahorse.internal.business.katavuccolservice.validators.IUserCredentialServiceValidator;
import seahorse.internal.business.katavuccolservice.verifiers.IUserCredentialServiceVerifier;
import seahorse.internal.business.shared.aop.InjectLogger;

/**
 * @author sajanmje
 *
 */
public class UserCredentialService implements IUserCredentialService {

	private IUserCredentialServiceMapper userCredentialServiceMapper;
	private IUserCredentialServiceVerifier userCredentialServiceVerifier;
	private IUserCredentialServiceValidator userCredentialServiceValidator;
	private IUserCredentialServiceProcessor userCredentialServiceProcessor;
	private IUserCredentialServicePostProcessor userCredentialServicePostProcessor;
	
	@InjectLogger  Logger logger;

	@Inject
	public UserCredentialService(IUserCredentialServiceMapper userCredentialServiceMapper,
			IUserCredentialServiceVerifier userCredentialServiceVerifier,
			IUserCredentialServiceValidator userCredentialServiceValidator,
			IUserCredentialServiceProcessor userCredentialServiceProcessor,
			IUserCredentialServicePostProcessor userCredentialServicePostProcessor)
	{
		this.userCredentialServiceMapper=userCredentialServiceMapper;
		this.userCredentialServiceVerifier=userCredentialServiceVerifier;
		this.userCredentialServiceValidator=userCredentialServiceValidator;
		this.userCredentialServiceProcessor=userCredentialServiceProcessor;
		this.userCredentialServicePostProcessor=userCredentialServicePostProcessor;
	}
}
