package seahorse.internal.business.categoryservice.api;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import seahorse.internal.business.categoryservice.CategoryServiceMapper;
import seahorse.internal.business.categoryservice.ICategoryService;
import seahorse.internal.business.categoryservice.ICategoryServiceMapper;
import seahorse.internal.business.categoryservice.api.datacontracts.*;
import seahorse.internal.business.categoryservice.datacontracts.*;
import seahorse.internal.business.credentialtypeservice.ICredentialTypeService;
import seahorse.internal.business.credentialtypeservice.datacontracts.*;
import seahorse.internal.business.katavuccolservice.IKatavuccolService;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultMessage;
import seahorse.internal.business.katavuccolservice.registries.KatavuccolServiceFactory;

@Path("/CategoryService")
public class CategoryServiceApi {
	private static final Logger logger = LogManager.getLogger(CategoryServiceApi.class);
	
	@Context
	private HttpServletRequest httpRequest;
	
	@POST
	@Path("/{userid}/category")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCategory(@PathParam("userid") String userid,CreateCategoryRequestModel createCategoryRequestModel) {
		ICategoryServiceApiMapper credentialCategoryServiceApiMapper=new CategoryServiceApiMapper();
		CreateCategoryResponseModel createCategoryResponseModel=new CreateCategoryResponseModel();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			CreateCategoryMessageEntity createCategoryMessageEntity=credentialCategoryServiceApiMapper.mapCategoryRequestMessageEntity(createCategoryRequestModel,userid,httpRequest);
			ICategoryService categoryService = KatavuccolServiceFactory.getICategoryService();
			Map<String, String> headers=getHeaders(httpRequest);
			createCategoryMessageEntity.setHttpMethod(httpRequest.getMethod());
			createCategoryMessageEntity.setHeaders(headers);
			CreateCategoryResponseMessageEntity createCategoryResponseMessageEntity=categoryService.createCategory(createCategoryMessageEntity);
			createCategoryResponseModel=credentialCategoryServiceApiMapper.mapCategoryResponse(createCategoryResponseMessageEntity,createCategoryMessageEntity);
			httpStatus = createCategoryResponseMessageEntity.getHttpStatus();
		}
		catch (Exception ex) {
			if (createCategoryResponseModel == null) {
				createCategoryResponseModel = getCategoryResponse();
			}
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(createCategoryResponseModel).build();
	}
	
	@DELETE
	@Path("/{userid}/category/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCategory(@PathParam("userid") String userid,@PathParam("id") String categoryId) 
	{
		ICategoryServiceApiMapper credentialCategoryServiceApiMapper=new CategoryServiceApiMapper();
		DeleteCategoryResponseModel deleteCategoryResponse=new DeleteCategoryResponseModel();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity=credentialCategoryServiceApiMapper.mapDeleteCategoryRequestMessageEntity(userid,categoryId,httpRequest);
			ICategoryService categoryService = KatavuccolServiceFactory.getICategoryService();
			Map<String, String> headers=getHeaders(httpRequest);
			deleteCategoryRequestMessageEntity.setHttpMethod(httpRequest.getMethod());
			deleteCategoryRequestMessageEntity.setHeaders(headers);
			DeleteCategoryResponseMessageEntity	deleteCategoryResponseMessageEntity=categoryService.deleteCategory(deleteCategoryRequestMessageEntity);
			deleteCategoryResponse=credentialCategoryServiceApiMapper.mapDeleteCategoryResponse(deleteCategoryResponseMessageEntity,deleteCategoryRequestMessageEntity);
			httpStatus = deleteCategoryResponseMessageEntity.getHttpStatus();
		}
		catch (Exception ex) {
			if (deleteCategoryResponse == null) {
				deleteCategoryResponse = getDeleteCategoryResponse();
			}
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(deleteCategoryResponse).build();
	}
	
	@PUT
	@Path("/{userid}/category/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCategory(@PathParam("userid") String userid,@PathParam("id") String categoryId,UpdateCategoryRequestModel updateCategoryRequest) 
	{
		ICategoryServiceMapper categoryServiceMapper=new CategoryServiceMapper();
		UpdateCategoryResponseModel updateCategoryResponse=new UpdateCategoryResponseModel();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			UpdateCategoryMessageEntity updateCategoryMessageEntity=categoryServiceMapper.mapUpdateCategoryRequestMessageEntity(updateCategoryRequest,userid,categoryId,httpRequest);
			ICategoryService categoryService = KatavuccolServiceFactory.getICategoryService();
			Map<String, String> headers=getHeaders(httpRequest);
			updateCategoryMessageEntity.setHttpMethod(httpRequest.getMethod());			
			updateCategoryMessageEntity.setHeaders(headers);
			UpdateCategoryResponseMessageEntity updateCategoryResponseMessageEntity=categoryService.updateCategory(updateCategoryMessageEntity);
			updateCategoryResponse=categoryServiceMapper.mapUpdateCategoryResponse(updateCategoryResponseMessageEntity,updateCategoryMessageEntity);
			httpStatus = updateCategoryResponseMessageEntity.getHttpStatus();
		}
		catch (Exception ex) {
			if (updateCategoryResponse == null) {
				updateCategoryResponse = getUpdateCategoryResponse();
			}
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(updateCategoryResponse).build();
	}
	
	//GET ==> /income/category
	@GET
	@Path("/{userid}/category")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategoryByUserId(@PathParam("userid") String userid){
		ICategoryServiceMapper categoryServiceMapper=new CategoryServiceMapper();
		List<CategoryModel> categorys=new ArrayList<>();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			GetCategoryMessageEntity getCategoryMessageEntity=categoryServiceMapper.mapGetCategoryMessageEntity(userid,httpRequest);
			ICategoryService categoryService = KatavuccolServiceFactory.getICategoryService();
			categorys=categoryService.getCategory(getCategoryMessageEntity);
		}
		catch (Exception ex) {				
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(categorys).build();
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
	
	private CreateCategoryResponseModel getCategoryResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		CreateCategoryResponseModel categoryResponse = new CreateCategoryResponseModel();		
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		categoryResponse.setResultMessages(resultMessage);
		return categoryResponse;
	}
	private DeleteCategoryResponseModel getDeleteCategoryResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		DeleteCategoryResponseModel deleteCategoryResponse = new DeleteCategoryResponseModel();		
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		deleteCategoryResponse.setResultMessages(resultMessage);
		return deleteCategoryResponse;
	}
	
	private UpdateCategoryResponseModel getUpdateCategoryResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		UpdateCategoryResponseModel updateCategoryResponse = new UpdateCategoryResponseModel();		
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		updateCategoryResponse.setResultMessages(resultMessage);
		return updateCategoryResponse;
	}
}
