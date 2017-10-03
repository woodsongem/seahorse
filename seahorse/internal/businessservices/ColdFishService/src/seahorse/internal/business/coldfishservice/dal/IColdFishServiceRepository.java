/**
 * 
 */
package seahorse.internal.business.coldfishservice.dal;

import java.util.List;

import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceRepository {

	List<IncometypeDAO> getIncometypeByUserId(String userId);

	List<IncometypeDAO> getDefaultIncometype();

	UserCredentialDAO getUserCredential(LoginDetailMessageEntity loginDetailMessageEntity);

	IncometypeDAO createIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity);
}
