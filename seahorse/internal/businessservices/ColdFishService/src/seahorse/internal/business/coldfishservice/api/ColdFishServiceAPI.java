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
			IncomeTypeMessageEntity incomeTypeMessageEntity = coldFishServiceAPIMapper.mapIncomeTypeMessageEntity(incomeTypeRequest);
			IncomeTypeResponseMessageEntity incomeTypeResponseMessageEntity = coldFishService.createIncomeType(incomeTypeMessageEntity);
			loginResponse = coldFishServiceAPIMapper.mapIncomeTypeResponse(incomeTypeResponseMessageEntity);
			httpStatus=incomeTypeResponseMessageEntity.getHttpStatus();
		} catch (Exception ex) {
			if (loginResponse == null) {
				loginResponse =getIncomeTypeResponse();
			}
			logger.error(ex);
		}
		
		loginResponse.setresultMessage(coldFishServiceAPIMapper.mapResultMessages(loginResponse.getresultMessage(),httpRequest.getMethod()));
		return Response.status(httpStatus).entity(loginResponse).build();
	}
	
	private IncomeTypeResponse getIncomeTypeResponse()
	{
		IColdFishServiceErrorCode coldFishServiceErrorCode=new ColdFishServiceErrorCode();
		IncomeTypeResponse incomeTypeResponse = new IncomeTypeResponse();		
		incomeTypeResponse.setResultStatus(ResultStatus.ERROR.toString());
		ResultMessage resultMessage=new ResultMessage();
		resultMessage.setErrorCode(coldFishServiceErrorCode.internalError());		
		incomeTypeResponse.setresultMessage(resultMessage);
		return incomeTypeResponse;
	}

}
