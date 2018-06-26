/**
 * 
 */
package seahorse.internal.business.credentialservice;

import org.apache.logging.log4j.Logger;
import com.google.inject.Inject;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialValueDetail;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialByUserIdMessageEntity;

import seahorse.internal.business.shared.aop.InjectLogger;

/**
 * @author admin
 *
 */
public class CredentialService implements ICredentialService {

	private ICredentialServiceMapper credentialServiceMapper;
	private ICredentialServiceVerifier credentialServiceVerifier;
	private ICredentialServiceValidator credentialServiceValidator;
	private ICredentialServiceProcessor credentialServiceProcessor;
	private ICredentialServicePostProcessor credentialServicePostProcessor;	
	
	@InjectLogger  Logger logger;

	@Inject
	public CredentialService(ICredentialServiceMapper credentialServiceMapper,
			ICredentialServiceVerifier credentialServiceVerifier,
			ICredentialServiceValidator credentialServiceValidator,
			ICredentialServiceProcessor credentialServiceProcessor,
			ICredentialServicePostProcessor credentialServicePostProcessor)
	{
		this.credentialServiceMapper=credentialServiceMapper;
		this.credentialServiceVerifier=credentialServiceVerifier;
		this.credentialServiceValidator=credentialServiceValidator;
		this.credentialServiceProcessor=credentialServiceProcessor;
		this.credentialServicePostProcessor=credentialServicePostProcessor;		
	}
	
	public CredentialValueDetail getCredentialsByUserId(GetCredentialByUserIdMessageEntity getCredentialByUserIdMessageEntity) {
		Result result=	credentialServiceValidator.validateGetCredentialsByUserId(getCredentialByUserIdMessageEntity);
		result=credentialServiceVerifier.verifyGetCredentialsByUserId(getCredentialByUserIdMessageEntity);
		result=credentialServiceProcessor.processorGetCredentialsByUserId(getCredentialByUserIdMessageEntity);
		result=credentialServicePostProcessor.postProcessorGetCredentialsByUserId(getCredentialByUserIdMessageEntity);
		return null;
	}
}
