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
public interface IEmailAddressServiceVerifier {

	Result verifyCreateEmailAddressRequest(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity);

	Result verifyUpdateEmailAddressRequest(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity);

	Result isEmailAddressValid(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity);

	Result isUserIdValid(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity);

}
