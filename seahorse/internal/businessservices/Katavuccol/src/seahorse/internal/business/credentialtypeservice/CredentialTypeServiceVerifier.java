/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import com.google.inject.Inject;

import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByIdMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByUserIdMsgEntity;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
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

	@Inject
	public CredentialTypeServiceVerifier(
			IBaseCredentialTypeService  baseCredentialTypeService,
			IBaseProfileService baseProfileService,
			IKatavuccolServiceErrorCode katavuccolServiceErrorCode
			)
	{
		this.baseCredentialTypeService=baseCredentialTypeService;
		this.baseProfileService=baseProfileService;
		this.katavuccolServiceErrorCode=katavuccolServiceErrorCode;
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
}
