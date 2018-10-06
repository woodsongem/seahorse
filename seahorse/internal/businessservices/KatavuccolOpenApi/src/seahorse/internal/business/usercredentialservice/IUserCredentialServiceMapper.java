/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import seahorse.internal.business.usercredentialservice.datacontracts.CreateProfileApiMsgEntity;
import seahorse.internal.business.usercredentialservice.external.datacontracts.CreateUserCredentialApi;
import seahorse.internal.business.usercredentialservice.rest.datacontracts.CreateUserCredentialIPost;

/**
 * @author SMJE
 *
 */
public interface IUserCredentialServiceMapper {

	CreateUserCredentialApi mapCreateUserCredentialApi(CreateProfileApiMsgEntity createProfileApiMsgEntity);

	CreateUserCredentialIPost mapCreateUserCredentialIPost(CreateUserCredentialApi createUserCredential);

}
