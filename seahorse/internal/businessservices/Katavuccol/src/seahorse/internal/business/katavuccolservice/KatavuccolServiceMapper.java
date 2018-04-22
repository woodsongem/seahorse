/**
 * 
 */
package seahorse.internal.business.katavuccolservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.katavuccolservice.api.datacontracts.Category;
import seahorse.internal.business.katavuccolservice.api.datacontracts.Credential;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCategoryResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialsMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCategoryResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialResponseMessageEntity;
import seahorse.internal.business.katavuccolservice.utilities.KatavuccolServiceUtility;

/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceMapper implements IKatavuccolServiceMapper {

	@Override
	public CredentialResponseMessageEntity mapCredentialResponseMessageEntity(Result result, Status badRequest) {
		CredentialResponseMessageEntity credentialsResponseMessageEntity=new CredentialResponseMessageEntity();
		credentialsResponseMessageEntity.setResultStatus(result.getResultStatus());
		credentialsResponseMessageEntity.setResultMessages(result.getResultMessages());
		credentialsResponseMessageEntity.setHttpStatus(badRequest);
		return credentialsResponseMessageEntity;
	}

	@Override
	public CredentialResponseMessageEntity mapCredentialResponseMessageEntity(Result result,CredentialRequestMessageEntity credentialRequestMessageEntity) {
		CredentialResponseMessageEntity credentialsResponseMessageEntity=new CredentialResponseMessageEntity();
		credentialsResponseMessageEntity.setResultStatus(result.getResultStatus());
		credentialsResponseMessageEntity.setResultMessages(result.getResultMessages());
		credentialsResponseMessageEntity.setHttpStatus(Status.OK);
		credentialsResponseMessageEntity.setId(credentialRequestMessageEntity.getId());
		if (credentialRequestMessageEntity.getHttpStatus() == null) {
			if (result.getResultStatus() == ResultStatus.SUCCESS)
				credentialsResponseMessageEntity.setHttpStatus(Status.OK);
			else
				credentialsResponseMessageEntity.setHttpStatus(Status.FORBIDDEN);
		}
		else
		{
			credentialsResponseMessageEntity.setHttpStatus(credentialRequestMessageEntity.getHttpStatus());
		}
		return credentialsResponseMessageEntity;
	}

	@Override
	public GetCredentialsMessageEntity mapGetCredentialsMessageEntity(Result result, Status badRequest) {
		GetCredentialsMessageEntity getCredentialsMessageEntity=new GetCredentialsMessageEntity();
		getCredentialsMessageEntity.setResultStatus(result.getResultStatus());
		getCredentialsMessageEntity.setResultMessages(result.getResultMessages());
		getCredentialsMessageEntity.setHttpStatus(badRequest);
		return getCredentialsMessageEntity;
	}

	@Override
	public List<Credential> mapCredentials(Result result, GetCredentialMessageEntity getCredentialMessageEntity) {
		List<Credential> credentials=new ArrayList<>();
		
		if(getCredentialMessageEntity.getCredentialDAO() == null || getCredentialMessageEntity.getCredentialDAO().isEmpty())
		{
			return credentials;
		}
		
		for (CredentialDAO credentialDAO : getCredentialMessageEntity.getCredentialDAO()) {
			Credential credential=new Credential();
			credential.setCategoryId(KatavuccolServiceUtility.getString(credentialDAO.getCategoryId()));
			credential.setCreatedBy(KatavuccolServiceUtility.getString(credentialDAO.getCreatedBy()));
			credential.setCreatedDate(credentialDAO.getCreatedDate());
			credential.setCredentialTypeId(KatavuccolServiceUtility.getString(credentialDAO.getCredentialTypeId()));
			credential.setDescription(credentialDAO.getDescription());
			credential.setId(KatavuccolServiceUtility.getString(credentialDAO.getId()));
			credential.setModifiedBy(KatavuccolServiceUtility.getString(credentialDAO.getModifiedBy()));
			credential.setModifiedDate(credentialDAO.getModifiedDate());
			credential.setParentId(KatavuccolServiceUtility.getString(credentialDAO.getParentId()));
			credential.setStatus(credentialDAO.getStatus());
			credential.setUserId(KatavuccolServiceUtility.getString(credentialDAO.getUserId()));
			credentials.add(credential);
		}		
		return credentials;
	}

	@Override
	public DeleteCredentialResponseMessageEntity mapDeleteCredentialResponseMessageEntity(Result result,Status badRequest) {
		DeleteCredentialResponseMessageEntity deleteCredentialResponseMessageEntity=new DeleteCredentialResponseMessageEntity();
		deleteCredentialResponseMessageEntity.setResultStatus(result.getResultStatus());
		deleteCredentialResponseMessageEntity.setResultMessages(result.getResultMessages());
		deleteCredentialResponseMessageEntity.setHttpStatus(badRequest);
		return deleteCredentialResponseMessageEntity;
	}

	@Override
	public DeleteCredentialResponseMessageEntity mapDeleteCredentialResponseMessageEntity(Result result,DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
		DeleteCredentialResponseMessageEntity deleteCredentialResponseMessageEntity=new DeleteCredentialResponseMessageEntity();
		deleteCredentialResponseMessageEntity.setResultStatus(result.getResultStatus());
		deleteCredentialResponseMessageEntity.setResultMessages(result.getResultMessages());
		deleteCredentialResponseMessageEntity.setHttpStatus(Status.OK);		
		if (deleteCredentialResponseMessageEntity.getHttpStatus() == null) {
			if (result.getResultStatus() == ResultStatus.SUCCESS)
				deleteCredentialResponseMessageEntity.setHttpStatus(Status.OK);
			else
				deleteCredentialResponseMessageEntity.setHttpStatus(Status.FORBIDDEN);
		}
		else
		{
			deleteCredentialResponseMessageEntity.setHttpStatus(deleteCredentialResponseMessageEntity.getHttpStatus());
		}
		return deleteCredentialResponseMessageEntity;
	}

	@Override
	public UpdateCredentialResponseMessageEntity mapUpdateCredentialResponseMessageEntity(Result result,Status badRequest) {
		UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity=new UpdateCredentialResponseMessageEntity();
		updateCredentialResponseMessageEntity.setResultStatus(result.getResultStatus());
		updateCredentialResponseMessageEntity.setResultMessages(result.getResultMessages());
		updateCredentialResponseMessageEntity.setHttpStatus(badRequest);
		return updateCredentialResponseMessageEntity;
	}

	@Override
	public UpdateCredentialResponseMessageEntity mapUpdateCredentialResponseMessageEntity(Result result,
			UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity=new UpdateCredentialResponseMessageEntity();
		updateCredentialResponseMessageEntity.setResultStatus(result.getResultStatus());
		updateCredentialResponseMessageEntity.setResultMessages(result.getResultMessages());
		updateCredentialResponseMessageEntity.setHttpStatus(Status.OK);		
		if (updateCredentialResponseMessageEntity.getHttpStatus() == null) {
			if (result.getResultStatus() == ResultStatus.SUCCESS)
				updateCredentialResponseMessageEntity.setHttpStatus(Status.OK);
			else
				updateCredentialResponseMessageEntity.setHttpStatus(Status.FORBIDDEN);
		}
		else
		{
			updateCredentialResponseMessageEntity.setHttpStatus(updateCredentialResponseMessageEntity.getHttpStatus());
		}
		return updateCredentialResponseMessageEntity;
	}

	@Override
	public CredentialTypeResponseMessageEntity mapCredentialTypeResponseMessageEntity(Result result,Status badRequest) {
		CredentialTypeResponseMessageEntity credentialTypeResponseMessageEntity=new CredentialTypeResponseMessageEntity();
		credentialTypeResponseMessageEntity.setResultStatus(result.getResultStatus());
		credentialTypeResponseMessageEntity.setResultMessages(result.getResultMessages());
		credentialTypeResponseMessageEntity.setHttpStatus(badRequest);
		return credentialTypeResponseMessageEntity;
	}

	@Override
	public CredentialTypeResponseMessageEntity mapCredentialTypeResponseMessageEntity(Result result,CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryResponseMessageEntity mapCategoryResponseMessageEntity(Result result, Status badRequest) {
		CategoryResponseMessageEntity categoryResponseMessageEntity=new CategoryResponseMessageEntity();
		categoryResponseMessageEntity.setResultStatus(result.getResultStatus());
		categoryResponseMessageEntity.setResultMessages(result.getResultMessages());
		categoryResponseMessageEntity.setHttpStatus(badRequest);
		return categoryResponseMessageEntity;
	}

	@Override
	public CategoryResponseMessageEntity mapCategoryResponseMessageEntity(Result result,CategoryRequestMessageEntity categoryRequestMessageEntity) {
		CategoryResponseMessageEntity categoryResponseMessageEntity=new CategoryResponseMessageEntity();
		categoryResponseMessageEntity.setResultStatus(result.getResultStatus());
		categoryResponseMessageEntity.setResultMessages(result.getResultMessages());
		categoryResponseMessageEntity.setHttpStatus(Status.OK);		
		if (categoryRequestMessageEntity.getHttpStatus() == null) {
			if (result.getResultStatus() == ResultStatus.SUCCESS)
				categoryResponseMessageEntity.setHttpStatus(Status.OK);
			else
				categoryResponseMessageEntity.setHttpStatus(Status.FORBIDDEN);
		}
		else
		{
			categoryResponseMessageEntity.setHttpStatus(categoryRequestMessageEntity.getHttpStatus());
		}
		return categoryResponseMessageEntity;
	}

	@Override
	public DeleteCategoryResponseMessageEntity mapDeleteCategoryResponseMessageEntity(Result result,Status badRequest) {
		DeleteCategoryResponseMessageEntity deleteCategoryResponseMessageEntity=new DeleteCategoryResponseMessageEntity();
		deleteCategoryResponseMessageEntity.setResultStatus(result.getResultStatus());
		deleteCategoryResponseMessageEntity.setResultMessages(result.getResultMessages());
		deleteCategoryResponseMessageEntity.setHttpStatus(badRequest);
		return deleteCategoryResponseMessageEntity;
	}

	@Override
	public DeleteCategoryResponseMessageEntity mapDeleteCategoryResponseMessageEntity(Result result,DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		DeleteCategoryResponseMessageEntity deleteCategoryResponseMessageEntity=new DeleteCategoryResponseMessageEntity();
		deleteCategoryResponseMessageEntity.setResultStatus(result.getResultStatus());
		deleteCategoryResponseMessageEntity.setResultMessages(result.getResultMessages());
		deleteCategoryResponseMessageEntity.setHttpStatus(Status.OK);		
		if (deleteCategoryRequestMessageEntity.getHttpStatus() == null) {
			if (result.getResultStatus() == ResultStatus.SUCCESS)
				deleteCategoryResponseMessageEntity.setHttpStatus(Status.OK);
			else
				deleteCategoryResponseMessageEntity.setHttpStatus(Status.FORBIDDEN);
		}
		else
		{
			deleteCategoryResponseMessageEntity.setHttpStatus(deleteCategoryRequestMessageEntity.getHttpStatus());
		}
		return deleteCategoryResponseMessageEntity;
	}

	@Override
	public List<Category> mapCategory(Result result, GetCategoryMessageEntity getCategoryMessageEntity) {
		List<Category> categorys=new ArrayList<>();
		if(getCategoryMessageEntity.getCategory() == null || getCategoryMessageEntity.getCategory().isEmpty())
		{
			return categorys;
		}
		for (seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO categoryDAO : getCategoryMessageEntity.getCategory()) {
			Category category=new Category();
			category.setName(categoryDAO.getName());
			category.setUserId(KatavuccolServiceUtility.getString(categoryDAO.getUserId()));
			category.setDescription(categoryDAO.getDescription());
			category.setId(KatavuccolServiceUtility.getString(categoryDAO.getId()));
			category.setCreatedBy(KatavuccolServiceUtility.getString(categoryDAO.getCreatedBy()));
			category.setCreatedDate(categoryDAO.getCreatedDate());
			category.setModifiedBy(KatavuccolServiceUtility.getString(categoryDAO.getModifiedBy()));
			category.setModifiedDate(categoryDAO.getModifiedDate());			
			category.setStatus(categoryDAO.getStatus());			
			categorys.add(category);
		}		
		return categorys;
	}

	@Override
	public List<Category> mapCategory(Result result, Status forbidden) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateCategoryResponseMessageEntity mapUpdateCategoryResponseMessageEntity(Result result,Status badRequest) {
		UpdateCategoryResponseMessageEntity updateCategoryResponseMessageEntity=new UpdateCategoryResponseMessageEntity();
		updateCategoryResponseMessageEntity.setResultStatus(result.getResultStatus());
		updateCategoryResponseMessageEntity.setResultMessages(result.getResultMessages());
		updateCategoryResponseMessageEntity.setHttpStatus(badRequest);
		return updateCategoryResponseMessageEntity;
	}

	@Override
	public UpdateCategoryResponseMessageEntity mapUpdateCategoryResponseMessageEntity(Result result,
			UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		UpdateCategoryResponseMessageEntity updateCategoryResponseMessageEntity=new UpdateCategoryResponseMessageEntity();
		updateCategoryResponseMessageEntity.setResultStatus(result.getResultStatus());
		updateCategoryResponseMessageEntity.setResultMessages(result.getResultMessages());
		updateCategoryResponseMessageEntity.setHttpStatus(Status.OK);		
		if (updateCategoryMessageEntity.getHttpStatus() == null) {
			if (result.getResultStatus() == ResultStatus.SUCCESS)
				updateCategoryResponseMessageEntity.setHttpStatus(Status.OK);
			else
				updateCategoryResponseMessageEntity.setHttpStatus(Status.FORBIDDEN);
		}
		else
		{
			updateCategoryResponseMessageEntity.setHttpStatus(updateCategoryMessageEntity.getHttpStatus());
		}
		return updateCategoryResponseMessageEntity;
	}

}
