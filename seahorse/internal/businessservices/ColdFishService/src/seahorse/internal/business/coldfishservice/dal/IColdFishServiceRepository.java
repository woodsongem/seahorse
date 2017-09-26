/**
 * 
 */
package seahorse.internal.business.coldfishservice.dal;

import java.util.List;

import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceRepository {

	 List<IncometypeDAO> GetIncometypeByUserId(String userId);
	 
	 List<IncometypeDAO> GetDefaultIncometype();
}
