/**
 * 
 */
package seahorse.internal.business.usercredentialservice;

import com.google.inject.Inject;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.usercredentialservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateUserCredentialMsgEntity;
import seahorse.internal.business.usercredentialservice.datacontracts.UserCredentialMsgEntity;

/**
 * @author SMJE
 *
 */
public class BaseUserCredentialService implements IBaseUserCredentialService {
	private final IUserCredentialServiceMapper userCredentialServiceMapper;
	private final IUserCredentialRepository userCredentialRepository;

	@Inject
	public BaseUserCredentialService(IUserCredentialRepository userCredentialRepository,
			IUserCredentialServiceMapper userCredentialServiceMapper) {
		this.userCredentialServiceMapper = userCredentialServiceMapper;
		this.userCredentialRepository = userCredentialRepository;
	}

	@Override
	public UserCredentialMsgEntity getUserCredentialByUserName(String username) {
		UserCredentialDAO userCredentialDAO = userCredentialServiceMapper.mapUserCredentialDAO(username);
		UserCredentialDAO resUserCredentialDAO = userCredentialRepository.getUserCredentialByUserName(userCredentialDAO);
		return userCredentialServiceMapper.MapUserCredentialMsgEntity(resUserCredentialDAO);

	}

	@Override
	public Result createUserCredential(CreateUserCredentialMsgEntity createUserCredentialMsgEntity) {
		UserCredentialDAO userCredentialDAO = userCredentialServiceMapper
				.mapUserCredentialDAO(createUserCredentialMsgEntity);
		return userCredentialRepository.createUserCredential(userCredentialDAO);
	}

}
