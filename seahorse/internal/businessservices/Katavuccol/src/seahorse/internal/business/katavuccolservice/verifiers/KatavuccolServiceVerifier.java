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
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsRequestMessageEntity;

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
	public Result verifyCreateCredentials(CredentialsRequestMessageEntity credentialsRequestMessageEntity) {	
		Result result;

		result = isUserIdValid(credentialsRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		result = isCategoryIdValid(credentialsRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isTypeIdValid(credentialsRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}


	public Result isTypeIdValid(CredentialsRequestMessageEntity credentialsRequestMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}


	public Result isCategoryIdValid(CredentialsRequestMessageEntity credentialsRequestMessageEntity) {
		Result result = null;
	
		return result;
	}

	public Result isUserIdValid(CredentialsRequestMessageEntity credentialsRequestMessageEntity) {		
		return new Result(ResultStatus.SUCCESS);
	}

}
