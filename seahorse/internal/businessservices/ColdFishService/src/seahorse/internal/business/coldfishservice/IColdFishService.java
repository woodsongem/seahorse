/**
 * 
 */
package seahorse.internal.business.coldfishservice;

import java.util.List;

import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryResponseMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailResponseMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishService {

	IncomeTypeResponseMessageEntity createIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity);
	
	List<IncomeTypeMessageEntity> getIncomeTypeByUserId(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity);

	IncomeDetailResponseMessageEntity createIncomeDetail(IncomeDetailMessageEntity incomeDetailMessageEntity);

	List<IncomeDetailMessageEntity> getIncomeDetailByUserId(GetIncomeDetailMessageEntity getincomeDetailMessageEntity);

	IncomeCategoryResponseMessageEntity createIncomeCategory(IncomeCategoryMessageEntity incomeDetailMessageEntity);

}
