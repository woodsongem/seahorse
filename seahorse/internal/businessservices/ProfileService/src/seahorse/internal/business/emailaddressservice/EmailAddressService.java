/**
 * 
 */
package seahorse.internal.business.emailaddressservice;

import java.util.Date;

import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.Logger;

import com.datastax.driver.core.utils.UUIDs;
import com.google.inject.Inject;

import seahorse.internal.business.emailaddressservice.api.datatcontracts.EmailAddressModel;
import seahorse.internal.business.emailaddressservice.datacontracts.CreateEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.DeleteEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.GetEmailAddressByEmailAddressIdMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.UpdateEmailAddressRequestMsgEntity;
import seahorse.internal.business.shared.aop.InjectLogger;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolConstant;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;

/**
 * @author SMJE
 *
 */
public class EmailAddressService implements IEmailAddressService {

	private IEmailAddressServiceMapper emailAddressServiceMapper;
	private IEmailAddressServiceValidator emailAddressServiceValidator;
	private IEmailAddressServiceVerifier emailAddressServiceVerifier;
	private IEmailAddressServiceProcessor emailAddressServiceProcessor;
	private IEmailAddressServicePostProcessor emailAddressServicePostProcessor;

	@InjectLogger
	Logger logger;

	@Inject
	public EmailAddressService(IEmailAddressServiceMapper emailAddressServiceMapper, IEmailAddressServiceValidator emailAddressServiceValidator,
			IEmailAddressServiceVerifier emailAddressServiceVerifier, IEmailAddressServiceProcessor emailAddressServiceProcessor,
			IEmailAddressServicePostProcessor emailAddressServicePostProcessor) {
		this.emailAddressServiceMapper = emailAddressServiceMapper;
		this.emailAddressServiceValidator = emailAddressServiceValidator;
		this.emailAddressServiceVerifier = emailAddressServiceVerifier;
		this.emailAddressServiceProcessor = emailAddressServiceProcessor;
		this.emailAddressServicePostProcessor = emailAddressServicePostProcessor;
	}

	@Override
	public Result CreateEmailAddress(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity) {
		// Set
		if (createEmailAddressRequestMsgEntity != null) {
			createEmailAddressRequestMsgEntity.setId(UUIDs.timeBased());
			createEmailAddressRequestMsgEntity.setStatus(KatavuccolConstant.ACTIVESTATUS);
			createEmailAddressRequestMsgEntity.setCreatedDate(new Date());
		}

		// validator
		Result result = emailAddressServiceValidator.validCreateEmailAddressRequest(createEmailAddressRequestMsgEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			createEmailAddressRequestMsgEntity.setHttpStatus(Status.BAD_REQUEST);
			return result;
		}

		// Verifier
		result = emailAddressServiceVerifier.verifyCreateEmailAddressRequest(createEmailAddressRequestMsgEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			createEmailAddressRequestMsgEntity.setHttpStatus(Status.BAD_REQUEST);
			return result;
		}

		// Processor
		result = emailAddressServiceProcessor.processCreateEmailAddress(createEmailAddressRequestMsgEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			createEmailAddressRequestMsgEntity.setHttpStatus(Status.BAD_REQUEST);
			return result;
		}

		// Post Processor
		Result postresult = emailAddressServicePostProcessor.postProcessCreateEmailAddress(createEmailAddressRequestMsgEntity);

		return result;

	}


	@Override
	public Result updateEmailAddress(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity) {
		//Set		
		updateEmailAddressRequestMsgEntity.setModifiedDate(new Date());
				
		//Validator	    
	    Result result = emailAddressServiceValidator.validateUpdateEmailAddressRequest(updateEmailAddressRequestMsgEntity);
	    if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
	    	updateEmailAddressRequestMsgEntity.setHttpStatus(Status.BAD_REQUEST);
			return result;
		}
		
	    //Verifier
	    result = emailAddressServiceVerifier.verifyUpdateEmailAddressRequest(updateEmailAddressRequestMsgEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			updateEmailAddressRequestMsgEntity.setHttpStatus(Status.BAD_REQUEST);
			return result;
		}
		
		//Processor
		result=emailAddressServiceProcessor.processUpdateEmailAddress(updateEmailAddressRequestMsgEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			updateEmailAddressRequestMsgEntity.setHttpStatus(Status.FORBIDDEN);
			return result;
		}
		
		//Post Processor
		Result postresult=emailAddressServicePostProcessor.postProcessorUpdateEmailAddress(updateEmailAddressRequestMsgEntity);
		
		return result;
	}
	
	@Override
	public Result deleteEmailAddress(DeleteEmailAddressRequestMsgEntity deleteEmailAddressRequestMsgEntity) {
		deleteEmailAddressRequestMsgEntity.setModifiedDate(new Date());
		
		//Validator	    
	    Result result = emailAddressServiceValidator.validDeleteEmailAddressRequest(deleteEmailAddressRequestMsgEntity);
	    if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
	    	deleteEmailAddressRequestMsgEntity.setHttpStatus(Status.BAD_REQUEST);
	    	return result;
		}
		
	    //Verifier
	    result = emailAddressServiceVerifier.verifyDeleteEmailAddressRequest(deleteEmailAddressRequestMsgEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			deleteEmailAddressRequestMsgEntity.setHttpStatus(Status.BAD_REQUEST);
	    	return result;
		}
		
		//Processor
		result=emailAddressServiceProcessor.processorDeleteEmailAddressRequest(deleteEmailAddressRequestMsgEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			deleteEmailAddressRequestMsgEntity.setHttpStatus(Status.FORBIDDEN);
	    	return result;
		}
		
		//Post Processor
		Result postresult=emailAddressServicePostProcessor.postProcessorDeleteEmailAddressRequest(deleteEmailAddressRequestMsgEntity);
		
		return result;
	}
	
	@Override
	public EmailAddressModel getEmailAddressModelByEmailAddressId(GetEmailAddressByEmailAddressIdMsgEntity getEmailAddressByEmailAddressIdMsgEntity) {
		return null;
	
	}
}
