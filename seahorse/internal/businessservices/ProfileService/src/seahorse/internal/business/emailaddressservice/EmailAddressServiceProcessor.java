/**
 * 
 */
package seahorse.internal.business.emailaddressservice;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import seahorse.internal.business.emailaddressservice.dal.datacontracts.EmailAddressDAO;
import seahorse.internal.business.emailaddressservice.datacontracts.CreateEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.DeleteEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.UpdateEmailAddressRequestMsgEntity;
import seahorse.internal.business.shared.aop.InjectLogger;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;

/**
 * @author SMJE
 *
 */
public class EmailAddressServiceProcessor implements IEmailAddressServiceProcessor {

	private final IBaseEmailAddressService baseEmailAddressService;
	private final IEmailServiceRepository emailServiceRepository;
	private final IEmailAddressServiceMapper emailAddressServiceMapper;

	@InjectLogger
	Logger logger;

	@Inject

	public EmailAddressServiceProcessor(IBaseEmailAddressService baseEmailAddressService,
			IEmailServiceRepository emailServiceRepository, IEmailAddressServiceMapper emailAddressServiceMapper) {
		this.baseEmailAddressService = baseEmailAddressService;
		this.emailServiceRepository = emailServiceRepository;
		this.emailAddressServiceMapper = emailAddressServiceMapper;
	}

	@Override
	public Result processCreateEmailAddress(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity) {
		Result result = createEmailAddress(createEmailAddressRequestMsgEntity);
		if (result.getResultStatus() != ResultStatus.ERROR) {
			return result;
		}
		return result;
	}

	@Override
	public Result processUpdateEmailAddress(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity) {
		Result result = updateEmailAddress(updateEmailAddressRequestMsgEntity);
		if (result.getResultStatus() != ResultStatus.ERROR) {
			return result;
		}
		return result;
	}

	@Override
	public Result processorDeleteEmailAddressRequest(DeleteEmailAddressRequestMsgEntity deleteEmailAddressRequestMsgEntity) {
		Result result = deleteEmailAddress(deleteEmailAddressRequestMsgEntity);
		if (result.getResultStatus() != ResultStatus.ERROR) {
			return result;
		}
		return result;
	}

	@Override
	public Result deleteEmailAddress(DeleteEmailAddressRequestMsgEntity deleteEmailAddressRequestMsgEntity) {
		EmailAddressDAO emailAddressDAO=emailAddressServiceMapper.mapEmailAddressDAO(deleteEmailAddressRequestMsgEntity);
		return	emailServiceRepository.DeleteEmailAddress(emailAddressDAO);
	}

	@Override
	public Result updateEmailAddress(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity) {
		EmailAddressDAO emailAddressDAO=emailAddressServiceMapper.mapEmailAddressDAO(updateEmailAddressRequestMsgEntity);
		return	emailServiceRepository.updateEmailAddress(emailAddressDAO);
	}

	@Override
	public Result createEmailAddress(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity) {
		EmailAddressDAO emailAddressDAO=emailAddressServiceMapper.mapEmailAddressDAO(createEmailAddressRequestMsgEntity);
		return	emailServiceRepository.CreateEmailAddress(emailAddressDAO);
	}
}
