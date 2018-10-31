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
public interface IEmailAddressService {

	Result CreateEmailAddress(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity);

	Result updateEmailAddress(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity);

}
