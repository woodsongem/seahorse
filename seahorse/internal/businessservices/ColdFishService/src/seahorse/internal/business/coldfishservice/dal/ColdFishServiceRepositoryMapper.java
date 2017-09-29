/**
 * 
 */
package seahorse.internal.business.coldfishservice.dal;

import java.text.MessageFormat;

import com.datastax.driver.core.Row;

import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceRepositoryMapper implements IColdFishServiceRepositoryMapper {

	@Override
	public String getDefaultIncometypeQuery() {
		return new MessageFormat(QueryConstants.GETINCOMETYPEQUERY).toString();
	}

	@Override
	public IncometypeDAO mapIncometypeDAO(Row incometypeDAOResult) {
		IncometypeDAO incometypeDAO = new IncometypeDAO();
		incometypeDAO.setId(incometypeDAOResult.getUUID(DataBaseColumn.ID));
		incometypeDAO.setCategory(incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_CATEGORY));
		incometypeDAO.setCreatedBy(incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_CREATEDBY));
		incometypeDAO.setCreatedDate(incometypeDAOResult.getDate(DataBaseColumn.INCOMETYPE_CREATEDDATE));
		incometypeDAO.setDescription(incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_DESCRIPTION));
		incometypeDAO.setModifiedBy(incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_MODIFIEDBY));
		incometypeDAO.setModifiedDate(incometypeDAOResult.getDate(DataBaseColumn.INCOMETYPE_MODIFIEDDATE));
		incometypeDAO.setName(incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_NAME));
		incometypeDAO.setStatus(incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_STATUS));
		incometypeDAO.setUserId(incometypeDAOResult.getUUID(DataBaseColumn.INCOMETYPE_USERID));
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
				incomeTypeMessageEntity.getCategory(), incomeTypeMessageEntity.getCreatedBy(),
				incomeTypeMessageEntity.getCreatedDate(), incomeTypeMessageEntity.getDescription(),
				incomeTypeMessageEntity.getName() };
		return new MessageFormat(QueryConstants.CREATEINCOMETYPEQUERY).format(args);
	}

	@Override
	public IncometypeDAO mapcreateIncomeType(Row incometypeDAOResult) {
		return null;
	}
}
