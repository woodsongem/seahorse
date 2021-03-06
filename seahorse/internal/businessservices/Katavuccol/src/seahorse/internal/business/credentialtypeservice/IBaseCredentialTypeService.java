/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.credentialtypeservice.api.datacontracts.CredentialTypeModel;
import seahorse.internal.business.credentialtypeservice.datacontracts.DeleteCredentialTypeReqMsgEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.profileservice.datacontracts.UserProfileMsgEntity;

/**
 * @author admin
 *
 */
public interface IBaseCredentialTypeService {

	List<CredentialTypeModel> getCredentialTypeByUserId(UUID parsedUserId);

	Result DeleteCredentialTypeByUserIdAndId(DeleteCredentialTypeReqMsgEntity deleteCredentialTypeReqMsgEntity);

	UserProfileMsgEntity getUserDetailByUserId(UUID parsedUserId);
}
