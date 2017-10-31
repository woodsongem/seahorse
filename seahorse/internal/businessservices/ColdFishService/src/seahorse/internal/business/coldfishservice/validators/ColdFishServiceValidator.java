/**
 * 
 */
package seahorse.internal.business.coldfishservice.validators;

import java.util.UUID;

import com.google.inject.Inject;

import seahorse.internal.business.coldfishservice.common.IReadPropertiesFile;
import seahorse.internal.business.coldfishservice.common.datacontracts.IColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.IncomeTypes;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.utilities.ColdFishServiceUtility;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceValidator implements IColdFishServiceValidator {

	private final IColdFishServiceErrorCode coldFishServiceErrorCode;

	@Inject
	public ColdFishServiceValidator(IColdFishServiceErrorCode coldFishServiceErrorCode,
			IReadPropertiesFile readPropertiesFile) {
		this.coldFishServiceErrorCode = coldFishServiceErrorCode;

	}

	public ResultMessageEntity validateCreateIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity) {

		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = isIncomeTypeMessageEntityValid(incomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}

		resultMessageEntity = isNameValid(incomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}

		resultMessageEntity = isUserIdValid(incomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}

		resultMessageEntity = isDescriptionValid(incomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}

		resultMessageEntity = isCategoryValid(incomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}

		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}

	public ResultMessageEntity isIncomeTypeMessageEntityValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		if (incomeTypeMessageEntity != null) {
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}

		return ColdFishServiceUtility.getResultMessageEntity(
				coldFishServiceErrorCode.emptyIncomeTypeMessageEntityErrorCode(), "IncomeTypeMessageEntity",
				ResultStatus.ERROR);
	}

	public ResultMessageEntity isNameValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		if (incomeTypeMessageEntity.getName() != null) {
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}

		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyNameErrorCode(), "Name",
				ResultStatus.ERROR);
	}

	public ResultMessageEntity isUserIdValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		ResultMessageEntity resultMessageEntity= isUserIdValid(incomeTypeMessageEntity.getUserId());
		if(resultMessageEntity.getResultStatus()==ResultStatus.SUCCESS)
		{
			incomeTypeMessageEntity.setParsedUserId(UUID.fromString(incomeTypeMessageEntity.getUserId()));
		}
		return resultMessageEntity;
	}

	public ResultMessageEntity isDescriptionValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		if (incomeTypeMessageEntity.getDescription() != null) {
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}

		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyDescriptionErrorCode(),
				"Name", ResultStatus.ERROR);
	}

	public ResultMessageEntity isCategoryValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		if (incomeTypeMessageEntity.getCategory() == null || incomeTypeMessageEntity.getCategory().trim() == null) {
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyCategoryErrorCode(),
					"Category", ResultStatus.ERROR);
		}

		if (!ColdFishServiceUtility.isInEnum(incomeTypeMessageEntity.getCategory(), IncomeTypes.class)) {
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.inValidCategoryErrorCode(),
					"Category", ResultStatus.ERROR);
		}

		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}

	@Override
	public ResultMessageEntity validategetIncomeTypeByUserId(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity) {
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = isGetIncomeTypeMessageEntityValid(getIncomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}

		IncomeTypeMessageEntity incomeTypeMessageEntity = new IncomeTypeMessageEntity();
		incomeTypeMessageEntity.setUserId(getIncomeTypeMessageEntity.getUserId());
		resultMessageEntity = isUserIdValid(incomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}

		return resultMessageEntity;
	}

	public ResultMessageEntity isGetIncomeTypeMessageEntityValid(GetIncomeTypeMessageEntity getIncomeTypeMessageEntity) {
		if (getIncomeTypeMessageEntity != null) {
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}

		return ColdFishServiceUtility.getResultMessageEntity(
				coldFishServiceErrorCode.emptyGetIncomeTypeMessageEntityErrorCode(), "GetIncomeTypeMessageEntity",
				ResultStatus.ERROR);
	}

	@Override
	public ResultMessageEntity validateCreateIncomeDetail(IncomeDetailMessageEntity incomeDetailMessageEntity) {
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = isIncomeDetailMessageEntityValid(incomeDetailMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		resultMessageEntity = isUserIdValid(incomeDetailMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		resultMessageEntity = isIncomeTypeIdValid(incomeDetailMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
		
		resultMessageEntity = isAmountValid(incomeDetailMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}
	
		return resultMessageEntity;
	}
	
	public ResultMessageEntity isIncomeDetailMessageEntityValid(IncomeDetailMessageEntity incomeDetailMessageEntity)
	{
		if (incomeDetailMessageEntity != null) {
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}

		return ColdFishServiceUtility.getResultMessageEntity(
				coldFishServiceErrorCode.emptyIncomeDetailMessageEntityErrorCode(), "incomeDetailMessageEntity",
				ResultStatus.ERROR);
	}

	public ResultMessageEntity isUserIdValid(IncomeDetailMessageEntity incomeDetailMessageEntity)
	{
		ResultMessageEntity resultMessageEntity= isUserIdValid(incomeDetailMessageEntity.getUserId());
		if(resultMessageEntity.getResultStatus()==ResultStatus.SUCCESS)
		{
			incomeDetailMessageEntity.setParsedUserId(UUID.fromString(incomeDetailMessageEntity.getUserId()));
		}
		return resultMessageEntity;
	}
	
	public ResultMessageEntity isIncomeTypeIdValid(IncomeDetailMessageEntity incomeDetailMessageEntity)
	{
		ResultMessageEntity resultMessageEntity= isIncomeTypeIdValid(incomeDetailMessageEntity.getUserId());
		if(resultMessageEntity.getResultStatus()==ResultStatus.SUCCESS)
		{
			incomeDetailMessageEntity.setParsedUserId(UUID.fromString(incomeDetailMessageEntity.getUserId()));
		}
		return resultMessageEntity;
	}
	
	public ResultMessageEntity isAmountValid(IncomeDetailMessageEntity incomeDetailMessageEntity)
	{		
		if(incomeDetailMessageEntity.getAmount()==0)
		{
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.zeroAmountErrorCode(),"Amount", ResultStatus.ERROR);
		}
		if(isAmountValid(incomeDetailMessageEntity.getAmount()))
		{
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}
		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.negativeAmountErrorCode(),"Amount", ResultStatus.ERROR);
	}
	
	public Boolean isAmountValid(double amount)
	{
		return true;
	}
	
	public ResultMessageEntity isIncomeTypeIdValid(String incomeTypeId)
	{
		if (incomeTypeId == null) {
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyIncomeTypeId(),"IncomeTypeId", ResultStatus.ERROR);
		}
		
		if(isUUIDValid(incomeTypeId))
		{
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}
		
		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.inValidIncomeTypeIdErrorCode(),"IncomeTypeId", ResultStatus.ERROR);
	}
	
	public ResultMessageEntity isUserIdValid(String userId)
	{
		if (userId == null) {
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyUseridErrorCode(),"UserId", ResultStatus.ERROR);
		}
		
		if(isUUIDValid(userId))
		{
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}
		
		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.inValidUserIdErrorCode(),"Name", ResultStatus.ERROR);
	}
	
	private Boolean isUUIDValid(String uuid)
	{
		if (uuid == null) {
		 return false;
		}
		try {
			UUID.fromString(uuid);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
