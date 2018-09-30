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

import seahorse.internal.business.profileservice.api.datacontracts.CreateProfileRequestModel;
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
import seahorse.internal.business.usercredentialservice.datacontracts.GetUserCredentialByUserIdMsgEntity;

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
		try {
			IUserCredentialService userCredentialService = UserCredentialServiceFactory.getIUserCredentialService();
			CreateUserCredentialMsgEntity createUserProfileMsgEntity = profileServiceApiMapper
					.MapCreateUserCredentialMsgEntity(createProfileRequestModel);
			result = userCredentialService.createUserCredential(createUserProfileMsgEntity);
			if (result == null) {
				result = new OutPutResponse();
			} else {
				if (result.getResultStatus() == ResultStatus.ERROR) {
					ReplaceErrorCode(result,ProfileServiceConstants.CreateUserProfileMethodName);
				}
				httpStatus = createUserProfileMsgEntity.getHttpStatus();
			}
		} catch (Exception ex) {
			String error=ex.toString();
		}
		return Response.status(httpStatus).entity(result).build();
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
		return null;

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
			}
		} catch (Exception ex) {
			httpStatus = Status.INTERNAL_SERVER_ERROR;
		}
		return Response.status(httpStatus).entity(userCredentialModel).build();
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
