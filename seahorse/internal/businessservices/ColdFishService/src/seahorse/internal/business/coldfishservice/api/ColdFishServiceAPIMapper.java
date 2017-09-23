/**
 * 
 */
package seahorse.internal.business.coldfishservice.api;

import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeRequest;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeResponse;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceAPIMapper implements IColdFishServiceAPIMapper{

	
	public IncomeTypeMessageEntity MapIncomeTypeMessageEntity(IncomeTypeRequest incomeTypeRequest) {
		IncomeTypeMessageEntity incomeTypeMessageEntity=new IncomeTypeMessageEntity();
		incomeTypeMessageEntity.name=incomeTypeRequest.name;
		incomeTypeMessageEntity.Description=incomeTypeRequest.Description;
		incomeTypeMessageEntity.UserId=incomeTypeRequest.UserId;
		incomeTypeMessageEntity.CreatedBy=incomeTypeRequest.CreatedBy;		
		return incomeTypeMessageEntity;
	}

	
	public IncomeTypeResponse MapIncomeTypeResponse(IncomeTypeResponseMessageEntity incomeTypeResponseMessageEntity) {
		IncomeTypeResponse incomeTypeResponse=new IncomeTypeResponse();
		incomeTypeResponse.Id=incomeTypeResponseMessageEntity.toString();
		return incomeTypeResponse;
	}

}
