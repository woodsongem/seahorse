/**
 * 
 */
package seahorse.internal.business.coldfishservice.verifiers;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.UserCredentialMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceVerifier {

	ResultMessageEntity verifyCreateIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity);
	
	ResultMessageEntity isUserIdValid(IncomeTypeMessageEntity incomeTypeMessageEntity);
	
	ResultMessageEntity isNameValid(IncomeTypeMessageEntity incomeTypeMessageEntity);

	ResultMessageEntity verifygetIncomeTypeByUserId(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity);

	ResultMessageEntity verifyCreateIncomeDetail(IncomeDetailMessageEntity incomeDetailMessageEntity);
	
	ResultMessageEntity isUserIdValid(IncomeDetailMessageEntity incomeDetailMessageEntity);
	
	ResultMessageEntity isIncomeTypeIdValid(IncomeDetailMessageEntity incomeDetailMessageEntity);
	
	ResultMessageEntity isUserIdValid(UUID userId,List<UserCredentialMessageEntity> userCredentialMessageEntitys);	 
	
	ResultMessageEntity isIncomeTypeIdValid(UUID incomeTypeId,IncomeTypeMessageEntity incomeTypeMessageEntity);

	ResultMessageEntity verifyGetIncomeDetailByUserId(GetIncomeDetailMessageEntity getincomeDetailMessageEntity);

	ResultMessageEntity verifyCreateIncomeCategory(IncomeCategoryMessageEntity incomeDetailMessageEntity);
	
	ResultMessageEntity isUserIdValid(GetIncomeDetailMessageEntity getincomeDetailMessageEntity);
	
	ResultMessageEntity isUserIdValid(IncomeCategoryMessageEntity incomeCategoryMessageEntity);
	
	ResultMessageEntity isIncomeCategoryNameValid(IncomeCategoryMessageEntity incomeCategoryMessageEntity);

	ResultMessageEntity verifyUpdateIncomeCategory(IncomeCategoryMessageEntity incomeCategoryMessageEntity);
	
	ResultMessageEntity isIncomeCategoryIdValid(IncomeCategoryMessageEntity incomeCategoryMessageEntity);
	
	ResultMessageEntity IsIncomeCategoryIdValid(UUID incomeCategoryId,IncomeCategoryMessageEntity incomeCategoryMessageEntity );
}
