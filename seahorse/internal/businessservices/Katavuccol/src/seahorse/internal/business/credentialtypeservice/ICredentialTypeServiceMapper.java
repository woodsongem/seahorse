/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.UUID;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeResMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.DeleteCredentialTypeReqMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.DeleteCredentialTypeResMsgEntity;
import seahorse.internal.business.credentialtypeservice.external.datacontracts.UserProfileModelExAPI;
import seahorse.internal.business.credentialtypeservice.rest.datacontracts.GetUserProfileIGet;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;
import seahorse.internal.business.profileservice.datacontracts.UserProfileMsgEntity;

/**
 * @author admin
 *
 */
public interface ICredentialTypeServiceMapper {

	CredentialTypeDAO MapcredentialTypeDAO(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);

	CreateCredentialTypeResMsgEntity mapCreateCredentialTypeResMsgEntity(Result result,CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);

	CreateCredentialTypeResMsgEntity mapCreateCredentialTypeResMsgEntity(Result result, Status badRequest);

	DeleteCredentialTypeResMsgEntity mapDeleteCredentialTypeResMsgEntity(Result result, Status badRequest);

	CredentialTypeDAO mapCredentialTypeDAO(DeleteCredentialTypeReqMsgEntity deleteCredentialTypeReqMsgEntity);

	DeleteCredentialTypeResMsgEntity mapDeleteCredentialTypeResMsgEntity(Result result,DeleteCredentialTypeReqMsgEntity deleteCredentialTypeReqMsgEntity);

	GetUserProfileIGet MapGetUserProfileIGet(UUID parsedUserId);

	UserProfileMsgEntity MapUserProfileMsgEntity(UserProfileModelExAPI userProfileModelExAPI);

}
