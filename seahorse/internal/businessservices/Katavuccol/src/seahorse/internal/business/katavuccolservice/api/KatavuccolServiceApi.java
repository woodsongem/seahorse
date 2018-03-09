/**
 * 
 */
package seahorse.internal.business.katavuccolservice.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultMessage;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialsMessageEntity;
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
	@Path("/{userid}/credentials")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCredential(@PathParam("userid") String userid,CredentialRequest credentialsRequest) {
		IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
		CredentialResponse credentialsResponse=new CredentialResponse();
		Status httpStatus = Status.INTERNAL_SERVER_ERROR;
		try {
			CredentialRequestMessageEntity credentialMessageEntity=katavuccolServiceApiMapper.mapCredentialRequestMessageEntity(credentialsRequest,userid,httpRequest);
			IKatavuccolService katavuccolService = KatavuccolServiceFactory.getKatavuccolService();
			CredentialResponseMessageEntity credentialsResMessageEntity=katavuccolService.createCredential(credentialMessageEntity);
			credentialsResponse=katavuccolServiceApiMapper.mapCredentialsResponse(credentialsResMessageEntity);
		}
		catch (Exception ex) {
			if (credentialsResponse == null) {
				credentialsResponse = getCredentialsResponse();
			}
			logger.error(ex);
		}
		return Response.status(httpStatus).entity(credentialsResponse).build();
	}
	
		//GET ==> /income/category
		@GET
		@Path("/{userid}/credentials")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getCredentialsByUserId(@PathParam("userid") String userid){
			IKatavuccolServiceApiMapper katavuccolServiceApiMapper=new KatavuccolServiceApiMapper();
			List<Credential> credentials=new ArrayList<>();
			Status httpStatus = Status.INTERNAL_SERVER_ERROR;
			try {
				GetCredentialMessageEntity getCredentialMessageEntity=katavuccolServiceApiMapper.mapGetCredentialMessageEntity(userid,httpRequest);
				IKatavuccolService katavuccolService = KatavuccolServiceFactory.getKatavuccolService();
				GetCredentialsMessageEntity getCredentialsMessageEntity=katavuccolService.getCredentials(getCredentialMessageEntity);
				credentials=katavuccolServiceApiMapper.mapCredential(getCredentialsMessageEntity);
			}
			catch (Exception ex) {				
				logger.error(ex);
			}
			return Response.status(httpStatus).entity(credentials).build();
		}
	
	
	private CredentialResponse getCredentialsResponse() {
		IKatavuccolServiceErrorCode katavuccolServiceErrorCode = new KatavuccolServiceErrorCode();
		CredentialResponse credentialsResponse = new CredentialResponse();
		//incomeCategoryResponse.setResultStatus(ResultStatus.ERROR.toString());
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setErrorCode(katavuccolServiceErrorCode.internalError());
		credentialsResponse.setResultMessages(resultMessage);
		return credentialsResponse;
	}
}
