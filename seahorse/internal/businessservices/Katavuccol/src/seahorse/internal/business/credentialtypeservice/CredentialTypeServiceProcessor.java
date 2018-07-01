/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.List;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByUserIdMsgEntity;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeModel;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;
import seahorse.internal.business.shared.aop.InjectLogger;

/**
 * @author admin
 *
 */
public class CredentialTypeServiceProcessor implements ICredentialTypeServiceProcessor {

	private final IBaseCredentialTypeService baseCredentialTypeService;
	private final ICredentialTypeServiceRepository credentialTypeServiceRepository;
	private final ICredentialTypeServiceMapper credentialTypeServiceMapper;
	
	@InjectLogger  
	Logger logger;

	@Inject
	public CredentialTypeServiceProcessor(
			IBaseCredentialTypeService baseCredentialTypeService,
			ICredentialTypeServiceRepository credentialTypeServiceRepository,
			ICredentialTypeServiceMapper credentialTypeServiceMapper
			)
	{
		this.baseCredentialTypeService=baseCredentialTypeService;
		this.credentialTypeServiceRepository=credentialTypeServiceRepository;
		this.credentialTypeServiceMapper=credentialTypeServiceMapper;
	}
	
	@Override
	public Result processGetCredentialTypeByUserId(CredentialTypeByUserIdMsgEntity credentialTypeByUserId) {
		Result result=getCredentialTypeByUserId(credentialTypeByUserId);
		if(result.getResultStatus() != ResultStatus.SUCCESS)
		{
			return result;
		}		
		return result;
	}
	
	@Override
	public Result processCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {
		Result result=CreateCredentialType(createCredentialTypeMsgEntity);
		if(result.getResultStatus() != ResultStatus.SUCCESS)
		{
			return result;
		}		
		return result;
	}
	
	@Override
	public Result CreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {
		CredentialTypeDAO credentialTypeDAO =credentialTypeServiceMapper.MapcredentialTypeDAO(createCredentialTypeMsgEntity);
		return credentialTypeServiceRepository.createCategoryType(credentialTypeDAO);
	}
	
	@Override
	public Result getCredentialTypeByUserId(CredentialTypeByUserIdMsgEntity credentialTypeByUserId)
	{
		List<CredentialTypeModel> credentialTypeModel=baseCredentialTypeService.getCredentialTypeByUserId(credentialTypeByUserId.getParsedUserId());
		if(credentialTypeModel.isEmpty() || credentialTypeModel.size() == 0)
		{
			return new Result(ResultStatus.ERROR);
		}
		credentialTypeByUserId.setCredentialType(credentialTypeModel);
		return new Result(ResultStatus.SUCCESS);
	}

	

}
