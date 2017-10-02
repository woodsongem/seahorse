/**
 * 
 */
package seahorse.internal.business.coldfishservice.api;

import java.util.List;

import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeRequest;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.ResultMessage;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceAPIMapper implements IColdFishServiceAPIMapper {

	public IncomeTypeMessageEntity mapIncomeTypeMessageEntity(IncomeTypeRequest incomeTypeRequest) {
		if (incomeTypeRequest == null)
			return null;
		IncomeTypeMessageEntity incomeTypeMessageEntity = new IncomeTypeMessageEntity();
		incomeTypeMessageEntity.setName(incomeTypeRequest.getName());
		incomeTypeMessageEntity.setDescription(incomeTypeRequest.getDescription());
		incomeTypeMessageEntity.setUserId(incomeTypeRequest.getUserId());
		incomeTypeMessageEntity.setCreatedBy(incomeTypeRequest.getCreatedBy());
		return incomeTypeMessageEntity;
	}

	public IncomeTypeResponse mapIncomeTypeResponse(IncomeTypeResponseMessageEntity incomeTypeResponseMessageEntity) {
		IncomeTypeResponse incomeTypeResponse = new IncomeTypeResponse();
		incomeTypeResponse.setId(incomeTypeResponseMessageEntity.toString());
		return incomeTypeResponse;
	}

	@Override
	public List<ResultMessage> mapResultMessages(List<ResultMessage> resultMessages,String httpmethod) {

		for (ResultMessage resultMessage : resultMessages) {
			resultMessage.setErrorCode(resultMessage.getErrorCode().replaceAll("_httpmethod", httpmethod));
		}
		return resultMessages;
	}

}
