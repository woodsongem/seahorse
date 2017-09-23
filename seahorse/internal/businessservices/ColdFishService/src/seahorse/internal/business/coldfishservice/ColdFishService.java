/**
 * 
 */
package seahorse.internal.business.coldfishservice;

import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.Logger;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;
import seahorse.internal.business.coldfishservice.utilities.ColdFishServiceUtility;
import seahorse.internal.business.coldfishservice.validators.IColdFishServiceValidator;
import seahorse.internal.business.coldfishservice.verifiers.IColdFishServiceVerifier;
import seahorse.internal.business.shared.aop.InjectLogger;

/**
 * @author sajanmje
 *
 */
public class ColdFishService implements IColdFishService {
	
	private IColdFishServiceMapper coldFishServiceMapper;
	private IColdFishServiceVerifier coldFishServiceVerifier;
	private IColdFishServiceValidator coldFishServiceValidator;
	
	@InjectLogger  Logger logger;

	public ColdFishService(IColdFishServiceMapper coldFishServiceMapper,
			IColdFishServiceVerifier coldFishServiceVerifier,
			IColdFishServiceValidator coldFishServiceValidator)
	{
		this.coldFishServiceMapper=coldFishServiceMapper;
		this.coldFishServiceVerifier=coldFishServiceVerifier;
		this.coldFishServiceValidator=coldFishServiceValidator;
	}
	
	public IncomeTypeResponseMessageEntity CreateIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		
		//Set
		
		//Validator	    
	    ResultMessageEntity resultMessageEntity = coldFishServiceValidator.ValidateCreateIncomeType(incomeTypeMessageEntity);
	    if (resultMessageEntity == null || resultMessageEntity.GetResultStatus() != ResultStatus.Success) {
			return ColdFishServiceUtility.GetIncomeTypeResponseMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}
		
		//Verifier
	    resultMessageEntity = coldFishServiceVerifier.VerifyCreateIncomeType(incomeTypeMessageEntity);

		if (resultMessageEntity == null || resultMessageEntity.GetResultStatus() != ResultStatus.Success) {
			return ColdFishServiceUtility.GetIncomeTypeResponseMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}
		
		//Processor
		//resultMessageEntity=userCredentialServiceHelper.LoginProcessor(incomeTypeMessageEntity);
		if (resultMessageEntity == null || resultMessageEntity.GetResultStatus() != ResultStatus.Success) {
			return ColdFishServiceUtility.GetIncomeTypeResponseMessageEntity(resultMessageEntity, Status.FORBIDDEN);
		}
		
		//Post Process
		//userCredentialServiceHelper.LoginPostProcessor(incomeTypeMessageEntity);		
		
		return coldFishServiceMapper.MapIncomeTypeResponseMessageEntity(resultMessageEntity, incomeTypeMessageEntity);	
	}

}
