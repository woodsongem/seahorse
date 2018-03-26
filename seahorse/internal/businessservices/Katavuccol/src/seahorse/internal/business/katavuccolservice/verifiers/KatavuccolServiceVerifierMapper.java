/**
 * 
 */
package seahorse.internal.business.katavuccolservice.verifiers;

import java.util.ArrayList;
import java.util.List;

import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeMessageEntity;

/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceVerifierMapper implements IKatavuccolServiceVerifierMapper {

	@Override
	public CategoryMessageEntity mapCategoryMessageEntity(CategoryDAO categoryDAO) {
		CategoryMessageEntity categoryMessageEntity=new CategoryMessageEntity();
		categoryMessageEntity.setCreatedBy(categoryDAO.getCreatedBy());
		categoryMessageEntity.setCreatedDate(categoryDAO.getCreatedDate());
		categoryMessageEntity.setDescription(categoryDAO.getDescription());
		categoryMessageEntity.setId(categoryDAO.getId());
		categoryMessageEntity.setModifiedBy(categoryDAO.getModifiedBy());
		categoryMessageEntity.setModifiedDate(categoryDAO.getModifiedDate());
		categoryMessageEntity.setName(categoryDAO.getName());
		categoryMessageEntity.setStatus(categoryDAO.getStatus());
		categoryMessageEntity.setUserId(categoryDAO.getUserId());		
		return	categoryMessageEntity;
	}

	@Override
	public CredentialTypeMessageEntity mapCredentialTypeDAOMessageEntity(CredentialTypeDAO typeDAO) {
		CredentialTypeMessageEntity credentialTypeMessageEntity=new CredentialTypeMessageEntity();
		credentialTypeMessageEntity.setCategoryId(typeDAO.getCategoryId());
		credentialTypeMessageEntity.setCreatedBy(typeDAO.getCreatedBy());
		credentialTypeMessageEntity.setCreatedDate(typeDAO.getCreatedDate());
		credentialTypeMessageEntity.setDescription(typeDAO.getDescription());
		credentialTypeMessageEntity.setId(typeDAO.getId());
		credentialTypeMessageEntity.setModifiedBy(typeDAO.getModifiedBy());
		credentialTypeMessageEntity.setModifiedDate(typeDAO.getModifiedDate());
		credentialTypeMessageEntity.setName(typeDAO.getName());
		credentialTypeMessageEntity.setStatus(typeDAO.getStatus());
		credentialTypeMessageEntity.setUserId(typeDAO.getUserId());
		credentialTypeMessageEntity.setIsDuplicationAllowed(typeDAO.getIsDuplicationAllowed());
		credentialTypeMessageEntity.setIsSubitemAllowed(typeDAO.getIsSubitemAllowed());
		return credentialTypeMessageEntity;
	}

	@Override
	public List<CredentialMessageEntity> MapCredentialMessageEntity(List<CredentialDAO> credentialDAOs) {
		
		List<CredentialMessageEntity> credentialMessageEntities=new ArrayList<>();
		if(credentialDAOs.isEmpty())
		{
			return credentialMessageEntities;
		}
		for (CredentialDAO credentialDAO : credentialDAOs) {
			CredentialMessageEntity credentialMessageEntity=new CredentialMessageEntity();
			credentialMessageEntity.setCategoryId(credentialDAO.getCategoryId());
			credentialMessageEntity.setCreatedBy(credentialDAO.getCreatedBy());
			credentialMessageEntity.setCreatedDate(credentialDAO.getCreatedDate());
			credentialMessageEntity.setCredentialTypeId(credentialDAO.getCredentialTypeId());
			credentialMessageEntity.setDescription(credentialDAO.getDescription());
			credentialMessageEntity.setId(credentialDAO.getId());
			credentialMessageEntity.setModifiedBy(credentialDAO.getModifiedBy());
			credentialMessageEntity.setModifiedDate(credentialDAO.getModifiedDate());
			credentialMessageEntity.setStatus(credentialDAO.getStatus());
			credentialMessageEntity.setUserId(credentialDAO.getUserId());
			credentialMessageEntity.setParentId(credentialDAO.getParentId());
			credentialMessageEntities.add(credentialMessageEntity);
		}
		return credentialMessageEntities;
	}

	@Override
	public CredentialMessageEntity MapCredentialMessageEntity(CredentialDAO credentialDAO) {
		CredentialMessageEntity credentialMessageEntity=new CredentialMessageEntity();
		credentialMessageEntity.setCategoryId(credentialDAO.getCategoryId());
		credentialMessageEntity.setCreatedBy(credentialDAO.getCreatedBy());
		credentialMessageEntity.setCreatedDate(credentialDAO.getCreatedDate());
		credentialMessageEntity.setCredentialTypeId(credentialDAO.getCredentialTypeId());
		credentialMessageEntity.setDescription(credentialDAO.getDescription());
		credentialMessageEntity.setId(credentialDAO.getId());
		credentialMessageEntity.setModifiedBy(credentialDAO.getModifiedBy());
		credentialMessageEntity.setModifiedDate(credentialDAO.getModifiedDate());
		credentialMessageEntity.setStatus(credentialDAO.getStatus());
		credentialMessageEntity.setUserId(credentialDAO.getUserId());
		credentialMessageEntity.setParentId(credentialDAO.getParentId());
		return credentialMessageEntity;
	}

}
