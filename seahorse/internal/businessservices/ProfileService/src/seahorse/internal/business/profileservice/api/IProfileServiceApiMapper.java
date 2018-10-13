/**
 * 
 */
package seahorse.internal.business.profileservice.api;

import javax.servlet.http.HttpServletRequest;

import seahorse.internal.business.profileservice.api.datacontracts.CreateProfileRequestModel;
import seahorse.internal.business.profileservice.api.datacontracts.CreateProfileResponseModel;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.DeleteUserProfileMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.GetUserCredentialByUserIdMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.GetUserProfileByUserNameMsgEntity;

/**
 * @author SMJE
 *
 */
public interface IProfileServiceApiMapper {

	CreateUserCredentialMsgEntity MapCreateUserCredentialMsgEntity(CreateProfileRequestModel createProfileRequestModel);

	GetUserCredentialByUserIdMsgEntity MapGetUserCredentialByUserIdMsgEntity(String userid);

	OutPutResponse MapOutPutResponse(Result result, CreateUserCredentialMsgEntity createUserProfileMsgEntity, HttpServletRequest httpRequest);

	DeleteUserProfileMsgEntity MapDeleteUserProfileMsgEntity(String userid);

	CreateProfileResponseModel mapCreateProfileResponseModel(Result result, CreateUserCredentialMsgEntity createUserProfileMsgEntity, HttpServletRequest httpRequest);

	GetUserProfileByUserNameMsgEntity MapGetUserProfileByUserNameMsgEntity(String username);

}
