/**
 * 
 */

package seahorse.internal.business.katavuccolopenapi.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author SMJE
 *
 */
@Path("/")
public class UserCredentialApi {
	private static final Logger logger = LogManager.getLogger(UserCredentialApi.class);
	@Context
	private HttpServletRequest httpRequest;

	@POST
	@Path("/profile")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUserProfile(CreateProfileRequestModel createProfileRequestModel) {

	}

}
