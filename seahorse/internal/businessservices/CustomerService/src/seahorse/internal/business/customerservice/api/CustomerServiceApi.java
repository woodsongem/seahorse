/**
 * 
 */
package seahorse.internal.business.customerservice.api;

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

import seahorse.internal.business.customerservice.IUserCredentialService;
import seahorse.internal.business.customerservice.Factories.CustomerServiceFactory;
import seahorse.internal.business.customerservice.api.datacontracts.LoginRequest;
import seahorse.internal.business.customerservice.api.datacontracts.LoginResponse;
import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.LoginResponseMessageEntity;

/**
 * @author sajanmje
 *
 */

@Path("/customer")
public class CustomerServiceApi {
	private static final Logger logger = LogManager.getLogger(CustomerServiceApi.class);
	@Context
	private HttpServletRequest httpRequest;

	@POST
	@Path("/{login}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response Login(LoginRequest loginRequest) {
		LoginResponse loginResponse = new LoginResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			IUserCredentialService userCredentialService = CustomerServiceFactory.GetUserCredentialService();
			ICustomerServiceApiServiceMapper customerServiceApiServiceMapper = new CustomerServiceApiServiceMapper();
			LoginDetailMessageEntity loginDetailMessageEntity = customerServiceApiServiceMapper.MapLoginDetailMessageEntity(loginRequest);
			LoginResponseMessageEntity loginResponseMessageEntity = userCredentialService.Login(loginDetailMessageEntity);
			loginResponse = customerServiceApiServiceMapper.MapLoginResponse(loginResponseMessageEntity);
		} catch (Exception ex) {
			if (loginResponse == null) {
				loginResponse = new LoginResponse();
			}
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(loginResponse).build();
	}

}
