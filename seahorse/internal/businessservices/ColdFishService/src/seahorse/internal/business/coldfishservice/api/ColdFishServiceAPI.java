/**
 * 
 */
package seahorse.internal.business.coldfishservice.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import seahorse.internal.business.coldfishservice.IColdFishService;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeDetailRequest;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeDetailsResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeType;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeRequest;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.ResultMessage;
import seahorse.internal.business.coldfishservice.common.datacontracts.ColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.IColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailResponseMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;
import seahorse.internal.business.coldfishservice.factories.ColdFishServiceFactory;

/**
 * @author sajanmje
 *
 */
@Path("/")
public class ColdFishServiceAPI {
	private static final Logger logger = LogManager.getLogger(ColdFishServiceAPI.class);
	@Context
	private HttpServletRequest httpRequest;

	@POST
	@Path("/Income/IncomeType")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createIncomeType(IncomeTypeRequest incomeTypeRequest) {

		IncomeTypeResponse incomeTypeResponse = getIncomeTypeResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		IColdFishServiceAPIMapper coldFishServiceAPIMapper = new ColdFishServiceAPIMapper();
		try {
			IColdFishService coldFishService = ColdFishServiceFactory.getColdFishService();
			IncomeTypeMessageEntity incomeTypeMessageEntity = coldFishServiceAPIMapper.mapIncomeTypeMessageEntity(incomeTypeRequest);
			IncomeTypeResponseMessageEntity incomeTypeResponseMessageEntity = coldFishService.createIncomeType(incomeTypeMessageEntity);
			incomeTypeResponse = coldFishServiceAPIMapper.mapIncomeTypeResponse(incomeTypeResponseMessageEntity);
			httpStatus = incomeTypeResponseMessageEntity.getHttpStatus();
		} catch (Exception ex) {
			if (incomeTypeResponse == null) {
				incomeTypeResponse = getIncomeTypeResponse();
			}
			logger.error(ex);
		}
		if (incomeTypeResponse == null) {
			incomeTypeResponse = getIncomeTypeResponse();
		} else if (incomeTypeResponse.getResultStatus() != ResultStatus.SUCCESS.toString()) {
			incomeTypeResponse.setresultMessage(coldFishServiceAPIMapper.mapResultMessages(incomeTypeResponse.getresultMessage(),
					httpRequest.getMethod()));
		}
		return Response.status(httpStatus).entity(incomeTypeResponse).build();
	}

	@GET
	@Path("/IncomeType")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIncomeTypeByUserId(@QueryParam("userid") String userid) {
		List<IncomeType> incomeTypes=null;
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;		
		IColdFishServiceAPIMapper coldFishServiceAPIMapper = new ColdFishServiceAPIMapper();		
		try {
			IColdFishService coldFishService = ColdFishServiceFactory.getColdFishService();
			GetIncomeTypeMessageEntity getIncomeTypeMessageEntity = coldFishServiceAPIMapper.mapGetIncomeTypeMessageEntity(userid);
			List<IncomeTypeMessageEntity> incomeTypeMessageEntitys = coldFishService.getIncomeTypeByUserId(getIncomeTypeMessageEntity);
			incomeTypes = coldFishServiceAPIMapper.mapIncomeTypes(incomeTypeMessageEntitys);	
			httpStatus=Status.OK;
		} catch (Exception ex) {
			logger.error(ex);
			httpStatus=Status.INTERNAL_SERVER_ERROR;
		}
		Response response;
		if (incomeTypes == null || incomeTypes.isEmpty()) {		
			httpStatus=Status.NOT_FOUND;
			response = Response.status(httpStatus).entity("").build();
		} 
		else {
			response = Response.status(httpStatus).entity(incomeTypes).build();
		}
		return response;
	}	

	@POST
	@Path("/Income")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createIncomeDetails(IncomeDetailRequest incomeDetailRequest)
	{
		IncomeDetailsResponse incomeDetailsResponse = getIncomeDetailsResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		IColdFishServiceAPIMapper coldFishServiceAPIMapper = new ColdFishServiceAPIMapper();
		try {
			IColdFishService coldFishService = ColdFishServiceFactory.getColdFishService();
			IncomeDetailMessageEntity incomeDetailMessageEntity = coldFishServiceAPIMapper.mapIncomeDetailMessageEntity(incomeDetailRequest);
			IncomeDetailResponseMessageEntity incomeDetailResponseMessageEntity = coldFishService.createIncomeDetail(incomeDetailMessageEntity);
			incomeDetailsResponse= coldFishServiceAPIMapper.mapIncomeDetailsResponse(incomeDetailResponseMessageEntity);
			httpStatus = incomeDetailResponseMessageEntity.getHttpStatus();
		} catch (Exception ex) {
			if (incomeDetailsResponse == null) {
				incomeDetailsResponse = getIncomeDetailsResponse();
			}
			logger.error(ex);
		}
		if (incomeDetailsResponse == null) {
			incomeDetailsResponse = getIncomeDetailsResponse();
		} else if (incomeDetailsResponse.getResultStatus() != ResultStatus.SUCCESS.toString()) {
			incomeDetailsResponse.setresultMessage(coldFishServiceAPIMapper.mapResultMessages(incomeDetailsResponse.getresultMessage(),
					httpRequest.getMethod()));
		}
		return Response.status(httpStatus).entity(incomeDetailsResponse).build();
	}

	private IncomeTypeResponse getIncomeTypeResponse() {
		IColdFishServiceErrorCode coldFishServiceErrorCode = new ColdFishServiceErrorCode();
		IncomeTypeResponse incomeTypeResponse = new IncomeTypeResponse();
		incomeTypeResponse.setResultStatus(ResultStatus.ERROR.toString());
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(coldFishServiceErrorCode.internalError());
		incomeTypeResponse.setresultMessage(resultMessage);
		return incomeTypeResponse;
	}
	
	private IncomeDetailsResponse getIncomeDetailsResponse() {
		IColdFishServiceErrorCode coldFishServiceErrorCode = new ColdFishServiceErrorCode();
		IncomeDetailsResponse incomeDetailsResponse = new IncomeDetailsResponse();
		incomeDetailsResponse.setResultStatus(ResultStatus.ERROR.toString());
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(coldFishServiceErrorCode.internalError());
		incomeDetailsResponse.setresultMessage(resultMessage);
		return incomeDetailsResponse;
	}

	private ResultMessage getResultMessage(String errorCode, String httpmethod) {
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(errorCode.replaceAll("_httpmethod", httpmethod));
		return resultMessage;
	}

}
