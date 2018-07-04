/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;

import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByIdMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByUserIdMsgEntity;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.profileservice.IProfileServiceValidator;

/**
 * @author admin
 *
 */
public class CredentialTypeServiceValidator implements ICredentialTypeServiceValidator {

	private final IKatavuccolServiceErrorCode katavuccolServiceErrorCode;
	private final IProfileServiceValidator profileServiceValidator;

	@Inject
	public CredentialTypeServiceValidator(
			IKatavuccolServiceErrorCode katavuccolServiceErrorCode,
			IProfileServiceValidator profileServiceValidator
			) {
		this.katavuccolServiceErrorCode = katavuccolServiceErrorCode;
		this.profileServiceValidator=profileServiceValidator;
	}

	@Override
	public Result validGetCredentialTypeByUserId(CredentialTypeByUserIdMsgEntity credentialTypeByUserId) {
		Result result = IsCredentialTypeByUserIdMsgEntityValid(credentialTypeByUserId);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result=IsUserIdValid(credentialTypeByUserId);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return result;
	}
	@Override
	public Result validCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {
		Result result;

		result = isCreateCredentialTypeMsgEntityValid(createCredentialTypeMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isUserIdValid(createCredentialTypeMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isNameValid(createCredentialTypeMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
				
		return new Result(ResultStatus.SUCCESS);
	}
	public Result isUserIdValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {
		Result result=profileServiceValidator.isUserIdValid(createCredentialTypeMsgEntity.getUserId());
		if(result.getResultStatus() == ResultStatus.ERROR)
		{
			return result;
		}
		createCredentialTypeMsgEntity.setParsedUserId(UUID.fromString(createCredentialTypeMsgEntity.getUserId()));
		createCredentialTypeMsgEntity.setCreatedBy(createCredentialTypeMsgEntity.getParsedUserId());
		return new Result(ResultStatus.SUCCESS);
	}

	public Result isCreateCredentialTypeMsgEntityValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {
		Result result=new Result(ResultStatus.SUCCESS);		
		
		if(createCredentialTypeMsgEntity==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"CreateCredentialTypeMsgEntity is null","CreateCredentialTypeMsgEntity",katavuccolServiceErrorCode.createCredentialTypeMsgEntityIsEmpty());
		}
		
		return result;
	}

	@Override
	public Result validGetCredentialTypeById(CredentialTypeByIdMsgEntity credentialTypeByIdMsgEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Result IsCredentialTypeByUserIdMsgEntityValid(CredentialTypeByUserIdMsgEntity credentialTypeByUserId) {
		if (credentialTypeByUserId == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "CredentialTypeByUserIdMsgEntity is null",
					"CredentialTypeByUserIdMsgEntity",
					katavuccolServiceErrorCode.CredentialTypeByUserIdMsgEntityIsEmpty());
		}
		return new Result(ResultStatus.SUCCESS);
	}
	
	public Result IsUserIdValid(CredentialTypeByUserIdMsgEntity credentialTypeByUserId) {
		Result result=profileServiceValidator.isUserIdValid(credentialTypeByUserId.getUserId());
		if(result.getResultStatus() == ResultStatus.ERROR)
		{
			return result;
		}
		credentialTypeByUserId.setParsedUserId(UUID.fromString(credentialTypeByUserId.getUserId()));
		return new Result(ResultStatus.SUCCESS);
	}

	
	public Result isNameValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {
		Result result=new Result(ResultStatus.SUCCESS);		
		
		if(StringUtils.isEmpty(createCredentialTypeMsgEntity.getName()))
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"Name is null","Name",katavuccolServiceErrorCode.NameIsEmpty());
		}
		
		return result;
	}
}
