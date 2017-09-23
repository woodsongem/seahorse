/**
 * 
 */
package seahorse.internal.business.coldfishservice;

import org.apache.logging.log4j.Logger;

import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;
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
		// TODO Auto-generated method stub
		return null;
	}

}
