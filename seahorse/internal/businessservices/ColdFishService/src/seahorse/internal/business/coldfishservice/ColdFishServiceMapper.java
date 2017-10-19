/**
 * 
 */
package seahorse.internal.business.coldfishservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceMapper implements IColdFishServiceMapper {

	@Override
	public IncomeTypeResponseMessageEntity mapIncomeTypeResponseMessageEntity(ResultMessageEntity resultMessageEntity,
			IncomeTypeMessageEntity incomeTypeMessageEntity) {
		IncomeTypeResponseMessageEntity incomeTypeResponseMessageEntity = new IncomeTypeResponseMessageEntity();
		incomeTypeResponseMessageEntity.setResultStatus(resultMessageEntity.getResultStatus());
		incomeTypeResponseMessageEntity.setId(incomeTypeMessageEntity.getId());
		incomeTypeResponseMessageEntity.setResultMessages(resultMessageEntity.getResultMessages());
		if (resultMessageEntity.getHttpStatus() == null) {
			if (resultMessageEntity.getResultStatus() == ResultStatus.SUCCESS)
				incomeTypeResponseMessageEntity.setHttpStatus(Status.OK);
			else
				incomeTypeResponseMessageEntity.setHttpStatus(Status.FORBIDDEN);
		}
		else
		{
			incomeTypeResponseMessageEntity.setHttpStatus(resultMessageEntity.getHttpStatus());
		}
		return incomeTypeResponseMessageEntity;
	}

	@Override
	public IncomeTypeResponseMessageEntity mapIncomeTypeResponseMessageEntity(ResultMessageEntity resultMessageEntity,
			Status badRequest) {
		IncomeTypeResponseMessageEntity incomeTypeResponseMessageEntity = new IncomeTypeResponseMessageEntity();
		incomeTypeResponseMessageEntity.setResultMessages(resultMessageEntity.getResultMessages());
		incomeTypeResponseMessageEntity.setResultStatus(resultMessageEntity.getResultStatus());
		incomeTypeResponseMessageEntity.setHttpStatus(badRequest);
		return incomeTypeResponseMessageEntity;
	}

	@Override
	public List<IncomeTypeMessageEntity> mapIncomeTypeMessageEntity(ResultMessageEntity resultMessageEntity,GetIncomeTypeMessageEntity getIncomeTypeMessageEntity) {
		return getIncomeTypeMessageEntity.getIncomeTypeMessageEntity();
	}

	@Override
	public List<IncomeTypeMessageEntity> mapIncomeTypeMessageEntity(ResultMessageEntity resultMessageEntity,Status badRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
