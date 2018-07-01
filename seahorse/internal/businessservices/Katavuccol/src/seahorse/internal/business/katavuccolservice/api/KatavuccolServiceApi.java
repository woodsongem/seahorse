/**
 * 
 */
package seahorse.internal.business.katavuccolservice.api;

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

import seahorse.internal.business.credentialservice.ICredentialService;
import seahorse.internal.business.credentialtypeservice.ICredentialTypeService;
import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeResMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByUserIdMsgEntity;
import seahorse.internal.business.katavuccolservice.IKatavuccolService;
import seahorse.internal.business.katavuccolservice.api.datacontracts.*;
import seahorse.internal.business.katavuccolservice.datacontracts.*;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.datacontracts.OutPutResponse;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultMessage;
import seahorse.internal.business.katavuccolservice.registries.KatavuccolServiceFactory;

/**
 * @author sajanmje
 * KatavuccolServiceErrorCode
 */

@Path("/")
public class KatavuccolServiceApi {

	private static final Logger logger = LogManager.getLogger(KatavuccolServiceApi.class);
	@Context
	private HttpServletRequest httpRequest;
	
	@POST
	@Path("/{userid}/category")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCategory(@PathParam("userid") String userid,CategoryRequest categoryRequest) {
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		CategoryResponse categoryResponse=new CategoryResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			CategoryRequestMessageEntity categoryMessageEntity=katavuccolServiceApiMapper.mapCategoryRequestMessageEntity(categoryRequest,userid,httpRequest);
			IKatavuccolService katavuccolService = KatavuccolServiceFactory.getKatavuccolService();
			Map<String, String> headers=getHeaders(httpRequest);
			categoryMessageEntity.setHttpMethod(httpRequest.getMethod());
			categoryMessageEntity.setHeaders(headers);
			CategoryResponseMessageEntity categoryResponseMessageEntity=katavuccolService.createCategory(categoryMessageEntity);
			categoryResponse=katavuccolServiceApiMapper.mapCategoryResponse(categoryResponseMessageEntity,categoryMessageEntity);
			httpStatus = categoryResponseMessageEntity.getHttpStatus();
		}
		catch (Exception ex) {
			if (categoryResponse == null) {
				categoryResponse = getCategoryResponse();
			}
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(categoryResponse).build();
	}
	
	@DELETE
	@Path("/{userid}/category/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCategory(@PathParam("userid") String userid,@PathParam("id") String categoryId) 
	{
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		DeleteCategoryResponse deleteCategoryResponse=new DeleteCategoryResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity=katavuccolServiceApiMapper.mapDeleteCategoryRequestMessageEntity(userid,categoryId,httpRequest);
			IKatavuccolService katavuccolService = KatavuccolServiceFactory.getKatavuccolService();
			Map<String, String> headers=getHeaders(httpRequest);
			deleteCategoryRequestMessageEntity.setHttpMethod(httpRequest.getMethod());
			deleteCategoryRequestMessageEntity.setHeaders(headers);
			DeleteCategoryResponseMessageEntity	deleteCategoryResponseMessageEntity=katavuccolService.deleteCategory(deleteCategoryRequestMessageEntity);
			deleteCategoryResponse=katavuccolServiceApiMapper.mapDeleteCategoryResponse(deleteCategoryResponseMessageEntity,deleteCategoryRequestMessageEntity);
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
	public Response updateCategory(@PathParam("userid") String userid,@PathParam("id") String categoryId,UpdateCategoryRequest updateCategoryRequest) 
	{
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		UpdateCategoryResponse updateCategoryResponse=new UpdateCategoryResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			UpdateCategoryMessageEntity updateCategoryMessageEntity=katavuccolServiceApiMapper.mapUpdateCategoryRequestMessageEntity(updateCategoryRequest,userid,categoryId,httpRequest);
			IKatavuccolService katavuccolService = KatavuccolServiceFactory.getKatavuccolService();
			Map<String, String> headers=getHeaders(httpRequest);
			updateCategoryMessageEntity.setHttpMethod(httpRequest.getMethod());			
			updateCategoryMessageEntity.setHeaders(headers);
			UpdateCategoryResponseMessageEntity updateCategoryResponseMessageEntity=katavuccolService.updateCategory(updateCategoryMessageEntity);
			updateCategoryResponse=katavuccolServiceApiMapper.mapUpdateCategoryResponse(updateCategoryResponseMessageEntity,updateCategoryMessageEntity);
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
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		List<Category> categorys=new ArrayList<>();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			GetCategoryMessageEntity getCategoryMessageEntity=katavuccolServiceApiMapper.mapGetCategoryMessageEntity(userid,httpRequest);
			IKatavuccolService katavuccolService = KatavuccolServiceFactory.getKatavuccolService();
			categorys=katavuccolService.getCategory(getCategoryMessageEntity);
		}
		catch (Exception ex) {				
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(categorys).build();
	}
	
	@POST
	@Path("/credentialtype/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCredentialType(@PathParam("userid") String userid,CredentialTypeRequest credentialTypeRequest) {
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		CreateCredentialTypeResponse createCredentialTypeResponse=new CreateCredentialTypeResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity=katavuccolServiceApiMapper.mapCreateCredentialTypeMsgEntity(credentialTypeRequest,userid,httpRequest);
			ICredentialTypeService credentialTypeService = KatavuccolServiceFactory.getICredentialTypeService();
			Map<String, String> headers=getHeaders(httpRequest);
			createCredentialTypeMsgEntity.setHttpMethod(httpRequest.getMethod());
			createCredentialTypeMsgEntity.setHeaders(headers);
			CreateCredentialTypeResMsgEntity createCredentialTypeResMsgEntity=credentialTypeService.Create(createCredentialTypeMsgEntity);
			createCredentialTypeResponse=katavuccolServiceApiMapper.mapCredentialTypeResponse(createCredentialTypeResMsgEntity,createCredentialTypeMsgEntity);
			httpStatus = createCredentialTypeResMsgEntity.getHttpStatus();
		}
		catch (Exception ex) {
			if (createCredentialTypeResponse == null) {
				createCredentialTypeResponse = getCredentialTypeResponse();
			}
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(createCredentialTypeResponse).build();
	}	
	
	@PUT
	@Path("/{userid}/credentialtype/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCredentialType(@PathParam("userid") String userid,@PathParam("id") String credentialId,UpdateCredentialTypeRequest updateCredentialTypeRequest) 
	{
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		UpdateCredentialTypeResponse updateCredentialTypeResponse=new UpdateCredentialTypeResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			UpdateCredentialTypeMessageEntity updateCredentialTypeMessageEntity=katavuccolServiceApiMapper.mapUpdateCredentialRequestMessageEntity(updateCredentialTypeRequest,userid,credentialId,httpRequest);
			IKatavuccolService katavuccolService = KatavuccolServiceFactory.getKatavuccolService();
			Map<String, String> headers=getHeaders(httpRequest);
			updateCredentialTypeMessageEntity.setHttpMethod(httpRequest.getMethod());			
			updateCredentialTypeMessageEntity.setHeaders(headers);
			UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity=katavuccolService.updateCredentialType(updateCredentialTypeMessageEntity);
			updateCredentialTypeResponse=katavuccolServiceApiMapper.mapUpdateCredentialTypeResponse(updateCredentialResponseMessageEntity,updateCredentialTypeMessageEntity);
			httpStatus = updateCredentialResponseMessageEntity.getHttpStatus();
		}
		catch (Exception ex) {
			if (updateCredentialTypeResponse == null) {
				updateCredentialTypeResponse = getUpdateTypeCredentialResponse();
			}
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(updateCredentialTypeResponse).build();
	}

	@DELETE
	@Path("/{userid}/credentialtype/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCredentialType(@PathParam("userid") String userid,@PathParam("id") String credentialTypeId) 
	{
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		DeleteCredentialTypeResponse deleteCredentialTypeResponse=new DeleteCredentialTypeResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			DeleteCredentialTypeRequestMessageEntity deleteCredentialTypeRequestMessageEntity=katavuccolServiceApiMapper.mapDeleteCredentialTypeRequestMessageEntity(userid,credentialTypeId,httpRequest);
			IKatavuccolService katavuccolService = KatavuccolServiceFactory.getKatavuccolService();
			Map<String, String> headers=getHeaders(httpRequest);
			deleteCredentialTypeRequestMessageEntity.setHttpMethod(httpRequest.getMethod());
			deleteCredentialTypeRequestMessageEntity.setHeaders(headers);
			DeleteCredentialResponseMessageEntity	deleteCredentialResponseMessageEntity=katavuccolService.deleteCredentialType(deleteCredentialTypeRequestMessageEntity);
			deleteCredentialTypeResponse=katavuccolServiceApiMapper.mapDeleteCredentialTypeResponse(deleteCredentialResponseMessageEntity,deleteCredentialTypeRequestMessageEntity);
			httpStatus = deleteCredentialResponseMessageEntity.getHttpStatus();
		}
		catch (Exception ex) {
			if (deleteCredentialTypeResponse == null) {
				deleteCredentialTypeResponse = getDeleteCredentialTypeResponse();
			}
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(deleteCredentialTypeResponse).build();
	}
	

	@GET
	@Path("/credentialtype/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCredentialTypeByUserId(@PathParam("userid") String userid)
	{
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		List<CredentialTypeModel> credentialTypeModel=new ArrayList<>();
		try {
			ICredentialTypeService credentialTypeService = KatavuccolServiceFactory.getICredentialTypeService();
			CredentialTypeByUserIdMsgEntity credentialTypeByUserIdMsgEntity=katavuccolServiceApiMapper.mapCredentialTypeByUserIdMsgEntity(userid);
			credentialTypeModel= credentialTypeService.getCredentialTypeByUserId(credentialTypeByUserIdMsgEntity);
			httpStatus= Status.OK;
			if(credentialTypeModel==null)
			{
				httpStatus=Status.BAD_REQUEST;
			}
			
		}
		catch (Exception ex) {			
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(credentialTypeModel).build();
	}
	
	// POST ==> /income/category
	@POST
	@Path("/{userid}/{categoryid}/credential/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCredential(@PathParam("userid") String userid,@PathParam("categoryid") String categoryid,CredentialRequest credentialsRequest) {
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		CredentialResponse credentialsResponse=new CredentialResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			CredentialRequestMessageEntity credentialMessageEntity=katavuccolServiceApiMapper.mapCredentialRequestMessageEntity(credentialsRequest,userid,categoryid,httpRequest);
			IKatavuccolService katavuccolService = KatavuccolServiceFactory.getKatavuccolService();
			Map<String, String> headers=getHeaders(httpRequest);
			credentialMessageEntity.setHttpMethod(httpRequest.getMethod());
			credentialMessageEntity.setHeaders(headers);
			CredentialResponseMessageEntity credentialsResMessageEntity=katavuccolService.createCredential(credentialMessageEntity);
			credentialsResponse=katavuccolServiceApiMapper.mapCredentialsResponse(credentialsResMessageEntity,credentialMessageEntity);
			httpStatus = credentialsResMessageEntity.getHttpStatus();
		}
		catch (Exception ex) {
			if (credentialsResponse == null) {
				credentialsResponse = getCredentialsResponse();
			}
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(credentialsResponse).build();
	}
	
	// @PUT ==> /income/category
	@PUT
	@Path("/{userid}/{categoryid}/credential/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCredential(@PathParam("userid") String userid,@PathParam("categoryid") String categoryid,@PathParam("id") String credentialId,UpdateCredentialRequest updateCredentialRequest) 
	{
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		UpdateCredentialResponse updateCredentialResponse=new UpdateCredentialResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			UpdateCredentialMessageEntity updateCredentialMessageEntity=katavuccolServiceApiMapper.mapUpdateCredentialRequestMessageEntity(updateCredentialRequest,userid,categoryid,credentialId,httpRequest);
			IKatavuccolService katavuccolService = KatavuccolServiceFactory.getKatavuccolService();
			Map<String, String> headers=getHeaders(httpRequest);
			updateCredentialMessageEntity.setHttpMethod(httpRequest.getMethod());			
			updateCredentialMessageEntity.setHeaders(headers);
			UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity=katavuccolService.updateCredential(updateCredentialMessageEntity);
			updateCredentialResponse=katavuccolServiceApiMapper.mapUpdateCredentialResponse(updateCredentialResponseMessageEntity,updateCredentialMessageEntity);
			httpStatus = updateCredentialResponseMessageEntity.getHttpStatus();
		}
		catch (Exception ex) {
			if (updateCredentialResponse == null) {
				updateCredentialResponse = getUpdateCredentialResponse();
			}
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(updateCredentialResponse).build();
	}
	
	// @DELETE ==> /income/category
	@DELETE
	@Path("/{userid}/{categoryid}/credential/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCredential(@PathParam("userid") String userid,@PathParam("userid") String categoryid,@PathParam("id") String credentialId) 
	{
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		DeleteCredentialResponse deleteCredentialResponse=new DeleteCredentialResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity=katavuccolServiceApiMapper.mapDeleteCredentialRequestMessageEntity(userid,categoryid,credentialId,httpRequest);
			IKatavuccolService katavuccolService = KatavuccolServiceFactory.getKatavuccolService();
			Map<String, String> headers=getHeaders(httpRequest);
			deleteCredentialMessageEntity.setHttpMethod(httpRequest.getMethod());
			deleteCredentialMessageEntity.setHeaders(headers);
			DeleteCredentialResponseMessageEntity	deleteCredentialResponseMessageEntity=katavuccolService.deleteCredential(deleteCredentialMessageEntity);
			deleteCredentialResponse=katavuccolServiceApiMapper.mapDeleteCredentialResponse(deleteCredentialResponseMessageEntity,deleteCredentialMessageEntity);
			httpStatus = deleteCredentialResponseMessageEntity.getHttpStatus();
		}
		catch (Exception ex) {
			if (deleteCredentialResponse == null) {
				deleteCredentialResponse = getDeleteCredentialResponse();
			}
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(deleteCredentialResponse).build();
	}
	
	//GET ==> /income/category
	@GET
	@Path("/{userid}/{categoryid}/credential")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCredentialsByCategoryId(@PathParam("userid") String userid,@PathParam("categoryid") String categoryid){
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		List<Credential> credentials=new ArrayList<>();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			GetCredentialMessageEntity getCredentialMessageEntity=katavuccolServiceApiMapper.mapGetCredentialMessageEntity(userid,categoryid,httpRequest);
			IKatavuccolService katavuccolService = KatavuccolServiceFactory.getKatavuccolService();
			credentials=katavuccolService.getCredentialsByCategoryId(getCredentialMessageEntity);			
		}
		catch (Exception ex) {				
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(credentials).build();
	}
	@POST
	@Path("/{userid}/{categoryid}/credential/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCredentialValueByCredentialId(@PathParam("userid") String userid,@PathParam("categoryid") String categoryid,
			@PathParam("id") String credentialId,GetCredentialValueRequest getCredentialValueRequest){
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		CredentialValueDetail credentialValueDetail=new CredentialValueDetail();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			GetCredentialValueMessageEntity getCredentialValueMessageEntity=katavuccolServiceApiMapper.mapGetCredentialValueMessageEntity(userid,categoryid,credentialId,httpRequest,getCredentialValueRequest);
			IKatavuccolService katavuccolService = KatavuccolServiceFactory.getKatavuccolService();
			credentialValueDetail=katavuccolService.getCredentialValueByCredentialId(getCredentialValueMessageEntity);
			
		}
		catch (Exception ex) {				
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(credentialValueDetail).build();
	}
	@GET
	@Path("/{userid}/credential")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCredentialsByUserId(@PathParam("userid") String userid){
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		CredentialValueDetail credentialValueDetail=new CredentialValueDetail();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			GetCredentialByUserIdMessageEntity getCredentialByUserIdMessageEntity=katavuccolServiceApiMapper.mapGetCredentialByUserIdMessageEntity(userid);
			ICredentialService credentialService = KatavuccolServiceFactory.getICredentialService();
			credentialValueDetail=credentialService.getCredentialsByUserId(getCredentialByUserIdMessageEntity);			
		}
		catch (Exception ex) {				
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(credentialValueDetail).build();
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
		
	private CredentialResponse getCredentialsResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		CredentialResponse credentialsResponse = new CredentialResponse();		
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		credentialsResponse.setResultMessages(resultMessage);
		return credentialsResponse;
	}
	
	private UpdateCredentialResponse getUpdateCredentialResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		UpdateCredentialResponse updateCredentialResponse = new UpdateCredentialResponse();		
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		updateCredentialResponse.setResultMessages(resultMessage);
		return updateCredentialResponse;
	}
	
	private DeleteCredentialResponse getDeleteCredentialResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		DeleteCredentialResponse deleteCredentialResponse = new DeleteCredentialResponse();		
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		deleteCredentialResponse.setResultMessages(resultMessage);
		return deleteCredentialResponse;
	}
	private CategoryResponse getCategoryResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		CategoryResponse categoryResponse = new CategoryResponse();		
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		categoryResponse.setResultMessages(resultMessage);
		return categoryResponse;
	}
	private DeleteCategoryResponse getDeleteCategoryResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		DeleteCategoryResponse deleteCategoryResponse = new DeleteCategoryResponse();		
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		deleteCategoryResponse.setResultMessages(resultMessage);
		return deleteCategoryResponse;
	}
	
	private UpdateCategoryResponse getUpdateCategoryResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		UpdateCategoryResponse updateCategoryResponse = new UpdateCategoryResponse();		
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		updateCategoryResponse.setResultMessages(resultMessage);
		return updateCategoryResponse;
	}
	private CreateCredentialTypeResponse getCredentialTypeResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		CreateCredentialTypeResponse createCredentialTypeResponse = new CreateCredentialTypeResponse();		
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		createCredentialTypeResponse.setResultMessages(resultMessage);
		return createCredentialTypeResponse;
	}
	private UpdateCredentialTypeResponse getUpdateTypeCredentialResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		UpdateCredentialTypeResponse updateCredentialTypeResponse = new UpdateCredentialTypeResponse();		
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		updateCredentialTypeResponse.setResultMessages(resultMessage);
		return updateCredentialTypeResponse;
	}
	private DeleteCredentialTypeResponse getDeleteCredentialTypeResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		DeleteCredentialTypeResponse deleteCredentialTypeResponse = new DeleteCredentialTypeResponse();		
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		deleteCredentialTypeResponse.setResultMessages(resultMessage);
		return deleteCredentialTypeResponse;
	}

}
