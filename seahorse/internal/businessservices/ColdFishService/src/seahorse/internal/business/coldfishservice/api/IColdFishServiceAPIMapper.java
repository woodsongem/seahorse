/**
 * 
 */
package seahorse.internal.business.coldfishservice.api;

import java.util.List;
import java.util.Map;

import seahorse.internal.business.coldfishservice.api.datacontracts.DeleteIncomeCategoryResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeCategory;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeCategoryRequest;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeCategoryResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeDetail;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeDetailRequest;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeDetailsResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeType;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeRequest;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.ResultMessage;
import seahorse.internal.business.coldfishservice.datacontracts.DeleteIncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.DeleteIncomeCategoryResponseMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryDetail;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryResponseMessageEntity;
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

	IncomeCategoryMessageEntity mapIncomeCategoryMessageEntity(IncomeCategoryRequest incomeCategoryRequest,Map<String, String> headers);

	IncomeCategoryResponse mapIncomeCategoryResponse(IncomeCategoryResponseMessageEntity incomeCategoryResponseMessageEntity);

	DeleteIncomeCategoryMessageEntity mapDeleteIncomeCategoryMessageEntity(String incomecategoryid,Map<String, String> headers);

	DeleteIncomeCategoryResponse mapDeleteIncomeCategoryResponse(DeleteIncomeCategoryResponseMessageEntity deleteIncomeCategoryResponseMessageEntity);

	GetIncomeDetailMessageEntity mapGetIncomeCategory(String userid, int incomeyear, String incomemonth,Map<String, String> headers);

	List<IncomeCategory> mapIncomeCategory(List<IncomeCategoryDetail> incomeCategoryDetail);

}
