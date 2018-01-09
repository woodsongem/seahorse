/**
 * 
 */
package seahorse.internal.business.coldfishservice.dal;

import java.util.List;
import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;

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
public interface IColdFishServiceRepositoryMapper {

	String getDefaultIncometypeQuery();

	IncometypeDAO mapIncometypeDAO(Row incometypeDAOResult);

	String getIncometypeByUserIdQuery(String userId);

	String createIncomeTypeQuery(IncomeTypeMessageEntity incomeTypeMessageEntity);

	IncometypeDAO mapcreateIncomeType(Row incometypeDAOResult);

	String getUserCredentialQuery(LoginDetailMessageEntity loginDetailMessageEntity);

	UserCredentialDAO mapUserCredentialDAO(Row userCredentialDAOResult);

	String getIncomeTypeById(IncomeTypeMessageEntity incomeTypeMessageEntity);

	String createIncomeDetailQuery(IncomeDetailMessageEntity incomeDetailMessageEntity);

	String getIncomeDetailByUserIdQuery(String userId);

	IncomeDetailDAO mapIncomeDetailDAO(Row incomeDetailResult);

	String getIncomeTypeByIdsQuery(List<String> incomeTypeIds);

	String getDefaultIncomeCategoryQuery();

	IncomeCategoryDAO mapIncomeCategoryDAO(Row incomeCategoryDAOResult);

	String getIncomeCategoryByUserIdQuery(UUID userId);

	String getCreateIncomeCategoryQuery(IncomeCategoryMessageEntity incomeDetailMessageEntity);
	
	BoundStatement mapBoundStatement(PreparedStatement prepared, LoginDetailMessageEntity loginDetailMessageEntity);

	BoundStatement mapBoundStatement(PreparedStatement preparedStatement, UUID userId, String month,int year);

	BoundStatement mapBoundStatement(PreparedStatement preparedStatement,UUID incomeCategoryId);
	
	BoundStatement mapCreateCategoryBoundStatement(PreparedStatement preparedStatement,IncomeCategoryMessageEntity incomeDetailMessageEntity);

	BoundStatement mapBoundStatement(PreparedStatement preparedStatement,DeleteIncomeCategoryMessageEntity deleteIncomeCategoryMessageEntity);
	
	BoundStatement mapGetIncomeCategoryBoundStatement(PreparedStatement preparedStatement,IncomeCategoryMessageEntity incomeDetailMessageEntity);

}
