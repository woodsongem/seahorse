/**
 * 
 */
package seahorse.internal.business.katavuccolservice.verifiers;

import com.google.inject.Inject;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.IKatavuccolServiceRepository;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.TypeDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;


/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceVerifier implements IKatavuccolServiceVerifier {
	
	private final IBaseVerifier baseVerifier;	
	private final IKatavuccolServiceVerifierMapper katavuccolServiceVerifierMapper;
	private final IKatavuccolServiceErrorCode katavuccolServiceErrorCode;
	private final IKatavuccolServiceRepository katavuccolServiceRepository;
	
	@Inject
	public KatavuccolServiceVerifier(IBaseVerifier baseVerifier,
			IKatavuccolServiceVerifierMapper katavuccolServiceVerifierMapper,
			IKatavuccolServiceErrorCode katavuccolServiceErrorCode, IKatavuccolServiceRepository katavuccolServiceRepository)
	{
		this.baseVerifier=baseVerifier;
		this.katavuccolServiceVerifierMapper = katavuccolServiceVerifierMapper;
		this.katavuccolServiceErrorCode = katavuccolServiceErrorCode;
		this.katavuccolServiceRepository = katavuccolServiceRepository;
	}
	

	@Override
	public Result verifyCreateCredentials(CredentialRequestMessageEntity credentialRequestMessageEntity) {	
		Result result;

		result = isUserIdValid(credentialRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		result = isCategoryIdValid(credentialRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isCredentialTypeIdValid(credentialRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}


	public Result isCredentialTypeIdValid(CredentialRequestMessageEntity credentialRequestMessageEntity) {
		TypeDAO typeDAO = katavuccolServiceRepository.getCredentialTypeDetailById(credentialRequestMessageEntity.getParsedTypeId(),credentialRequestMessageEntity.getParsedUserId());
		if(typeDAO !=null)
		{
			return new Result(ResultStatus.ERROR);
		}
		credentialRequestMessageEntity.setCredentialType(katavuccolServiceVerifierMapper.mapCredentialTypeDAOMessageEntity(typeDAO));		
		return new Result(ResultStatus.SUCCESS);
	}


	public Result isCategoryIdValid(CredentialRequestMessageEntity credentialsRequestMessageEntity) {		
		CategoryDAO categoryDAO = katavuccolServiceRepository.getCategoryDetailById(credentialsRequestMessageEntity.getParsedCategoryId(),credentialsRequestMessageEntity.getParsedUserId());
		if(categoryDAO !=null)
		{
			return new Result(ResultStatus.ERROR);
		}		
		credentialsRequestMessageEntity.setCategory(katavuccolServiceVerifierMapper.mapCategoryMessageEntity(categoryDAO));
		return new Result(ResultStatus.SUCCESS);
	}

	public Result isUserIdValid(CredentialRequestMessageEntity credentialsRequestMessageEntity) {		
		return new Result(ResultStatus.SUCCESS);
	}

}
