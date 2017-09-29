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
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
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

		IncometypeDAO incometypeDAO = coldFishServiceRepository.createIncomeType(incomeTypeMessageEntity);
		if (incometypeDAO == null) {
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(
					ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.inValidUserIdErrorCode(), null));
			return resultMessageEntity;
		}
		return resultMessageEntity;
	}
}
