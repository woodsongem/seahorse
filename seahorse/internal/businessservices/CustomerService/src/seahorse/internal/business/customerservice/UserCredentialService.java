/**
 * 
 */
package seahorse.internal.business.customerservice;

import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import seahorse.internal.business.applicationservice.utilities.CustomerServiceUtility;
import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.LoginResponseMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultStatus;
import seahorse.internal.business.customerservice.helpers.IUserCredentialServiceHelper;
import seahorse.internal.business.customerservice.validators.IUserCredentialServiceValidator;
import seahorse.internal.business.customerservice.verifiers.IUserCredentialServiceVerifier;
import seahorse.internal.business.shared.aop.InjectLogger;
import seahorse.internal.business.shared.aop.Report;

/**
 * @author sajanmje
 *
 */
public class UserCredentialService implements IUserCredentialService {

	private final IUserCredentialServiceValidator userCredentialServiceValidator;
	private final IUserCredentialServiceVerifier userCredentialServiceVerifier;
	private final IUserCredentialServiceMapper userCredentialServiceMapper;
	private final IUserCredentialServiceHelper userCredentialServiceHelper;

	@InjectLogger  Logger logger;

	@Inject
	public UserCredentialService(IUserCredentialServiceValidator userCredentialServiceValidator,
			IUserCredentialServiceVerifier userCredentialServiceVerifier,
			IUserCredentialServiceMapper userCredentialServiceMapper,
			IUserCredentialServiceHelper userCredentialServiceHelper) {
		this.userCredentialServiceValidator = userCredentialServiceValidator;
		this.userCredentialServiceVerifier = userCredentialServiceVerifier;
		this.userCredentialServiceMapper = userCredentialServiceMapper;
		this.userCredentialServiceHelper=userCredentialServiceHelper;
	}

	@Report
	public LoginResponseMessageEntity Login(LoginDetailMessageEntity loginDetailMessageEntity) {
		
		//Validator
		ResultMessageEntity resultMessageEntity = userCredentialServiceValidator.ValidateLogin(loginDetailMessageEntity);

		if (resultMessageEntity == null || resultMessageEntity.GetResultStatus() != ResultStatus.Success) {
			return CustomerServiceUtility.GetApplicationDetailMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}

		//Verifier
		resultMessageEntity = userCredentialServiceVerifier.VerifyLogin(loginDetailMessageEntity);

		if (resultMessageEntity == null || resultMessageEntity.GetResultStatus() != ResultStatus.Success) {
			return CustomerServiceUtility.GetApplicationDetailMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}

		resultMessageEntity=userCredentialServiceHelper.LoginProcessor(loginDetailMessageEntity);
		
		if (resultMessageEntity == null || resultMessageEntity.GetResultStatus() != ResultStatus.Success) {
			return CustomerServiceUtility.GetApplicationDetailMessageEntity(resultMessageEntity, Status.FORBIDDEN);
		}
		
		//Post Process
		userCredentialServiceHelper.LoginPostProcessor(loginDetailMessageEntity);
		
		return userCredentialServiceMapper.MapLoginResponseMessageEntity(resultMessageEntity, loginDetailMessageEntity);	
	}

}
