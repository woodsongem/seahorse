/**
 * 
 */
package seahorse.internal.business.coldfishservice.validators;

import java.util.UUID;

import com.google.inject.Inject;

import seahorse.internal.business.coldfishservice.common.IReadPropertiesFile;
import seahorse.internal.business.coldfishservice.common.datacontracts.IColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.utilities.ColdFishServiceUtility;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceValidator implements IColdFishServiceValidator {

	private final IColdFishServiceErrorCode coldFishServiceErrorCode;
	//private final IReadPropertiesFile readPropertiesFile;

	@Inject
	public ColdFishServiceValidator(IColdFishServiceErrorCode coldFishServiceErrorCode,
			IReadPropertiesFile readPropertiesFile) {
		this.coldFishServiceErrorCode = coldFishServiceErrorCode;
		//this.readPropertiesFile = readPropertiesFile;
	}

	
	public ResultMessageEntity ValidateCreateIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity) {

		ResultMessageEntity resultMessageEntity;
		
		resultMessageEntity=IsIncomeTypeMessageEntityValid(incomeTypeMessageEntity);
		if(resultMessageEntity.GetResultStatus() != ResultStatus.Success)
		{
			return resultMessageEntity;
		}
		
		resultMessageEntity=IsNameValid(incomeTypeMessageEntity);
		if(resultMessageEntity.GetResultStatus() != ResultStatus.Success)
		{
			return resultMessageEntity;
		}
		
		resultMessageEntity=IsUserIdValid(incomeTypeMessageEntity);
		if(resultMessageEntity.GetResultStatus() != ResultStatus.Success)
		{
			return resultMessageEntity;
		}
		
		resultMessageEntity=IsDescriptionValid(incomeTypeMessageEntity);
		if(resultMessageEntity.GetResultStatus() != ResultStatus.Success)
		{
			return resultMessageEntity;
		}
		
		return ColdFishServiceUtility.GetResultMessageEntity("", "", ResultStatus.Success);
	}

	public ResultMessageEntity IsIncomeTypeMessageEntityValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		if (incomeTypeMessageEntity != null) {
			return ColdFishServiceUtility.GetResultMessageEntity("", "", ResultStatus.Success);
		}

		return ColdFishServiceUtility.GetResultMessageEntity(
				coldFishServiceErrorCode.EmptyIncomeTypeMessageEntityErrorCode(), "IncomeTypeMessageEntity",
				ResultStatus.Error);
	}

	public ResultMessageEntity IsNameValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		if (incomeTypeMessageEntity.name != null) {
			return ColdFishServiceUtility.GetResultMessageEntity("", "", ResultStatus.Success);
		}

		return ColdFishServiceUtility.GetResultMessageEntity(coldFishServiceErrorCode.EmptyNameErrorCode(), "Name",
				ResultStatus.Error);
	}

	public ResultMessageEntity IsUserIdValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		if (incomeTypeMessageEntity.UserId == null) {
			return ColdFishServiceUtility.GetResultMessageEntity(coldFishServiceErrorCode.EmptyUseridErrorCode(),
					"Name", ResultStatus.Error);
		}

		try {
			incomeTypeMessageEntity.ParsedUserId = UUID.fromString(incomeTypeMessageEntity.UserId);
		} catch (Exception e) {
			return ColdFishServiceUtility.GetResultMessageEntity(coldFishServiceErrorCode.InValidUserIdErrorCode(),
					"Name", ResultStatus.Error);
		}

		return ColdFishServiceUtility.GetResultMessageEntity("", "", ResultStatus.Success);
	}

	public ResultMessageEntity IsDescriptionValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		if (incomeTypeMessageEntity.Description != null) {
			return ColdFishServiceUtility.GetResultMessageEntity("", "", ResultStatus.Success);
		}

		return ColdFishServiceUtility.GetResultMessageEntity(coldFishServiceErrorCode.EmptyDescriptionErrorCode(),
				"Name", ResultStatus.Error);
	}
}
