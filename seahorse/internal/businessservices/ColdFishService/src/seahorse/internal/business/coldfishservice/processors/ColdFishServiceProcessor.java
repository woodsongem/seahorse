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
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeDetailDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
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

	@Override
	public ResultMessageEntity createIncomeDetailProcessor(IncomeDetailMessageEntity incomeDetailMessageEntity) {
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = createIncomeDetail(incomeDetailMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}
	
	@Override
	public ResultMessageEntity createIncomeDetail(IncomeDetailMessageEntity incomeDetailMessageEntity) {
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		try {
			coldFishServiceRepository.createIncomeDetail(incomeDetailMessageEntity);
		} catch (Exception e) {
			logger.error("Error in IColdFishServiceProcessor::createIncomeDetail error=" + e);
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(
					ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.internalError(), null));
			return resultMessageEntity;
		}
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		return resultMessageEntity;
	}

	@Override
	public ResultMessageEntity getIncomeDetailByUserIdProcessor(GetIncomeDetailMessageEntity getincomeDetailMessageEntity) {
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = getIncomeDetailByUserId(getincomeDetailMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}
	
	public ResultMessageEntity getIncomeDetailByUserId(GetIncomeDetailMessageEntity getincomeDetailMessageEntity)
	{
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		try {
			List<IncomeDetailDAO> incomeDetailDAOs = coldFishServiceRepository.getIncomeDetailByUserId(getincomeDetailMessageEntity.getUserId());
			if(incomeDetailDAOs.isEmpty())
			{
				resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
				return resultMessageEntity;
			}
			if (getincomeDetailMessageEntity.getIncomeDetails().isEmpty()) {
				getincomeDetailMessageEntity.setIncomeDetails(coldFishServiceProcessorMapper.mapIncomeDetailMessageEntity(incomeDetailDAOs));
			}
			else
			{	
				getincomeDetailMessageEntity.getIncomeDetails().addAll(coldFishServiceProcessorMapper.mapIncomeDetailMessageEntity(incomeDetailDAOs));	
			}
		} catch (Exception e) {
			logger.error("Error in IColdFishServiceProcessor::getIncomeDetailByUserId error=" + e);
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(
					ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.internalError(), null));
			return resultMessageEntity;
		}
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		return resultMessageEntity;
	}


	public ResultMessageEntity GetIncomeTypeByIds(GetIncomeDetailMessageEntity getIncomeDetailMessageEntity)
	{
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		try {
			List<IncomeDetailDAO> incomeDetailDAOs = coldFishServiceRepository.getIncomeDetailByUserId(getIncomeDetailMessageEntity.getUserId());
			if(incomeDetailDAOs.isEmpty())
			{
				resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
				return resultMessageEntity;
			}
			if (getIncomeDetailMessageEntity.getIncomeDetails().isEmpty()) {
				getIncomeDetailMessageEntity.setIncomeDetails(coldFishServiceProcessorMapper.mapIncomeDetailMessageEntity(incomeDetailDAOs));
			}
			else
			{	
				getIncomeDetailMessageEntity.getIncomeDetails().addAll(coldFishServiceProcessorMapper.mapIncomeDetailMessageEntity(incomeDetailDAOs));	
			}
		} catch (Exception e) {
			logger.error("Error in IColdFishServiceProcessor::getIncomeDetailByUserId error=" + e);
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(
					ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.internalError(), null));
			return resultMessageEntity;
		}
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		return resultMessageEntity;
	}
}
