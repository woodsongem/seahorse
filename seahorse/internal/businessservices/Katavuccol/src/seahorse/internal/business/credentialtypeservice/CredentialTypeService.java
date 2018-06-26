/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.List;

import org.apache.logging.log4j.Logger;
import com.google.inject.Inject;

import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByIdMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByIdResMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByUserIdMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeMsgEntity;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeModel;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.shared.aop.InjectLogger;

/**
 * @author admin
 *
 */
public class CredentialTypeService implements ICredentialTypeService {
	private ICredentialTypeServiceMapper credentialTypeServiceMapper;
	private ICredentialTypeServiceVerifier credentialTypeServiceVerifier;
	private ICredentialTypeServiceValidator credentialTypeServiceValidator;
	private ICredentialTypeServiceProcessor credentialTypeServiceProcessor;
	private ICredentialTypeServicePostProcessor credentialTypeServicePostProcessor;	
	
	@InjectLogger  Logger logger;

	@Inject
	public CredentialTypeService(ICredentialTypeServiceMapper credentialTypeServiceMapper,
			ICredentialTypeServiceVerifier credentialTypeServiceVerifier,
			ICredentialTypeServiceValidator credentialTypeServiceValidator,
			ICredentialTypeServiceProcessor credentialTypeServiceProcessor,
			ICredentialTypeServicePostProcessor credentialTypeServicePostProcessor)
	{
		this.credentialTypeServiceMapper=credentialTypeServiceMapper;
		this.credentialTypeServiceVerifier=credentialTypeServiceVerifier;
		this.credentialTypeServiceValidator=credentialTypeServiceValidator;
		this.credentialTypeServiceProcessor=credentialTypeServiceProcessor;
		this.credentialTypeServicePostProcessor=credentialTypeServicePostProcessor;		
	}
	
	public List<CredentialTypeModel> getCredentialTypeByUserId(CredentialTypeByUserIdMsgEntity credentialTypeByUserId)
	{
		Result result=credentialTypeServiceValidator.validGetCredentialTypeByUserId(credentialTypeByUserId);
		
		result=credentialTypeServiceVerifier.verifyGetCredentialTypeByUserId(credentialTypeByUserId);
		
		return null;
		
	}
	public CredentialTypeMsgEntity getCredentialTypeById(CredentialTypeByIdMsgEntity credentialTypeByIdMsgEntity)
	{		
		
		Result result=credentialTypeServiceValidator.validGetCredentialTypeById(credentialTypeByIdMsgEntity);
		
		result=credentialTypeServiceVerifier.verifyGetCredentialTypeById(credentialTypeByIdMsgEntity);
		
		return null;
		
	}
}
