/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import com.google.inject.Inject;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.*;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateProfileApiMsgEntity;

/**
 * @author SMJE
 *
 */
public class UserCredentialService implements IUserCredentialService {

	private final IUserCredentialServiceMapper userCredentialServiceMapper;
	//private final IKatavuccolClient katavuccolClient;

	@Inject
	public UserCredentialService(IUserCredentialServiceMapper userCredentialServiceMapper)//,
			//IKatavuccolClient katavuccolClient) {
			{
		this.userCredentialServiceMapper = userCredentialServiceMapper;
		//this.katavuccolClient = katavuccolClient;
	}

	@Override
	public OutPutResponse createUserCredential(CreateProfileApiMsgEntity createProfileApiMsgEntity) {
		return null;

	}
}
