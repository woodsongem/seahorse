/**
 * 
 */
package seahorse.internal.business.coldfishservice.processors;

import java.util.List;

import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeDetailDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceProcessorMapper {

	List<IncomeTypeMessageEntity> mapIncomeTypeMessageEntity(List<IncometypeDAO> incometypeDAO);

	List<IncomeDetailMessageEntity> mapIncomeDetailMessageEntity(List<IncomeDetailDAO> incomeDetailDAOs);	

}
