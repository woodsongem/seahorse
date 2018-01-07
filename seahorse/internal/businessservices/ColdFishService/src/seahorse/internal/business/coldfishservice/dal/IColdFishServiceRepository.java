/**
 * 
 */
package seahorse.internal.business.coldfishservice.dal;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeCategoryDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeDetailDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.coldfishservice.datacontracts.DeleteIncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.LoginDetailMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServiceRepository {

	List<IncometypeDAO> getIncometypeByUserId(String userId);

	List<IncometypeDAO> getDefaultIncometype();

	List<UserCredentialDAO> getUserCredential(LoginDetailMessageEntity loginDetailMessageEntity);

	IncometypeDAO createIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity);
	
	IncometypeDAO getIncomeTypeById(IncomeTypeMessageEntity incomeTypeMessageEntity);

	IncomeDetailDAO createIncomeDetail(IncomeDetailMessageEntity incomeDetailMessageEntity);

	List<IncomeDetailDAO> getIncomeDetailByUserId(String userId);

	List<IncometypeDAO> getIncomeTypeByIds(List<String> incomeTypeIds);

	List<IncomeCategoryDAO> getDefaultIncomeCategory();

	List<IncomeCategoryDAO> getIncomeCategoryByUserId(UUID userId,String month,int year);

	IncomeCategoryDAO createIncomeCategory(IncomeCategoryMessageEntity incomeDetailMessageEntity);

	IncomeCategoryDAO getIncomeCategoryById(IncomeCategoryMessageEntity incomeCategory);

	void DeleteIncomeCategory(DeleteIncomeCategoryMessageEntity deleteIncomeCategoryMessageEntity);
	
	
}
