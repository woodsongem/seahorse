/**
 * 
 */
package seahorse.internal.business.katavuccolservice.api;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import seahorse.internal.business.katavuccolservice.api.datacontracts.CategoryRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CategoryResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.Credential;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.DeleteCategoryResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.DeleteCredentialResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.DeleteCredentialTypeResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.UpdateCategoryRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.UpdateCategoryResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.UpdateCredentialRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.UpdateCredentialResponse;
import seahorse.internal.business.katavuccolservice.api.datacontracts.UpdateCredentialTypeRequest;
import seahorse.internal.business.katavuccolservice.api.datacontracts.UpdateCredentialTypeResponse;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialTypeRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialsMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCategoryResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialTypeMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceApiMapper {	

	CredentialResponse mapCredentialsResponse(CredentialResponseMessageEntity credentialsResMessageEntity);

	CredentialRequestMessageEntity mapCredentialRequestMessageEntity(CredentialRequest credentialRequest,String userid, HttpServletRequest httpRequest);

	GetCredentialMessageEntity mapGetCredentialMessageEntity(String userid, HttpServletRequest httpRequest);

	List<Credential> mapCredential(GetCredentialsMessageEntity getCredentialsMessageEntity);

	CredentialResponse mapCredentialsResponse(CredentialResponseMessageEntity credentialsResMessageEntity, CredentialRequestMessageEntity credentialMessageEntity);

	UpdateCredentialMessageEntity mapUpdateCredentialRequestMessageEntity(UpdateCredentialRequest updateCredentialRequest, String userid, String credentialId,HttpServletRequest httpRequest);

	UpdateCredentialResponse mapUpdateCredentialResponse(UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity,UpdateCredentialMessageEntity updateCredentialMessageEntity);

	DeleteCredentialRequestMessageEntity mapDeleteCredentialRequestMessageEntity(String userid, String credentialId,HttpServletRequest httpRequest);

	DeleteCredentialResponse mapDeleteCredentialResponse(DeleteCredentialResponseMessageEntity deleteCredentialResponseMessageEntity,DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);

	CategoryRequestMessageEntity mapCategoryRequestMessageEntity(CategoryRequest categoryRequest, String userid, HttpServletRequest httpRequest);

	CategoryResponse mapCategoryResponse(CategoryResponseMessageEntity categoryResponseMessageEntity,CategoryRequestMessageEntity categoryMessageEntity);

	DeleteCategoryRequestMessageEntity mapDeleteCategoryRequestMessageEntity(String userid, String categoryId,HttpServletRequest httpRequest);

	DeleteCategoryResponse mapDeleteCategoryResponse(DeleteCredentialResponseMessageEntity deleteCredentialResponseMessageEntity,DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity);

	UpdateCategoryMessageEntity mapUpdateCategoryRequestMessageEntity(UpdateCategoryRequest updateCategoryRequest,
			String userid, String categoryId, HttpServletRequest httpRequest);

	UpdateCategoryResponse mapUpdateCategoryResponse(
			UpdateCategoryResponseMessageEntity updateCategoryResponseMessageEntity,
			UpdateCategoryMessageEntity updateCategoryMessageEntity);

	CredentialTypeRequestMessageEntity mapCredentialTypeRequestMessageEntity(
			CredentialTypeRequest credentialTypeRequest, 
			String userid, 
			HttpServletRequest httpRequest);

	CredentialTypeResponse mapCredentialTypeResponse(
			CredentialTypeResponseMessageEntity credentialTypeResponseMessageEntity,
			CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity);

	UpdateCredentialTypeMessageEntity mapUpdateCredentialRequestMessageEntity(
			UpdateCredentialTypeRequest updateCredentialTypeRequest, String userid, String credentialId,
			HttpServletRequest httpRequest);

	UpdateCredentialTypeResponse mapUpdateCredentialTypeResponse(
			UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity,
			UpdateCredentialTypeMessageEntity updateCredentialTypeMessageEntity);

	DeleteCredentialTypeResponse mapDeleteCredentialTypeResponse(
			DeleteCredentialResponseMessageEntity deleteCredentialResponseMessageEntity,
			DeleteCredentialTypeRequestMessageEntity deleteCredentialTypeRequestMessageEntity);

	DeleteCredentialTypeRequestMessageEntity mapDeleteCredentialTypeRequestMessageEntity(String userid,
			String credentialTypeId, HttpServletRequest httpRequest);

}
