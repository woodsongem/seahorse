/**
 * 
 */
package seahorse.internal.business.coldfishservice.api;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import seahorse.internal.business.coldfishservice.IColdFishService;
import seahorse.internal.business.coldfishservice.api.datacontracts.DeleteIncomeCategoryResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeCategory;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeCategoryRequest;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeCategoryResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeDetailsResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.ResultMessage;
import seahorse.internal.business.coldfishservice.common.datacontracts.ColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.IColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.datacontracts.DeleteIncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.DeleteIncomeCategoryResponseMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryDetail;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryResponseMessageEntity;
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
	

	// POST ==> /income/category
	@POST
	@Path("/{userid}/income/category")
	@Produces(MediaType.APPLICATION_JSON)	
 	public Response createIncomeCategory(@PathParam("userid") String userid,IncomeCategoryRequest incomeCategoryRequest)
	{
		IncomeCategoryResponse incomeCategoryResponse = getIncomeCategoryResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		IColdFishServiceAPIMapper coldFishServiceAPIMapper = new ColdFishServiceAPIMapper();
		try {
			
			IColdFishService coldFishService = ColdFishServiceFactory.getColdFishService();
			Map<String, String> headers=getHeaders(httpRequest);
			IncomeCategoryMessageEntity incomeDetailMessageEntity = coldFishServiceAPIMapper.mapIncomeCategoryMessageEntity(incomeCategoryRequest,headers);
			IncomeCategoryResponseMessageEntity incomeCategoryResponseMessageEntity = coldFishService.createIncomeCategory(incomeDetailMessageEntity);
			incomeCategoryResponse= coldFishServiceAPIMapper.mapIncomeCategoryResponse(incomeCategoryResponseMessageEntity);
			httpStatus = incomeCategoryResponseMessageEntity.getHttpStatus();
		} catch (Exception ex) {
			if (incomeCategoryResponse == null) {
				incomeCategoryResponse = getIncomeCategoryResponse();
			}
			logger.error(ex);
		}
		if (incomeCategoryResponse == null) {
			incomeCategoryResponse = getIncomeCategoryResponse();
		} else if (!incomeCategoryResponse.getResultMessage().isEmpty()) {
			incomeCategoryResponse.setResultMessage(coldFishServiceAPIMapper.mapResultMessages(incomeCategoryResponse.getResultMessage(),
					httpRequest.getMethod()));
		}
		return Response.status(httpStatus).entity(incomeCategoryResponse).build();
	}

	// @DELETE ==> /income/category
	@DELETE
	@Path("/{userid}/income/category/{incomecategoryid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteIncomeCategoryById(@PathParam("userid") String userid,@PathParam("incomecategoryid") String incomecategoryid)
	{
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		IColdFishServiceAPIMapper coldFishServiceAPIMapper = new ColdFishServiceAPIMapper();
		DeleteIncomeCategoryResponse response=new DeleteIncomeCategoryResponse();
		try {
			IColdFishService coldFishService = ColdFishServiceFactory.getColdFishService();
			Map<String, String> headers=getHeaders(httpRequest);
			DeleteIncomeCategoryMessageEntity deleteIncomeCategoryMessageEntity = coldFishServiceAPIMapper.mapDeleteIncomeCategoryMessageEntity(incomecategoryid,headers);			
			DeleteIncomeCategoryResponseMessageEntity deleteIncomeCategoryResponseMessageEntity = coldFishService.deleteIncomeCategory(deleteIncomeCategoryMessageEntity);
			response= coldFishServiceAPIMapper.mapDeleteIncomeCategoryResponse(deleteIncomeCategoryResponseMessageEntity);
			httpStatus = deleteIncomeCategoryResponseMessageEntity.getHttpStatus();
		}
		catch (Exception ex) {			
			logger.error(ex);
		}		
		if (response != null && !response.getResultMessage().isEmpty()) {					
			response.setResultMessage(coldFishServiceAPIMapper.mapResultMessages(response.getResultMessage(),httpRequest.getMethod()));
		}
		return Response.status(httpStatus).entity(response).build();
	}
	//Get ==> /income/category
	@GET
	@Path("/{userid}/income/category/{incomeyear}/{incomemonth}")
	@Produces(MediaType.APPLICATION_JSON)	
 	public Response getIncomeCategory(@PathParam("userid") String userid,@PathParam("incomeyear") int incomeyear,@PathParam("incomemonth") String incomemonth)
	{
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		IColdFishServiceAPIMapper coldFishServiceAPIMapper = new ColdFishServiceAPIMapper();
		List<IncomeCategory>  incomeCategorys=new ArrayList<>();
		try {
			IColdFishService coldFishService = ColdFishServiceFactory.getColdFishService();
			Map<String, String> headers=getHeaders(httpRequest);
			GetIncomeDetailMessageEntity getIncomeDetailMessageEntity = coldFishServiceAPIMapper.mapGetIncomeCategory(userid,incomeyear,incomemonth,headers);			
			List<IncomeCategoryDetail> incomeCategoryDetail = coldFishService.getIncomeCategoryDetails(getIncomeDetailMessageEntity);
			incomeCategorys= coldFishServiceAPIMapper.mapIncomeCategory(incomeCategoryDetail);			
		}
		catch (Exception ex) {			
			logger.error(ex);
		}		
		
		return Response.status(httpStatus).entity(incomeCategorys).build();
	}	

	public Map<String, String> getHeaders(HttpServletRequest httpRequest)
	{
		Map<String, String> mapheaders=new HashMap<>();
		Enumeration<String> e=httpRequest.getHeaderNames();
		while(e.hasMoreElements())
		{
			  String name =  e.nextElement();
			  String value = httpRequest.getHeader(name);
			  mapheaders.put(name, value);
		}
		return mapheaders;		
	}
	
	/*
	@PUT
	@Path("/income/category")
	@Produces(MediaType.APPLICATION_JSON)	
	public Response updateIncomeCategory(IncomeCategoryRequest incomeCategoryRequest)
	{
		IncomeCategoryResponse incomeCategoryResponse = getIncomeCategoryResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		IColdFishServiceAPIMapper coldFishServiceAPIMapper = new ColdFishServiceAPIMapper();
		try {
			IColdFishService coldFishService = ColdFishServiceFactory.getColdFishService();
			IncomeCategoryMessageEntity incomeDetailMessageEntity = coldFishServiceAPIMapper.mapIncomeCategoryMessageEntity(incomeCategoryRequest);
			IncomeCategoryResponseMessageEntity incomeCategoryResponseMessageEntity = coldFishService.updateIncomeCategory(incomeDetailMessageEntity);
			incomeCategoryResponse= coldFishServiceAPIMapper.mapIncomeCategoryResponse(incomeCategoryResponseMessageEntity);
			httpStatus = incomeCategoryResponseMessageEntity.getHttpStatus();
		} catch (Exception ex) {
			if (incomeCategoryResponse == null) {
				incomeCategoryResponse = getIncomeCategoryResponse();
			}
			logger.error(ex);
		}
		if (incomeCategoryResponse == null) {
			incomeCategoryResponse = getIncomeCategoryResponse();
		} else if (incomeCategoryResponse.getResultStatus() != ResultStatus.SUCCESS.toString()) {
			incomeCategoryResponse.setresultMessage(coldFishServiceAPIMapper.mapResultMessages(incomeCategoryResponse.getResultMessage(),
					httpRequest.getMethod()));
		}
		return Response.status(httpStatus).entity(incomeCategoryResponse).build();
	}
		
	@GET
	@Path("/income/category/{incomecategoryid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIncomeCategoryById(String incomecategoryid)
	{
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		return Response.status(httpStatus).entity(null).build();
	}
	
	@GET
	@Path("/income/category")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIncomeCategoryByUserId(@QueryParam("userid") String userid)
	{
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		return Response.status(httpStatus).entity(null).build();
	}	
	
	@DELETE
	@Path("/income/category/{incomecategoryid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteIncomeCategoryById(String incomecategoryid)
	{
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		return Response.status(httpStatus).entity(null).build();
	}	
	
	
	@POST
	@Path("/income/category/subcategory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createIncomeSubCategory(IncomeSubCategoryRequest incomeSubCategoryRequest)
	{
		IncomeSubCategoryResponse incomeSubCategoryResponse =null;
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;		
		return Response.status(httpStatus).entity(incomeSubCategoryResponse).build();
	}
	
	@PUT
	@Path("/income/category/subcategory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateIncomeSubCategory(UpdateIncomeSubCategoryRequest updateIncomeSubCategoryRequest)
	{
		UpdateIncomeSubCategoryResponse updateIncomeSubCategoryResponse =null;
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;		
		return Response.status(httpStatus).entity(updateIncomeSubCategoryResponse).build();
	}
	
	@DELETE
	@Path("/income/category/subcategory/{incomeSubCategoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteIncomeSubCategory(@QueryParam("incomeSubCategoryId") String incomeSubCategoryId)
	{
		UpdateIncomeSubCategoryResponse updateIncomeSubCategoryResponse =null;
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;		
		return Response.status(httpStatus).entity(updateIncomeSubCategoryResponse).build();
	}
	
	@GET
	@Path("/income/category/subcategory/{incomeSubCategoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIncomeSubCategory(@QueryParam("incomeSubCategoryId") String incomeSubCategoryId)
	{
		UpdateIncomeSubCategoryResponse updateIncomeSubCategoryResponse =null;
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;		
		return Response.status(httpStatus).entity(updateIncomeSubCategoryResponse).build();
	}
	
	
	
	public Response createExpenseCategory(ExpenseCategoryRequest expenseCategoryRequest)
	{
		IncomeCategoryResponse incomeCategoryResponse = getIncomeCategoryResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;		
		return Response.status(httpStatus).entity(incomeCategoryResponse).build();
	}
		
	@PUT
	@Path("/income/category")
	@Produces(MediaType.APPLICATION_JSON)	
	public Response updateExpenseCategory(UpdateExpenseCategoryRequest updateExpenseCategoryRequest)
	{
		IncomeCategoryResponse incomeCategoryResponse = getIncomeCategoryResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;		
		return Response.status(httpStatus).entity(incomeCategoryResponse).build();
	}
		
	@GET
	@Path("/income/category/{incomecategoryid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getExpenseCategoryById(String incomecategoryid)
	{
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		return Response.status(httpStatus).entity(null).build();
	}
	
	@GET
	@Path("/income/category")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getExpenseCategoryByUserId(@QueryParam("userid") String userid)
	{
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		return Response.status(httpStatus).entity(null).build();
	}	
	
	@DELETE
	@Path("/income/category/{incomecategoryid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteExpenseCategoryById(String incomecategoryid)
	{
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		return Response.status(httpStatus).entity(null).build();
	}	
	
	
	@POST
	@Path("/income/category/subcategory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createExpenseSubCategory(ExpenseSubCategoryRequest expenseSubCategoryRequest)
	{
		IncomeSubCategoryResponse incomeSubCategoryResponse =null;
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;		
		return Response.status(httpStatus).entity(incomeSubCategoryResponse).build();
	}
	
	@PUT
	@Path("/income/category/subcategory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateExpenseSubCategory(UpdateExpenseSubCategoryRequest updateExpenseSubCategoryRequest)
	{
		UpdateIncomeSubCategoryResponse updateIncomeSubCategoryResponse =null;
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;		
		return Response.status(httpStatus).entity(updateIncomeSubCategoryResponse).build();
	}
	
	@DELETE
	@Path("/income/category/subcategory/{incomeSubCategoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteExpenseSubCategory(@QueryParam("expenseSubCategoryId") String expenseSubCategoryId)
	{
		UpdateIncomeSubCategoryResponse updateIncomeSubCategoryResponse =null;
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;		
		return Response.status(httpStatus).entity(updateIncomeSubCategoryResponse).build();
	}
	
	@GET
	@Path("/income/category/subcategory/{incomeSubCategoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getExpenseSubCategory(@QueryParam("expenseSubCategoryId") String expenseSubCategoryId)
	{
		UpdateIncomeSubCategoryResponse updateIncomeSubCategoryResponse =null;
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;		
		return Response.status(httpStatus).entity(updateIncomeSubCategoryResponse).build();
	}	
	
	@POST
	@Path("/income/incometype")
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
			incomeTypeResponse.setresultMessage(coldFishServiceAPIMapper.mapResultMessages(incomeTypeResponse.getResultMessage(),
					httpRequest.getMethod()));
		}
		return Response.status(httpStatus).entity(incomeTypeResponse).build();
	}

	@PUT
	@Path("/income/incometype")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateIncomeType(IncomeTypeRequest incomeTypeRequest) {
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		return Response.status(httpStatus).entity(null).build();
	}
	
	@DELETE
	@Path("/income/incometype")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteIncomeType(IncomeTypeRequest incomeTypeRequest) {
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		return Response.status(httpStatus).entity(null).build();
	}
	
	@GET
	@Path("/income/incometype/{incomeTypeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIncomeTypeById(String incomeTypeId) {
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		return Response.status(httpStatus).entity(null).build();
	}
		
	@GET
	@Path("/income/incometype")
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
	@Path("/income/")
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
			incomeDetailsResponse.setresultMessage(coldFishServiceAPIMapper.mapResultMessages(incomeDetailsResponse.getResultMessage(),
					httpRequest.getMethod()));
		}
		return Response.status(httpStatus).entity(incomeDetailsResponse).build();
	}
	
	@GET
	@Path("/income")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIncomeDetailById(@QueryParam("incomeid") String incomeid)
	{
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		return Response.status(httpStatus).entity(null).build();
	}
	
	@GET
	@Path("/income")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIncomeDetailByUserId(@QueryParam("userid") String userid)
	{
		List<IncomeDetail> incomeDetail=null;
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;		
		IColdFishServiceAPIMapper coldFishServiceAPIMapper = new ColdFishServiceAPIMapper();		
		try {
			IColdFishService coldFishService = ColdFishServiceFactory.getColdFishService();
			GetIncomeDetailMessageEntity getincomeDetailMessageEntity = coldFishServiceAPIMapper.mapGetincomeDetailMessageEntity(userid);
			List<IncomeDetailMessageEntity> incomeDetailMessageEntity = coldFishService.getIncomeDetailByUserId(getincomeDetailMessageEntity);
			incomeDetail = coldFishServiceAPIMapper.mapIncomeDetail(incomeDetailMessageEntity);	
			httpStatus=Status.OK;
		} catch (Exception ex) {
			logger.error(ex);
			httpStatus=Status.INTERNAL_SERVER_ERROR;
		}
		Response response;
		if (incomeDetail == null || incomeDetail.isEmpty()) {		
			httpStatus=Status.NOT_FOUND;
			response = Response.status(httpStatus).entity("").build();
		} 
		else {
			response = Response.status(httpStatus).entity(incomeDetail).build();
		}
		return response;
	}
*/
	
	private IncomeTypeResponse getIncomeTypeResponse() {
		IColdFishServiceErrorCode coldFishServiceErrorCode = new ColdFishServiceErrorCode();
		IncomeTypeResponse incomeTypeResponse = new IncomeTypeResponse();
	//	incomeTypeResponse.setResultStatus(ResultStatus.ERROR.toString());
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(coldFishServiceErrorCode.internalError());
		incomeTypeResponse.setResultMessages(resultMessage);
		return incomeTypeResponse;
	}
	
	private IncomeDetailsResponse getIncomeDetailsResponse() {
		IColdFishServiceErrorCode coldFishServiceErrorCode = new ColdFishServiceErrorCode();
		IncomeDetailsResponse incomeDetailsResponse = new IncomeDetailsResponse();
	//	incomeDetailsResponse.setResultStatus(ResultStatus.ERROR.toString());
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(coldFishServiceErrorCode.internalError());
		incomeDetailsResponse.setResultMessages(resultMessage);
		return incomeDetailsResponse;
	}

	private ResultMessage getResultMessage(String errorCode, String httpmethod) {
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(errorCode.replaceAll("_httpmethod", httpmethod));
		return resultMessage;
	}

	private IncomeCategoryResponse getIncomeCategoryResponse() {
		IColdFishServiceErrorCode coldFishServiceErrorCode = new ColdFishServiceErrorCode();
		IncomeCategoryResponse incomeCategoryResponse = new IncomeCategoryResponse();
		//incomeCategoryResponse.setResultStatus(ResultStatus.ERROR.toString());
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(coldFishServiceErrorCode.internalError());
		incomeCategoryResponse.setResultMessages(resultMessage);
		return incomeCategoryResponse;
	}
}
