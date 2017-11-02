/**
 * 
 */
package seahorse.internal.business.coldfishservice.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeDetailRequest;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeDetailsResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeType;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeRequest;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.ResultMessage;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailResponseMessageEntity;
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
		incomeTypeMessageEntity.setCategory(incomeTypeRequest.getCategory());
		return incomeTypeMessageEntity;
	}

	public IncomeTypeResponse mapIncomeTypeResponse(IncomeTypeResponseMessageEntity incomeTypeResponseMessageEntity) {
		IncomeTypeResponse incomeTypeResponse = new IncomeTypeResponse();
		if (incomeTypeResponseMessageEntity.getId() != null) {
			incomeTypeResponse.setId(incomeTypeResponseMessageEntity.getId().toString());
		}
		incomeTypeResponse.setResultStatus(incomeTypeResponseMessageEntity.getResultStatus().toString());
		if (incomeTypeResponseMessageEntity.getResultMessages() == null) {
			return incomeTypeResponse;
		}
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessage resultMessageMS : incomeTypeResponseMessageEntity
				.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(resultMessageMS.getErrorCode());
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		incomeTypeResponse.setresultMessage(resultMessages);
		return incomeTypeResponse;
	}

	@Override
	public List<ResultMessage> mapResultMessages(List<ResultMessage> resultMessages, String httpmethod) {
		if (resultMessages == null)
			return resultMessages;
		for (ResultMessage resultMessage : resultMessages) {
			resultMessage.setErrorCode(resultMessage.getErrorCode().replaceAll("_httpmethod", httpmethod));
		}
		return resultMessages;
	}

	@Override
	public GetIncomeTypeMessageEntity mapGetIncomeTypeMessageEntity(String userid) {
		GetIncomeTypeMessageEntity getIncomeTypeMessageEntity = new GetIncomeTypeMessageEntity();
		getIncomeTypeMessageEntity.setUserId(userid);
		return getIncomeTypeMessageEntity;
	}

	@Override
	public IncomeTypeResponse mapIncomeTypeMessageEntity(List<IncomeTypeMessageEntity> incomeTypeMessageEntitys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IncomeType> mapIncomeTypes(List<IncomeTypeMessageEntity> incomeTypeMessageEntitys) {
		if (incomeTypeMessageEntitys == null || incomeTypeMessageEntitys.isEmpty()) {
			return Collections.emptyList();
		}
		List<IncomeType> incomeTypes = new ArrayList<>();
		for (IncomeTypeMessageEntity incomeTypeMessageEntity : incomeTypeMessageEntitys) {
			IncomeType incomeType = new IncomeType();
			incomeType.setCategory(incomeTypeMessageEntity.getCategory());
			incomeType.setCreatedBy(incomeTypeMessageEntity.getCreatedBy());
			incomeType.setCreatedDate(incomeTypeMessageEntity.getCreatedDate());
			incomeType.setDescription(incomeTypeMessageEntity.getDescription());
			if (incomeTypeMessageEntity.getId() != null) {
				incomeType.setId(incomeTypeMessageEntity.getId().toString());
			}
			incomeType.setName(incomeTypeMessageEntity.getName());
			incomeType.setStatus(incomeTypeMessageEntity.getStatus());
			incomeType.setUserId(incomeTypeMessageEntity.getUserId());
			incomeType.setIncometypecategory(incomeTypeMessageEntity.getIncometypecategory());
			incomeTypes.add(incomeType);
		}

		return incomeTypes;
	}

	@Override
	public IncomeDetailMessageEntity mapIncomeDetailMessageEntity(IncomeDetailRequest incomeDetailRequest) {
		if(incomeDetailRequest==null)
		{
			return null;
		}
		IncomeDetailMessageEntity incomeDetailMessageEntity=new IncomeDetailMessageEntity();
		incomeDetailMessageEntity.setAmount(incomeDetailRequest.getAmount());		
		incomeDetailMessageEntity.setDescription(incomeDetailRequest.getDescription());
		incomeDetailMessageEntity.setIncomeTypeId(incomeDetailRequest.getIncomeTypeId());
		incomeDetailMessageEntity.setUserId(incomeDetailRequest.getUserId());
		incomeDetailMessageEntity.setName(incomeDetailRequest.getName());		
		return incomeDetailMessageEntity;		
	}

	@Override
	public IncomeDetailsResponse mapIncomeDetailsResponse(
			IncomeDetailResponseMessageEntity incomeDetailResponseMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
