/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByIdMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByUserIdMsgEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;

/**
 * @author admin
 *
 */
public interface ICredentialTypeServiceVerifier {

	Result verifyGetCredentialTypeByUserId(CredentialTypeByUserIdMsgEntity credentialTypeByUserId);

	Result verifyGetCredentialTypeById(CredentialTypeByIdMsgEntity credentialTypeByIdMsgEntity);

}
