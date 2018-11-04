/**
 * 
 */
package seahorse.internal.business.emailaddressservice;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import seahorse.internal.business.emailaddressservice.datacontracts.CreateEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.DeleteEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.UpdateEmailAddressRequestMsgEntity;
import seahorse.internal.business.shared.aop.InjectLogger;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;

/**
 * @author SMJE
 *
 */
public class BaseEmailAddressService implements IBaseEmailAddressService {

	private final IEmailAddressServiceRepository emailAddressServiceRepository;

	@InjectLogger
	Logger logger;

	@Inject
	public BaseEmailAddressService(IEmailAddressServiceRepository emailAddressServiceRepository) {
		this.emailAddressServiceRepository=emailAddressServiceRepository;
	}

	@Override
	public Result CreateEmailAddress(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateEmailAddress(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result deleteEmailAddress(DeleteEmailAddressRequestMsgEntity deleteEmailAddressRequestMsgEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
