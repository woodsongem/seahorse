/**
 * 
 */
package seahorse.internal.business.coldfishservice;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.core.Response.Status;
import org.apache.logging.log4j.Logger;

import com.datastax.driver.core.utils.UUIDs;
import com.google.inject.Inject;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.constants.Constant;
import seahorse.internal.business.coldfishservice.datacontracts.DeleteIncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.DeleteIncomeCategoryResponseMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryResponseMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailResponseMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;
import seahorse.internal.business.coldfishservice.postprocessors.IColdFishServicePostProcessor;
import seahorse.internal.business.coldfishservice.processors.IColdFishServiceProcessor;
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
		
		incomeTypeMessageEntity.setId(UUID.randomUUID());
		
		//Validator	    
	    ResultMessageEntity resultMessageEntity = coldFishServiceValidator.validateCreateIncomeType(incomeTypeMessageEntity);
	    if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return coldFishServiceMapper.mapIncomeTypeResponseMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}
		
		//Verifier
	    resultMessageEntity = coldFishServiceVerifier.verifyCreateIncomeType(incomeTypeMessageEntity);
		if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return coldFishServiceMapper.mapIncomeTypeResponseMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}		
		
		//Processor
		resultMessageEntity=coldFishServiceProcessor.createIncomeTypeProcessor(incomeTypeMessageEntity);
		if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return coldFishServiceMapper.mapIncomeTypeResponseMessageEntity(resultMessageEntity, Status.FORBIDDEN);
		}
		
		//Post Processor
		ResultMessageEntity postResultMessageEntity=coldFishServicePostProcessor.createIncomeTypePostProcessor(incomeTypeMessageEntity);
		
				
		
		return coldFishServiceMapper.mapIncomeTypeResponseMessageEntity(resultMessageEntity, incomeTypeMessageEntity);	
	}
	
	public	List<IncomeTypeMessageEntity> getIncomeTypeByUserId(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity) {		
			//Set			
			
		 	//Validator	    
		    ResultMessageEntity resultMessageEntity = coldFishServiceValidator.validategetIncomeTypeByUserId(getIncomeTypeMessageEntity);
		    if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
				return coldFishServiceMapper.mapIncomeTypeMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
			}
			
			//Verifier
		    resultMessageEntity = coldFishServiceVerifier.verifygetIncomeTypeByUserId(getIncomeTypeMessageEntity);
			if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
				return coldFishServiceMapper.mapIncomeTypeMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
			}		
			
			//Processor
			resultMessageEntity=coldFishServiceProcessor.getIncomeTypeByUserIdProcessor(getIncomeTypeMessageEntity);
			if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
				return coldFishServiceMapper.mapIncomeTypeMessageEntity(resultMessageEntity, Status.FORBIDDEN);
			}
			
			//Post Processor
			ResultMessageEntity postResultMessageEntity=coldFishServicePostProcessor.getIncomeTypeByUserIdPostProcessor(getIncomeTypeMessageEntity);
			
					
			
			return coldFishServiceMapper.mapIncomeTypeMessageEntity(resultMessageEntity, getIncomeTypeMessageEntity);	
		}

	@Override
	public IncomeDetailResponseMessageEntity createIncomeDetail(IncomeDetailMessageEntity incomeDetailMessageEntity) {		
		//Set	
		
		if(incomeDetailMessageEntity !=null)
		{		
			incomeDetailMessageEntity.setId(UUID.randomUUID());
		}
		
		//Validator	    
	    ResultMessageEntity resultMessageEntity = coldFishServiceValidator.validateCreateIncomeDetail(incomeDetailMessageEntity);
	    if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return coldFishServiceMapper.mapIncomeDetailResponseMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}
		
		//Verifier
	    resultMessageEntity = coldFishServiceVerifier.verifyCreateIncomeDetail(incomeDetailMessageEntity);
		if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return coldFishServiceMapper.mapIncomeDetailResponseMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}		
		
		//Processor
		resultMessageEntity=coldFishServiceProcessor.createIncomeDetailProcessor(incomeDetailMessageEntity);
		if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return coldFishServiceMapper.mapIncomeDetailResponseMessageEntity(resultMessageEntity, Status.FORBIDDEN);
		}
		
		//Post Processor
		ResultMessageEntity postResultMessageEntity=coldFishServicePostProcessor.createIncomeDetailProcessor(incomeDetailMessageEntity);
		
				
		
		return coldFishServiceMapper.mapIncomeDetailResponseMessageEntity(resultMessageEntity, incomeDetailMessageEntity);	
	}

	@Override
	public List<IncomeDetailMessageEntity> getIncomeDetailByUserId(GetIncomeDetailMessageEntity getincomeDetailMessageEntity) {

	 	//Validator	    
	    ResultMessageEntity resultMessageEntity = coldFishServiceValidator.validateGetIncomeDetailByUserId(getincomeDetailMessageEntity);
	    if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return coldFishServiceMapper.mapIncomeDetailMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}
		
		//Verifier
	    resultMessageEntity = coldFishServiceVerifier.verifyGetIncomeDetailByUserId(getincomeDetailMessageEntity);
		if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return coldFishServiceMapper.mapIncomeDetailMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}		
		
		//Processor
		resultMessageEntity=coldFishServiceProcessor.getIncomeDetailByUserIdProcessor(getincomeDetailMessageEntity);
		if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return coldFishServiceMapper.mapIncomeDetailMessageEntity(resultMessageEntity, Status.FORBIDDEN);
		}
		
		//Post Processor
		ResultMessageEntity postResultMessageEntity=coldFishServicePostProcessor.getIncomeDetailByUserIdProcessor(getincomeDetailMessageEntity);		
				
		
		return coldFishServiceMapper.mapIncomeDetailMessageEntity(resultMessageEntity, getincomeDetailMessageEntity);	
	}

	@Override
	public IncomeCategoryResponseMessageEntity createIncomeCategory(IncomeCategoryMessageEntity incomeCategoryMessageEntity) {
		
		if(incomeCategoryMessageEntity != null)
		{
			incomeCategoryMessageEntity.setId(UUIDs.timeBased());
			incomeCategoryMessageEntity.setCreatedDate(LocalDateTime.now());
			incomeCategoryMessageEntity.setStatus(Constant.ACTIVESTATUS);
			if(incomeCategoryMessageEntity.getAmount()==null)
			{
				incomeCategoryMessageEntity.setAmount(new BigDecimal(0.0));
			}
		}
		//Validator	    
	    ResultMessageEntity resultMessageEntity = coldFishServiceValidator.validateCreateIncomeCategory(incomeCategoryMessageEntity);
	    if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return coldFishServiceMapper.mapIncomeCategoryResponseMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}
		
		//Verifier
	    resultMessageEntity = coldFishServiceVerifier.verifyCreateIncomeCategory(incomeCategoryMessageEntity);
		if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return coldFishServiceMapper.mapIncomeCategoryResponseMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}		
		
		//Processor
		resultMessageEntity=coldFishServiceProcessor.createIncomeCategoryProcessor(incomeCategoryMessageEntity);
		if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return coldFishServiceMapper.mapIncomeCategoryResponseMessageEntity(resultMessageEntity, Status.FORBIDDEN);
		}
		
		//Post Processor
		ResultMessageEntity postResultMessageEntity=coldFishServicePostProcessor.getCreateIncomeCategoryPostProcessor(incomeCategoryMessageEntity);		
				
		
		return coldFishServiceMapper.mapIncomeCategoryResponseMessageEntity(resultMessageEntity, incomeCategoryMessageEntity);	
	}

	@Override
	public IncomeCategoryResponseMessageEntity updateIncomeCategory(IncomeCategoryMessageEntity incomeCategoryMessageEntity) {
		//Validator	    
	    ResultMessageEntity resultMessageEntity = coldFishServiceValidator.validateUpdateIncomeCategory(incomeCategoryMessageEntity);
	    if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return coldFishServiceMapper.mapIncomeCategoryResponseMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}
		
		//Verifier
	    resultMessageEntity = coldFishServiceVerifier.verifyUpdateIncomeCategory(incomeCategoryMessageEntity);
		if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return coldFishServiceMapper.mapIncomeCategoryResponseMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}		
		
		//Processor
		resultMessageEntity=coldFishServiceProcessor.UpdateIncomeCategoryProcessor(incomeCategoryMessageEntity);
		if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return coldFishServiceMapper.mapIncomeCategoryResponseMessageEntity(resultMessageEntity, Status.FORBIDDEN);
		}
		
		//Post Processor
		ResultMessageEntity postResultMessageEntity=coldFishServicePostProcessor.updateIncomeCategoryPostProcessor(incomeCategoryMessageEntity);		
				
		
		return coldFishServiceMapper.mapIncomeCategoryResponseMessageEntity(resultMessageEntity, incomeCategoryMessageEntity);	
	}

	@Override
	public DeleteIncomeCategoryResponseMessageEntity deleteIncomeCategory(DeleteIncomeCategoryMessageEntity deleteIncomeCategoryMessageEntity) {
		//Validator	    
	    ResultMessageEntity resultMessageEntity = coldFishServiceValidator.validateDeleteIncomeCategory(deleteIncomeCategoryMessageEntity);
	    if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return coldFishServiceMapper.mapDeleteIncomeCategoryResponseMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}
		
		//Verifier
	    resultMessageEntity = coldFishServiceVerifier.verifyDeleteIncomeCategory(deleteIncomeCategoryMessageEntity);
		if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return coldFishServiceMapper.mapDeleteIncomeCategoryResponseMessageEntity(resultMessageEntity, Status.BAD_REQUEST);
		}		
		
		//Processor
		resultMessageEntity=coldFishServiceProcessor.deleteIncomeCategoryProcessor(deleteIncomeCategoryMessageEntity);
		if (resultMessageEntity == null || resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return coldFishServiceMapper.mapDeleteIncomeCategoryResponseMessageEntity(resultMessageEntity, Status.FORBIDDEN);
		}
		
		//Post Processor
		ResultMessageEntity postResultMessageEntity=coldFishServicePostProcessor.deleteIncomeCategoryPostProcessor(deleteIncomeCategoryMessageEntity);		
				
		
		return coldFishServiceMapper.mapIncomeCategoryResponseMessageEntity(resultMessageEntity, deleteIncomeCategoryMessageEntity);
	}

}
