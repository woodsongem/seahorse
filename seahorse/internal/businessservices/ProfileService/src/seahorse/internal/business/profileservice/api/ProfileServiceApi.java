/**
 * 
 */
package seahorse.internal.business.profileservice.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import seahorse.internal.business.emailaddressservice.EmailAddressServiceFactory;
import seahorse.internal.business.emailaddressservice.IEmailAddressService;
import seahorse.internal.business.emailaddressservice.api.datatcontracts.CreateEmailAddressRequestModel;
import seahorse.internal.business.emailaddressservice.api.datatcontracts.CreateEmailAddressResponseModel;
import seahorse.internal.business.emailaddressservice.api.datatcontracts.EmailAddressModel;
import seahorse.internal.business.emailaddressservice.api.datatcontracts.UpdateEmailAddressRequestModel;
import seahorse.internal.business.emailaddressservice.api.datatcontracts.UpdateEmailAddressResponseModel;
import seahorse.internal.business.emailaddressservice.datacontracts.CreateEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.DeleteEmailAddressRequestMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.GetEmailAddressByEmailAddressIdMsgEntity;
import seahorse.internal.business.emailaddressservice.datacontracts.UpdateEmailAddressRequestMsgEntity;
import seahorse.internal.business.profileservice.api.datacontracts.CreateProfileRequestModel;
import seahorse.internal.business.profileservice.api.datacontracts.CreateProfileResponseModel;
import seahorse.internal.business.profileservice.api.datacontracts.UpdateProfileRequestModel;
import seahorse.internal.business.profileservice.api.datacontracts.UserCredentialModel;
import seahorse.internal.business.profileservice.common.ProfileServiceConstants;
import seahorse.internal.business.shared.katavuccol.common.KatavuccolServiceUtility;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultMessage;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;
import seahorse.internal.business.usercredentialservice.IUserCredentialService;
import seahorse.internal.business.usercredentialservice.UserCredentialServiceFactory;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.DeleteUserProfileMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.GetUserCredentialByUserIdMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.GetUserProfileByUserNameMsgEntity;

/**
 * @author SMJE
 *
 */
@Path("/")
public class ProfileServiceApi {

	private static final Logger logger = LogManager.getLogger(ProfileServiceApi.class);
	@Context
	private HttpServletRequest httpRequest;

	@POST
	@Path("/profile")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUserProfile(CreateProfileRequestModel createProfileRequestModel) {
		IProfileServiceApiMapper profileServiceApiMapper = new ProfileServiceApiMapper();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		Result result = new Result();
		CreateUserCredentialMsgEntity createUserProfileMsgEntity = null;
		try {
			IUserCredentialService userCredentialService = UserCredentialServiceFactory.getIUserCredentialService();
			createUserProfileMsgEntity = profileServiceApiMapper
					.MapCreateUserCredentialMsgEntity(createProfileRequestModel);
			result = userCredentialService.createUserCredential(createUserProfileMsgEntity);
			if (result == null) {
				result = new OutPutResponse();
			} else {
				if (result.getResultStatus() == ResultStatus.ERROR) {
					ReplaceErrorCode(result, ProfileServiceConstants.CreateUserProfileMethodName);
				}
				httpStatus = createUserProfileMsgEntity.getHttpStatus() == null ? Status.INTERNAL_SERVER_ERROR
						: createUserProfileMsgEntity.getHttpStatus();
			}
		} catch (Exception ex) {
			httpStatus = Status.INTERNAL_SERVER_ERROR;
			logger.error("ProfileServiceApi::createUserProfile Exception=" + ex);
		}
		CreateProfileResponseModel createProfileResponseModel = profileServiceApiMapper
				.mapCreateProfileResponseModel(result, createUserProfileMsgEntity, httpRequest);
		return Response.status(httpStatus).entity(createProfileResponseModel).build();
	}

	@PUT
	@Path("/profile/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUserProfile(@PathParam("userid") String userid,
			UpdateProfileRequestModel updateProfileRequestModel) {
		return null;

	}

	@DELETE
	@Path("/profile/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUserProfile(@PathParam("userid") String userid) {
		IProfileServiceApiMapper profileServiceApiMapper = new ProfileServiceApiMapper();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		Result result = new Result();
		try {
			IUserCredentialService userCredentialService = UserCredentialServiceFactory.getIUserCredentialService();
			DeleteUserProfileMsgEntity getUserCredentialByUserIdMsgEntity = profileServiceApiMapper
					.MapDeleteUserProfileMsgEntity(userid);
			result = userCredentialService.deleteUserProfile(getUserCredentialByUserIdMsgEntity);
			if (result == null) {
				httpStatus = Status.NOT_FOUND;
				result = new Result();
			}
		} catch (Exception ex) {
			httpStatus = Status.INTERNAL_SERVER_ERROR;
			logger.error("ProfileServiceApi::deleteUserProfile Exception=" + ex);
		}
		return Response.status(httpStatus).entity(result).build();

	}

	@GET
	@Path("/profile/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserProfileByUserId(@PathParam("userid") String userid) {
		IProfileServiceApiMapper profileServiceApiMapper = new ProfileServiceApiMapper();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		UserCredentialModel userCredentialModel = new UserCredentialModel();
		try {
			IUserCredentialService userCredentialService = UserCredentialServiceFactory.getIUserCredentialService();
			GetUserCredentialByUserIdMsgEntity getUserCredentialByUserIdMsgEntity = profileServiceApiMapper
					.MapGetUserCredentialByUserIdMsgEntity(userid);
			userCredentialModel = userCredentialService.getUserCredentialByUserId(getUserCredentialByUserIdMsgEntity);
			if (userCredentialModel == null) {
				httpStatus = Status.NOT_FOUND;
				userCredentialModel = new UserCredentialModel();
			}
		} catch (Exception ex) {
			httpStatus = Status.INTERNAL_SERVER_ERROR;
			logger.error("ProfileServiceApi::getUserProfileByUserId Exception=" + ex);
		}
		return Response.status(httpStatus).entity(userCredentialModel).build();
	}

	@GET
	@Path("/profile/type=username&value={username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserProfileByUserName(@PathParam("username") String username) {
		IProfileServiceApiMapper profileServiceApiMapper = new ProfileServiceApiMapper();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		UserCredentialModel userCredentialModel = new UserCredentialModel();
		try {
			IUserCredentialService userCredentialService = UserCredentialServiceFactory.getIUserCredentialService();
			GetUserProfileByUserNameMsgEntity getUserProfileByUserNameMsgEntity = profileServiceApiMapper
					.MapGetUserProfileByUserNameMsgEntity(username);
			userCredentialModel = userCredentialService.getUserCredentialByUserName(getUserProfileByUserNameMsgEntity);
			if (userCredentialModel == null) {
				httpStatus = Status.NOT_FOUND;
				userCredentialModel = new UserCredentialModel();
			}
		} catch (Exception ex) {
			httpStatus = Status.INTERNAL_SERVER_ERROR;
			logger.error("ProfileServiceApi::getUserProfileByUserId Exception=" + ex);
		}
		return Response.status(httpStatus).entity(userCredentialModel).build();

	}

	@POST
	@Path("/profile/{userid}/emailaddress")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEmailAddress(CreateEmailAddressRequestModel createEmailAddressRequestModel) {
		IProfileServiceApiMapper profileServiceApiMapper = new ProfileServiceApiMapper();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		Result result = new Result();
		CreateEmailAddressRequestMsgEntity createEmailAddressRequestMsgEntity = null;
		try {
			IEmailAddressService emailAddressService = EmailAddressServiceFactory.getIEmailAddressService();
			createEmailAddressRequestMsgEntity = profileServiceApiMapper
					.MapCreateEmailAddressRequestMsgEntity(createEmailAddressRequestModel);
			Result createEmailAddressResponse = emailAddressService
					.CreateEmailAddress(createEmailAddressRequestMsgEntity);

		} catch (Exception ex) {
			httpStatus = Status.INTERNAL_SERVER_ERROR;
			logger.error("ProfileServiceApi::createEmailAddress Exception=" + ex);
		}
		CreateEmailAddressResponseModel createEmailAddressResponseModel = profileServiceApiMapper
				.mapCreateEmailAddressResponseModel(result, createEmailAddressRequestMsgEntity, httpRequest);
		return Response.status(httpStatus).entity(createEmailAddressResponseModel).build();
	}

	@DELETE
	@Path("/profile/{userid}/emailaddress/{emailaddressid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEmailAddress(@PathParam("userid") String userid,
			@PathParam("emailaddressid") String emailaddressid) {
		IProfileServiceApiMapper profileServiceApiMapper = new ProfileServiceApiMapper();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		Result result = new Result();
		try {
			IEmailAddressService emailAddressService = EmailAddressServiceFactory.getIEmailAddressService();
			DeleteEmailAddressRequestMsgEntity deleteEmailAddressRequestMsgEntity = profileServiceApiMapper
					.MapDeleteEmailAddressRequestMsgEntity(userid, emailaddressid);
			result = emailAddressService.deleteEmailAddress(deleteEmailAddressRequestMsgEntity);
			if (result == null) {
				httpStatus = Status.NOT_FOUND;
				result = new Result();
			}
		} catch (Exception ex) {
			httpStatus = Status.INTERNAL_SERVER_ERROR;
			logger.error("ProfileServiceApi::deleteEmailAddress Exception=" + ex);
		}
		return Response.status(httpStatus).entity(result).build();
	}

	@PUT
	@Path("/profile/{userid}/emailaddress/{emailaddressid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmailAddress(@PathParam("userid") String userid,
			@PathParam("emailaddressid") String emailaddressid,
			UpdateEmailAddressRequestModel updateEmailAddressRequestModel) {
		
		IProfileServiceApiMapper profileServiceApiMapper = new ProfileServiceApiMapper();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		Result result = new Result();
		UpdateEmailAddressRequestMsgEntity updateEmailAddressRequestMsgEntity = null;
		try {
			IEmailAddressService emailAddressService = EmailAddressServiceFactory.getIEmailAddressService();
			updateEmailAddressRequestMsgEntity = profileServiceApiMapper
					.MapUpdateEmailAddressRequestMsgEntity(userid,emailaddressid,updateEmailAddressRequestModel);
			Result createEmailAddressResponse = emailAddressService
					.updateEmailAddress(updateEmailAddressRequestMsgEntity);

		} catch (Exception ex) {
			httpStatus = Status.INTERNAL_SERVER_ERROR;
			logger.error("ProfileServiceApi::createEmailAddress Exception=" + ex);
		}
		UpdateEmailAddressResponseModel updateEmailAddressResponseModel = profileServiceApiMapper
				.mapUpdateEmailAddressResponseModel(result, updateEmailAddressRequestMsgEntity, httpRequest);
		return Response.status(httpStatus).entity(updateEmailAddressResponseModel).build();
	}

	@GET
	@Path("/profile/{userid}/emailaddress/{emailaddressid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmailAddressById(@PathParam("userid") String userid,
			@PathParam("emailaddressid") String emailaddressid) {
		IProfileServiceApiMapper profileServiceApiMapper = new ProfileServiceApiMapper();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		Result result = new Result();
		EmailAddressModel emailAddressModel = null;
		try {
			IEmailAddressService emailAddressService = EmailAddressServiceFactory.getIEmailAddressService();
			GetEmailAddressByEmailAddressIdMsgEntity getEmailAddressByEmailAddressIdMsgEntity = profileServiceApiMapper
					.MapGetEmailAddressByEmailAddressIdMsgEntity(userid,emailaddressid);
			 emailAddressModel = emailAddressService
					.getEmailAddressModelByEmailAddressId(getEmailAddressByEmailAddressIdMsgEntity);

		} catch (Exception ex) {
			httpStatus = Status.INTERNAL_SERVER_ERROR;
			logger.error("ProfileServiceApi::getEmailAddressById Exception=" + ex);
		}
		
		return Response.status(httpStatus).entity(emailAddressModel).build();
	}

	public void ReplaceErrorCode(Result result, String methodName) {
		for (ResultMessage resultMessage : result.getResultMessages()) {
			if (!KatavuccolServiceUtility.isNullOrWhitespace(resultMessage.getErrorCode())) {
				resultMessage
						.setErrorCode(String.format(resultMessage.getErrorCode(), httpRequest.getMethod(), methodName));
			}
		}
	}
}
