/**
 * 
 */
package seahorse.internal.business.emailaddressservice;

import seahorse.internal.business.emailaddressservice.datacontracts.CreateEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.DeleteEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.UpdateEmailAddressRequestMsgEntity;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;

/**
 * @author SMJE
 *
 */
public class EmailAddressServicePostProcessor implements IEmailAddressServicePostProcessor {

	@Override
	public Result postProcessCreateEmailAddress(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity) {
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result postProcessorUpdateEmailAddress(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity) {
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result postProcessorDeleteEmailAddressRequest(DeleteEmailAddressRequestMsgEntity deleteEmailAddressRequestMsgEntity) {
		return new Result(ResultStatus.SUCCESS);
	}

}
