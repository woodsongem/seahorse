/**
 * 
 */
package seahorse.internal.business.coldfishservice.dal;

import com.datastax.driver.core.Row;

import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceRepositoryMapper {

	String getDefaultIncometypeQuery();

	IncometypeDAO mapIncometypeDAO(Row incometypeDAOResult);

}
