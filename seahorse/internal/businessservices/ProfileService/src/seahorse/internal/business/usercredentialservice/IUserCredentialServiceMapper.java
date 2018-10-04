/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import seahorse.internal.business.usercredentialservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.DeleteUserProfileMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.UserCredentialMsgEntity;

/**
 * @author SMJE
 *
 */
public interface IUserCredentialServiceMapper {

	UserCredentialDAO mapUserCredentialDAO(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

	UserCredentialDAO mapUserCredentialDAO(String username);

	UserCredentialMsgEntity MapUserCredentialMsgEntity(UserCredentialDAO resUserCredentialDAO);

	UserCredentialDAO mapUserCredentialDAO(DeleteUserProfileMsgEntity deleteUserProfileMsgEntity);

}
