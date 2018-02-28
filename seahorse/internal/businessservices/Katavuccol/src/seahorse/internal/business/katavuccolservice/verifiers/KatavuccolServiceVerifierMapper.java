/**
 * 
 */
package seahorse.internal.business.katavuccolservice.verifiers;

import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.TypeDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.TypeMessageEntity;

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
	public TypeMessageEntity mapTypeDAOMessageEntity(TypeDAO typeDAO) {
		TypeMessageEntity typeDAOMessageEntity=new TypeMessageEntity();
		typeDAOMessageEntity.setCategoryId(typeDAO.getCategoryId());
		typeDAOMessageEntity.setCreatedBy(typeDAO.getCreatedBy());
		typeDAOMessageEntity.setCreatedDate(typeDAO.getCreatedDate());
		typeDAOMessageEntity.setDescription(typeDAO.getDescription());
		typeDAOMessageEntity.setId(typeDAO.getId());
		typeDAOMessageEntity.setModifiedBy(typeDAO.getModifiedBy());
		typeDAOMessageEntity.setModifiedDate(typeDAO.getModifiedDate());
		typeDAOMessageEntity.setName(typeDAO.getName());
		typeDAOMessageEntity.setStatus(typeDAO.getStatus());
		typeDAOMessageEntity.setUserId(typeDAO.getUserId());		
		return typeDAOMessageEntity;
	}

}
