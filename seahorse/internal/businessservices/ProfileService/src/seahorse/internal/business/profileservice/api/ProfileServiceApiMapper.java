/**
 * 
 */
package seahorse.internal.business.profileservice.api;

import javax.servlet.http.HttpServletRequest;

import seahorse.internal.business.profileservice.api.datacontracts.CreateProfileRequestModel;
import seahorse.internal.business.profileservice.common.ProfileServiceErrorCode;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolServiceUtility;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.GetUserCredentialByUserIdMsgEntity;

/**
 * @author SMJE
 *
 */
public class ProfileServiceApiMapper implements IProfileServiceApiMapper {

	@Override
	public CreateUserCredentialMsgEntity MapCreateUserCredentialMsgEntity(
			CreateProfileRequestModel createProfileRequestModel) {

		if (createProfileRequestModel == null) {
			return null;
		}
		CreateUserCredentialMsgEntity createUserCredentialMsgEntity = new CreateUserCredentialMsgEntity();
		createUserCredentialMsgEntity.setUsername(createProfileRequestModel.getUserName());
		createUserCredentialMsgEntity.setPassword(createProfileRequestModel.getPassword());
		createUserCredentialMsgEntity.setEmailAddress(createProfileRequestModel.getEmailAddress());
		createUserCredentialMsgEntity.setPhoneNumber(createProfileRequestModel.getPhoneNumber());
		createUserCredentialMsgEntity.setProductItemId(createProfileRequestModel.getProductItemId());
		return createUserCredentialMsgEntity;
	}

	@Override
	public GetUserCredentialByUserIdMsgEntity MapGetUserCredentialByUserIdMsgEntity(String userid) {
		GetUserCredentialByUserIdMsgEntity getUserCredentialByUserIdMsgEntity = new GetUserCredentialByUserIdMsgEntity();
		getUserCredentialByUserIdMsgEntity.setUserId(userid);
		return getUserCredentialByUserIdMsgEntity;
	}

	@Override
	public OutPutResponse MapOutPutResponse(Result result, CreateUserCredentialMsgEntity createUserProfileMsgEntity,
			HttpServletRequest httpRequest) {
		OutPutResponse outPutResponse = new OutPutResponse();
		if (result == null) {
			outPutResponse.setResultStatus(ResultStatus.ERROR);
			String errorCode = String.format(ProfileServiceErrorCode.InternalError, httpRequest.getMethod(),"CreateUserProfile");
			outPutResponse.setResultMessage(KatavuccolServiceUtility.getResultMessage(errorCode, "", ResultStatus.ERROR));
		}
		outPutResponse.setResultMessages(result.getResultMessages());
		outPutResponse.setResultStatus(result.getResultStatus());
		if (result.getResultStatus() == ResultStatus.SUCCESS) {
			outPutResponse.setId(createUserProfileMsgEntity.getId());
		}

		return outPutResponse;
	}

}
