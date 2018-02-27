/**
 * 
 */

package seahorse.internal.business.katavuccolservice.dal;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;

import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.TypeDAO;

/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceRepositoryMapper implements IKatavuccolServiceRepositoryMapper {

	@Override
	public String getCategoryDetailsByIdQuery(UUID categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDAO mapCategoryDAO(Row categoryDAOResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTypeDetailsByIdQuery(UUID typeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeDAO mapTypeDAO(Row typeDAOResult) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
