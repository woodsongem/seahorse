/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.DeleteCategoryResponseMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.GetCategoryMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.categoryservice.datacontracts.UpdateCategoryResponseMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialResponseMessageEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeRequestMessageEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.api.datacontracts.Category;
import seahorse.internal.business.katavuccolservice.api.datacontracts.Credential;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialValueDetail;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialResMsgEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialValueMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialsMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceMapper {

	CredentialResponseMessageEntity mapCredentialResponseMessageEntity(Result result, Status badRequest);

	CredentialResponseMessageEntity mapCredentialResponseMessageEntity(Result result,CredentialRequestMessageEntity credentialRequestMessageEntity);

	GetCredentialsMessageEntity mapGetCredentialsMessageEntity(Result result, Status badRequest);

	List<Credential> mapCredentials(Result result, GetCredentialMessageEntity getCredentialMessageEntity);

	DeleteCredentialResMsgEntity mapDeleteCredentialResponseMessageEntity(Result result, Status badRequest);

	DeleteCredentialResMsgEntity mapDeleteCredentialResponseMessageEntity(Result result,
			DeleteCredentialMessageEntity deleteCredentialMessageEntity);

	UpdateCredentialResponseMessageEntity mapUpdateCredentialResponseMessageEntity(Result result, Status badRequest);

	UpdateCredentialResponseMessageEntity mapUpdateCredentialResponseMessageEntity(Result result,
			UpdateCredentialMessageEntity updateCredentialMessageEntity);

	CredentialTypeResponseMessageEntity mapCredentialTypeResponseMessageEntity(Result result, Status badRequest);

	CredentialTypeResponseMessageEntity mapCredentialTypeResponseMessageEntity(Result result,CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity);

	CategoryResponseMessageEntity mapCategoryResponseMessageEntity(Result result, Status badRequest);

	CategoryResponseMessageEntity mapCategoryResponseMessageEntity(Result result,CategoryRequestMessageEntity categoryRequestMessageEntity);

	DeleteCategoryResponseMessageEntity mapDeleteCategoryResponseMessageEntity(Result result, Status badRequest);

	DeleteCategoryResponseMessageEntity mapDeleteCategoryResponseMessageEntity(Result result,DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);

	List<Category> mapCategory(Result result, GetCategoryMessageEntity getCategoryMessageEntity);

	List<Category> mapCategory(Result result, Status forbidden);

	UpdateCategoryResponseMessageEntity mapUpdateCategoryResponseMessageEntity(Result result, Status badRequest);

	UpdateCategoryResponseMessageEntity mapUpdateCategoryResponseMessageEntity(Result result,
			UpdateCategoryMessageEntity updateCategoryMessageEntity);

	Credential mapCategory(Result result, GetCredentialValueMessageEntity getCredentialValueMessageEntity);

	CredentialValueDetail mapCredentialValueDetail(Result result,GetCredentialValueMessageEntity getCredentialValueMessageEntity);	

}
