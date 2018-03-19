/**
 * 
 */
package seahorse.internal.business.katavuccolservice.verifiers;

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
public interface IKatavuccolServiceVerifierMapper {

	CategoryMessageEntity mapCategoryMessageEntity(CategoryDAO categoryDAO);

	CredentialTypeMessageEntity mapCredentialTypeDAOMessageEntity(CredentialTypeDAO typeDAO);

	List<CredentialMessageEntity> MapCredentialMessageEntity(List<CredentialDAO> credentialDAOs);	

}
