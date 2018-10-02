/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import java.util.UUID;

import seahorse.internal.business.profileservice.common.ProfileServiceErrorCode;
import seahorse.internal.business.profileservice.common.ProfileServiceUtility;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolServiceUtility;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;

/**
 * @author SMJE
 *
 */
public class UserCredentialServiceValidator implements IUserCredentialServiceValidator {

	@Override
	public Result validCreateUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		Result result = isCreateUserCredentialMsgEntityValid(createUserCredentialMsgEntity);
		if (result.getResultStatus() == ResultStatus.ERROR) {
			return result;
		}
		result = isUserNameValid(createUserCredentialMsgEntity);
		if (result.getResultStatus() == ResultStatus.ERROR) {
			return result;
		}
		result = isPasswordValid(createUserCredentialMsgEntity);
		if (result.getResultStatus() == ResultStatus.ERROR) {
			return result;
		}

		result = isProductItemIdValid(createUserCredentialMsgEntity);
		if (result.getResultStatus() == ResultStatus.ERROR) {
			return result;
		}

		return result;
	}

	@Override
	public Result isProductItemIdValid(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		if (KatavuccolServiceUtility.isNullOrWhitespace(createUserCredentialMsgEntity.getProductItemId())) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "ProductItemId",ProfileServiceErrorCode.ProductItemIdIsEmpty);
		}
		if (!KatavuccolServiceUtility.isValidUUID(createUserCredentialMsgEntity.getProductItemId())) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "ProductItemId",ProfileServiceErrorCode.ProductItemIdIsInValid);
		}
		createUserCredentialMsgEntity.setParsedProductItemId(UUID.fromString(createUserCredentialMsgEntity.getProductItemId()));
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isCreateUserCredentialMsgEntityValid(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		if (createUserCredentialMsgEntity == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "CreateUserCredentialMsgEntity",
					ProfileServiceErrorCode.CreateUserCredentialMsgEntityIsEmpty);
		}
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isUserNameValid(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		if (KatavuccolServiceUtility.isNullOrWhitespace(createUserCredentialMsgEntity.getUsername())) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UserName",
					ProfileServiceErrorCode.UserNameIsEmpty);
		}
		if (!ProfileServiceUtility.isUserNameValid(createUserCredentialMsgEntity.getUsername())) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UserName",
					ProfileServiceErrorCode.UserNameIsInValid);
		}
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isPasswordValid(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		if (KatavuccolServiceUtility.isNullOrWhitespace(createUserCredentialMsgEntity.getPassword())) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Password",
					ProfileServiceErrorCode.PasswordIsEmpty);
		}
		if (!ProfileServiceUtility.isPasswordValid(createUserCredentialMsgEntity.getPassword())) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Password",
					ProfileServiceErrorCode.PasswordIsInValid);
		}
		return new Result(ResultStatus.SUCCESS);
	}

}
