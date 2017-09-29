/**
 * 
 */
package seahorse.internal.business.coldfishservice;

import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;
import seahorse.internal.business.coldfishservice.postprocessors.IColdFishServicePostProcessor;
import seahorse.internal.business.coldfishservice.processors.IColdFishServiceProcessor;
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
	private IColdFishServiceProcessor coldFishServiceProcessor;
	private IColdFishServicePostProcessor coldFishServicePostProcessor;
	
	@InjectLogger  Logger logger;

	@Inject
	public ColdFishService(IColdFishServiceMapper coldFishServiceMapper,
			IColdFishServiceVerifier coldFishServiceVerifier,
			IColdFishServiceValidator coldFishServiceValidator,
			IColdFishServiceProcessor coldFishServiceProcessor,
			IColdFishServicePostProcessor coldFishServicePostProcessor)
	{
		this.coldFishServiceMapper=coldFishServiceMapper;
		this.coldFishServiceVerifier=coldFishServiceVerifier;
		this.coldFishServiceValidator=coldFishServiceValidator;
		this.coldFishServiceProcessor=coldFishServiceProcessor;
		this.coldFishServicePostProcessor=coldFishServicePostProcessor;
	}
	
	public IncomeTypeResponseMessageEntity createIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity) {		
		//Set		
		//Validator	    
	    ResultMessageEntity resultMessageEntity = coldFishServiceValidator.validateCreateIncomeType(incomeTypeMessageEntity);
	    if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return ColdFishServiceUtility.getIncomeTypeResponseMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}
		
		//Verifier
	    resultMessageEntity = coldFishServiceVerifier.verifyCreateIncomeType(incomeTypeMessageEntity);
		if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return ColdFishServiceUtility.getIncomeTypeResponseMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}		
		
		//Processor
		resultMessageEntity=coldFishServiceProcessor.createIncomeTypeProcessor(incomeTypeMessageEntity);
		if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return ColdFishServiceUtility.getIncomeTypeResponseMessageEntity(resultMessageEntity, Status.FORBIDDEN);
		}
		
		//Post Processor
		resultMessageEntity=coldFishServicePostProcessor.createIncomeTypePostProcessor(incomeTypeMessageEntity);
				
		
		return coldFishServiceMapper.mapIncomeTypeResponseMessageEntity(resultMessageEntity, incomeTypeMessageEntity);	
	}

}
