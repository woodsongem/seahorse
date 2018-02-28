/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import java.util.UUID;
import javax.ws.rs.core.Response.Status;
import org.apache.logging.log4j.Logger;
import com.google.inject.Inject;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialsMessageEntity;
import seahorse.internal.business.katavuccolservice.postprocessors.IKatavuccolServicePostProcessor;
import seahorse.internal.business.katavuccolservice.processors.IKatavuccolServiceProcessor;
import seahorse.internal.business.katavuccolservice.validators.IKatavuccolServiceValidator;
import seahorse.internal.business.katavuccolservice.verifiers.IKatavuccolServiceVerifier;
import seahorse.internal.business.shared.aop.InjectLogger;

/**
 * @author sajanmje
 *
 */
public class KatavuccolService implements IKatavuccolService {

	private IKatavuccolServiceMapper katavuccolServiceMapper;
	private IKatavuccolServiceVerifier katavuccolServiceVerifier;
	private IKatavuccolServiceValidator katavuccolServiceValidator;
	private IKatavuccolServiceProcessor katavuccolServiceProcessor;
	private IKatavuccolServicePostProcessor katavuccolServicePostProcessor;
	
	@InjectLogger  Logger logger;

	@Inject
	public KatavuccolService(IKatavuccolServiceMapper katavuccolServiceMapper,
			IKatavuccolServiceVerifier katavuccolServiceVerifier,
			IKatavuccolServiceValidator katavuccolServiceValidator,
			IKatavuccolServiceProcessor katavuccolServiceProcessor,
			IKatavuccolServicePostProcessor katavuccolServicePostProcessor)
	{
		this.katavuccolServiceMapper=katavuccolServiceMapper;
		this.katavuccolServiceVerifier=katavuccolServiceVerifier;
		this.katavuccolServiceValidator=katavuccolServiceValidator;
		this.katavuccolServiceProcessor=katavuccolServiceProcessor;
		this.katavuccolServicePostProcessor=katavuccolServicePostProcessor;
	}
	
	@Override
	public CredentialResponseMessageEntity createCredential(CredentialRequestMessageEntity credentialRequestMessageEntity) {

		//Set	
		credentialRequestMessageEntity.setId(UUID.randomUUID());
		
		//Validator	    
	    Result result = katavuccolServiceValidator.validateCreateCredentials(credentialRequestMessageEntity);
	    if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return katavuccolServiceMapper.mapCredentialResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
	    //Verifier
	    result = katavuccolServiceVerifier.verifyCreateCredentials(credentialRequestMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return katavuccolServiceMapper.mapCredentialResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
		//Processor
		result=katavuccolServiceProcessor.ProcessorCreateCredentials(credentialRequestMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return katavuccolServiceMapper.mapCredentialResponseMessageEntity(result, Status.FORBIDDEN);
		}
		
		//Post Processor
		result=katavuccolServicePostProcessor.PostProcessorCreateCredentials(credentialRequestMessageEntity);
				
		return katavuccolServiceMapper.mapCredentialResponseMessageEntity(result, credentialRequestMessageEntity);
	}

	@Override
	public GetCredentialsMessageEntity getCredentials(GetCredentialMessageEntity getCredentialMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}
}
