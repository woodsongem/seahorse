/**
 * 
 */
package seahorse.internal.business.coldfishservice.api;

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

import seahorse.internal.business.coldfishservice.IColdFishService;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeRequest;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.ResultMessage;
import seahorse.internal.business.coldfishservice.common.datacontracts.ColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.IColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;
import seahorse.internal.business.coldfishservice.factories.ColdFishServiceFactory;




/**
 * @author sajanmje
 *
 */
@Path("/ColdFishService")
public class ColdFishServiceAPI {
	private static final Logger logger = LogManager.getLogger(ColdFishServiceAPI.class);
	@Context
	private HttpServletRequest httpRequest;
	
	@POST
	@Path("/IncomeType")
	@Produces(MediaType.APPLICATION_JSON)
	public Response CreateIncomeType(IncomeTypeRequest incomeTypeRequest) {
	
		IncomeTypeResponse loginResponse = GetIncomeTypeResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			IColdFishService coldFishService = ColdFishServiceFactory.GetColdFishService();
			IColdFishServiceAPIMapper coldFishServiceAPIMapper = new ColdFishServiceAPIMapper();
			IncomeTypeMessageEntity incomeTypeMessageEntity = coldFishServiceAPIMapper.MapIncomeTypeMessageEntity(incomeTypeRequest);
			IncomeTypeResponseMessageEntity incomeTypeResponseMessageEntity = coldFishService.CreateIncomeType(incomeTypeMessageEntity);
			loginResponse = coldFishServiceAPIMapper.MapIncomeTypeResponse(incomeTypeResponseMessageEntity);
			httpStatus=incomeTypeResponseMessageEntity.GetHttpStatus();
		} catch (Exception ex) {
			if (loginResponse == null) {
				loginResponse =GetIncomeTypeResponse();
			}
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(loginResponse).build();
	}
	private IncomeTypeResponse GetIncomeTypeResponse()
	{
		IColdFishServiceErrorCode coldFishServiceErrorCode=new ColdFishServiceErrorCode();
		IncomeTypeResponse incomeTypeResponse = new IncomeTypeResponse();		
		incomeTypeResponse.setResultStatus(ResultStatus.Error.toString());
		ResultMessage resultMessage=new ResultMessage();
		resultMessage.setErrorCode(coldFishServiceErrorCode.InternalError());		
		incomeTypeResponse.setresultMessage(resultMessage);
		return incomeTypeResponse;
	}

}
