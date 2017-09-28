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
		incometypeDAO.Id=incometypeDAOResult.getUUID(DataBaseColumn.ID);
		incometypeDAO.Category=incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_CATEGORY);
		incometypeDAO.CreatedBy=incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_CREATEDBY);
		incometypeDAO.CreatedDate=incometypeDAOResult.getDate(DataBaseColumn.INCOMETYPE_CREATEDDATE);
		incometypeDAO.Description=incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_DESCRIPTION);
		incometypeDAO.ModifiedBy=incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_MODIFIEDBY);
		incometypeDAO.ModifiedDate=incometypeDAOResult.getDate(DataBaseColumn.INCOMETYPE_MODIFIEDDATE);
		incometypeDAO.Name=incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_NAME);
		incometypeDAO.Status=incometypeDAOResult.getString(DataBaseColumn.INCOMETYPE_STATUS);
		incometypeDAO.UserId=incometypeDAOResult.getUUID(DataBaseColumn.INCOMETYPE_USERID);
		return incometypeDAO;
	}

	@Override
	public String getIncometypeByUserIdQuery(String userId) {
		Object[] args = { userId };
		return new MessageFormat(QueryConstants.GETINCOMETYPEBYUSERIDQUERY).format(args);
	}

	@Override
	public String createIncomeTypeQuery(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		
		return null;
	}

	@Override
	public IncometypeDAO mapcreateIncomeType(Row incometypeDAOResult) {
		return null;
	}
}
