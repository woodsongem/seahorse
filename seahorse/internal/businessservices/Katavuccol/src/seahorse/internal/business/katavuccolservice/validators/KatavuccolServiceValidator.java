/**
 * 
 */
package seahorse.internal.business.katavuccolservice.validators;

import com.google.inject.Inject;

import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialsRequestMessageEntity;

/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceValidator implements IKatavuccolServiceValidator {
	
	private final IBaseValidator baseValidator;
	
	@Inject
	public KatavuccolServiceValidator(IBaseValidator baseValidator)
	{
		this.baseValidator=baseValidator;
	}

	@Override
	public Result validateCreateCredentials(CredentialsRequestMessageEntity credentialsRequestMessageEntity) {
		Result result;

		result = isCredentialsRequestMessageEntityValid(credentialsRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isPasswordValid(credentialsRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isUsernameValid(credentialsRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		result = isUserIdValid(credentialsRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return new Result();
	}

	public Result isUserIdValid(CredentialsRequestMessageEntity credentialsRequestMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Result isUsernameValid(CredentialsRequestMessageEntity credentialsRequestMessageEntity) {
		Result result=new Result();
		result.setResultStatus(ResultStatus.SUCCESS);
		
		return result;
	}

	public Result isCredentialsRequestMessageEntityValid(CredentialsRequestMessageEntity credentialsRequestMessageEntity) {
		Result result=new Result();
		result.setResultStatus(ResultStatus.SUCCESS);
		
		if(credentialsRequestMessageEntity==null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"credentialsRequestMessageEntity is null","CredentialsRequestMessageEntity","8989");
		}
		
		return result;
	}
	
	public Result isPasswordValid(CredentialsRequestMessageEntity credentialsRequestMessageEntity) {
		Result result=new Result();
		result.setResultStatus(ResultStatus.SUCCESS);
		
		if(credentialsRequestMessageEntity.getPassword() == null)
		{
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR,"Password is null","Password","8989");
		}
		
		return result;
	}

}
