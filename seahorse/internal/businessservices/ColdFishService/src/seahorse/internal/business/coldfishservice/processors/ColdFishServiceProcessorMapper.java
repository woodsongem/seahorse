/**
 * 
 */
package seahorse.internal.business.coldfishservice.processors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeCategoryDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeDetailDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceProcessorMapper implements IColdFishServiceProcessorMapper {

	@Override
	public List<IncomeTypeMessageEntity> mapIncomeTypeMessageEntity(List<IncometypeDAO> incometypeDAOs) {
		if (incometypeDAOs == null || incometypeDAOs.isEmpty()) {
			return Collections.emptyList();
		}
		List<IncomeTypeMessageEntity> incomeTypeMessageEntitys=new ArrayList<>();
		
		for (IncometypeDAO incometypeDAO : incometypeDAOs) {
			IncomeTypeMessageEntity incomeTypeMessageEntity=new IncomeTypeMessageEntity();
			incomeTypeMessageEntity.setCategory(incometypeDAO.getCategory());
			//incomeTypeMessageEntity.setCreatedBy(incometypeDAO.getCreatedBy());
			//incomeTypeMessageEntity.setCreatedDate(incometypeDAO.getCreatedDate());
			incomeTypeMessageEntity.setDescription(incometypeDAO.getDescription());
			incomeTypeMessageEntity.setId(incometypeDAO.getId());
			incomeTypeMessageEntity.setName(incometypeDAO.getName());
			incomeTypeMessageEntity.setStatus(incometypeDAO.getStatus());
			incomeTypeMessageEntity.setParsedUserId(incometypeDAO.getUserId());
			incomeTypeMessageEntity.setUserId(incometypeDAO.getUserId().toString());	
			incomeTypeMessageEntity.setIncometypecategory(incometypeDAO.getIncometypecategory());
			incomeTypeMessageEntitys.add(incomeTypeMessageEntity);
		}
		return incomeTypeMessageEntitys;
	}

	@Override
	public List<IncomeCategoryMessageEntity> mapIncomeCategoryMessageEntity(List<IncomeCategoryDAO> incomeDetailDAOs) {
		List<IncomeCategoryMessageEntity>  incomeCategoryMessageEntitys=new ArrayList<>();
		for (IncomeCategoryDAO incomeCategoryDAO : incomeDetailDAOs) {
			IncomeCategoryMessageEntity incomeCategoryMessageEntity=new IncomeCategoryMessageEntity();
			incomeCategoryMessageEntity.setAmount(incomeCategoryDAO.getAmount());
			incomeCategoryMessageEntity.setCreatedBy(incomeCategoryDAO.getCreatedBy());
			incomeCategoryMessageEntity.setCreatedDate(incomeCategoryDAO.getCreatedDate());
			incomeCategoryMessageEntity.setDescription(incomeCategoryDAO.getDescription());
			incomeCategoryMessageEntity.setId(incomeCategoryDAO.getId());
			incomeCategoryMessageEntity.setIncomeMonth(incomeCategoryDAO.getIncomeMonth());
			incomeCategoryMessageEntity.setIncomeYear(incomeCategoryDAO.getIncomeYear());
			incomeCategoryMessageEntity.setModifiedBy(incomeCategoryDAO.getModifiedBy());
			incomeCategoryMessageEntity.setModifiedDate(incomeCategoryDAO.getModifiedDate());			
			incomeCategoryMessageEntity.setName(incomeCategoryDAO.getName());
			incomeCategoryMessageEntity.setParsedParentid(incomeCategoryDAO.getUserId());
			incomeCategoryMessageEntity.setParsedUserId(incomeCategoryDAO.getUserId());
			incomeCategoryMessageEntity.setStatus(incomeCategoryDAO.getStatus());			
			incomeCategoryMessageEntitys.add(incomeCategoryMessageEntity);
		}
		return incomeCategoryMessageEntitys;
	}

	@Override
	public IncomeCategoryDAO MapIncomeCategoryDAO(GetIncomeCategoryMessageEntity getIncomeCategoryMessageEntity) {
		IncomeCategoryDAO incomeCategoryDAO=new IncomeCategoryDAO();
		incomeCategoryDAO.setUserId(getIncomeCategoryMessageEntity.getParsedUserId());
		incomeCategoryDAO.setIncomeMonth(getIncomeCategoryMessageEntity.getIncomeMonth());
		incomeCategoryDAO.setIncomeYear(getIncomeCategoryMessageEntity.getIncomeYear());
		return incomeCategoryDAO;
	}

}
