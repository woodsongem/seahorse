/**
 * 
 */
package seahorse.internal.business.credentialservice;

import seahorse.internal.business.credentialservice.datacontracts.CreateCredentialRequestMessageEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByIdMsgEntity;

/**
 * @author SMJE
 *
 */
public class CredentialServiceVerifierMapper implements ICredentialServiceVerifierMapper {

	@Override
	public CredentialTypeByIdMsgEntity mapCredentialTypeByIdMsgEntity(CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {
		CredentialTypeByIdMsgEntity  credentialTypeByIdMsgEntity=new CredentialTypeByIdMsgEntity();
		credentialTypeByIdMsgEntity.setCredentialTypeId(credentialRequestMessageEntity.getTypeId());
		credentialTypeByIdMsgEntity.setUserId(credentialRequestMessageEntity.getUserId());
		return credentialTypeByIdMsgEntity;
	}

}
