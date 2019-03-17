/**
 * 
 */
package seahorse.internal.business.emailaddressservice;

import seahorse.internal.business.emailaddressservice.datacontracts.CreateEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.DeleteEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.UpdateEmailAddressRequestMsgEntity;
import seahorse.internal.business.profileservice.common.ProfileServiceErrorCode;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolServiceUtility;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;

/**
 * @author SMJE
 *
 */
public class EmailAddressServiceValidator implements IEmailAddressServiceValidator {

	@Override
	public Result validCreateEmailAddressRequest(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity) {
		Result result;
		result = isCreateEmailAddressRequestMsgEntityValid(createEmailAddressRequestMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		result = isUserIdValid(createEmailAddressRequestMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		result = isEmailAddressValid(createEmailAddressRequestMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		return result;
	}

	@Override
	public Result validateUpdateEmailAddressRequest(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity) {
		Result result;
		result = isUpdateEmailAddressRequestMsgEntityValid(updateEmailAddressRequestMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = isEmailAddressIdValid(updateEmailAddressRequestMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = isEmailAddressValid(updateEmailAddressRequestMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = isUserIdValid(updateEmailAddressRequestMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		return result;
	}
	
	@Override
	public Result validDeleteEmailAddressRequest(DeleteEmailAddressRequestMsgEntity deleteEmailAddressRequestMsgEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result isUserIdValid(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity) {
		if (!KatavuccolServiceUtility.isValidUUID(updateEmailAddressRequestMsgEntity.getUserId())) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UserId",
					ProfileServiceErrorCode.UserIdIsInValid);
		}
		updateEmailAddressRequestMsgEntity.setModifiedBy(updateEmailAddressRequestMsgEntity.getUserId());
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isEmailAddressIdValid(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity) {
		if (!KatavuccolServiceUtility.isValidUUID(updateEmailAddressRequestMsgEntity.getId())) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Id",
					ProfileServiceErrorCode.EmailAddressIdIsInValid);
		}
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isEmailAddressValid(UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity) {
		if (KatavuccolServiceUtility.isNullOrWhitespace(updateEmailAddressRequestMsgEntity.getEmailAddress())) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "EmailAddress",
					ProfileServiceErrorCode.EmailAddressIsInEmpty);
		}
		if (!KatavuccolServiceUtility.isValidEmailAddress(updateEmailAddressRequestMsgEntity.getEmailAddress())) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "EmailAddress",
					ProfileServiceErrorCode.EmailAddressIsInValid);
		}

		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isUpdateEmailAddressRequestMsgEntityValid(
			UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity) {
		if (updateEmailAddressRequestMsgEntity == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UpdateEmailAddressRequestMsgEntity is null",
					"UpdateEmailAddressRequestMsgEntity",
					ProfileServiceErrorCode.UpdateEmailAddressRequestMsgEntityIsEmpty);
		}

		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isEmailAddressValid(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity) {
		if (KatavuccolServiceUtility.isNullOrWhitespace(createEmailAddressRequestMsgEntity.getEmailAddress())) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "EmailAddress",
					ProfileServiceErrorCode.EmailAddressIsInEmpty);
		}
		if (!KatavuccolServiceUtility.isValidEmailAddress(createEmailAddressRequestMsgEntity.getEmailAddress())) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "EmailAddress",
					ProfileServiceErrorCode.EmailAddressIsInValid);
		}

		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isUserIdValid(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity) {

		if (!KatavuccolServiceUtility.isValidUUID(createEmailAddressRequestMsgEntity.getUserId())) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UserId",
					ProfileServiceErrorCode.UserIdIsInValid);
		}
		createEmailAddressRequestMsgEntity.setModifiedBy(createEmailAddressRequestMsgEntity.getUserId());
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isCreateEmailAddressRequestMsgEntityValid(CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity) {

		if (createEmailAddressRequestMsgEntity == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "CreateEmailAddressRequestMsgEntity is null",
					"CreateEmailAddressRequestMsgEntity",
					ProfileServiceErrorCode.CreateEmailAddressRequestMsgEntityIsEmpty);
		}

		return new Result(ResultStatus.SUCCESS);
	}

	

}
