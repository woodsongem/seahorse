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
public interface IEmailAddressServiceProcessor {

	Result processCreateEmailAddress(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity);

	Result processUpdateEmailAddress(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity);

}
