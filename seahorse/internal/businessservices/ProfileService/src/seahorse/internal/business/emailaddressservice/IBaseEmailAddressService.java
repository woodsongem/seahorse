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
public interface IBaseEmailAddressService {

	Result CreateEmailAddress(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity);

	Result updateEmailAddress(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity);

	Result deleteEmailAddress(DeleteEmailAddressRequestMsgEntity deleteEmailAddressRequestMsgEntity);

}
