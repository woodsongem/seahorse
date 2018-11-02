/**
 * 
 */
package seahorse.internal.business.emailservice;

import com.google.inject.Inject;

import seahorse.internal.business.emailservice.dal.datacontracts.EmailAddressDAO;
import seahorse.internal.business.emailservice.datacontracts.CreateEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailservice.datacontracts.UpdateEmailAddressRequestMsgEntity;
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
	public Result verifyCreateEmailAddressRequest(
			CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity) {
		Result result;
		result = isEmailAddressValid(createEmailAddressRequestMsgEntity);
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
	public Result isUserIdValid(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity) {
		UserCredentialDAO userCredentialDAO = userCredentialRepository
				.getUserCredentialByUserId(createEmailAddressRequestMsgEntity.getUserId());
		if (userCredentialDAO != null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UserId",
					ProfileServiceErrorCode.UserIdNotFound);
		}
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isEmailAddressValid(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity) {
		EmailAddressDAO emailAddressDAO = emailServiceRepository.getEmailAddressDetailByEmailAddress(createEmailAddressRequestMsgEntity.getEmailAddress());
				
		if (emailAddressDAO != null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "EmailAddress",
					ProfileServiceErrorCode.EmailAddressIsDuplicate);
		}
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result verifyUpdateEmailAddressRequest(
			UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
