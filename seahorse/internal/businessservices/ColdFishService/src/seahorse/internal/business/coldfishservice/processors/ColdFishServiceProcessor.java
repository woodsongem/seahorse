/**
 * 
 */
package seahorse.internal.business.coldfishservice.processors;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import seahorse.internal.business.coldfishservice.common.datacontracts.IColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.dal.IColdFishServiceRepository;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.utilities.ColdFishServiceUtility;
import seahorse.internal.business.shared.aop.InjectLogger;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceProcessor implements IColdFishServiceProcessor {

	private final IColdFishServiceProcessorMapper coldFishServiceProcessorMapper;
	private final IColdFishServiceErrorCode coldFishServiceErrorCode;
	private final IColdFishServiceRepository coldFishServiceRepository;

	@InjectLogger
	Logger logger;

	@Inject
	public ColdFishServiceProcessor(IColdFishServiceProcessorMapper coldFishServiceProcessorMapper,
			IColdFishServiceErrorCode coldFishServiceErrorCode, IColdFishServiceRepository coldFishServiceRepository) {
		this.coldFishServiceProcessorMapper = coldFishServiceProcessorMapper;
		this.coldFishServiceErrorCode = coldFishServiceErrorCode;
		this.coldFishServiceRepository = coldFishServiceRepository;

	}

	@Override
	public ResultMessageEntity createIncomeTypeProcessor(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = createIncomeType(incomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}

	public ResultMessageEntity createIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();		
		incomeTypeMessageEntity.setCreatedDate(ColdFishServiceUtility.getCurrentDate());		
		try {
			coldFishServiceRepository.createIncomeType(incomeTypeMessageEntity);
		} catch (Exception e) {
			logger.error("Error in IColdFishServiceProcessor::CreateIncomeType error="+e);
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(
					ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.internalError(), null));
			return resultMessageEntity;
		}
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		return resultMessageEntity;
	}

	@Override
	public ResultMessageEntity creategetIncomeTypeByUserId(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}
}
