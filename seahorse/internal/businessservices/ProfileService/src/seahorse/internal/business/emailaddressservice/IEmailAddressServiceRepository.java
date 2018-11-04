/**
 * 
 */
package seahorse.internal.business.emailaddressservice;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.emailaddressservice.dal.datacontracts.EmailAddressDAO;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;

/**
 * @author SMJE
 *
 */
public interface IEmailAddressServiceRepository {

	List<EmailAddressDAO> getEmailAddressByUserId(UUID userId);

	OutPutResponse CreateEmailAddress(EmailAddressDAO emailAddressDAO);

	Result updateEmailAddress(EmailAddressDAO emailAddressDAO);

	Result DeleteEmailAddress(EmailAddressDAO emailAddressDAO);

	EmailAddressDAO getEmailAddressById(UUID emailAddressId);

	EmailAddressDAO getEmailAddressDetailByEmailAddress(String emailAddress);

	EmailAddressDAO getEmailAddressDetailById(UUID id);

}
