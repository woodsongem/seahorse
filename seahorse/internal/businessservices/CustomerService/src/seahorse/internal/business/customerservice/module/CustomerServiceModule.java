/**
 * 
 */


package seahorse.internal.business.customerservice.module;

import com.google.inject.AbstractModule;

import seahorse.internal.business.customerservice.AddressService;
import seahorse.internal.business.customerservice.EmailAddressService;
import seahorse.internal.business.customerservice.IAddressService;
import seahorse.internal.business.customerservice.IEmailAddressService;
import seahorse.internal.business.customerservice.IPhoneService;
import seahorse.internal.business.customerservice.IUserCredentialService;
import seahorse.internal.business.customerservice.PhoneService;
import seahorse.internal.business.customerservice.UserCredentialService;
import seahorse.internal.business.customerservice.dal.AddressServiceRepository;
import seahorse.internal.business.customerservice.dal.EmailAddressServiceRepository;
import seahorse.internal.business.customerservice.dal.IAddressServiceRepository;
import seahorse.internal.business.customerservice.dal.IEmailAddressServiceRepository;
import seahorse.internal.business.customerservice.dal.IPhoneServiceRepository;
import seahorse.internal.business.customerservice.dal.IUserCredentialServiceRepository;
import seahorse.internal.business.customerservice.dal.PhoneServiceRepository;
import seahorse.internal.business.customerservice.dal.UserCredentialServiceRepository;
import seahorse.internal.business.customerservice.validators.AddressServiceValidator;
import seahorse.internal.business.customerservice.validators.EmailAddressServiceValidator;
import seahorse.internal.business.customerservice.validators.IAddressServiceValidator;
import seahorse.internal.business.customerservice.validators.IEmailAddressServiceValidator;
import seahorse.internal.business.customerservice.validators.IPhoneServiceValidator;
import seahorse.internal.business.customerservice.validators.IUserCredentialServiceValidator;
import seahorse.internal.business.customerservice.validators.PhoneServiceValidator;
import seahorse.internal.business.customerservice.validators.UserCredentialServiceValidator;
import seahorse.internal.business.customerservice.verifiers.AddressServiceVerifier;
import seahorse.internal.business.customerservice.verifiers.EmailAddressServiceVerifier;
import seahorse.internal.business.customerservice.verifiers.IAddressServiceVerifier;
import seahorse.internal.business.customerservice.verifiers.IEmailAddressServiceVerifier;
import seahorse.internal.business.customerservice.verifiers.IPhoneServiceVerifier;
import seahorse.internal.business.customerservice.verifiers.IUserCredentialServiceVerifier;
import seahorse.internal.business.customerservice.verifiers.PhoneServiceVerifier;
import seahorse.internal.business.customerservice.verifiers.UserCredentialServiceVerifier;

/**
 * @author admin
 *
 */
public class CustomerServiceModule extends AbstractModule
{

	@Override
	protected void configure() {
		 /*
	      * This tells Guice that whenever it sees a dependency on a ApplicationDetailRepository,
	      * it should satisfy the dependency using a ApplicationDetailService.
	      */
		bind(IEmailAddressService.class).to(EmailAddressService.class);
		bind(IPhoneService.class).to(PhoneService.class);
		bind(IAddressService.class).to(AddressService.class);
		bind(IUserCredentialService.class).to(UserCredentialService.class);
		
		bind(IEmailAddressServiceValidator.class).to(EmailAddressServiceValidator.class);
		bind(IEmailAddressServiceVerifier.class).to(EmailAddressServiceVerifier.class);
		bind(IEmailAddressServiceRepository.class).to(EmailAddressServiceRepository.class);
		
		bind(IPhoneServiceValidator.class).to(PhoneServiceValidator.class);
		bind(IPhoneServiceVerifier.class).to(PhoneServiceVerifier.class);
		bind(IPhoneServiceRepository.class).to(PhoneServiceRepository.class);
		
		
		bind(IAddressServiceValidator.class).to(AddressServiceValidator.class);
		bind(IAddressServiceVerifier.class).to(AddressServiceVerifier.class);
		bind(IAddressServiceRepository.class).to(AddressServiceRepository.class);
		
		bind(IUserCredentialServiceValidator.class).to(UserCredentialServiceValidator.class);
		bind(IUserCredentialServiceVerifier.class).to(UserCredentialServiceVerifier.class);
		bind(IUserCredentialServiceRepository.class).to(UserCredentialServiceRepository.class);
		
	}

}
