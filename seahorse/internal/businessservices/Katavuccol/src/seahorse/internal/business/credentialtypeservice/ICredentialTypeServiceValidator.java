/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByIdMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByUserIdMsgEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;

/**
 * @author admin
 *
 */
public interface ICredentialTypeServiceValidator {

	Result validGetCredentialTypeByUserId(CredentialTypeByUserIdMsgEntity credentialTypeByUserId);

	Result validGetCredentialTypeById(CredentialTypeByIdMsgEntity credentialTypeByIdMsgEntity);
	
	Result IsCredentialTypeByUserIdMsgEntityValid(CredentialTypeByUserIdMsgEntity credentialTypeByUserId);
	
	Result IsUserIdValid(CredentialTypeByUserIdMsgEntity credentialTypeByUserId);

	Result validCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
	
	Result isCreateCredentialTypeMsgEntityValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
	
	Result isUserIdValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);
	
	Result isNameValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);

}
