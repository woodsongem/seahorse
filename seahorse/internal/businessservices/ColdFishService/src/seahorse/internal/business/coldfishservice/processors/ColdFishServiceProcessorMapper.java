/**
 * 
 */
package seahorse.internal.business.coldfishservice.processors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeDetailDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
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
	public List<IncomeDetailMessageEntity> mapIncomeDetailMessageEntity(List<IncomeDetailDAO> incomeDetailDAOs) {
		// TODO Auto-generated method stub
		return null;
	}

}
