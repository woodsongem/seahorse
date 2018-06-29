/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeModel;

/**
 * @author admin
 *
 */
public interface ICredentialTypeServiceRepository {

	List<CredentialTypeModel> getCredentialTypeByUserId(UUID userId,Boolean includeInActiveStatus);
}
