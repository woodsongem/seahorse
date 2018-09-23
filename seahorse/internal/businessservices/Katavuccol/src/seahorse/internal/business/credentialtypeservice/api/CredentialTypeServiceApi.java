/**
 * 
 */
package seahorse.internal.business.credentialtypeservice.api;

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

import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialResponseMessageEntity;
import seahorse.internal.business.credentialtypeservice.ICredentialTypeService;
import seahorse.internal.business.credentialtypeservice.api.datacontracts.CreateCredentialTypeRequestModel;
import seahorse.internal.business.credentialtypeservice.api.datacontracts.CreateCredentialTypeResponseModel;
import seahorse.internal.business.credentialtypeservice.api.datacontracts.CredentialTypeModel;
import seahorse.internal.business.credentialtypeservice.api.datacontracts.DeleteCredentialTypeResponseModel;
import seahorse.internal.business.credentialtypeservice.api.datacontracts.UpdateCredentialTypeRequestModel;
import seahorse.internal.business.credentialtypeservice.api.datacontracts.UpdateCredentialTypeResponseModel;
import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeResMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByUserIdMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.DeleteCredentialTypeReqMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.DeleteCredentialTypeResMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.UpdateCredentialTypeMessageEntity;
import seahorse.internal.business.katavuccolservice.api.IKatavuccolServiceApiMapper;
import seahorse.internal.business.katavuccolservice.api.KatavuccolServiceApiMapper;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultMessage;
import seahorse.internal.business.katavuccolservice.registries.KatavuccolServiceFactory;

/**
 * @author admin
 *
 */

@Path("/credentialtypeservice")
public class CredentialTypeServiceApi {
	
	private static final Logger logger = LogManager.getLogger(CredentialTypeServiceApi.class);
	@Context
	private HttpServletRequest httpRequest;

	@POST
	@Path("/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCredentialType(@PathParam("userid") String userid,CreateCredentialTypeRequestModel credentialTypeRequest) {
		ICredentialTypeServiceApiMapper credentialTypeServiceApiMapper=new CredentialTypeServiceApiMapper();
		CreateCredentialTypeResponseModel createCredentialTypeResponse=new CreateCredentialTypeResponseModel();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity=credentialTypeServiceApiMapper.mapCreateCredentialTypeMsgEntity(credentialTypeRequest,userid,httpRequest);
			ICredentialTypeService credentialTypeService = KatavuccolServiceFactory.getICredentialTypeService();
			Map<String, String> headers=getHeaders(httpRequest);
			createCredentialTypeMsgEntity.setHttpMethod(httpRequest.getMethod());
			createCredentialTypeMsgEntity.setHeaders(headers);
			CreateCredentialTypeResMsgEntity createCredentialTypeResMsgEntity=credentialTypeService.Create(createCredentialTypeMsgEntity);
			createCredentialTypeResponse=credentialTypeServiceApiMapper.mapCredentialTypeResponse(createCredentialTypeResMsgEntity,createCredentialTypeMsgEntity);
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
	@Path("/{userid}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCredentialType(@PathParam("userid") String userid,@PathParam("id") String credentialId,UpdateCredentialTypeRequestModel updateCredentialTypeRequest) 
	{
		ICredentialTypeServiceApiMapper credentialTypeServiceApiMapper=new CredentialTypeServiceApiMapper();
		UpdateCredentialTypeResponseModel updateCredentialTypeResponse=new UpdateCredentialTypeResponseModel();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			UpdateCredentialTypeMessageEntity updateCredentialTypeMessageEntity=credentialTypeServiceApiMapper.mapUpdateCredentialRequestMessageEntity(updateCredentialTypeRequest,userid,credentialId,httpRequest);
			ICredentialTypeService credentialTypeService = KatavuccolServiceFactory.getICredentialTypeService();
			Map<String, String> headers=getHeaders(httpRequest);
			updateCredentialTypeMessageEntity.setHttpMethod(httpRequest.getMethod());			
			updateCredentialTypeMessageEntity.setHeaders(headers);
			UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity=credentialTypeService.updateCredentialType(updateCredentialTypeMessageEntity);
			updateCredentialTypeResponse=credentialTypeServiceApiMapper.mapUpdateCredentialTypeResponse(updateCredentialResponseMessageEntity,updateCredentialTypeMessageEntity);
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
	@Path("/{userid}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCredentialType(@PathParam("userid") String userid,@PathParam("id") String credentialTypeId) 
	{
		ICredentialTypeServiceApiMapper credentialTypeServiceApiMapper=new CredentialTypeServiceApiMapper();
		DeleteCredentialTypeResponseModel deleteCredentialTypeResponse=new DeleteCredentialTypeResponseModel();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			DeleteCredentialTypeReqMsgEntity deleteCredentialTypeRequestMessageEntity=credentialTypeServiceApiMapper.mapDeleteCredentialTypeRequestMessageEntity(userid,credentialTypeId,httpRequest);
			ICredentialTypeService credentialTypeService = KatavuccolServiceFactory.getICredentialTypeService();
			Map<String, String> headers=getHeaders(httpRequest);
			deleteCredentialTypeRequestMessageEntity.setHttpMethod(httpRequest.getMethod());
			deleteCredentialTypeRequestMessageEntity.setHeaders(headers);
			DeleteCredentialTypeResMsgEntity deleteCredentialTypeResMsgEntity=credentialTypeService.deleteCredentialType(deleteCredentialTypeRequestMessageEntity);
			deleteCredentialTypeResponse=credentialTypeServiceApiMapper.mapDeleteCredentialTypeResponse(deleteCredentialTypeResMsgEntity,deleteCredentialTypeRequestMessageEntity);
			httpStatus = deleteCredentialTypeResMsgEntity.getHttpStatus();
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
	@Path("/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCredentialTypeByUserId(@PathParam("userid") String userid)
	{
		ICredentialTypeServiceApiMapper credentialTypeServiceApiMapper=new CredentialTypeServiceApiMapper();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		List<CredentialTypeModel> credentialTypeModel=new ArrayList<>();
		try {
			ICredentialTypeService credentialTypeService = KatavuccolServiceFactory.getICredentialTypeService();
			CredentialTypeByUserIdMsgEntity credentialTypeByUserIdMsgEntity=credentialTypeServiceApiMapper.mapCredentialTypeByUserIdMsgEntity(userid);
			credentialTypeModel= credentialTypeService.getCredentialTypeByUserId(credentialTypeByUserIdMsgEntity);
			httpStatus= Status.OK;
			if(credentialTypeModel==null)
			{
				credentialTypeModel=new  ArrayList<>();
			}
			
		}
		catch (Exception ex) {	
			httpStatus= Status.INTERNAL_SERVER_ERROR;
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(credentialTypeModel).build();
	}
	@GET
	@Path("/credentialtype/{id}?userid={userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCredentialTypeByUserIdAndId(@PathParam("userid") String userid,@PathParam("id") String id)
	{
		ICredentialTypeServiceApiMapper credentialTypeServiceApiMapper=new CredentialTypeServiceApiMapper();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		CredentialTypeModel credentialTypeModel=new CredentialTypeModel();
		try {
			ICredentialTypeService credentialTypeService = KatavuccolServiceFactory.getICredentialTypeService();
			CredentialTypeByUserIdMsgEntity credentialTypeByUserIdMsgEntity=credentialTypeServiceApiMapper.mapCredentialTypeByUserIdMsgEntity(userid,id);
			credentialTypeModel= credentialTypeService.getCredentialTypeByUserIdAndId(credentialTypeByUserIdMsgEntity);
			httpStatus= Status.OK;
			if(credentialTypeModel==null || credentialTypeModel.getId()==null)
			{
				httpStatus=Status.BAD_REQUEST;
			}
			
		}
		catch (Exception ex) {			
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(credentialTypeModel).build();
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
	private CreateCredentialTypeResponseModel getCredentialTypeResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		CreateCredentialTypeResponseModel createCredentialTypeResponse = new CreateCredentialTypeResponseModel();		
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		createCredentialTypeResponse.setResultMessages(resultMessage);
		return createCredentialTypeResponse;
	}
	private UpdateCredentialTypeResponseModel getUpdateTypeCredentialResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		UpdateCredentialTypeResponseModel updateCredentialTypeResponse = new UpdateCredentialTypeResponseModel();		
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		updateCredentialTypeResponse.setResultMessages(resultMessage);
		return updateCredentialTypeResponse;
	}
	private DeleteCredentialTypeResponseModel getDeleteCredentialTypeResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		DeleteCredentialTypeResponseModel deleteCredentialTypeResponse = new DeleteCredentialTypeResponseModel();		
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		deleteCredentialTypeResponse.setResultMessages(resultMessage);
		return deleteCredentialTypeResponse;
	}
}
