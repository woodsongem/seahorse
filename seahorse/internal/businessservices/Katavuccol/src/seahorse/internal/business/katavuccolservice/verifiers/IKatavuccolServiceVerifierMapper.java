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
public interface IKatavuccolServiceVerifierMapper {

	CategoryMessageEntity mapCategoryMessageEntity(CategoryDAO categoryDAO);

	CredentialTypeMessageEntity mapCredentialTypeDAOMessageEntity(TypeDAO typeDAO);	

}
