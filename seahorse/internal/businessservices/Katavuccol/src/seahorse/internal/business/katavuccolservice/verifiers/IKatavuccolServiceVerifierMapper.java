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
public interface IKatavuccolServiceVerifierMapper {

	CategoryMessageEntity mapCategoryMessageEntity(CategoryDAO categoryDAO);

	TypeMessageEntity mapTypeDAOMessageEntity(TypeDAO typeDAO);	

}
