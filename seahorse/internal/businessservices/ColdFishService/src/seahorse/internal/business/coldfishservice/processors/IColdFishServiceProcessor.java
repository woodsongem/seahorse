/**
 * 
 */
package seahorse.internal.business.coldfishservice.processors;

import java.util.List;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.IncomeTypeDetail;
import seahorse.internal.business.coldfishservice.processors.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceProcessor {

	ResultMessageEntity CreateIncomeTypeProcessor(IncomeTypeMessageEntity incomeTypeMessageEntity);

}
