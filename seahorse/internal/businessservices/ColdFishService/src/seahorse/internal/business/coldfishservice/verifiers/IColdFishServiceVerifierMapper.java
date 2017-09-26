/**
 * 
 */
package seahorse.internal.business.coldfishservice.verifiers;

import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.LoginDetailMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceVerifierMapper {

	LoginDetailMessageEntity MapLoginDetailMessageEntity(IncomeTypeMessageEntity incomeTypeMessageEntity);

}
