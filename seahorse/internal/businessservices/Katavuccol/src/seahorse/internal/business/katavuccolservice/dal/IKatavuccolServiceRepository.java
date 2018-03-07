/**
 * 
 */

package seahorse.internal.business.katavuccolservice.dal;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.katavuccolservice.common.datacontracts.OutPutResponse;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.TypeDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceRepository {
	
	CategoryDAO getCategoryDetailById(UUID categoryId,UUID userId);
	
	TypeDAO getCredentialTypeDetailById(UUID typeId, UUID userId);
	
	List<CategoryDAO> getCategoryDetailByUserId(UUID userId);
	
	List<TypeDAO>  getTypeDetailsByUserId(UUID userId);
	
	OutPutResponse createCredential(CredentialRequestMessageEntity credentialRequestMessageEntity);
}
