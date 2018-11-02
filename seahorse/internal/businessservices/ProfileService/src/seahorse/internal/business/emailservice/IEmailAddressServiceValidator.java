/**
 * 
 */
package seahorse.internal.business.emailservice;

import seahorse.internal.business.emailservice.datacontracts.CreateEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailservice.datacontracts.UpdateEmailAddressRequestMsgEntity;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;

/**
 * @author SMJE
 *
 */
public interface IEmailAddressServiceValidator {

	Result validCreateEmailAddressRequest(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity);

	Result validateUpdateEmailAddressRequest(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity);

	Result isCreateEmailAddressRequestMsgEntityValid(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity);

	Result isUserIdValid(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity);

	Result isEmailAddressValid(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity);

	Result isUpdateEmailAddressRequestMsgEntityValid(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity);

	Result isEmailAddressValid(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity);

	Result isEmailAddressIdValid(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity);

	Result isUserIdValid(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity);

}
