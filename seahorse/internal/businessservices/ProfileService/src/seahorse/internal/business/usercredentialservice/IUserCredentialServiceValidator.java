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
public interface IUserCredentialServiceValidator {

	Result validCreateUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

	Result isCreateUserCredentialMsgEntityValid(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

	Result isUserNameValid(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

	Result isPasswordValid(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

	Result isProductItemIdValid(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

}
