/**
 * 
 */
package seahorse.internal.business.katavuccolservice.verifiers;

/**
 * @author sajanmje
 *
 */
public class UserCredentialServiceVerifier implements IUserCredentialServiceVerifier {

	/*private final IBaseVerifier baseVerifier;	
	private final IUserCredentialVerifierMapper userCredentialVerifierMapper;
	private final IUserCredentialErrorCode userCredentialErrorCode;
	private final IUserCredentialRepository userCredentialRepository;	
	
	@Inject
	public UserCredentialServiceVerifier(IBaseVerifier baseVerifier,
			IUserCredentialVerifierMapper userCredentialVerifierMapper,
			IUserCredentialErrorCode userCredentialErrorCode, 
			IUserCredentialRepository userCredentialRepository
			)
	{
		this.baseVerifier=baseVerifier;
		this.userCredentialVerifierMapper = userCredentialVerifierMapper;
		this.userCredentialErrorCode = userCredentialErrorCode;
		this.userCredentialRepository = userCredentialRepository;		
	}
	
	@Override
	public Result verifyGetUserCredential(GetUserCredentialMessageEntity getUserCredentialMessageEntity) {
		Result result;
		
		result = isUserIdValid(getUserCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}

	public Result isUserIdValid(GetUserCredentialMessageEntity getUserCredentialMessageEntity) {
		UserCredentialMessageEntity userCredentialMessageEntity=userCredentialVerifierMapper.mapUserCredentialMessageEntity(getUserCredentialMessageEntity);		
		UserCredentialDAO  userCredentialDAO=userCredentialRepository.getUserCredentialById(userCredentialMessageEntity);
		if(userCredentialDAO == null || userCredentialDAO.getId()==null)
		{
			return new Result(ResultStatus.ERROR);
		}
		UserCredentialMessageEntity userCredentialResMessageEntity=userCredentialVerifierMapper.mapUserCredentialMessageEntity(userCredentialDAO);
		getUserCredentialMessageEntity.setUserCredential(userCredentialResMessageEntity);
		return new Result(ResultStatus.SUCCESS);
	}*/
}
