/**
 * 
 */
package seahorse.internal.business.credentialtypeservice.api;

import javax.servlet.http.HttpServletRequest;

import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialResponseMessageEntity;
import seahorse.internal.business.credentialtypeservice.api.datacontracts.CreateCredentialTypeRequestModel;
import seahorse.internal.business.credentialtypeservice.api.datacontracts.CreateCredentialTypeResponseModel;
import seahorse.internal.business.credentialtypeservice.api.datacontracts.DeleteCredentialTypeResponseModel;
import seahorse.internal.business.credentialtypeservice.api.datacontracts.UpdateCredentialTypeRequestModel;
import seahorse.internal.business.credentialtypeservice.api.datacontracts.UpdateCredentialTypeResponseModel;
import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeResMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByUserIdMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.DeleteCredentialTypeReqMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.DeleteCredentialTypeResMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.UpdateCredentialTypeMessageEntity;

/**
 * @author SMJE
 *
 */
public interface ICredentialTypeServiceApiMapper {

	CreateCredentialTypeMsgEntity mapCreateCredentialTypeMsgEntity(CreateCredentialTypeRequestModel credentialTypeRequest, String userid, HttpServletRequest httpRequest);

	CreateCredentialTypeResponseModel mapCredentialTypeResponse(CreateCredentialTypeResMsgEntity createCredentialTypeResMsgEntity,CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);

	UpdateCredentialTypeMessageEntity mapUpdateCredentialRequestMessageEntity(
			UpdateCredentialTypeRequestModel updateCredentialTypeRequest, String userid, String credentialId,
			HttpServletRequest httpRequest);

	UpdateCredentialTypeResponseModel mapUpdateCredentialTypeResponse(
			UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity,
			UpdateCredentialTypeMessageEntity updateCredentialTypeMessageEntity);

	DeleteCredentialTypeResponseModel mapDeleteCredentialTypeResponse(
			DeleteCredentialTypeResMsgEntity deleteCredentialTypeResMsgEntity,
			DeleteCredentialTypeReqMsgEntity deleteCredentialTypeReqMsgEntity);

	DeleteCredentialTypeReqMsgEntity mapDeleteCredentialTypeRequestMessageEntity(String userid, String credentialTypeId,
			HttpServletRequest httpRequest);

	CredentialTypeByUserIdMsgEntity mapCredentialTypeByUserIdMsgEntity(String userid);

	CredentialTypeByUserIdMsgEntity mapCredentialTypeByUserIdMsgEntity(String userid, String id);

}