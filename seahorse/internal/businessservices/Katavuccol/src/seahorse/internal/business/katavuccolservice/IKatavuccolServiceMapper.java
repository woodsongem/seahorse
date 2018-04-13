/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.katavuccolservice.api.datacontracts.Credential;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialsMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceMapper {

	CredentialResponseMessageEntity mapCredentialResponseMessageEntity(Result result, Status badRequest);

	CredentialResponseMessageEntity mapCredentialResponseMessageEntity(Result result,CredentialRequestMessageEntity credentialRequestMessageEntity);

	GetCredentialsMessageEntity mapGetCredentialsMessageEntity(Result result, Status badRequest);

	List<Credential> mapCredentials(Result result, GetCredentialMessageEntity getCredentialMessageEntity);

	DeleteCredentialResponseMessageEntity mapDeleteCredentialResponseMessageEntity(Result result, Status badRequest);

	DeleteCredentialResponseMessageEntity mapDeleteCredentialResponseMessageEntity(Result result,
			DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);

	UpdateCredentialResponseMessageEntity mapUpdateCredentialResponseMessageEntity(Result result, Status badRequest);

	UpdateCredentialResponseMessageEntity mapUpdateCredentialResponseMessageEntity(Result result,
			UpdateCredentialMessageEntity updateCredentialMessageEntity);

	CredentialTypeResponseMessageEntity mapCredentialTypeResponseMessageEntity(Result result, Status badRequest);

	CredentialTypeResponseMessageEntity mapCredentialTypeResponseMessageEntity(Result result,CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity);

	CategoryResponseMessageEntity mapCategoryResponseMessageEntity(Result result, Status badRequest);

	CategoryResponseMessageEntity mapCategoryResponseMessageEntity(Result result,CategoryRequestMessageEntity categoryRequestMessageEntity);

}
