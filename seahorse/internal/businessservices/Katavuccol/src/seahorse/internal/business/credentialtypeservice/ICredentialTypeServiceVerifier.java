/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByIdMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByUserIdMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.DeleteCredentialTypeReqMsgEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeRequestMessageEntity;

/**
 * @author admin
 *
 */
public interface ICredentialTypeServiceVerifier {

	Result verifyGetCredentialTypeByUserId(CredentialTypeByUserIdMsgEntity credentialTypeByUserId);

	Result verifyGetCredentialTypeById(CredentialTypeByIdMsgEntity credentialTypeByIdMsgEntity);

	Result verifyCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);

	Result isUserIdValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
	
	Result isUserIdValid(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity);
	
	Result IsDefaultNameValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);

	Result verifyDeleteCredentialType(DeleteCredentialTypeReqMsgEntity deleteCredentialTypeReqMsgEntity);
}
