/**
 * 
 */
package seahorse.internal.business.coldfishservice.dal;

import java.util.List;

import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeDetailDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.LoginDetailMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceRepository {

	List<IncometypeDAO> getIncometypeByUserId(String userId);

	List<IncometypeDAO> getDefaultIncometype();

	List<UserCredentialDAO> getUserCredential(LoginDetailMessageEntity loginDetailMessageEntity);

	IncometypeDAO createIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity);
	
	IncometypeDAO getIncomeTypeById(IncomeTypeMessageEntity incomeTypeMessageEntity);

	IncomeDetailDAO createIncomeDetail(IncomeDetailMessageEntity incomeDetailMessageEntity);
}
