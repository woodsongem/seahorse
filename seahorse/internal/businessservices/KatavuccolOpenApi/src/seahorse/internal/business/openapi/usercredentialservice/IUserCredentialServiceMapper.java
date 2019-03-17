/**
 * 
 */
package seahorse.internal.business.openapi.usercredentialservice;

import seahorse.internal.business.openapi.usercredentialservice.datacontracts.CreateProfileApiMsgEntity;
import seahorse.internal.business.openapi.usercredentialservice.external.datacontracts.CreateProfileRequestModelApiEx;
import seahorse.internal.business.openapi.usercredentialservice.external.datacontracts.CreateProfileResponseModelApiEx;
import seahorse.internal.business.openapi.usercredentialservice.rest.datacontracts.CreateUserCredentialIPost;
import seahorse.internal.business.openapi.usercredentialservice.rest.datacontracts.GetUserProfileByUserNameIGet;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;


/**
 * @author SMJE
 *
 */
public interface IUserCredentialServiceMapper {

	CreateProfileRequestModelApiEx mapCreateUserCredentialApi(CreateProfileApiMsgEntity createProfileApiMsgEntity);

	CreateUserCredentialIPost mapCreateUserCredentialIPost(CreateProfileRequestModelApiEx createUserCredential);

	OutPutResponse mapOutPutResponse(CreateProfileResponseModelApiEx createProfileResponseModelApiEx);

	GetUserProfileByUserNameIGet mapGetUserProfileByUserNameIGet(String username);

}
