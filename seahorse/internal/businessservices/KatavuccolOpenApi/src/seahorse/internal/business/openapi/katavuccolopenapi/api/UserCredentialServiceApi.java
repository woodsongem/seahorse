/**
 * 
 */

package seahorse.internal.business.openapi.katavuccolopenapi.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import seahorse.internal.business.openapi.usercredentialapi.api.datacontracts.CreateProfileApiModel;
import seahorse.internal.business.openapi.usercredentialservice.IUserCredentialService;
import seahorse.internal.business.openapi.usercredentialservice.UserCredentialServiceFactory;
import seahorse.internal.business.openapi.usercredentialservice.datacontracts.CreateProfileApiMsgEntity;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;

/**
 * @author SMJE
 *
 */
@Path("/")
public class UserCredentialServiceApi {
	private static final Logger logger = LogManager.getLogger(UserCredentialServiceApi.class);
	@Context
	private HttpServletRequest httpRequest;

	@POST
	@Path("/profile")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUserProfile(CreateProfileApiModel createProfileApiModel) {
		IUserCredentialServiceApiMapper userCredentialServiceApiMapper = new UserCredentialServiceApiMapper();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		CreateProfileApiMsgEntity createProfileApiMsgEntity = null;
		OutPutResponse outPutResponse = new OutPutResponse();
		try {
			createProfileApiMsgEntity = userCredentialServiceApiMapper.MapCreateProfileApiMsgEntity(createProfileApiModel);
			IUserCredentialService userCredentialService = UserCredentialServiceFactory.GetIUserCredentialService();
			outPutResponse = userCredentialService.createUserCredential(createProfileApiMsgEntity);
			
		} catch (Exception ex) {
			httpStatus = Status.INTERNAL_SERVER_ERROR;
			logger.error("UserCredentialServiceApi::createUserProfile Exception=" + ex);
		}
		
		return Response.status(httpStatus).entity(outPutResponse).build();

	}

}
