/**
 * 
 */
package seahorse.internal.business.profileservice;

import java.util.UUID;

import seahorse.internal.business.katavuccolservice.common.datacontracts.OutPutResponse;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.profileservice.api.datacontracts.UserProfileModel;
import seahorse.internal.business.profileservice.dal.datacontracts.UserCredentialDAO;

/**
 * @author admin
 *
 */
public interface IProfileServiceRepository {

	OutPutResponse createUserProfile(UserCredentialDAO userCredentialDAO);

	Result deleteUserProfile(UserCredentialDAO userCredentialDAO);

	Result updateUserProfile(UserCredentialDAO userCredentialDAO);

	UserCredentialDAO getUserProfileByUserId(UUID userId);

	UserProfileModel getUserProfileModelByUserId(UUID userId);

}
