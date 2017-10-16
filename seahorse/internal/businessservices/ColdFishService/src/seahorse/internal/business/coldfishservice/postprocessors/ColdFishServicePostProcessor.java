/**
 * 
 */
package seahorse.internal.business.coldfishservice.postprocessors;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;

/**
 * @author sajanmje
 *
 */
public class ColdFishServicePostProcessor  implements IColdFishServicePostProcessor{

	@Override
	public ResultMessageEntity createIncomeTypePostProcessor(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		
		return null;
	}

	@Override
	public ResultMessageEntity creategetIncomeTypeByUserId(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
