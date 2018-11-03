/**
 * 
 */
package seahorse.internal.business.emailaddressservice;

import seahorse.internal.business.emailaddressservice.datacontracts.CreateEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.DeleteEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.UpdateEmailAddressRequestMsgEntity;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;

/**
 * @author SMJE
 *
 */
public interface IEmailAddressServicePostProcessor {

	Result postProcessCreateEmailAddress(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity);

	Result postProcessorUpdateEmailAddress(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity);

	Result postProcessorDeleteEmailAddressRequest(DeleteEmailAddressRequestMsgEntity deleteEmailAddressRequestMsgEntity);

}
