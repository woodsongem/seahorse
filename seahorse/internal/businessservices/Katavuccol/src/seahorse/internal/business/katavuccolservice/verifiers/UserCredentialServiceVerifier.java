/**
 * 
 */
package seahorse.internal.business.katavuccolservice.verifiers;

import java.util.List;
import com.google.inject.Inject;

import seahorse.internal.business.katavuccolservice.common.IUserCredentialErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.IUserCredentialRepository;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.GetUserCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public class UserCredentialServiceVerifier implements IUserCredentialServiceVerifier {

	private final IBaseVerifier baseVerifier;	
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
	}
}
