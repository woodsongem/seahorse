/**
 * 
 */
package seahorse.internal.business.emailservice;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.emailservice.dal.datacontracts.EmailAddressDAO;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;

/**
 * @author SMJE
 *
 */
public interface IEmailServiceRepository {

	List<EmailAddressDAO> getEmailAddressByUserId(UUID userId);

	OutPutResponse CreateEmailAddress(EmailAddressDAO emailAddressDAO);

	Result updateEmailId(EmailAddressDAO emailAddressDAO);

	Result DeleteEmailId(UUID emailAddressId);

	EmailAddressDAO getEmailAddressById(UUID emailAddressId);

	EmailAddressDAO getEmailAddressDetailByEmailAddress(String emailAddress);

}
