/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceMapper implements IKatavuccolServiceMapper {

	@Override
	public CredentialsResponseMessageEntity mapCredentialsResponseMessageEntity(Result result, Status badRequest) {
		CredentialsResponseMessageEntity credentialsResponseMessageEntity=new CredentialsResponseMessageEntity();
		credentialsResponseMessageEntity.setResultStatus(result.getResultStatus());
		credentialsResponseMessageEntity.setResultMessages(result.getResultMessages());
		return credentialsResponseMessageEntity;
	}

	@Override
	public CredentialsResponseMessageEntity mapCredentialsResponseMessageEntity(Result result,CredentialsRequestMessageEntity credentialsRequestMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
