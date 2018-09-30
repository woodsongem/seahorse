/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import seahorse.internal.business.usercredentialservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;

/**
 * @author SMJE
 *
 */
public interface IUserCredentialServiceMapper {

	UserCredentialDAO mapUserCredentialDAO(CreateUserCredentialMsgEntity createUserCredentialMsgEntity);

}
