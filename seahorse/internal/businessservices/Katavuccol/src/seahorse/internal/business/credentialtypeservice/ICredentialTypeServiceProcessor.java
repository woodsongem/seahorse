/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByUserIdMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.DeleteCredentialTypeReqMsgEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;

/**
 * @author admin
 *
 */
public interface ICredentialTypeServiceProcessor {

	Result processGetCredentialTypeByUserId(CredentialTypeByUserIdMsgEntity credentialTypeByUserId);

	Result processCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
	
	Result CreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
	
	Result getCredentialTypeByUserId(CredentialTypeByUserIdMsgEntity credentialTypeByUserId);

	Result processDeleteCredentialType(DeleteCredentialTypeReqMsgEntity deleteCredentialTypeReqMsgEntity);
}
