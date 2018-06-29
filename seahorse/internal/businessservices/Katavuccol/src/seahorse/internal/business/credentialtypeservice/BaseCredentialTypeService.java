/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeModel;
import seahorse.internal.business.shared.aop.InjectLogger;


/**
 * @author admin
 *
 */
public class BaseCredentialTypeService implements IBaseCredentialTypeService {

	private final ICredentialTypeServiceRepository credentialTypeServiceRepository;
	
	@InjectLogger
	Logger logger;
	
	@Inject
	public BaseCredentialTypeService(ICredentialTypeServiceRepository credentialTypeServiceRepository)
	{
		this.credentialTypeServiceRepository=credentialTypeServiceRepository;
	}
	
	@Override
	public List<CredentialTypeModel> getCredentialTypeByUserId(UUID parsedUserId) {
		return credentialTypeServiceRepository.getCredentialTypeByUserId(parsedUserId, false);		
	}
}
