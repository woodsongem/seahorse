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

import seahorse.internal.business.katavuccolservice.common.datacontracts.OutPutResponse;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.registries.KatavuccolServiceFactory;
import seahorse.internal.business.profileservice.IProfileService;
import seahorse.internal.business.profileservice.api.datacontracts.CreateProfileRequestModel;
import seahorse.internal.business.profileservice.api.datacontracts.UpdateProfileRequestModel;
import seahorse.internal.business.profileservice.api.datacontracts.UserProfileModel;
import seahorse.internal.business.profileservice.datacontracts.CreateUserProfileMsgEntity;

/**
 * @author SMJE
 *
 */
@Path("/profileservice")
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
			IProfileService profileService = KatavuccolServiceFactory.getIProfileService();
			CreateUserProfileMsgEntity createUserProfileMsgEntity=profileServiceApiMapper.MapCreateUserProfileMsgEntity(createProfileRequestModel);
			result=profileService.createUserProfile(createUserProfileMsgEntity);
			if(result==null)
			{
				result=new OutPutResponse();
			}
			else
			{
				httpStatus=result.getHttpStatus();
			}
		} catch (Exception ex) {

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
		UserProfileModel userProfileModel = new UserProfileModel();
		try {
			IProfileService profileService = KatavuccolServiceFactory.getIProfileService();
			userProfileModel=profileService.getUserProfileByUserId(userid);
		} catch (Exception ex) {

		}
		return null;
	}
}
