/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import seahorse.internal.business.katavuccolopenapi.common.datacontracts.ExternalEndPoint;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateProfileApiMsgEntity;
import seahorse.internal.business.usercredentialservice.external.datacontracts.CreateUserCredentialApi;
import seahorse.internal.business.usercredentialservice.rest.datacontracts.CreateUserCredentialIPost;

/**
 * @author SMJE
 *
 */
public class UserCredentialServiceMapper implements IUserCredentialServiceMapper{

	@Override
	public CreateUserCredentialApi mapCreateUserCredentialApi(CreateProfileApiMsgEntity createProfileApiMsgEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateUserCredentialIPost mapCreateUserCredentialIPost(CreateUserCredentialApi createUserCredential) {
		CreateUserCredentialIPost createUserCredentialIPost=new CreateUserCredentialIPost();
		createUserCredentialIPost.setEndPoint(ExternalEndPoint.ProfileService.toString());
		createUserCredentialIPost.setRequest(createUserCredential);
		return createUserCredentialIPost;
	}

}
