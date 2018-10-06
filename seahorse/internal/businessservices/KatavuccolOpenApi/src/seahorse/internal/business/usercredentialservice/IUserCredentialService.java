/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateProfileApiMsgEntity;

/**
 * @author SMJE
 *
 */
public interface IUserCredentialService {

	OutPutResponse createUserCredential(CreateProfileApiMsgEntity createProfileApiMsgEntity);

}
