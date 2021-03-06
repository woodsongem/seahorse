/**
 * 
 */
package seahorse.internal.business.coldfishservice.processors;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import seahorse.internal.business.coldfishservice.common.datacontracts.IColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.dal.IColdFishServiceRepository;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeCategoryDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeDetailDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
import seahorse.internal.business.coldfishservice.datacontracts.DeleteIncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryMessageEntity;
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
			List<IncometypeDAO> incometypeDAO = coldFishServiceRepository.getIncometypeByUserId(getIncomeTypeMessageEntity.getUserId());
			getIncomeTypeMessageEntity.setIncomeTypeMessageEntity(coldFishServiceProcessorMapper.mapIncomeTypeMessageEntity(incometypeDAO));
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
		resultMessageEntity = getIncomeTypeByIds(getincomeDetailMessageEntity);
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
				//getincomeDetailMessageEntity.setIncomeDetails(coldFishServiceProcessorMapper.mapIncomeDetailMessageEntity(incomeDetailDAOs));
			}
			else
			{	
				//getincomeDetailMessageEntity.getIncomeDetails().addAll(coldFishServiceProcessorMapper.mapIncomeDetailMessageEntity(incomeDetailDAOs));	
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

	public ResultMessageEntity getIncomeTypeByIds(GetIncomeDetailMessageEntity getIncomeDetailMessageEntity)
	{
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();		
		List<String> incomeTypeIds=new ArrayList<>();
		try {
			List<IncometypeDAO> incometypeDAOs = coldFishServiceRepository.getIncomeTypeByIds(incomeTypeIds);
			if(incometypeDAOs.isEmpty())
			{
				resultMessageEntity.setResultStatus(ResultStatus.ERROR);
				return resultMessageEntity;
			}
			for (IncomeDetailMessageEntity incomeDetailMessageEntity : getIncomeDetailMessageEntity.getIncomeDetails()) {
				IncometypeDAO incometypeDAO=incometypeDAOs.stream().filter(x->x.getId()==incomeDetailMessageEntity.getParsedIncomeTypeId()).findFirst().orElse(null);
				if(incometypeDAO==null)
				{
					resultMessageEntity.setResultStatus(ResultStatus.ERROR);
					resultMessageEntity.setResultMessages(ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.incomeTypeNotFound(), null));
					logger.error("IncomeType is not found for id="+incomeDetailMessageEntity.getParsedIncomeTypeId());
					return resultMessageEntity;
				}
				incomeDetailMessageEntity.setIncomeTypeName(incometypeDAO.getName());
			}
			
		} catch (Exception e) {
			logger.error("Error in IColdFishServiceProcessor::getIncomeDetailByUserId error=" + e);
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.internalError(), null));
			return resultMessageEntity;
		}
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		return resultMessageEntity;
	}

	@Override
	public ResultMessageEntity createIncomeCategoryProcessor(IncomeCategoryMessageEntity incomeDetailMessageEntity) {
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = createIncomeCategory(incomeDetailMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}

	public ResultMessageEntity createIncomeCategory(IncomeCategoryMessageEntity incomeDetailMessageEntity) {
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		try {
			coldFishServiceRepository.createIncomeCategory(incomeDetailMessageEntity);
		} catch (Exception e) {
			logger.error("Error in IColdFishServiceProcessor::createIncomeCategory error=" + e);
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(
					ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.internalError(), null));
			return resultMessageEntity;
		}
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		return resultMessageEntity;
	}

	@Override
	public ResultMessageEntity updateIncomeCategoryProcessor(IncomeCategoryMessageEntity incomeCategoryMessageEntity) {
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = createIncomeCategory(incomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}

	@Override
	public ResultMessageEntity deleteIncomeCategoryProcessor(DeleteIncomeCategoryMessageEntity deleteIncomeCategoryMessageEntity) {
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = deleteIncomeCategory(deleteIncomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}
	
	public ResultMessageEntity deleteSubIncomeCategory(DeleteIncomeCategoryMessageEntity deleteIncomeCategoryMessageEntity) {
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		try {
			coldFishServiceRepository.deleteSubIncomeCategory(deleteIncomeCategoryMessageEntity);
		} catch (Exception e) {
			logger.error("Error in IColdFishServiceProcessor::DeleteIncomeCategory error=" + e);
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(
					ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.internalError(), null));
			return resultMessageEntity;
		}
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		return resultMessageEntity;
	}

	public ResultMessageEntity deleteIncomeCategory(DeleteIncomeCategoryMessageEntity deleteIncomeCategoryMessageEntity) {
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		try {
			coldFishServiceRepository.DeleteIncomeCategory(deleteIncomeCategoryMessageEntity);
		} catch (Exception e) {
			logger.error("Error in IColdFishServiceProcessor::DeleteIncomeCategory error=" + e);
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(
					ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.internalError(), null));
			return resultMessageEntity;
		}
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		return resultMessageEntity;
	}

	@Override
	public ResultMessageEntity getIncomeCategoryDetailsProcessor(GetIncomeCategoryMessageEntity getIncomeCategoryMessageEntity) {
		ResultMessageEntity resultMessageEntity;
		resultMessageEntity = getIncomeCategoryDetails(getIncomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		return resultMessageEntity;
	}

	public ResultMessageEntity getIncomeCategoryDetails(GetIncomeCategoryMessageEntity getIncomeCategoryMessageEntity) {
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		IncomeCategoryDAO incomeCategoryDAO=coldFishServiceProcessorMapper.MapIncomeCategoryDAO(getIncomeCategoryMessageEntity);
		try {
		 List<IncomeCategoryDAO> incomeCategoryDAOs=coldFishServiceRepository.getIncomeCategoryDetail(incomeCategoryDAO);
		 List<IncomeCategoryMessageEntity> incomeCategoryMessageEntity= coldFishServiceProcessorMapper.mapIncomeCategoryMessageEntity(incomeCategoryDAOs);
		 getIncomeCategoryMessageEntity.setIncomeCategoryMessageEntity(incomeCategoryMessageEntity);
		} catch (Exception e) {
			logger.error("Error in IColdFishServiceProcessor::DeleteIncomeCategory error=" + e);
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.internalError(), null));
			return resultMessageEntity;
		}
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		return resultMessageEntity;
	}
}
