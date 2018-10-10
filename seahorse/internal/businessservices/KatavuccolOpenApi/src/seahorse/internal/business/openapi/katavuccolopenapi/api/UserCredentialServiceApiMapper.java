/**
 * 
 */
package seahorse.internal.business.openapi.katavuccolopenapi.api;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;

import seahorse.internal.business.openapi.katavuccolopenapi.common.KatavuccolOpenApiErrorCode;
import seahorse.internal.business.openapi.usercredentialapi.api.datacontracts.CreateProfileApiModel;
import seahorse.internal.business.openapi.usercredentialservice.datacontracts.CreateProfileApiMsgEntity;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolServiceUtility;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultMessage;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;

/**
 * @author SMJE
 *
 */
public class UserCredentialServiceApiMapper implements IUserCredentialServiceApiMapper {

	@Override
	public CreateProfileApiMsgEntity MapCreateProfileApiMsgEntity(CreateProfileApiModel createProfileApiModel) {
		if (createProfileApiModel == null) {
			return null;
		}
		CreateProfileApiMsgEntity createProfileApiMsgEntity = new CreateProfileApiMsgEntity();
		createProfileApiMsgEntity.setEmailAddress(createProfileApiModel.getEmailAddress());
		createProfileApiMsgEntity.setPassword(createProfileApiModel.getPassword());
		createProfileApiMsgEntity.setPhoneNumber(createProfileApiModel.getPhoneNumber());
		createProfileApiMsgEntity.setProductItemId(createProfileApiModel.getProductItemId());
		createProfileApiMsgEntity.setUserName(createProfileApiModel.getUserName());
		return createProfileApiMsgEntity;
	}

	@Override
	public OutPutResponse MapOutPutResponse(OutPutResponse outPutResponse,
			CreateProfileApiMsgEntity createProfileApiMsgEntity, HttpServletRequest httpRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutPutResponse mapOutPutResponse(OutPutResponse outPutResponse, HttpServletRequest httpRequest) {
		if (outPutResponse == null) {
			OutPutResponse outPutResponsetemp = new OutPutResponse();
			outPutResponsetemp.setResultStatus(ResultStatus.ERROR);
			String errorCode = MessageFormat.format(KatavuccolOpenApiErrorCode.InternalError,new Object[] { httpRequest.getMethod(), "CreateUserProfile"});
			outPutResponsetemp
					.setResultMessage(KatavuccolServiceUtility.getResultMessage(errorCode, "", ResultStatus.ERROR));
			return outPutResponsetemp;
		}
		if (outPutResponse.getResultMessages() == null || outPutResponse.getResultMessages().size() == 0) {
			return outPutResponse;
		}
		for (ResultMessage resultMessage : outPutResponse.getResultMessages()) {
			resultMessage.setErrorCode(MessageFormat.format(resultMessage.getErrorCode(),new Object[] { httpRequest.getMethod(), "CreateUserProfile" }));
		}
		return outPutResponse;
	}

}
