/**
 * 
 */
package seahorse.internal.business.katavuccolservice.verifiers;

import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.TypeDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryMessageEntity;
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
	public CredentialTypeMessageEntity mapCredentialTypeDAOMessageEntity(TypeDAO typeDAO) {
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
		return credentialTypeMessageEntity;
	}

}
