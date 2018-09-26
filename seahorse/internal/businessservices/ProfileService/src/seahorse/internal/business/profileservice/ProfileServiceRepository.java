/**
 * 
 */
package seahorse.internal.business.profileservice;

import java.util.UUID;

import seahorse.internal.business.profileservice.api.datacontracts.UserProfileModel;
import seahorse.internal.business.profileservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.*;

/**
 * @author admin
 *
 */
public class ProfileServiceRepository implements IProfileServiceRepository {

	private final IProfileServiceRepositoryMapper profileServiceRepositoryMapper;
	private final ICassandraConnector cassandraConnector;
	private final IReadPropertiesFile readPropertiesFile;

	public ProfileServiceRepository(IProfileServiceRepositoryMapper profileServiceRepositoryMapper,
			ICassandraConnector cassandraConnector, IReadPropertiesFile readPropertiesFile) {
		this.profileServiceRepositoryMapper = profileServiceRepositoryMapper;
		this.cassandraConnector = cassandraConnector;
		this.readPropertiesFile = readPropertiesFile;
	}

	@Override
	public OutPutResponse createUserProfile(UserCredentialDAO userCredentialDAO) {
		return null;

	}

	@Override
	public Result deleteUserProfile(UserCredentialDAO userCredentialDAO) {
		return null;

	}

	@Override
	public Result updateUserProfile(UserCredentialDAO userCredentialDAO) {
		return null;

	}

	@Override
	public UserCredentialDAO getUserProfileByUserId(UUID userId) {
		return null;

	}

	@Override
	public UserProfileModel getUserProfileModelByUserId(UUID userId) {
		return null;

	}
}
