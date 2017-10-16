/**
 * 
 */
package seahorse.internal.business.coldfishservice;

import java.util.List;

import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishService {

	IncomeTypeResponseMessageEntity createIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity);
	
	List<IncomeTypeMessageEntity> getIncomeTypeByUserId(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity);

}
