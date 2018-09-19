/**
 * 
 */
package seahorse.internal.business.credentialservice;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.credentialservice.api.datacontracts.CredentialModel;
import seahorse.internal.business.credentialservice.datacontracts.CreateCredentialRequestMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.CreateCredentialResponseMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.DeleteCredentialMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.DeleteCredentialResMsgEntity;
import seahorse.internal.business.credentialservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;

/**
 * @author admin
 *
 */
public interface ICredentialServiceMapper {

	CreateCredentialResponseMessageEntity mapCreateCredentialResponseMessageEntity(Result result, Status badRequest);

	CreateCredentialResponseMessageEntity mapCreateCredentialResponseMessageEntity(Result result,CreateCredentialRequestMessageEntity credentialRequestMessageEntity);

	UpdateCredentialResponseMessageEntity mapUpdateCredentialResponseMessageEntity(Result result, Status badRequest);

	UpdateCredentialResponseMessageEntity mapUpdateCredentialResponseMessageEntity(Result result,UpdateCredentialMessageEntity updateCredentialMessageEntity);

	DeleteCredentialResMsgEntity mapDeleteCredentialResponseMessageEntity(Result result, Status badRequest);

	DeleteCredentialResMsgEntity mapDeleteCredentialResponseMessageEntity(Result result,DeleteCredentialMessageEntity deleteCredentialMessageEntity);

	List<CredentialModel> mapCredential(Result result, GetCredentialMessageEntity getCredentialMessageEntity);

}
