/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.List;

import com.google.common.collect.FluentIterable;
import com.google.inject.Inject;

import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByIdMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByUserIdMsgEntity;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeModel;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeRequestMessageEntity;
import seahorse.internal.business.profileservice.IBaseProfileService;
import seahorse.internal.business.profileservice.IProfileServiceVerifier;
import seahorse.internal.business.profileservice.datacontracts.UserMessageEntity;

/**
 * @author admin
 *
 */
public class CredentialTypeServiceVerifier implements ICredentialTypeServiceVerifier {
	
	private final IBaseCredentialTypeService  baseCredentialTypeService;	
	private final IBaseProfileService baseProfileService;
	private final IKatavuccolServiceErrorCode katavuccolServiceErrorCode;
	private final ICredentialTypeServiceRepository credentialTypeServiceRepository;

	@Inject
	public CredentialTypeServiceVerifier(
			IBaseCredentialTypeService  baseCredentialTypeService,
			IBaseProfileService baseProfileService,
			IKatavuccolServiceErrorCode katavuccolServiceErrorCode,
			ICredentialTypeServiceRepository credentialTypeServiceRepository
			)
	{
		this.baseCredentialTypeService=baseCredentialTypeService;
		this.baseProfileService=baseProfileService;
		this.katavuccolServiceErrorCode=katavuccolServiceErrorCode;
		this.credentialTypeServiceRepository=credentialTypeServiceRepository;
	}
	
	@Override
	public Result verifyGetCredentialTypeByUserId(CredentialTypeByUserIdMsgEntity credentialTypeByUserId) {
		Result result=isUserIdValid(credentialTypeByUserId);
		if(result.getResultStatus() != ResultStatus.SUCCESS)
		{
			return result;
		}
		
		return result;
	}
	
	@Override
	public Result verifyCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {
		Result result;

		result = isUserIdValid(createCredentialTypeMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}	
			
		result = isNameValid(createCredentialTypeMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
				
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}
	
	@Override
	public Result isUserIdValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {
		 UserMessageEntity userMessageEntity=baseProfileService.getUserDetail(createCredentialTypeMsgEntity.getParsedUserId());
		  if(userMessageEntity==null)
		  {
				return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UserId is invalid",
						"UserId",katavuccolServiceErrorCode.userIdNotFound());
		  }
		  
		  return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result verifyGetCredentialTypeById(CredentialTypeByIdMsgEntity credentialTypeByIdMsgEntity) {		
		return null;
	}
	
	
	public Result isUserIdValid(CredentialTypeByUserIdMsgEntity credentialTypeByUserId)
	{
	  UserMessageEntity userMessageEntity=baseProfileService.getUserDetail(credentialTypeByUserId.getParsedUserId());
	  if(userMessageEntity==null)
	  {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UserId is null",
					"UserId",
					katavuccolServiceErrorCode.userIdNotFound());
	  }
	  
		return new Result(ResultStatus.SUCCESS);
	}
	
	public Result isNameValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {
		List<CredentialTypeDAO> CredentialTypeDAOs=credentialTypeServiceRepository.getCredentialTypeDAOByUserId(createCredentialTypeMsgEntity.getParsedUserId(),false);
		List<CredentialTypeDAO> filterCredentialTypeDAOs=
										FluentIterable
										.from(CredentialTypeDAOs)
										.filter(x-> KatavuccolServiceUtility.isEqual(x.getName(),createCredentialTypeMsgEntity.getName()))
										.toList();
		if(filterCredentialTypeDAOs.isEmpty())
		{
			return new Result(ResultStatus.SUCCESS);	
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Duplicate credential Name is not allowed", "Name", katavuccolServiceErrorCode.nameDuplicatedNotAllowed());
		
	}

	@Override
	public Result isUserIdValid(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
