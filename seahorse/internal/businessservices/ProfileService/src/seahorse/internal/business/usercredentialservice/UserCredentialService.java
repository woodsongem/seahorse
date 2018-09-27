/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import java.util.Date;

import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.Logger;

import com.datastax.driver.core.utils.UUIDs;
import com.google.inject.Inject;

import seahorse.internal.business.profileservice.api.datacontracts.UserCredentialModel;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolConstant;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;
import seahorse.internal.business.usercredentialservice.datacontracts.*;

/**
 * @author SMJE
 *
 */
public class UserCredentialService implements IUserCredentialService {
	private final IUserCredentialServiceMapper userCredentialServiceMapper;
	private final IUserCredentialServicePostProcessor userCredentialServicePostProcessor;
	private final IUserCredentialServiceProcessor userCredentialServiceProcessor;
	private final IUserCredentialServiceValidator userCredentialServiceValidator;
	private final IUserCredentialServiceVerifier userCredentialServiceVerifier;

	 //@InjectLogger Logger logger;

	@Inject
	public UserCredentialService(IUserCredentialServiceMapper userCredentialServiceMapper,
			IUserCredentialServicePostProcessor userCredentialServicePostProcessor,
			IUserCredentialServiceProcessor userCredentialServiceProcessor,
			IUserCredentialServiceValidator userCredentialServiceValidator,
			IUserCredentialServiceVerifier userCredentialServiceVerifier) {
		this.userCredentialServiceMapper = userCredentialServiceMapper;
		this.userCredentialServicePostProcessor = userCredentialServicePostProcessor;
		this.userCredentialServiceProcessor = userCredentialServiceProcessor;
		this.userCredentialServiceValidator = userCredentialServiceValidator;
		this.userCredentialServiceVerifier = userCredentialServiceVerifier;
	}

	@Override
	public Result createUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		// Set
		createUserCredentialMsgEntity.setId(UUIDs.timeBased());
		createUserCredentialMsgEntity.setStatus(KatavuccolConstant.ACTIVESTATUS);
		createUserCredentialMsgEntity.setCreatedDate(new Date());


		Result result = userCredentialServiceValidator.validCreateUserCredential(createUserCredentialMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		result = userCredentialServiceVerifier.verifyCreateUserCredential(createUserCredentialMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		result = userCredentialServiceProcessor.processCreateUserCredential(createUserCredentialMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = userCredentialServicePostProcessor.postProcessCreateUserCredential(createUserCredentialMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		return result;

	}

	@Override
	public Result deleteUserCredential(DeleteUserCredentialMsgEntity deleteUserCredentialMsgEntity) {
		return null;

	}

	@Override
	public Result updateUserCredential(UpdateUserCredentialMsgEntity updateUserCredentialMsgEntity) {
		return null;

	}

	@Override
	public UserCredentialModel getUserCredentialByUserId(
			GetUserCredentialByUserIdMsgEntity getUserCredentialByUserIdMsgEntity) {
		return null;

	}
}
