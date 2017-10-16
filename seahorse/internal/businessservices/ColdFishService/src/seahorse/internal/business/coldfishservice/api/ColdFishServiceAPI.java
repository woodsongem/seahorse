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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import seahorse.internal.business.coldfishservice.IColdFishService;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeType;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeRequest;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.ResultMessage;
import seahorse.internal.business.coldfishservice.common.datacontracts.ColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.IColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
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
	@Path("/IncomeType")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createIncomeType(IncomeTypeRequest incomeTypeRequest) {

		IncomeTypeResponse loginResponse = getIncomeTypeResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		IColdFishServiceAPIMapper coldFishServiceAPIMapper = new ColdFishServiceAPIMapper();
		try {
			IColdFishService coldFishService = ColdFishServiceFactory.getColdFishService();
			IncomeTypeMessageEntity incomeTypeMessageEntity = coldFishServiceAPIMapper
					.mapIncomeTypeMessageEntity(incomeTypeRequest);
			IncomeTypeResponseMessageEntity incomeTypeResponseMessageEntity = coldFishService
					.createIncomeType(incomeTypeMessageEntity);
			loginResponse = coldFishServiceAPIMapper.mapIncomeTypeResponse(incomeTypeResponseMessageEntity);
			httpStatus = incomeTypeResponseMessageEntity.getHttpStatus();
		} catch (Exception ex) {
			if (loginResponse == null) {
				loginResponse = getIncomeTypeResponse();
			}
			logger.error(ex);
		}
		if (loginResponse == null) {
			loginResponse = getIncomeTypeResponse();
		} else if (loginResponse.getResultStatus() != ResultStatus.SUCCESS.toString()) {
			loginResponse.setresultMessage(coldFishServiceAPIMapper.mapResultMessages(loginResponse.getresultMessage(),
					httpRequest.getMethod()));
		}
		return Response.status(httpStatus).entity(loginResponse).build();
	}

	@GET
	@Path("/IncomeType/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIncomeType(String userid) {
		IColdFishServiceErrorCode coldFishServiceErrorCode = new ColdFishServiceErrorCode();
		List<IncomeType> incomeTypes=null;
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		IColdFishServiceAPIMapper coldFishServiceAPIMapper = new ColdFishServiceAPIMapper();
		try {
			IColdFishService coldFishService = ColdFishServiceFactory.getColdFishService();
			GetIncomeTypeMessageEntity getIncomeTypeMessageEntity = coldFishServiceAPIMapper.mapGetIncomeTypeMessageEntity(userid);
			List<IncomeTypeMessageEntity> incomeTypeMessageEntitys = coldFishService.getIncomeTypeByUserId(getIncomeTypeMessageEntity);
			incomeTypes = coldFishServiceAPIMapper.mapIncomeTypes(incomeTypeMessageEntitys);
			httpStatus = Status.NOT_FOUND;
		} catch (Exception ex) {
			logger.error(ex);
		}
		Response response;
		if (incomeTypes.isEmpty()) {
			response = Response.status(httpStatus).entity(incomeTypes).build();
		} else {
			response = Response.status(httpStatus).entity(getResultMessage(coldFishServiceErrorCode.internalError())).build();
		}

		return response;
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

	private ResultMessage getResultMessage(String errorCode) {
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(errorCode);
		return resultMessage;
	}

}
