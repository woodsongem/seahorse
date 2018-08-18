/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import seahorse.internal.business.credentialtypeservice.datacontracts.DeleteCredentialTypeReqMsgEntity;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeModel;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;
import seahorse.internal.business.shared.aop.InjectLogger;


/**
 * @author admin
 *
 */
public class BaseCredentialTypeService implements IBaseCredentialTypeService {

	private final ICredentialTypeServiceRepository credentialTypeServiceRepository;
	private final ICredentialTypeServiceMapper credentialTypeServiceMapper;
	
	@InjectLogger
	Logger logger;
	
	@Inject
	public BaseCredentialTypeService(ICredentialTypeServiceRepository credentialTypeServiceRepository,ICredentialTypeServiceMapper credentialTypeServiceMapper)
	{
		this.credentialTypeServiceRepository=credentialTypeServiceRepository;
		this.credentialTypeServiceMapper=credentialTypeServiceMapper;
	}
	
	@Override
	public List<CredentialTypeModel> getCredentialTypeByUserId(UUID parsedUserId) {
		return credentialTypeServiceRepository.getCredentialTypeByUserId(parsedUserId, false);		
	}

	@Override
	public Result DeleteCredentialTypeByUserIdAndId(DeleteCredentialTypeReqMsgEntity deleteCredentialTypeReqMsgEntity) {
		CredentialTypeDAO credentialTypeDAO=credentialTypeServiceMapper.mapCredentialTypeDAO(deleteCredentialTypeReqMsgEntity);
		return credentialTypeServiceRepository.deleteCredentialType(credentialTypeDAO);
	}
}
