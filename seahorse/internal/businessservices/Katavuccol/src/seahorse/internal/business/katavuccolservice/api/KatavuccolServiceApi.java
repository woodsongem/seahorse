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
import seahorse.internal.business.katavuccolservice.IKatavuccolService;
import seahorse.internal.business.katavuccolservice.api.datacontracts.Credential;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.api.datacontracts.DeleteCredentialResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.UpdateCredentialRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.UpdateCredentialResponse;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultMessage;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialsMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialResponseMessageEntity;
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

	// POST ==> /income/category
	@POST
	@Path("/{userid}/category/credential/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCredential(@PathParam("userid") String userid,CredentialRequest credentialsRequest) {
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		CredentialResponse credentialsResponse=new CredentialResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			CredentialRequestMessageEntity credentialMessageEntity=katavuccolServiceApiMapper.mapCredentialRequestMessageEntity(credentialsRequest,userid,httpRequest);
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
	@Path("/{userid}/category/credential/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCredential(@PathParam("userid") String userid,@PathParam("id") String credentialId,UpdateCredentialRequest updateCredentialRequest) 
	{
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		UpdateCredentialResponse updateCredentialResponse=new UpdateCredentialResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			UpdateCredentialMessageEntity updateCredentialMessageEntity=katavuccolServiceApiMapper.mapUpdateCredentialRequestMessageEntity(updateCredentialRequest,userid,credentialId,httpRequest);
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
	@Path("/{userid}/category/credential/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCredential(@PathParam("userid") String userid,@PathParam("id") String credentialId) 
	{
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		DeleteCredentialResponse deleteCredentialResponse=new DeleteCredentialResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity=katavuccolServiceApiMapper.mapDeleteCredentialRequestMessageEntity(userid,credentialId,httpRequest);
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
	@Path("/{userid}/category/credential")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCredentialsByUserId(@PathParam("userid") String userid){
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		List<Credential> credentials=new ArrayList<>();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			GetCredentialMessageEntity getCredentialMessageEntity=katavuccolServiceApiMapper.mapGetCredentialMessageEntity(userid,httpRequest);
			IKatavuccolService katavuccolService = KatavuccolServiceFactory.getKatavuccolService();
			credentials=katavuccolService.getCredentials(getCredentialMessageEntity);
			
		}
		catch (Exception ex) {				
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(credentials).build();
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
}
