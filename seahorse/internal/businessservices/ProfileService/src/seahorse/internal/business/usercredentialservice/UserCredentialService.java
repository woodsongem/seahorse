/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import java.util.Date;
import java.util.UUID;

import javax.ws.rs.core.Response.Status;

import com.datastax.driver.core.utils.UUIDs;
import com.google.inject.Inject;

import seahorse.internal.business.profileservice.api.datacontracts.UserCredentialModel;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolConstant;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolServiceUtility;
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
	private final IBaseUserCredentialService baseUserCredentialService;
	// @InjectLogger Logger logger;

	@Inject
	public UserCredentialService(IUserCredentialServiceMapper userCredentialServiceMapper,
			IUserCredentialServicePostProcessor userCredentialServicePostProcessor,
			IUserCredentialServiceProcessor userCredentialServiceProcessor,
			IUserCredentialServiceValidator userCredentialServiceValidator,
			IUserCredentialServiceVerifier userCredentialServiceVerifier,
			IBaseUserCredentialService baseUserCredentialService) {
		this.userCredentialServiceMapper = userCredentialServiceMapper;
		this.userCredentialServicePostProcessor = userCredentialServicePostProcessor;
		this.userCredentialServiceProcessor = userCredentialServiceProcessor;
		this.userCredentialServiceValidator = userCredentialServiceValidator;
		this.userCredentialServiceVerifier = userCredentialServiceVerifier;
		this.baseUserCredentialService = baseUserCredentialService;
	}

	@Override
	public Result createUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		// Set
		if (createUserCredentialMsgEntity != null) {
			createUserCredentialMsgEntity.setId(UUIDs.timeBased());
			createUserCredentialMsgEntity.setStatus(KatavuccolConstant.ACTIVESTATUS);
			createUserCredentialMsgEntity.setCreatedDate(new Date());
		}

		Result result = userCredentialServiceValidator.validCreateUserCredential(createUserCredentialMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			createUserCredentialMsgEntity.setHttpStatus(Status.BAD_REQUEST);
			return result;
		}

		result = userCredentialServiceVerifier.verifyCreateUserCredential(createUserCredentialMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			createUserCredentialMsgEntity.setHttpStatus(Status.BAD_REQUEST);
			return result;
		}

		result = userCredentialServiceProcessor.processCreateUserCredential(createUserCredentialMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			createUserCredentialMsgEntity.setHttpStatus(Status.BAD_REQUEST);
			return result;
		}
		Result postResult = userCredentialServicePostProcessor
				.postProcessCreateUserCredential(createUserCredentialMsgEntity);
		if (postResult.getResultStatus() != ResultStatus.SUCCESS) {
			// Log error
		}
		createUserCredentialMsgEntity.setHttpStatus(Status.OK);
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
		if (getUserCredentialByUserIdMsgEntity == null) {

		}
		if (!KatavuccolServiceUtility.isValidUUID(getUserCredentialByUserIdMsgEntity.getUserId())) {

		}
		getUserCredentialByUserIdMsgEntity
				.setParsedUserId(UUID.fromString(getUserCredentialByUserIdMsgEntity.getUserId()));
		return baseUserCredentialService
				.getUserCredentialModelByUserId(getUserCredentialByUserIdMsgEntity.getParsedUserId());
	}

	@Override
	public Result deleteUserProfile(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity) {
		// Set
		if (deleteUserProfileMsgEntity != null) {
			deleteUserProfileMsgEntity.setStatus(KatavuccolConstant.INACTIVESTATUS);
			deleteUserProfileMsgEntity.setModifiedDate(new Date());
		}

		Result result = userCredentialServiceValidator.validDeleteUserProfile(deleteUserProfileMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = userCredentialServiceVerifier.verifyDeleteUserProfile(deleteUserProfileMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = userCredentialServiceProcessor.processDeleteUserProfile(deleteUserProfileMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		return result;
	}
}
