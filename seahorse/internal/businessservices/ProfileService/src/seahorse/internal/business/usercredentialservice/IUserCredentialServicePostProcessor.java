/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;

/**
 * @author SMJE
 *
 */
public interface IUserCredentialServicePostProcessor {

	Result postProcessCreateUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

}
