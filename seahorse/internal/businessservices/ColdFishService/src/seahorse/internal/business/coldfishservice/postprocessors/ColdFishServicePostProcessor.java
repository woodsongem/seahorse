/**
 * 
 */
package seahorse.internal.business.coldfishservice.postprocessors;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import seahorse.internal.business.coldfishservice.common.datacontracts.IColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.dal.IColdFishServiceRepository;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeCategoryDAO;
import seahorse.internal.business.coldfishservice.datacontracts.DeleteIncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.processors.IColdFishServiceProcessorMapper;
import seahorse.internal.business.coldfishservice.utilities.ColdFishServiceUtility;
import seahorse.internal.business.shared.aop.InjectLogger;

/**
 * @author sajanmje
 *
 */
public class ColdFishServicePostProcessor  implements IColdFishServicePostProcessor{

	private final IColdFishServicePostProcessorMapper coldFishServicePostProcessorMapper;
	private final IColdFishServiceErrorCode coldFishServiceErrorCode;
	private final IColdFishServiceRepository coldFishServiceRepository;
	
	@InjectLogger
	Logger logger;

	@Inject
	public ColdFishServicePostProcessor(IColdFishServicePostProcessorMapper coldFishServicePostProcessorMapper,
			IColdFishServiceErrorCode coldFishServiceErrorCode, IColdFishServiceRepository coldFishServiceRepository) {
		this.coldFishServicePostProcessorMapper = coldFishServicePostProcessorMapper;
		this.coldFishServiceErrorCode = coldFishServiceErrorCode;
		this.coldFishServiceRepository = coldFishServiceRepository;

	}
	
	@Override
	public ResultMessageEntity createIncomeTypePostProcessor(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		ResultMessageEntity resultMessageEntity=new ResultMessageEntity();
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		return resultMessageEntity;
	}

	@Override
	public ResultMessageEntity getIncomeTypeByUserIdPostProcessor(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity) {
		ResultMessageEntity resultMessageEntity=new ResultMessageEntity();
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		return resultMessageEntity;
	}

	@Override
	public ResultMessageEntity createIncomeDetailProcessor(IncomeDetailMessageEntity incomeDetailMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessageEntity getIncomeDetailByUserIdProcessor(GetIncomeDetailMessageEntity getincomeDetailMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessageEntity getCreateIncomeCategoryPostProcessor(IncomeCategoryMessageEntity incomeDetailMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessageEntity updateIncomeCategoryPostProcessor(IncomeCategoryMessageEntity incomeCategoryMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessageEntity deleteIncomeCategoryPostProcessor(DeleteIncomeCategoryMessageEntity deleteIncomeCategoryMessageEntity) {
		ResultMessageEntity resultMessageEntity=new ResultMessageEntity();
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		resultMessageEntity = deleteSubIncomeCategory(deleteIncomeCategoryMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		return resultMessageEntity;
		
		
	}

	private ResultMessageEntity deleteSubIncomeCategory(DeleteIncomeCategoryMessageEntity deleteIncomeCategoryMessageEntity) {
		ResultMessageEntity resultMessageEntity=new ResultMessageEntity();
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		IncomeCategoryDAO incomeCategoryDAO= coldFishServicePostProcessorMapper.mapIncomeCategoryDAO(deleteIncomeCategoryMessageEntity);
		
		List<IncomeCategoryDAO>  incomeCategoryDAOs=coldFishServiceRepository.getIncomeCategoryDetail(incomeCategoryDAO);
		
		if(incomeCategoryDAOs.isEmpty())
		{
			return resultMessageEntity;
		}
		UUID incomecategoryId=deleteIncomeCategoryMessageEntity.getParsedId();
			do
			{
				List<IncomeCategoryDAO> subincomeCategory=	incomeCategoryDAOs.stream().filter(x->x.getParentId()==incomecategoryId).collect(Collectors.toList());
				if(subincomeCategory.isEmpty())
				{
					return resultMessageEntity;
				}
				
				try {					
					for (IncomeCategoryDAO subIncomeCategoryDAO : subincomeCategory) {
						DeleteIncomeCategoryMessageEntity deleteIncomeCategory=coldFishServicePostProcessorMapper.mapDeleteIncomeCategoryMessageEntity(subIncomeCategoryDAO);
						coldFishServiceRepository.DeleteIncomeCategory(deleteIncomeCategory);	
					}					
				} catch (Exception e) {
					logger.error("Error in IColdFishServiceProcessor::deleteSubIncomeCategory error=" + e);				
				}		
				
			}while(true);
	}

	@Override
	public ResultMessageEntity getIncomeCategoryDetailsPostProcessor(
			GetIncomeDetailMessageEntity getIncomeDetailMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
