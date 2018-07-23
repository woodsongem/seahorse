/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.List;

import seahorse.internal.business.credentialtypeservice.datacontracts.*;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeModel;

/**
 * @author admin
 *
 */
public interface ICredentialTypeService {

	List<CredentialTypeModel> getCredentialTypeByUserId(CredentialTypeByUserIdMsgEntity credentialTypeByUserId);
	
	CredentialTypeMsgEntity getCredentialTypeById(CredentialTypeByIdMsgEntity credentialTypeByIdMsgEntity);
	
	CreateCredentialTypeResMsgEntity Create(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);

	CredentialTypeModel getCredentialTypeByUserIdAndId(CredentialTypeByUserIdMsgEntity credentialTypeByUserIdMsgEntity);
}
