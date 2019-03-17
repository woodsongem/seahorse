/**
 * 
 */
package seahorse.internal.business.emailaddressservice;

import seahorse.internal.business.emailaddressservice.dal.datacontracts.EmailAddressDAO;
import seahorse.internal.business.emailaddressservice.datacontracts.CreateEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.DeleteEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.UpdateEmailAddressRequestMsgEntity;

/**
 * @author SMJE
 *
 */
public interface IEmailAddressServiceMapper {

	EmailAddressDAO mapEmailAddressDAO(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity);

	EmailAddressDAO mapEmailAddressDAO(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity);

	EmailAddressDAO mapEmailAddressDAO(DeleteEmailAddressRequestMsgEntity deleteEmailAddressRequestMsgEntity);

}
