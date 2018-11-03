/**
 * 
 */
package seahorse.internal.business.emailaddressservice;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

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

	@InjectLogger
	Logger logger;

	@Inject

	public EmailAddressServiceProcessor(IBaseEmailAddressService baseEmailAddressService) {
		this.baseEmailAddressService = baseEmailAddressService;
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
		return result;
	}

	@Override
	public Result deleteEmailAddress(DeleteEmailAddressRequestMsgEntity deleteEmailAddressRequestMsgEntity) {
		Result result = baseEmailAddressService.deleteEmailAddress(deleteEmailAddressRequestMsgEntity);
		return result;
	}

	@Override
	public Result updateEmailAddress(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity) {
		Result result = baseEmailAddressService.updateEmailAddress(updateEmailAddressRequestMsgEntity);
		return result;
	}

	
	@Override
	public Result createEmailAddress(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity) {
		Result result = baseEmailAddressService.CreateEmailAddress(createEmailAddressRequestMsgEntity);
		return result;
	}
}
