/**
 * 
 */
package seahorse.internal.business.coldfishservice;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceMapper implements IColdFishServiceMapper {

	@Override
	public IncomeTypeResponseMessageEntity mapIncomeTypeResponseMessageEntity(ResultMessageEntity resultMessageEntity,
			IncomeTypeMessageEntity incomeTypeMessageEntity) {
		return null;
	}

	@Override
	public IncomeTypeResponseMessageEntity mapIncomeTypeResponseMessageEntity(ResultMessageEntity resultMessageEntity,
			Status badRequest) {
		IncomeTypeResponseMessageEntity incomeTypeResponseMessageEntity=new IncomeTypeResponseMessageEntity();
		incomeTypeResponseMessageEntity.setResultMessages(resultMessageEntity.getResultMessages());
		incomeTypeResponseMessageEntity.setResultStatus(resultMessageEntity.getResultStatus());
		incomeTypeResponseMessageEntity.setHttpStatus(badRequest);		
		return incomeTypeResponseMessageEntity;
	}

}
