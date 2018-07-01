/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeMsgEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;

/**
 * @author admin
 *
 */
public interface ICredentialTypeServicePostProcessor {

	Result postProcessCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);

}
