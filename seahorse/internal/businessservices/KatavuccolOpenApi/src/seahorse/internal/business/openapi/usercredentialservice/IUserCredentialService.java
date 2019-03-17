/**
 * 
 */
package seahorse.internal.business.openapi.usercredentialservice;

import seahorse.internal.business.openapi.usercredentialapi.api.datacontracts.UserCredentialApiModel;
import seahorse.internal.business.openapi.usercredentialservice.datacontracts.CreateProfileApiMsgEntity;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;

/**
 * @author SMJE
 *
 */
public interface IUserCredentialService {

	OutPutResponse createUserCredential(CreateProfileApiMsgEntity createProfileApiMsgEntity);

	UserCredentialApiModel getUserProfileByUserName(String username);

}
