/**
 * 
 */
package seahorse.internal.business.coldfishservice.dal;

import com.datastax.driver.core.Row;

import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;

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

}
