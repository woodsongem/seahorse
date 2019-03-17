/**
 * 
 */
package seahorse.internal.business.katavuccolservice.dal;

/**
 * @author sajanmje
 *
 */

public class UserCredentialRepository implements IUserCredentialRepository {
	
	/*private final IUserCredentialRepositoryMapper userCredentialRepositoryMapper;
	private final ICassandraConnector cassandraConnector;
	private final IReadPropertiesFile readPropertiesFile;

	@InjectLogger
	Logger logger;

	@Inject
	public UserCredentialRepository(
			IUserCredentialRepositoryMapper userCredentialRepositoryMapper,
			ICassandraConnector cassandraConnector, 
			IReadPropertiesFile readPropertiesFile) {
		this.userCredentialRepositoryMapper = userCredentialRepositoryMapper;
		this.cassandraConnector = cassandraConnector;
		this.readPropertiesFile = readPropertiesFile;
	}
	
	public UserCredentialDAO getUserCredentialById(UserCredentialMessageEntity userCredentialMessageEntity) {

		UserCredentialDAO userCredentialDAO = new UserCredentialDAO();

		try {
			cassandraConnector.connect(null, 0,null);
			PreparedStatement prepared=cassandraConnector.getSession().prepare(QueryConstants.GET_USER_CREDENTIAL_BY_USERIDQUERY);
			BoundStatement bound=userCredentialRepositoryMapper.mapBoundStatement(prepared,userCredentialMessageEntity);
			final ResultSet resultSet = cassandraConnector.getSession().execute(bound);
			cassandraConnector.close();
			while (!resultSet.isExhausted()) {
				final Row userCredentialDAOResult = resultSet.one();
				userCredentialDAO = userCredentialRepositoryMapper.mapUserCredentialDAO(userCredentialDAOResult);
				if(!KatavuccolServiceUtility.isEqual(userCredentialDAO.getStatus(), KatavuccolConstant.ACTIVESTATUS))
				{
					userCredentialDAO=new UserCredentialDAO();
				}
			}
		} catch (Exception exception) {
			logger.error("Exception in getUserCredential error=" + exception);
		}
		return userCredentialDAO;
	}
*/
}
