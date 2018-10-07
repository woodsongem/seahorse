/**
 * 
 */
package seahorse.internal.business.openapi.usercredentialservice;

import seahorse.internal.business.openapi.usercredentialservice.datacontracts.CreateProfileApiMsgEntity;
import seahorse.internal.business.openapi.usercredentialservice.external.datacontracts.CreateUserCredentialApi;
import seahorse.internal.business.openapi.usercredentialservice.rest.datacontracts.CreateUserCredentialIPost;

/**
 * @author SMJE
 *
 */
public interface IUserCredentialServiceMapper {

	CreateUserCredentialApi mapCreateUserCredentialApi(CreateProfileApiMsgEntity createProfileApiMsgEntity);

	CreateUserCredentialIPost mapCreateUserCredentialIPost(CreateUserCredentialApi createUserCredential);

}
