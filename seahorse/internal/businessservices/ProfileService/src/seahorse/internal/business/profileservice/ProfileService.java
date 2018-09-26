/**
 * 
 */
package seahorse.internal.business.profileservice;

import java.util.UUID;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.profileservice.api.datacontracts.UserProfileModel;
import seahorse.internal.business.profileservice.datacontracts.CreateUserProfileMsgEntity;
import seahorse.internal.business.profileservice.datacontracts.DeleteUserProfileMsgEntity;
import seahorse.internal.business.profileservice.datacontracts.UpdateUserProfileMsgEntity;
import seahorse.internal.business.profileservice.datacontracts.UserProfileMsgEntity;

/**
 * @author admin
 *
 */
public class ProfileService implements IProfileService {

	private final IBaseProfileService baseProfileService;
	private final IProfileServiceMapper profileServiceMapper;
	private final IProfileServicePostProcessor profileServicePostProcessor;
	private final IProfileServiceProcessor profileServiceProcessor;
	private final IProfileServiceValidator profileServiceValidator;
	private final IProfileServiceVerifier profileServiceVerifier;

	public ProfileService(IBaseProfileService baseProfileService, IProfileServiceMapper profileServiceMapper,
			IProfileServicePostProcessor profileServicePostProcessor, IProfileServiceProcessor profileServiceProcessor,
			IProfileServiceRepository profileServiceRepository, IProfileServiceValidator profileServiceValidator,
			IProfileServiceVerifier profileServiceVerifier) {
		this.baseProfileService = baseProfileService;
		this.profileServiceMapper = profileServiceMapper;
		this.profileServicePostProcessor = profileServicePostProcessor;
		this.profileServiceProcessor = profileServiceProcessor;
		this.profileServiceValidator = profileServiceValidator;
		this.profileServiceVerifier = profileServiceVerifier;
	}

	@Override
	public UserProfileModel getUserProfileByUserId(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserProfileMsgEntity getUserProfileMsgEntityByUserId(UUID userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result createUserProfile(CreateUserProfileMsgEntity createUserProfileMsgEntity) {
		Result result = profileServiceValidator.validCreateUserProfile(createUserProfileMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = profileServiceVerifier.verifyCreateUserProfile(createUserProfileMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = profileServiceProcessor.processorCreateUserProfile(createUserProfileMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = profileServicePostProcessor.postProcessorCreateUserProfile(createUserProfileMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		return result;
	}
	@Override
	public Result updateUserProfile(UpdateUserProfileMsgEntity updateUserProfileMsgEntity) {
		Result result = profileServiceValidator.validDeleteUserProfile(updateUserProfileMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = profileServiceVerifier.verifyDeleteUserProfile(updateUserProfileMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = profileServiceProcessor.processorDeleteUserProfile(updateUserProfileMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = profileServicePostProcessor.postProcessorDeleteUserProfile(updateUserProfileMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		return result;
	}
	
	@Override
	public Result deleteUserProfile(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity) {
		Result result = profileServiceValidator.validDeleteUserProfile(deleteUserProfileMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = profileServiceVerifier.verifyDeleteUserProfile(deleteUserProfileMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = profileServiceProcessor.processorDeleteUserProfile(deleteUserProfileMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = profileServicePostProcessor.postProcessorDeleteUserProfile(deleteUserProfileMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		return result;
	}

}
