/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Response.Status;
import org.apache.logging.log4j.Logger;

import com.datastax.driver.core.utils.UUIDs;
import com.google.inject.Inject;

import seahorse.internal.business.katavuccolservice.api.datacontracts.Credential;
import seahorse.internal.business.katavuccolservice.common.KatavuccolConstant;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
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
		credentialRequestMessageEntity.setId(UUIDs.timeBased());
		credentialRequestMessageEntity.setStatus(KatavuccolConstant.ACTIVESTATUS);
		credentialRequestMessageEntity.setCreatedDate(new Date());
		credentialRequestMessageEntity.setIsCredentialNull(false);
		
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
		Result postresult=katavuccolServicePostProcessor.PostProcessorCreateCredentials(credentialRequestMessageEntity);
				
		return katavuccolServiceMapper.mapCredentialResponseMessageEntity(result, credentialRequestMessageEntity);
	}

	@Override
	public List<Credential> getCredentials(GetCredentialMessageEntity getCredentialMessageEntity) {
		//Validator	    
	    Result result = katavuccolServiceValidator.validateGetCredentials(getCredentialMessageEntity);
	    if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return new ArrayList<>();
		}
	    
	    //Verifier
	    result = katavuccolServiceVerifier.verifyGetCredentials(getCredentialMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return new ArrayList<>();
		}
		
		return katavuccolServiceMapper.mapCredentials(result, getCredentialMessageEntity);
	}
}
