/**
 * 
 */
package seahorse.internal.business.credentialservice.api;

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

import com.google.api.client.auth.oauth2.Credential;

import seahorse.internal.business.credentialservice.ICredentialService;
import seahorse.internal.business.credentialservice.api.datacontracts.*;
import seahorse.internal.business.credentialservice.datacontracts.*;
import seahorse.internal.business.katavuccolservice.IKatavuccolService;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultMessage;
import seahorse.internal.business.katavuccolservice.registries.KatavuccolServiceFactory;

/**
 * @author SMJE
 *
 */
public class CredentialServiceApi {

	private static final Logger logger = LogManager.getLogger(CredentialServiceApi.class);
	@Context
	private HttpServletRequest httpRequest;

	// POST ==> /income/category
	@POST
	@Path("/{userid}/{categoryid}/credential/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCredential(@PathParam("userid") String userid, @PathParam("categoryid") String categoryid,
			CreateCredentialRequestModel credentialsRequest) {
		CredentialServiceApiMapper credentialServiceApiMapper = new CredentialServiceApiMapper();
		CreateCredentialResponseModel credentialsResponse = new CreateCredentialResponseModel();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			CreateCredentialRequestMessageEntity credentialMessageEntity = credentialServiceApiMapper.mapCredentialRequestMessageEntity(credentialsRequest, userid, categoryid, httpRequest);
			ICredentialService credentialService = KatavuccolServiceFactory.getICredentialService();
			Map<String, String> headers = getHeaders(httpRequest);
			credentialMessageEntity.setHttpMethod(httpRequest.getMethod());
			credentialMessageEntity.setHeaders(headers);
			CreateCredentialResponseMessageEntity credentialsResMessageEntity = credentialService.createCredential(credentialMessageEntity);
			credentialsResponse = credentialServiceApiMapper.mapCredentialsResponse(credentialsResMessageEntity,
					credentialMessageEntity);
			httpStatus = credentialsResMessageEntity.getHttpStatus();
		} catch (Exception ex) {
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
	public Response updateCredential(@PathParam("userid") String userid, @PathParam("categoryid") String categoryid,
			@PathParam("id") String credentialId, UpdateCredentialRequest updateCredentialRequest) {
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper = new KatavuccolServiceApiMapper();
		UpdateCredentialResponse updateCredentialResponse = new UpdateCredentialResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			UpdateCredentialMessageEntity updateCredentialMessageEntity = katavuccolServiceApiMapper
					.mapUpdateCredentialRequestMessageEntity(updateCredentialRequest, userid, categoryid, credentialId,
							httpRequest);
			IKatavuccolService katavuccolService = KatavuccolServiceFactory.getKatavuccolService();
			Map<String, String> headers = getHeaders(httpRequest);
			updateCredentialMessageEntity.setHttpMethod(httpRequest.getMethod());
			updateCredentialMessageEntity.setHeaders(headers);
			UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity = katavuccolService
					.updateCredential(updateCredentialMessageEntity);
			updateCredentialResponse = katavuccolServiceApiMapper
					.mapUpdateCredentialResponse(updateCredentialResponseMessageEntity, updateCredentialMessageEntity);
			httpStatus = updateCredentialResponseMessageEntity.getHttpStatus();
		} catch (Exception ex) {
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
	public Response deleteCredential(@PathParam("userid") String userid, @PathParam("userid") String categoryid,
			@PathParam("id") String credentialId) {
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper = new KatavuccolServiceApiMapper();
		DeleteCredentialResponse deleteCredentialResponse = new DeleteCredentialResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity = katavuccolServiceApiMapper
					.mapDeleteCredentialRequestMessageEntity(userid, categoryid, credentialId, httpRequest);
			IKatavuccolService katavuccolService = KatavuccolServiceFactory.getKatavuccolService();
			Map<String, String> headers = getHeaders(httpRequest);
			deleteCredentialMessageEntity.setHttpMethod(httpRequest.getMethod());
			deleteCredentialMessageEntity.setHeaders(headers);
			DeleteCredentialResMsgEntity deleteCredentialResponseMessageEntity = katavuccolService
					.deleteCredential(deleteCredentialMessageEntity);
			deleteCredentialResponse = katavuccolServiceApiMapper
					.mapDeleteCredentialResponse(deleteCredentialResponseMessageEntity, deleteCredentialMessageEntity);
			httpStatus = deleteCredentialResponseMessageEntity.getHttpStatus();
		} catch (Exception ex) {
			if (deleteCredentialResponse == null) {
				deleteCredentialResponse = getDeleteCredentialResponse();
			}
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(deleteCredentialResponse).build();
	}

	// GET ==> /income/category
	@GET
	@Path("/{userid}/{categoryid}/credential")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCredentialsByCategoryId(@PathParam("userid") String userid,
			@PathParam("categoryid") String categoryid) {
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper = new KatavuccolServiceApiMapper();
		List<Credential> credentials = new ArrayList<>();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			GetCredentialMessageEntity getCredentialMessageEntity = katavuccolServiceApiMapper
					.mapGetCredentialMessageEntity(userid, categoryid, httpRequest);
			IKatavuccolService katavuccolService = KatavuccolServiceFactory.getKatavuccolService();
			credentials = katavuccolService.getCredentialsByCategoryId(getCredentialMessageEntity);
		} catch (Exception ex) {
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(credentials).build();
	}

	@POST
	@Path("/{userid}/{categoryid}/credential/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCredentialValueByCredentialId(@PathParam("userid") String userid,
			@PathParam("categoryid") String categoryid, @PathParam("id") String credentialId,
			GetCredentialValueRequest getCredentialValueRequest) {
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper = new KatavuccolServiceApiMapper();
		CredentialValueDetail credentialValueDetail = new CredentialValueDetail();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			GetCredentialValueMessageEntity getCredentialValueMessageEntity = katavuccolServiceApiMapper
					.mapGetCredentialValueMessageEntity(userid, categoryid, credentialId, httpRequest,
							getCredentialValueRequest);
			IKatavuccolService katavuccolService = KatavuccolServiceFactory.getKatavuccolService();
			credentialValueDetail = katavuccolService.getCredentialValueByCredentialId(getCredentialValueMessageEntity);

		} catch (Exception ex) {
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(credentialValueDetail).build();
	}

	@GET
	@Path("/{userid}/credential")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCredentialsByUserId(@PathParam("userid") String userid) {
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper = new KatavuccolServiceApiMapper();
		CredentialValueDetail credentialValueDetail = new CredentialValueDetail();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			GetCredentialByUserIdMessageEntity getCredentialByUserIdMessageEntity = katavuccolServiceApiMapper
					.mapGetCredentialByUserIdMessageEntity(userid);
			ICredentialService credentialService = KatavuccolServiceFactory.getICredentialService();
			credentialValueDetail = credentialService.getCredentialsByUserId(getCredentialByUserIdMessageEntity);
		} catch (Exception ex) {
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(credentialValueDetail).build();
	}

	public Map<String, String> getHeaders(HttpServletRequest httpRequest) {
		Map<String, String> mapheaders = new HashMap<>();
		Enumeration<String> e = httpRequest.getHeaderNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value = httpRequest.getHeader(name);
			mapheaders.put(name, value);
		}
		return mapheaders;
	}

	public CredentialResponse getCredentialsResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		CredentialResponse credentialsResponse = new CredentialResponse();
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		credentialsResponse.setResultMessages(resultMessage);
		return credentialsResponse;
	}

	public UpdateCredentialResponse getUpdateCredentialResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		UpdateCredentialResponse updateCredentialResponse = new UpdateCredentialResponse();
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		updateCredentialResponse.setResultMessages(resultMessage);
		return updateCredentialResponse;
	}

	public DeleteCredentialResponse getDeleteCredentialResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		DeleteCredentialResponse deleteCredentialResponse = new DeleteCredentialResponse();
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		deleteCredentialResponse.setResultMessages(resultMessage);
		return deleteCredentialResponse;
	}

}
