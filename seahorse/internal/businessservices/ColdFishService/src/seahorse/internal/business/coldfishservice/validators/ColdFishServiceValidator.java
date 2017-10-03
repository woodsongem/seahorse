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
		if (incomeTypeMessageEntity.getUserId() == null) {
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyUseridErrorCode(),
					"UserId", ResultStatus.ERROR);
		}

		try {
			incomeTypeMessageEntity.setParsedUserId(UUID.fromString(incomeTypeMessageEntity.getUserId()));
		} catch (Exception e) {
			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.inValidUserIdErrorCode(),
					"Name", ResultStatus.ERROR);
		}

		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}

	public ResultMessageEntity isDescriptionValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		if (incomeTypeMessageEntity.getDescription() != null) {
			return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
		}

		return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.emptyDescriptionErrorCode(),
				"Name", ResultStatus.ERROR);
	}
}
