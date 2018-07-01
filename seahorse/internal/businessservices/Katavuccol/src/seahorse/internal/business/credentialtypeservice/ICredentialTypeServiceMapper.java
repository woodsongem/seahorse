/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeMsgEntity;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;

/**
 * @author admin
 *
 */
public interface ICredentialTypeServiceMapper {

	CredentialTypeDAO MapcredentialTypeDAO(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);

}
