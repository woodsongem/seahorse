/**
 * 
 */
package seahorse.internal.business.coldfishservice.processors;

import java.util.List;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import seahorse.internal.business.coldfishservice.common.datacontracts.IColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.dal.IColdFishServiceRepository;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
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
		try {
			coldFishServiceRepository.createIncomeType(incomeTypeMessageEntity);
		} catch (Exception e) {
			logger.error("Error in IColdFishServiceProcessor::CreateIncomeType error=" + e);
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(
					ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.internalError(), null));
			return resultMessageEntity;
		}
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		return resultMessageEntity;
	}

	@Override
	public ResultMessageEntity getIncomeTypeByUserId(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity) {
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		try {
			List<IncometypeDAO> incometypeDAO = coldFishServiceRepository
					.getIncometypeByUserId(getIncomeTypeMessageEntity.getUserId());
			getIncomeTypeMessageEntity.setIncomeTypeMessageEntity(
					coldFishServiceProcessorMapper.mapIncomeTypeMessageEntity(incometypeDAO));
		} catch (Exception e) {
			logger.error("Error in IColdFishServiceProcessor::CreateIncomeType error=" + e);
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(
					ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.internalError(), null));
			return resultMessageEntity;
		}
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		return resultMessageEntity;
	}

	public ResultMessageEntity getDefaultIncomeType(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity) {

		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		try {
			List<IncometypeDAO> incometypeDAOs = coldFishServiceRepository.getDefaultIncometype();
			if(incometypeDAOs.isEmpty())
			{
				resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
				return resultMessageEntity;
			}
			if (getIncomeTypeMessageEntity.getIncomeTypeMessageEntity().isEmpty()) {
				getIncomeTypeMessageEntity.setIncomeTypeMessageEntity(coldFishServiceProcessorMapper.mapIncomeTypeMessageEntity(incometypeDAOs));
			}
			else
			{	
				getIncomeTypeMessageEntity.getIncomeTypeMessageEntity().addAll(coldFishServiceProcessorMapper.mapIncomeTypeMessageEntity(incometypeDAOs));	
			}
		} catch (Exception e) {
			logger.error("Error in IColdFishServiceProcessor::CreateIncomeType error=" + e);
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(
					ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.internalError(), null));
			return resultMessageEntity;
		}
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		return resultMessageEntity;
	}

	@Override
	public ResultMessageEntity getIncomeTypeByUserIdProcessor(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity) {
		
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = getIncomeTypeByUserId(getIncomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		resultMessageEntity = getDefaultIncomeType(getIncomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}
}
