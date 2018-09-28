/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import com.google.inject.Inject;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;

/**
 * @author SMJE
 *
 */
public class UserCredentialServiceVerifier implements IUserCredentialServiceVerifier {

	private final IUserCredentialRepository userCredentialRepository;
	private final IUserCredentialServiceMapper userCredentialServiceMapper;

	@Inject
	public UserCredentialServiceVerifier(IUserCredentialRepository userCredentialRepository,
			IUserCredentialServiceMapper userCredentialServiceMapper) {
		this.userCredentialRepository = userCredentialRepository;
		this.userCredentialServiceMapper=userCredentialServiceMapper;
	}

	@Override
	public Result verifyCreateUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
