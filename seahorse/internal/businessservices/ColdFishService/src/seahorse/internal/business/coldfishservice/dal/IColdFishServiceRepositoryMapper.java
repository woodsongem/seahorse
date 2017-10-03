/**
 * 
 */
package seahorse.internal.business.coldfishservice.dal;

import com.datastax.driver.core.Row;

import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.LoginDetailMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceRepositoryMapper {

	String getDefaultIncometypeQuery();

	IncometypeDAO mapIncometypeDAO(Row incometypeDAOResult);

	String getIncometypeByUserIdQuery(String userId);

	String createIncomeTypeQuery(IncomeTypeMessageEntity incomeTypeMessageEntity);

	IncometypeDAO mapcreateIncomeType(Row incometypeDAOResult);

	String getUserCredentialQuery(LoginDetailMessageEntity loginDetailMessageEntity);

	UserCredentialDAO mapUserCredentialDAO(Row userCredentialDAOResult);

}
