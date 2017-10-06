/**
 * 
 */
package seahorse.internal.business.coldfishservice.verifiers;

import java.util.List;

import seahorse.internal.business.coldfishservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceVerifierMapper {

	LoginDetailMessageEntity mapLoginDetailMessageEntity(IncomeTypeMessageEntity incomeTypeMessageEntity);

	List<UserCredentialMessageEntity> mapUserCredentialMessageEntity(List<UserCredentialDAO> userCredentialDAO);

}
