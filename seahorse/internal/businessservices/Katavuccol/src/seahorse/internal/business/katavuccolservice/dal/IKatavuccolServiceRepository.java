/**
 * 
 */

package seahorse.internal.business.katavuccolservice.dal;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.katavuccolservice.api.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.OutPutResponse;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;
/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceRepository {
	
	CategoryDAO getCategoryDetailById(UUID categoryId,UUID userId);
	
	CredentialTypeDAO getCredentialTypeDetailById(UUID typeId, UUID userId);
	
	List<CategoryDAO> getCategoryDetailByUserId(UUID userId);
	
	List<CredentialTypeDAO>  getTypeDetailsByUserId(UUID userId);
	
	List<CredentialDAO>  getCredentialByUserId(UUID userId);
	
	OutPutResponse createCredential(CredentialRequestMessageEntity credentialRequestMessageEntity);

	CredentialDAO getCredentialById(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);

	OutPutResponse deleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity);

	OutPutResponse updateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity);
}
