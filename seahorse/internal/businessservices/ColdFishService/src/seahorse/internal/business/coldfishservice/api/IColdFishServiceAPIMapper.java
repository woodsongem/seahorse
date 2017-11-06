/**
 * 
 */
package seahorse.internal.business.coldfishservice.api;

import java.util.List;

import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeDetail;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeDetailRequest;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeDetailsResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeType;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeRequest;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.ResultMessage;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailResponseMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceAPIMapper {

	IncomeTypeMessageEntity mapIncomeTypeMessageEntity(IncomeTypeRequest incomeTypeRequest);

	IncomeTypeResponse mapIncomeTypeResponse(IncomeTypeResponseMessageEntity incomeTypeResponseMessageEntity);

	List<ResultMessage> mapResultMessages(List<ResultMessage> getresultMessage,String httpmethod);

	GetIncomeTypeMessageEntity mapGetIncomeTypeMessageEntity(String userid);

	IncomeTypeResponse mapIncomeTypeMessageEntity(List<IncomeTypeMessageEntity> incomeTypeMessageEntitys);

	List<IncomeType> mapIncomeTypes(List<IncomeTypeMessageEntity> incomeTypeMessageEntitys);

	IncomeDetailMessageEntity mapIncomeDetailMessageEntity(IncomeDetailRequest incomeDetailRequest);

	IncomeDetailsResponse mapIncomeDetailsResponse(IncomeDetailResponseMessageEntity incomeDetailResponseMessageEntity);

	GetIncomeDetailMessageEntity mapGetincomeDetailMessageEntity(String userid);

	List<IncomeDetail> mapIncomeDetail(List<IncomeDetailMessageEntity> incomeDetailMessageEntity);

}
