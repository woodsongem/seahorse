/**
 * 
 */
package seahorse.internal.business.coldfishservice;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceMapper {

	IncomeTypeResponseMessageEntity MapIncomeTypeResponseMessageEntity(ResultMessageEntity resultMessageEntity,
			IncomeTypeMessageEntity incomeTypeMessageEntity);

}
