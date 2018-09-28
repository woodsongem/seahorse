/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import java.util.UUID;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.usercredentialservice.dal.datacontracts.UserCredentialDAO;

/**
 * @author SMJE
 *
 */
public interface IUserCredentialRepository {

	UserCredentialDAO getUserCredentialByUserId(UUID userId);

	Result createUserCredential(UserCredentialDAO userCredentialDAO);

	Result deleteUserCredential(UUID userId);

	Result updateUserCredential(UserCredentialDAO userCredentialDAO);

}
