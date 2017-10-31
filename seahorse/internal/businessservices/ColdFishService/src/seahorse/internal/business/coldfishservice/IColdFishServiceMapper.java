/**
 * 
 */
package seahorse.internal.business.coldfishservice;
import java.util.List;

import javax.ws.rs.core.Response.Status;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailResponseMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceMapper {

	IncomeTypeResponseMessageEntity mapIncomeTypeResponseMessageEntity(ResultMessageEntity resultMessageEntity,IncomeTypeMessageEntity incomeTypeMessageEntity);

	IncomeTypeResponseMessageEntity mapIncomeTypeResponseMessageEntity(ResultMessageEntity resultMessageEntity,	Status badRequest);

	List<IncomeTypeMessageEntity> mapIncomeTypeMessageEntity(ResultMessageEntity resultMessageEntity,GetIncomeTypeMessageEntity getIncomeTypeMessageEntity);

	List<IncomeTypeMessageEntity> mapIncomeTypeMessageEntity(ResultMessageEntity resultMessageEntity,Status badRequest);

	IncomeDetailResponseMessageEntity mapIncomeDetailResponseMessageEntity(ResultMessageEntity resultMessageEntity,Status badRequest);

	IncomeDetailResponseMessageEntity mapIncomeDetailResponseMessageEntity(ResultMessageEntity resultMessageEntity,IncomeDetailMessageEntity incomeDetailMessageEntity);
}
