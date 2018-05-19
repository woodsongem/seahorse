/**
 * 
 */
package seahorse.internal.business.katavuccolservice.registries;

import com.google.inject.AbstractModule;

import seahorse.internal.business.katavuccolservice.IUserCredentialService;
import seahorse.internal.business.katavuccolservice.IUserCredentialServiceMapper;
import seahorse.internal.business.katavuccolservice.UserCredentialService;
import seahorse.internal.business.katavuccolservice.UserCredentialServiceMapper;
import seahorse.internal.business.katavuccolservice.common.IUserCredentialErrorCode;
import seahorse.internal.business.katavuccolservice.common.UserCredentialErrorCode;
import seahorse.internal.business.katavuccolservice.dal.IUserCredentialRepository;
import seahorse.internal.business.katavuccolservice.dal.IUserCredentialRepositoryMapper;
import seahorse.internal.business.katavuccolservice.dal.UserCredentialRepository;
import seahorse.internal.business.katavuccolservice.dal.UserCredentialRepositoryMapper;
import seahorse.internal.business.katavuccolservice.postprocessors.IUserCredentialServicePostProcessor;
import seahorse.internal.business.katavuccolservice.postprocessors.UserCredentialServicePostProcessor;
import seahorse.internal.business.katavuccolservice.processors.IUserCredentialServiceProcessor;
import seahorse.internal.business.katavuccolservice.processors.UserCredentialServiceProcessor;
import seahorse.internal.business.katavuccolservice.validators.BaseValidator;
import seahorse.internal.business.katavuccolservice.validators.IBaseValidator;
import seahorse.internal.business.katavuccolservice.validators.IUserCredentialServiceValidator;
import seahorse.internal.business.katavuccolservice.validators.UserCredentialServiceValidator;
import seahorse.internal.business.katavuccolservice.verifiers.BaseVerifier;
import seahorse.internal.business.katavuccolservice.verifiers.IBaseVerifier;
import seahorse.internal.business.katavuccolservice.verifiers.IUserCredentialServiceVerifier;
import seahorse.internal.business.katavuccolservice.verifiers.IUserCredentialVerifierMapper;
import seahorse.internal.business.katavuccolservice.verifiers.UserCredentialServiceVerifier;
import seahorse.internal.business.katavuccolservice.verifiers.UserCredentialVerifierMapper;

/**
 * @author sajanmje
 *
 */
public class UserCredentialModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IUserCredentialRepository.class).to(UserCredentialRepository.class);
		bind(IUserCredentialRepositoryMapper.class).to(UserCredentialRepositoryMapper.class);		
		bind(IUserCredentialServiceMapper.class).to(UserCredentialServiceMapper.class);
		bind(IUserCredentialService.class).to(UserCredentialService.class);
		
		bind(IUserCredentialServiceMapper.class).to(UserCredentialServiceMapper.class);
		bind(IUserCredentialServiceVerifier.class).to(UserCredentialServiceVerifier.class);
		bind(IUserCredentialServiceValidator.class).to(UserCredentialServiceValidator.class);
		bind(IUserCredentialServiceProcessor.class).to(UserCredentialServiceProcessor.class);
		bind(IUserCredentialServicePostProcessor.class).to(UserCredentialServicePostProcessor.class);
		
		bind(IUserCredentialVerifierMapper.class).to(UserCredentialVerifierMapper.class);
		bind(IUserCredentialErrorCode.class).to(UserCredentialErrorCode.class);
		
		bind(IBaseValidator.class).to(BaseValidator.class);
		bind(IBaseVerifier.class).to(BaseVerifier.class);
		bind(IUserCredentialErrorCode.class).to(UserCredentialErrorCode.class);
		
	}
}
