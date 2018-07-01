/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeModel;
import seahorse.internal.business.katavuccolservice.common.datacontracts.OutPutResponse;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;

/**
 * @author admin
 *
 */
public interface ICredentialTypeServiceRepository {

	List<CredentialTypeModel> getCredentialTypeByUserId(UUID userId,Boolean includeInActiveStatus);
	
	List<CredentialTypeDAO> getCredentialTypeDAOByUserId(UUID userId,Boolean includeInActiveStatus);

	OutPutResponse createCategoryType(CredentialTypeDAO credentialTypeDAO);	
}
