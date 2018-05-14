/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import java.util.ArrayList;
import java.util.UUID;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.datacontracts.CreateUserCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CreateUserCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteUserCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetUserCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateUserCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UserCredentialMessageEntity;
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
	
	
	public CreateUserCredentialResponseMessageEntity createUserCredential(CreateUserCredentialRequestMessageEntity createUserCredentialRequestMessageEntity) {
		CreateUserCredentialResponseMessageEntity createUserCredentialResponseMessageEntity=new CreateUserCredentialResponseMessageEntity();
		
		return createUserCredentialResponseMessageEntity;
	}
	
	public Result updateUserCredential(UpdateUserCredentialRequestMessageEntity updateUserCredentialRequestMessageEntity) {
		Result result=new Result();
		
		return result;
	}
	
	public Result deleteUserCredential(DeleteUserCredentialRequestMessageEntity deleteUserCredentialRequestMessageEntity) {
		Result result=new Result();
		
		return result;
	}
	
	public UserCredentialMessageEntity getUserCredential(UUID userId) {
		
		UserCredentialMessageEntity userCredentialMessageEntity=new UserCredentialMessageEntity();
		GetUserCredentialMessageEntity getUserCredentialMessageEntity=userCredentialServiceMapper.MapGetUserCredentialMessageEntity(userId);
		
		//Validator	    
	    Result result = userCredentialServiceValidator.validateGetUserCredential(getUserCredentialMessageEntity);
	    if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return userCredentialMessageEntity;
		}
	    
	    //Verifier
	    result = userCredentialServiceVerifier.verifyGetUserCredential(getUserCredentialMessageEntity);
		if (result == null || result.getResultStatus() != ResultStatus.SUCCESS) {
			return userCredentialMessageEntity;
		}
		
		return userCredentialServiceMapper.mapUserCredentialMessageEntity(result, getUserCredentialMessageEntity);
	}
}
