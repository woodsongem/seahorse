/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.UserCredentialMsgEntity;

/**
 * @author SMJE
 *
 */
public interface IBaseUserCredentialService {

	UserCredentialMsgEntity getUserCredentialByUserName(String username);

	Result createUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

}
