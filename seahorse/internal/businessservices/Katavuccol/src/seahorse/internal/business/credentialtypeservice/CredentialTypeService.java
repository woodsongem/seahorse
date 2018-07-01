/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.datastax.driver.core.utils.UUIDs;
import com.google.inject.Inject;

import seahorse.internal.business.credentialtypeservice.datacontracts.*;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeModel;
import seahorse.internal.business.katavuccolservice.common.KatavuccolConstant;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
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
	
	public CreateCredentialTypeResMsgEntity Create(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
	{
		//Set	
		createCredentialTypeMsgEntity.setId(UUIDs.timeBased());
		createCredentialTypeMsgEntity.setStatus(KatavuccolConstant.ACTIVESTATUS);
		createCredentialTypeMsgEntity.setCreatedDate(new Date());
				
		Result result=credentialTypeServiceValidator.validCreateCredentialType(createCredentialTypeMsgEntity);
		if(result.getResultStatus() != ResultStatus.SUCCESS)
		{
			return null;
		}
		
		result=credentialTypeServiceVerifier.verifyCreateCredentialType(createCredentialTypeMsgEntity);
		if(result.getResultStatus() != ResultStatus.SUCCESS)
		{
			return null;
		}
		
		result=	credentialTypeServiceProcessor.processCreateCredentialType(createCredentialTypeMsgEntity);
		if(result.getResultStatus() != ResultStatus.SUCCESS)
		{
			return null;
		}	
		result=	credentialTypeServicePostProcessor.postProcessCreateCredentialType(createCredentialTypeMsgEntity);
		if(result.getResultStatus() != ResultStatus.SUCCESS)
		{
			return null;
		}
		
		return null;
	}
	
	public List<CredentialTypeModel> getCredentialTypeByUserId(CredentialTypeByUserIdMsgEntity credentialTypeByUserId)
	{
		Result result=credentialTypeServiceValidator.validGetCredentialTypeByUserId(credentialTypeByUserId);
		if(result.getResultStatus() != ResultStatus.SUCCESS)
		{
			return null;
		}
		
		result=credentialTypeServiceVerifier.verifyGetCredentialTypeByUserId(credentialTypeByUserId);
		if(result.getResultStatus() != ResultStatus.SUCCESS)
		{
			return null;
		}
		
		result=	credentialTypeServiceProcessor.processGetCredentialTypeByUserId(credentialTypeByUserId);
		if(result.getResultStatus() != ResultStatus.SUCCESS)
		{
			return null;
		}
		
		return credentialTypeByUserId.getCredentialType();
		
	}
	public CredentialTypeMsgEntity getCredentialTypeById(CredentialTypeByIdMsgEntity credentialTypeByIdMsgEntity)
	{		
		
		Result result=credentialTypeServiceValidator.validGetCredentialTypeById(credentialTypeByIdMsgEntity);
		
		result=credentialTypeServiceVerifier.verifyGetCredentialTypeById(credentialTypeByIdMsgEntity);
		
		return null;
		
	}
	
	
}
