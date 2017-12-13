/**
 * 
 */
package seahorse.internal.business.coldfishservice.dal;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;

import seahorse.internal.business.coldfishservice.constants.Constant;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeCategoryDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeDetailDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
import seahorse.internal.business.coldfishservice.dal.datacontracts.UserCredentialDAO;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.LoginDetailMessageEntity;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceRepositoryMapper implements IColdFishServiceRepositoryMapper {

	@Override
	public String getDefaultIncometypeQuery() {
		Object[] args= {Constant.DEFAULT};
		return new MessageFormat(QueryConstants.GETINCOMETYPEQUERY).format(args);
	}

	@Override
	public IncometypeDAO mapIncometypeDAO(Row incometypeDAOResult) {
		IncometypeDAO incometypeDAO = new IncometypeDAO();
		incometypeDAO.setId(incometypeDAOResult.getUUID(DataBaseColumn.ID));
		incometypeDAO.setCategory(incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_CATEGORY));
		incometypeDAO.setCreatedBy(incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_CREATEDBY));
		incometypeDAO.setCreatedDate(incometypeDAOResult.getTimestamp(DataBaseColumn.INCOMETYPE_CREATEDDATE));
		incometypeDAO.setDescription(incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_DESCRIPTION));
		incometypeDAO.setModifiedBy(incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_MODIFIEDBY));
		incometypeDAO.setModifiedDate(incometypeDAOResult.getTimestamp(DataBaseColumn.INCOMETYPE_MODIFIEDDATE));
		incometypeDAO.setName(incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_NAME));
		incometypeDAO.setStatus(incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_STATUS));
		incometypeDAO.setUserId(incometypeDAOResult.getUUID(DataBaseColumn.INCOMETYPE_USERID));
		incometypeDAO.setIncometypecategory(incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_INCOMETYPECATEGORY));
		return incometypeDAO;
	}

	@Override
	public String getIncometypeByUserIdQuery(String userId) {
		Object[] args = { userId };
		return new MessageFormat(QueryConstants.GETINCOMETYPEBYUSERIDQUERY).format(args);
	}

	@Override
	public String createIncomeTypeQuery(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		Object[] args = { incomeTypeMessageEntity.getUserId(), "ACTIVE", incomeTypeMessageEntity.getId(),
				incomeTypeMessageEntity.getCategory().toUpperCase(), incomeTypeMessageEntity.getCreatedBy(),
				incomeTypeMessageEntity.getCreatedDate(), incomeTypeMessageEntity.getDescription(),
				incomeTypeMessageEntity.getName() };
		return new MessageFormat(QueryConstants.CREATEINCOMETYPEQUERY).format(args);
	}

	@Override
	public IncometypeDAO mapcreateIncomeType(Row incometypeDAOResult) {
		return null;
	}

	@Override
	public String getUserCredentialQuery(LoginDetailMessageEntity loginDetailMessageEntity) {
		Object[] args = { loginDetailMessageEntity.getUserId() };
		return new MessageFormat(QueryConstants.GETUSERCREDENTIALQUERY).format(args);
	}

	@Override
	public UserCredentialDAO mapUserCredentialDAO(Row userCredentialDAOResult) {
		UserCredentialDAO userCredentialDAO = new UserCredentialDAO();
		userCredentialDAO.setId(userCredentialDAOResult.getUUID(DataBaseColumn.ID));
		userCredentialDAO.setUsername(userCredentialDAOResult.getString(DataBaseColumn.USERCREDENTIAL_USERNAME));
		userCredentialDAO.setStatus(userCredentialDAOResult.getString(DataBaseColumn.STATUS));
		return userCredentialDAO;
	}

	@Override
	public String getIncomeTypeById(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		Object[] args = { incomeTypeMessageEntity.getId() };
		return new MessageFormat(QueryConstants.GETINCOMEDETAILBYIDQUERY).format(args);
	}

	@Override
	public String createIncomeDetailQuery(IncomeDetailMessageEntity incomeDetailMessageEntity) {
		Object[] args = {  incomeDetailMessageEntity.getId(),incomeDetailMessageEntity.getAmount(),incomeDetailMessageEntity.getCreatedBy(),incomeDetailMessageEntity.getCreatedDate(),
				incomeDetailMessageEntity.getDescription(),incomeDetailMessageEntity.getIncomeTypeId(), "ACTIVE",incomeDetailMessageEntity.getParsedUserId()};
		return new MessageFormat(QueryConstants.CREATEINCOMEDETAILQUERY).format(args);
	}

	@Override
	public String getIncomeDetailByUserIdQuery(String userId) {
		Object[] args = { userId };
		return new MessageFormat(QueryConstants.GETINCOMEDETAILBYIDQUERY).format(args);
	}

	@Override
	public IncomeDetailDAO mapIncomeDetailDAO(Row incomeDetailResult) {
		IncomeDetailDAO incometypeDAO = new IncomeDetailDAO();
		incometypeDAO.setId(incomeDetailResult.getUUID(DataBaseColumn.ID));		
		incometypeDAO.setCreatedBy(incomeDetailResult.getUUID(DataBaseColumn.CREATEDBY));
		incometypeDAO.setCreatedDate(incomeDetailResult.getTimestamp(DataBaseColumn.CREATEDDATE));		
		incometypeDAO.setModifiedBy(incomeDetailResult.getUUID(DataBaseColumn.MODIFIEDBY));
		incometypeDAO.setModifiedDate(incomeDetailResult.getTimestamp(DataBaseColumn.MODIFIEDDATE));		
		incometypeDAO.setStatus(incomeDetailResult.getString(DataBaseColumn.STATUS));
		incometypeDAO.setAmount(incomeDetailResult.getDouble(DataBaseColumn.INCOMEDETAIL_AMOUNT));
		incometypeDAO.setDescription(incomeDetailResult.getString(DataBaseColumn.INCOMEDETAIL_DESCRIPTION));
		incometypeDAO.setUserId(incomeDetailResult.getUUID(DataBaseColumn.INCOMETYPE_USERID));
		incometypeDAO.setIncometypeId(incomeDetailResult.getUUID(DataBaseColumn.INCOMEDETAIL_INCOMETYPEID));
		return incometypeDAO;
	}

	@Override
	public String getIncomeTypeByIdsQuery(List<String> incomeTypeIds) {
		Object[] args = { String.join(",", incomeTypeIds) };
		return new MessageFormat(QueryConstants.GETUSERCREDENTIALQUERY).format(args);
	}

	@Override
	public String getDefaultIncomeCategoryQuery() {		
		Object[] args= {Constant.DEFAULT};
		return new MessageFormat(QueryConstants.GETDEFAULTINCOMETYPEQUERY).format(args);
	}

	@Override
	public IncomeCategoryDAO mapIncomeCategoryDAO(Row incomeCategoryDAOResult) {
		IncomeCategoryDAO incomeCategoryDAO=new IncomeCategoryDAO();
		incomeCategoryDAO.setId(incomeCategoryDAOResult.getUUID(DataBaseColumn.ID));		
		incomeCategoryDAO.setCreatedBy(incomeCategoryDAOResult.getString(DataBaseColumn.CREATEDBY));
		incomeCategoryDAO.setCreatedDate(incomeCategoryDAOResult.getTimestamp(DataBaseColumn.CREATEDDATE));		
		incomeCategoryDAO.setModifiedBy(incomeCategoryDAOResult.getString(DataBaseColumn.MODIFIEDBY));
		incomeCategoryDAO.setModifiedDate(incomeCategoryDAOResult.getTimestamp(DataBaseColumn.MODIFIEDDATE));		
		incomeCategoryDAO.setStatus(incomeCategoryDAOResult.getString(DataBaseColumn.STATUS));
		incomeCategoryDAO.setName(incomeCategoryDAOResult.getString(DataBaseColumn.INCOMECATEGORY_NAME));
		incomeCategoryDAO.setUserId(incomeCategoryDAOResult.getUUID(DataBaseColumn.INCOMECATEGORY_USERID));		
		incomeCategoryDAO.setDescription(incomeCategoryDAOResult.getString(DataBaseColumn.INCOMECATEGORY_DESCRIPTION));
		incomeCategoryDAO.setIncomeMonth(incomeCategoryDAOResult.getString(DataBaseColumn.INCOMECATEGORY_INCOMEMONTH));
		incomeCategoryDAO.setIncomeYear(incomeCategoryDAOResult.getString(DataBaseColumn.INCOMECATEGORY_INCOMEYEAR));
		return incomeCategoryDAO;
	}

	@Override
	public String getIncomeCategoryByUserIdQuery(UUID userId) {
		Object[] args= {userId};
		return new MessageFormat(QueryConstants.GETINCOMECATEGORYBYUSERIDQUERY).format(args);
	}

	@Override
	public String getCreateIncomeCategoryQuery(IncomeCategoryMessageEntity incomeCategoryMessageEntity) {
		Object[] args = { incomeCategoryMessageEntity.getId(),incomeCategoryMessageEntity.getCreatedBy(), 
				incomeCategoryMessageEntity.getCreatedDate(),incomeCategoryMessageEntity.getDescription(),
				incomeCategoryMessageEntity.getName(),"ACTIVE",
				//incomeCategoryMessageEntity.getType().toUpperCase(),
				incomeCategoryMessageEntity.getUserId()};		
		return new MessageFormat(QueryConstants.CREATEINCOMECATEGORYQUERY).format(args);
	}

	@Override
	public BoundStatement mapBoundStatement(PreparedStatement prepared,LoginDetailMessageEntity loginDetailMessageEntity) {
		return prepared.bind(loginDetailMessageEntity.getUserId());		
	}

	@Override
	public BoundStatement mapBoundStatement(PreparedStatement preparedStatement, UUID userId, String month,int year) {		
		return	preparedStatement.bind(userId,year,month); 
	}

	@Override
	public BoundStatement mapBoundStatement(PreparedStatement preparedStatement,IncomeCategoryMessageEntity incomeDetailMessageEntity) {
		BoundStatement bound = preparedStatement.bind();
		bound.setUUID(DataBaseColumn.INCOMECATEGORY_ID, incomeDetailMessageEntity.getId());
		bound.setUUID(DataBaseColumn.INCOMECATEGORY_USERID, incomeDetailMessageEntity.getParsedUserId());		
		bound.setUUID(DataBaseColumn.CREATEDBY, incomeDetailMessageEntity.getCreatedBy());
		bound.setDate(DataBaseColumn.CREATEDDATE,incomeDetailMessageEntity.getCreatedDate());
		bound.setString(DataBaseColumn.INCOMECATEGORY_INCOMEMONTH, incomeDetailMessageEntity.getIncomeMonth());
		bound.setInt(DataBaseColumn.INCOMECATEGORY_INCOMEYEAR, incomeDetailMessageEntity.getIncomeYear());
		bound.setString(DataBaseColumn.INCOMECATEGORY_NAME, incomeDetailMessageEntity.getName());
		bound.setString(DataBaseColumn.STATUS, incomeDetailMessageEntity.getStatus());
		bound.setString(DataBaseColumn.INCOMECATEGORY_DESCRIPTION, incomeDetailMessageEntity.getDescription());
		return bound;
	}
}
