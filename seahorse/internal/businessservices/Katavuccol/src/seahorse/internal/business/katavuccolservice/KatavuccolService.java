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
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialTypeRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCategoryResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialTypeMessageEntity;
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

	@Override
	public UpdateCredentialResponseMessageEntity updateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		//Set		
		updateCredentialMessageEntity.setModifiedDate(new Date());
		
		//Validator	    
	    Result result = katavuccolServiceValidator.validateUpdateCredential(updateCredentialMessageEntity);
	    if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return katavuccolServiceMapper.mapUpdateCredentialResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
	    //Verifier
	    result = katavuccolServiceVerifier.verifyUpdateCredential(updateCredentialMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return katavuccolServiceMapper.mapUpdateCredentialResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
		//Processor
		result=katavuccolServiceProcessor.ProcessorUpdateCredential(updateCredentialMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return katavuccolServiceMapper.mapUpdateCredentialResponseMessageEntity(result, Status.FORBIDDEN);
		}
		
		//Post Processor
		Result postresult=katavuccolServicePostProcessor.PostProcessorUpdateCredential(updateCredentialMessageEntity);
				
		return katavuccolServiceMapper.mapUpdateCredentialResponseMessageEntity(result, updateCredentialMessageEntity);	
	}

	@Override
	public DeleteCredentialResponseMessageEntity deleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
		//Set
		deleteCredentialMessageEntity.setStatus(KatavuccolConstant.INACTIVESTATUS);
		deleteCredentialMessageEntity.setModifiedDate(new Date());
		
		//Validator	    
	    Result result = katavuccolServiceValidator.validateDeleteCredential(deleteCredentialMessageEntity);
	    if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return katavuccolServiceMapper.mapDeleteCredentialResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
	    //Verifier
	    result = katavuccolServiceVerifier.verifyDeleteCredential(deleteCredentialMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return katavuccolServiceMapper.mapDeleteCredentialResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
		//Processor
		result=katavuccolServiceProcessor.ProcessorDeleteCredential(deleteCredentialMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return katavuccolServiceMapper.mapDeleteCredentialResponseMessageEntity(result, Status.FORBIDDEN);
		}
		
		//Post Processor
		Result postresult=katavuccolServicePostProcessor.PostProcessorDeleteCredential(deleteCredentialMessageEntity);
				
		return katavuccolServiceMapper.mapDeleteCredentialResponseMessageEntity(result, deleteCredentialMessageEntity);	
		
	}

	@Override
	public CategoryResponseMessageEntity createCategory(CategoryRequestMessageEntity categoryRequestMessageEntity) {
		//Set	
		categoryRequestMessageEntity.setId(UUIDs.timeBased());
		categoryRequestMessageEntity.setStatus(KatavuccolConstant.ACTIVESTATUS);
		categoryRequestMessageEntity.setCreatedDate(new Date());		
		
		//Validator	    
	    Result result = katavuccolServiceValidator.validateCreateCategory(categoryRequestMessageEntity);
	    if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return katavuccolServiceMapper.mapCategoryResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
	    //Verifier
	    result = katavuccolServiceVerifier.verifyCreateCategory(categoryRequestMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return katavuccolServiceMapper.mapCategoryResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
		//Processor
		result=katavuccolServiceProcessor.ProcessorCreateCategory(categoryRequestMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return katavuccolServiceMapper.mapCategoryResponseMessageEntity(result, Status.FORBIDDEN);
		}
		
		//Post Processor
		Result postresult=katavuccolServicePostProcessor.PostProcessorCreateCategory(categoryRequestMessageEntity);
				
		return katavuccolServiceMapper.mapCategoryResponseMessageEntity(result, categoryRequestMessageEntity);
	}

	@Override
	public DeleteCredentialResponseMessageEntity deleteCategory(
			DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateCategoryResponseMessageEntity updateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CredentialTypeResponseMessageEntity createCredentialType(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity) {
		//Set	
		credentialTypeRequestMessageEntity.setId(UUIDs.timeBased());
		credentialTypeRequestMessageEntity.setStatus(KatavuccolConstant.ACTIVESTATUS);
		credentialTypeRequestMessageEntity.setCreatedDate(new Date());
	
		//Validator	    
	    Result result = katavuccolServiceValidator.validateCreateCredentialType(credentialTypeRequestMessageEntity);
	    if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return katavuccolServiceMapper.mapCredentialTypeResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
	    //Verifier
	    result = katavuccolServiceVerifier.verifyCreateCredentialType(credentialTypeRequestMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return katavuccolServiceMapper.mapCredentialTypeResponseMessageEntity(result, Status.BAD_REQUEST);
		}
		
		//Processor
		result=katavuccolServiceProcessor.ProcessorCreateCredentialType(credentialTypeRequestMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return katavuccolServiceMapper.mapCredentialTypeResponseMessageEntity(result, Status.FORBIDDEN);
		}
		
		//Post Processor
		Result postresult=katavuccolServicePostProcessor.PostProcessorCreateCredentialType(credentialTypeRequestMessageEntity);
				
		return katavuccolServiceMapper.mapCredentialTypeResponseMessageEntity(result, credentialTypeRequestMessageEntity);
	}

	@Override
	public UpdateCredentialResponseMessageEntity updateCredentialType(UpdateCredentialTypeMessageEntity updateCredentialTypeMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteCredentialResponseMessageEntity deleteCredentialType(DeleteCredentialTypeRequestMessageEntity deleteCredentialTypeRequestMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}
}
