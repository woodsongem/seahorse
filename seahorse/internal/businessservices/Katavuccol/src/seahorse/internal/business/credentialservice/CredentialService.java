/**
 * 
 */
package seahorse.internal.business.credentialservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.Logger;

import com.datastax.driver.core.utils.UUIDs;
import com.google.api.client.auth.oauth2.Credential;
import com.google.inject.Inject;

import seahorse.internal.business.credentialservice.datacontracts.*;
import seahorse.internal.business.katavuccolservice.common.KatavuccolConstant;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
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
	
	@Override
	public CreateCredentialResponseMessageEntity createCredential(CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {

		//Set	
		credentialRequestMessageEntity.setId(UUIDs.timeBased());
		credentialRequestMessageEntity.setStatus(KatavuccolConstant.ACTIVESTATUS);
		credentialRequestMessageEntity.setCreatedDate(new Date());
		credentialRequestMessageEntity.setIsCredentialNull(false);
		
		//Validator	    
	    Result result = credentialServiceValidator.validateCreateCredential(credentialRequestMessageEntity);
	    if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return credentialServiceMapper.mapCreateCredentialResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
	    //Verifier
	    result = credentialServiceVerifier.verifyCreateCredentials(credentialRequestMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return credentialServiceMapper.mapCreateCredentialResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
		//Processor
		result=credentialServiceProcessor.processorCreateCredentials(credentialRequestMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return credentialServiceMapper.mapCreateCredentialResponseMessageEntity(result, Status.FORBIDDEN);
		}
		
		//Post Processor
		Result postresult=credentialServicePostProcessor.postProcessorCreateCredentials(credentialRequestMessageEntity);
				
		return credentialServiceMapper.mapCreateCredentialResponseMessageEntity(result, credentialRequestMessageEntity);
	}


	@Override
	public UpdateCredentialResponseMessageEntity updateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		//Set		
		updateCredentialMessageEntity.setModifiedDate(new Date());
		
		//Validator	    
	    Result result = credentialServiceValidator.validateUpdateCredential(updateCredentialMessageEntity);
	    if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return credentialServiceMapper.mapUpdateCredentialResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
	    //Verifier
	    result = credentialServiceVerifier.verifyUpdateCredential(updateCredentialMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return credentialServiceMapper.mapUpdateCredentialResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
		//Processor
		result=credentialServiceProcessor.processorUpdateCredential(updateCredentialMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return credentialServiceMapper.mapUpdateCredentialResponseMessageEntity(result, Status.FORBIDDEN);
		}
		
		//Post Processor
		Result postresult=credentialServicePostProcessor.postProcessorUpdateCredential(updateCredentialMessageEntity);
				
		return credentialServiceMapper.mapUpdateCredentialResponseMessageEntity(result, updateCredentialMessageEntity);	
	}

	@Override
	public DeleteCredentialResMsgEntity deleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
		//Set
		deleteCredentialMessageEntity.setStatus(KatavuccolConstant.INACTIVESTATUS);
		deleteCredentialMessageEntity.setModifiedDate(new Date());
		
		//Validator	    
	    Result result = credentialServiceValidator.validateDeleteCredential(deleteCredentialMessageEntity);
	    if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return credentialServiceMapper.mapDeleteCredentialResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
	    //Verifier
	    result = credentialServiceVerifier.verifyDeleteCredential(deleteCredentialMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return credentialServiceMapper.mapDeleteCredentialResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
		//Processor
		result=credentialServiceProcessor.processorDeleteCredential(deleteCredentialMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return credentialServiceMapper.mapDeleteCredentialResponseMessageEntity(result, Status.FORBIDDEN);
		}
		
		//Post Processor
		Result postresult=credentialServicePostProcessor.postProcessorDeleteCredential(deleteCredentialMessageEntity);
				
		return credentialServiceMapper.mapDeleteCredentialResponseMessageEntity(result, deleteCredentialMessageEntity);	
		
	}

	@Override
	public List<Credential> getCredentialsByCategoryId(GetCredentialMessageEntity getCredentialMessageEntity) {
		//Validator	    
	    Result result = credentialServiceValidator.validateGetCredentials(getCredentialMessageEntity);
	    if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return new ArrayList<>();
		}
	    
	    //Verifier
	    result = credentialServiceVerifier.verifyGetCredentials(getCredentialMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return new ArrayList<>();
		}
		
		return credentialServiceMapper.mapCredentials(result, getCredentialMessageEntity);
	}
}
