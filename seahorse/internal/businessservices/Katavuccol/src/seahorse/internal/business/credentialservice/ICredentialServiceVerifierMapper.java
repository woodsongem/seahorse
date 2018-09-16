/**
 * 
 */
package seahorse.internal.business.credentialservice;

import seahorse.internal.business.credentialservice.dal.datacontracts.CredentialDAO;
import seahorse.internal.business.credentialservice.datacontracts.CreateCredentialRequestMessageEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByIdMsgEntity;

/**
 * @author SMJE
 *
 */
public interface ICredentialServiceVerifierMapper {

	CredentialTypeByIdMsgEntity mapCredentialTypeByIdMsgEntity(CreateCredentialRequestMessageEntity credentialRequestMessageEntity);


}
