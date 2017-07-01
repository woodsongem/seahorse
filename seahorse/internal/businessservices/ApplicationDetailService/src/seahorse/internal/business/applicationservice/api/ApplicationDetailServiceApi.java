/**
 * 
 */
package seahorse.internal.business.applicationservice.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import seahorse.internal.business.applicationservice.IApplicationDetailService;
import seahorse.internal.business.applicationservice.Factories.ApplicationServiceFactory;
import seahorse.internal.business.applicationservice.api.datacontracts.ApplicationDetail;
import seahorse.internal.business.applicationservice.datacontracts.ApplicationDetailMessageEntity;

/**
 * @author admin
 *
 */

@Path("/application")
public class ApplicationDetailServiceApi {

	private static final Logger logger = LogManager.getLogger(ApplicationDetailServiceApi.class);
	@Context
	private HttpServletRequest httpRequest;

	/*
	 * @GET
	 * 
	 * @Path("/{name}") public Response sayHello(@PathParam("name") String msg)
	 * {
	 * 
	 * String output = "Hello, " + msg + "!"; return
	 * Response.status(200).entity(output).build(); }
	 */

	@GET
	@Path("/{applicationId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetApplicationByApplicationId(@PathParam("applicationId") String applicationId) {
		ApplicationDetail _applicationDetails = new ApplicationDetail();		
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			IApplicationDetailApiServiceMapper _applicationDetailServiceMapper = get_applicationDetailServiceMapper();
			IApplicationDetailService _applicationDetailService = ApplicationServiceFactory.GetApplicationDetailService();
			ApplicationDetailMessageEntity _applicationDetailMessageEntity = _applicationDetailService.GetApplicationByApplicationId(applicationId);
			if (_applicationDetailMessageEntity == null) {
				httpStatus = Status.OK;
			} else {
				_applicationDetails = _applicationDetailServiceMapper.MapApplicationDetail(_applicationDetailMessageEntity);
				httpStatus = _applicationDetailMessageEntity.GetHttpStatus();
			}
		} catch (Exception ex) {
			if (_applicationDetails == null) {
				_applicationDetails = new ApplicationDetail();
			}
			logger.error(ex);
		}

		return Response.status(httpStatus).entity(_applicationDetails).build();
	}

	/*
	 * @POST
	 * 
	 * @Path("/{applicationId}")
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON) public Response
	 * CreateApplication(@PathParam("applicationId") String
	 * applicationId,@FormParam("applicationDetail") ApplicationDetail
	 * applicationDetail) { IApplicationDetailApiServiceMapper
	 * _applicationDetailApiServiceMapper =
	 * get_applicationDetailServiceMapper(); IApplicationDetailService
	 * _applicationDetailService = get_applicationDetailService();
	 * ApplicationDetailMessageEntity
	 * _applicationDetailMessageEntity=_applicationDetailApiServiceMapper.
	 * MapApplicationDetailMessageEntity(applicationDetail);
	 * ApplicationDetailResponseMessageEntity
	 * _applicationDetailResponseMessageEntity=
	 * _applicationDetailService.CreateApplication(
	 * _applicationDetailMessageEntity); ApplicationDetailResponse
	 * _applicationDetailResponse=
	 * _applicationDetailApiServiceMapper.MapApplicationDetailResponse(
	 * _applicationDetailResponseMessageEntity); return
	 * Response.status(200).entity(_applicationDetailResponse).build(); }
	 * 
	 * @PUT
	 * 
	 * @Path("/{applicationId}")
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON) public Response
	 * UpdateApplication(@PathParam("applicationId") String
	 * applicationId,@FormParam("applicationDetail") ApplicationDetail
	 * applicationDetail) { IApplicationDetailApiServiceMapper
	 * _applicationDetailApiServiceMapper =
	 * get_applicationDetailServiceMapper(); IApplicationDetailService
	 * _applicationDetailService = get_applicationDetailService();
	 * ApplicationDetailMessageEntity
	 * _applicationDetailMessageEntity=_applicationDetailApiServiceMapper.
	 * MapApplicationDetailMessageEntity(applicationDetail);
	 * ApplicationDetailResponseMessageEntity
	 * _applicationDetailResponseMessageEntity=
	 * _applicationDetailService.UpdateApplication(
	 * _applicationDetailMessageEntity); ApplicationDetailResponse
	 * _applicationDetailResponse=
	 * _applicationDetailApiServiceMapper.MapApplicationDetailResponse(
	 * _applicationDetailResponseMessageEntity); return
	 * Response.status(200).entity(_applicationDetailResponse).build(); }
	 */

	public IApplicationDetailApiServiceMapper get_applicationDetailServiceMapper() {
		return new ApplicationDetailApiServiceMapper();
	}
}