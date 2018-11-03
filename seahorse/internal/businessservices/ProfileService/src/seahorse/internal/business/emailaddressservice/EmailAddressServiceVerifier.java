/**
 * 
 */
package seahorse.internal.business.emailaddressservice;

import com.google.inject.Inject;

import seahorse.internal.business.emailaddressservice.dal.datacontracts.EmailAddressDAO;
import seahorse.internal.business.emailaddressservice.datacontracts.CreateEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.DeleteEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.UpdateEmailAddressRequestMsgEntity;
import seahorse.internal.business.profileservice.common.ProfileServiceErrorCode;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolServiceUtility;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;
import seahorse.internal.business.usercredentialservice.IUserCredentialRepository;
import seahorse.internal.business.usercredentialservice.dal.datacontracts.UserCredentialDAO;

/**
 * @author SMJE
 *
 */
public class EmailAddressServiceVerifier implements IEmailAddressServiceVerifier {

	private final IEmailServiceRepository emailServiceRepository;
	private final IEmailAddressServiceMapper emailAddressServiceMapper;
	private final IBaseEmailAddressService baseEmailAddressService;
	private final IUserCredentialRepository userCredentialRepository;

	@Inject
	public EmailAddressServiceVerifier(IEmailServiceRepository emailServiceRepository,
			IEmailAddressServiceMapper emailAddressServiceMapper, IBaseEmailAddressService baseEmailAddressService,
			IUserCredentialRepository userCredentialRepository) {
		this.emailServiceRepository = emailServiceRepository;
		this.emailAddressServiceMapper = emailAddressServiceMapper;
		this.baseEmailAddressService = baseEmailAddressService;
		this.userCredentialRepository = userCredentialRepository;

	}

	@Override
	public Result verifyCreateEmailAddressRequest(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity) {
		Result result;
		result = isEmailAddressExistValid(createEmailAddressRequestMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		result = isUserIdValid(createEmailAddressRequestMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		return new Result(ResultStatus.SUCCESS);
	}
	
	@Override
	public Result verifyUpdateEmailAddressRequest(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity) {
		Result result;
		result = isUserIdValid(updateEmailAddressRequestMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = isEmailAddressIdValid(updateEmailAddressRequestMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		return new Result(ResultStatus.SUCCESS);
	}
	
	@Override
	public Result verifyDeleteEmailAddressId(DeleteEmailAddressRequestMsgEntity deleteEmailAddressRequestMsgEntity) {
		Result result;
		result = isEmailAddressIdValid(deleteEmailAddressRequestMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = isUserIdValid(deleteEmailAddressRequestMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		return result;
	}

	@Override
	public Result isUserIdValid(DeleteEmailAddressRequestMsgEntity deleteEmailAddressRequestMsgEntity) {
		UserCredentialDAO userCredentialDAO = userCredentialRepository.getUserCredentialByUserId(deleteEmailAddressRequestMsgEntity.getUserId());
		if (userCredentialDAO == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UserId",
					ProfileServiceErrorCode.UserIdNotFound);
		}
		deleteEmailAddressRequestMsgEntity.setUserCredential(userCredentialDAO);
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isEmailAddressIdValid(DeleteEmailAddressRequestMsgEntity deleteEmailAddressRequestMsgEntity) {
		EmailAddressDAO emailAddressDAO = emailServiceRepository.getEmailAddressDetailById(deleteEmailAddressRequestMsgEntity.getId());

		if (emailAddressDAO == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "EmailAddressId",ProfileServiceErrorCode.EmailAddressIdNotFound);
		}
		deleteEmailAddressRequestMsgEntity.setEmailAddressDetail(emailAddressDAO);
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isEmailAddressIdValid(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity) {
		EmailAddressDAO emailAddressDAO = emailServiceRepository.getEmailAddressDetailById(updateEmailAddressRequestMsgEntity.getId());

		if (emailAddressDAO == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "EmailAddressId",ProfileServiceErrorCode.EmailAddressIdNotFound);
		}
		updateEmailAddressRequestMsgEntity.setEmailAddressDetail(emailAddressDAO);
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isUserIdValid(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity) {
		UserCredentialDAO userCredentialDAO = userCredentialRepository.getUserCredentialByUserId(updateEmailAddressRequestMsgEntity.getUserId());
		if (userCredentialDAO == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UserId",
					ProfileServiceErrorCode.UserIdNotFound);
		}
		updateEmailAddressRequestMsgEntity.setUserCredential(userCredentialDAO);
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isUserIdValid(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity) {
		UserCredentialDAO userCredentialDAO = userCredentialRepository.getUserCredentialByUserId(createEmailAddressRequestMsgEntity.getUserId());
		if (userCredentialDAO == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UserId",
					ProfileServiceErrorCode.UserIdNotFound);
		}
		createEmailAddressRequestMsgEntity.setUserCredential(userCredentialDAO);
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isEmailAddressExistValid(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity) {
		EmailAddressDAO emailAddressDAO = emailServiceRepository.getEmailAddressDetailByEmailAddress(createEmailAddressRequestMsgEntity.getEmailAddress());

		if (emailAddressDAO != null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "EmailAddress",ProfileServiceErrorCode.EmailAddressIsDuplicate);
		}
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result verifyDeleteEmailAddressRequest(
			DeleteEmailAddressRequestMsgEntity deleteEmailAddressRequestMsgEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
