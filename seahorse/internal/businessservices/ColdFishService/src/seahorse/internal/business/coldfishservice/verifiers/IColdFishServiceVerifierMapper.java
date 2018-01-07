/**
 * 
 */
package seahorse.internal.business.coldfishservice.verifiers;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeCategoryDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryMessageEntity;
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

	LoginDetailMessageEntity mapLoginDetailMessageEntity(UUID userId);

	IncomeTypeMessageEntity mapIncomeTypeMessageEntity(UUID incomeTypeId);

	IncomeTypeMessageEntity mapIncomeTypeMessageEntity(IncometypeDAO incometypeDAO);

	IncomeCategoryMessageEntity mapIncomeCategoryMessageEntity(UUID incomeCategoryId);

	IncomeCategoryMessageEntity mapincomeCategoryMessageEntity(IncomeCategoryDAO incomeCategoryDAO);

}
